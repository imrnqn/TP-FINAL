/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
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

    public DietaData() {
        this.conexion=Conexion.getConnection();
    }
    
     public void guardarDieta (Dieta dieta){
        String sql = "INSERT INTO dieta (nombre, idPaciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal, estado)"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        
        try {          
            PreparedStatement ps;    
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
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
     
    public Dieta buscarDietaXdni(int dni){
        Dieta dieta = new Dieta();
        Paciente paciente;
        PacienteData pacienteData = new PacienteData();
        paciente = pacienteData.buscarPacienteXdni(dni);
        String sql = "SELECT idDieta, nombre, idPaciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal"
                + " FROM dieta WHERE idPaciente = ? AND estado = true";
        try{
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paciente.getIdPaciente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(paciente);
                dieta.setFechaInicial((LocalDate) rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                if (rs.getDouble("pesoFinal")!= 0){
                    dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                }else{
                    dieta.setPesoFinal(0);
                }
                if (rs.getDate("fechaFinal")!= null){
                    dieta.setFechaFinal((LocalDate)rs.getDate("fechaFinal").toLocalDate());
                }else{
                    dieta.setFechaFinal(null);
                }
                dieta.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no tiene dieta.");
            }
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta.");
        }
    return dieta;
    }
     
     
     
    public void modificarDieta(Dieta dieta, int dni) {
        DietaData dietaData = new DietaData();
        Paciente paciente;
        Dieta dietaId;
        String sql = "UPDATE dieta SET nombre = ?, idPaciente = ?, fechaInicial = ?, pesoInicial = ?, pesoFinal = ?, fechaFinal = ? WHERE idDieta = ?";
        dietaId = dietaData.buscarDietaXdni(dni);
        paciente = dietaId.getPaciente();
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, paciente.getIdPaciente());
            ps.setObject(3, (LocalDate) dieta.getFechaInicial());
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setObject(6, (LocalDate) dieta.getFechaFinal());
            ps.setInt(7, dietaId.getIdDieta());
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
        
        try {
            PreparedStatement ps;
            String sql = "UPDATE dieta SET estado = 0 WHERE idDieta = ? ";
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
