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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pfnutricionista.entidades.Comida;
import pfnutricionista.entidades.Dieta;
import pfnutricionista.entidades.Historial;
import pfnutricionista.entidades.Paciente;

/**
 *
 * @author ivanm
 */
public class HistorialData {
        
    private  Connection conexion = null;
    
    public HistorialData() {
        this.conexion=Conexion.getConnection();
    }
   
public void guardarControlPeso(int idPaciente, double peso, LocalDate fecha ){
        String sql = "INSERT INTO historial (idPaciente, peso, fechaRegistro )"
                + " VALUES ( ?, ?, ?)";
        
        try {          
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idPaciente);
                ps.setDouble(2, peso);
                ps.setDate(3, Date.valueOf(fecha));
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    JOptionPane.showMessageDialog(null, "El registro fue añadido con exito.");
                }
                ps.close();
             } catch (SQLException ex){
                 if (ex.getErrorCode()== 1062){
                    JOptionPane.showMessageDialog(null, "Error. El registro ya existe en esta dieta.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la BD.");
                 }
            }
    }

public ArrayList<Historial> listarHistorial(int idPaciente) {
        ArrayList<Historial> listaHistorial = new ArrayList<>();
        String sql = "SELECT idHistorial, idPaciente, peso, fechaRegistro FROM historial WHERE idPaciente = ? ORDER BY fechaRegistro";
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Historial registro = new Historial();
                registro.setIdHistorial(rs.getInt("idHistorial"));
                registro.setidPaciente(rs.getInt("idPaciente"));
                registro.setPeso(rs.getDouble("peso"));
                registro.setFechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
                listaHistorial.add(registro);
            }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Control de Peso.");
        }
return listaHistorial;
}

public void eliminarControlPeso (int idHistorial) {
        PreparedStatement ps;
        try {
            String sql = "DELETE FROM historial WHERE idHistorial = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idHistorial);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el registro del Historial. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BD. ");
        }
    }




}
