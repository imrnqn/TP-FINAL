/*
 *
 Acceso a datos: tabla paciente
 *
 */
package pfnutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pfnutricionista.entidades.Comida;
import pfnutricionista.entidades.Dieta;
import pfnutricionista.entidades.Paciente;

/**
 *
 * @author CIN
 */
public class PacienteData {
    
    private  Connection conexion = null;

//ok
    public PacienteData() {
        this.conexion=Conexion.getConnection();
    }
    
//ok            
    public void guardarPaciente (Paciente paciente){
        String sql = "INSERT INTO paciente (nombre, apellido, dni, domicilio, telefono, estado )"
                + " VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {          
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setString(4, paciente.getDomicilio());
            ps.setString(5,paciente.getTelefono());
            ps.setBoolean(6, true);
                     
                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Paciente añadido con exito.");
                }
                ps.close();
             } catch (SQLException ex){
                 if (ex.getErrorCode()== 1062){
                    JOptionPane.showMessageDialog(null, "Error. Dato duplicado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la BD.");
                 }
            }
    }

//ok
    public void modificarPaciente(Paciente paciente) {
        PacienteData pacienteData = new PacienteData();
        Paciente pacienteId = new Paciente();
        String sql = "UPDATE paciente SET nombre = ?, apellido = ?, dni = ?, domicilio = ?, telefono = ?  WHERE idPaciente = ?";
        PreparedStatement ps;
        pacienteId = pacienteData.buscarPaciente(paciente.getDni());
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setString(4, paciente.getDomicilio());
            ps.setString(5,paciente.getTelefono());
            ps.setInt(6, pacienteId.getIdPaciente());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Los datos del paciente furon modiificados exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pacientes.");
        }
    }

//ok
    public void eliminarPaciente(int idPac) {
        PreparedStatement ps;
        try {
            String sql = "UPDATE paciente SET estado = 0 WHERE idPaciente = ? ";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPac);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el Paciente. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabal Paciente. ");
        }
    }


//ok
    public Paciente buscarPaciente(int dni){
        Paciente paciente = new Paciente();
        
        String sql = "SELECT idpaciente, apellido, nombre, dni, domicilio, telefono FROM paciente "
                + "WHERE dni = ? AND estado = true";
        
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt("idpaciente"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error. El paciente no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente.");
        }
    return paciente;
    }
    
    public Paciente buscarPacientXid(int idPaciente){
        Paciente paciente = new Paciente();
        
        String sql = "SELECT idPaciente, apellido, nombre, dni, domicilio, telefono FROM paciente "
                + "WHERE idPaciente = ? AND estado = true";
        
        
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error. El paciente no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente.");
        }
        
    return paciente;
    }
    
    public Paciente buscarPaciente(String apellido, String nombre){
        Paciente paciente = new Paciente();
        apellido = apellido+"%";
        nombre = nombre+"%";
        
        String sql = "SELECT idpaciente, apellido, nombre, dni, domicilio, telefono FROM paciente "
                + "WHERE ((apellido LIKE ? OR nombre LIKE ?) AND estado = true)";
        
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, apellido);
            ps.setString(2, nombre);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt("idpaciente"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error. El paciente no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente.");
        }
    return paciente;
    }
    
//    public Paciente buscarPaciente(int idPac){
//        Paciente paciente = new Paciente();
//                
//        String sql = "SELECT idpaciente, apellido, nombre, dni, domicilio, telefono FROM paciente "
//                + "WHERE ((idPaciente = ? AND estado = true)";
//        
//        PreparedStatement ps;
//        try {
//            ps = conexion.prepareStatement(sql);
//            ps.setInt(1, idPac);
//            
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                paciente.setIdPaciente(rs.getInt("idpaciente"));
//                paciente.setApellido(rs.getString("apellido"));
//                paciente.setNombre(rs.getString("nombre"));
//                paciente.setDni(rs.getInt("dni"));
//                paciente.setDomicilio(rs.getString("domicilio"));
//                paciente.setTelefono(rs.getString("telefono"));
//                paciente.setEstado(true);
//            } else {
//                JOptionPane.showMessageDialog(null, "Error. El paciente no existe.");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente.");
//        }
//    return paciente;
//    }

}
