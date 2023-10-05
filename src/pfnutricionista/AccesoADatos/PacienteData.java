/*
 *
 Acceso a datos: tabla paciente
 *
 */
package pfnutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

        String sql = "UPDATE paciente SET nombre = ?, apellido = ?, dni = ?, domicilio = ?, telefono = ?  WHERE idPaciente = ?";
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setString(4, paciente.getDomicilio());
            ps.setString(5,paciente.getTelefono());
            ps.setInt(6, paciente.getIdPaciente());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente modiificado exitosamente. ");
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pacientes. ");
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
                JOptionPane.showMessageDialog(null, "Se elimino el alumno. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabal Alumno. ");
        }
    }










}