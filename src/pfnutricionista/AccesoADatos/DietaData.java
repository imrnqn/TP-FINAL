/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import pfnutricionista.entidades.Dieta;
import pfnutricionista.entidades.Paciente;

/**
 *
 * @author ivanm
 */
public class DietaData {
    
    private  Connection conexion = null;
    //private  Dieta dieta = new Dieta();
    //private  Paciente paciente = new Paciente();

    public DietaData() {
        this.conexion=Conexion.getConnection();
    }
    
     public void guardarDieta (Dieta dieta, Paciente paciente){
        String sql = "INSERT INTO dieta (nombre, idPaciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal, estado)"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {          
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, dieta.getNombre());
                ps.setInt(2, paciente.getIdPaciente());
                ps.setObject(3, (LocalDate) dieta.getFechaInicial());
                ps.setDouble(4, dieta.getPesoInicial());
                ps.setDouble(5, dieta.getPesoFinal());
                ps.setObject(6, (LocalDate) dieta.getFechaFinal());
                ps.setBoolean(7, true);
                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Dieta añadida con exito.");
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
     
     public Dieta buscarDieta(String nombre){
        Dieta dieta = new Dieta();
        Paciente paciente;
        PacienteData pacienteData = new PacienteData();
        nombre = nombre+"%";
        System.out.println(nombre);
        String sql = "SELECT idDieta, nombre, idPaciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal"
                + " FROM dieta WHERE nombre LIKE ? AND estado = true";
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt("idPaciente"));
                paciente = pacienteData.buscarPacientXid(rs.getInt("idPaciente"));
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(paciente);
                dieta.setFechaInicial((LocalDate) rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFianl"));
                dieta.setFechaFinal((LocalDate) rs.getDate("fechaFinal").toLocalDate());
                dieta.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Error. La dieta no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta.");
        }
        System.out.println(dieta);
        return dieta;
    }
     
    public void modificarDieta(Dieta dieta) {
        DietaData dietaData = new DietaData();
        PacienteData pacienteData = new PacienteData();
        Paciente paciente;
        Dieta dietaId;
        String sql = "UPDATE dieta SET nombre = ?, idPaciente = ?, fechaInicial = ?, pesoInicial = ?, pesoFinal = ?, fechaFinal = ? WHERE idComida = ?";
        PreparedStatement ps;
        dietaId = dietaData.buscarDieta(dieta.getNombre());
        paciente = dietaId.getPaciente();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, paciente.getIdPaciente());
            ps.setObject(3, (LocalDate) dieta.getFechaInicial());
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setObject(6, (LocalDate) dieta.getFechaFinal());
            ps.setInt(5, dietaId.getIdDieta());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Los datos de la dieta furon modiificados exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La dieta no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta.");
        }
    }

    public void eliminarDieta(int idDieta) {
        PreparedStatement ps;
        try {
            String sql = "UPDATE dieta SET estado = 0 WHERE idDieta = ? ";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDieta);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la Dieta. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta. ");
        }
    } 
}
