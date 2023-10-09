/*
 *
 Acceso a datos: tabla dietacomida
 *
 */
package pfnutricionista.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import pfnutricionista.entidades.Comida;
import pfnutricionista.entidades.Dieta;

/**
 *
 * @author ivanm
 */
public class DietaComidaData {
    
    private  Connection conexion = null;
    private  Dieta dieta = new Dieta();
    private  Comida comida = new Comida();

    public DietaComidaData() {
        this.conexion=Conexion.getConnection();
    }
    
    public void guardarDietaComida (Dieta dieta, Comida comida){
        String sql = "INSERT INTO dietaComida (idDieta, idComida)"
                + " VALUES ( ?, ?)";
        PreparedStatement ps;
        try {          
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dieta.getIdDieta());
            ps.setInt(2, comida.getIdComida());
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    JOptionPane.showMessageDialog(null, "Comida añadida con exito a la Dieta.");
                }
                ps.close();
             } catch (SQLException ex){
                 if (ex.getErrorCode()== 1062){
                    JOptionPane.showMessageDialog(null, "Error. El paciente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la BD.");
                 }
            }
    }
    
        public void finalizarDieta(int idDieta) {
        String sql = "UPDATE dieta SET fechaFin = CURRENT_DATE WHERE idDieta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idDieta);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Dieta finalizada con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al finalizar la dieta: " + ex.getMessage());
        }
    }
        
        public void guardarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (idPaciente, fechaInicio, fechaFin, pesoInicial, pesoBuscado) "
                   + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try{
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dieta.getPaciente().getIdPaciente());
            ps.setObject(2, ((LocalDate)dieta.getFechaInicial()));
            ps.setObject(3, ((LocalDate)dieta.getFechaFinal()));
            ps.setDouble(4, dieta.getPesoInicial());
           

            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Dieta guardada con éxito.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    dieta.setIdDieta(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la dieta: " + ex.getMessage());
        }
    }
    
}

