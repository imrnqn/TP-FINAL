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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pfnutricionista.entidades.Comida;
import pfnutricionista.entidades.Dieta;
import pfnutricionista.entidades.DietaComida;

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
    
    public void guardarDietaComida (int idDieta, int idComida){
        String sql = "INSERT INTO dietaComida (idDieta, idComida)"
                + " VALUES ( ?, ?)";
        
        try {          
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idDieta);
                ps.setInt(2, idComida);
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    JOptionPane.showMessageDialog(null, "Comida añadida con exito a la Dieta.");
                }
                ps.close();
             } catch (SQLException ex){
                 if (ex.getErrorCode()== 1062){
                    JOptionPane.showMessageDialog(null, "Error. La comida ya existe en esta dieta.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la BD.");
                 }
            }
    }
    
    public void eliminarPaciente(int idDietaComida) {
        PreparedStatement ps;
        try {
            String sql = "UPDATE paciente SET estado = 0 WHERE idDietaComida = ? ";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDietaComida);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el la comida de la dieta. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabal DietaComida. ");
        }
    }
    
    public ArrayList<DietaComida> listarDietaComida(Dieta dieta) {
        ArrayList<DietaComida> dComidas = new ArrayList<>();
        ComidaData cData = new ComidaData();
        String sql = "SELECT idDietaComida, idComida, idDieta FROM dietaComida WHERE idDieta = ? AND estado = 1";
        PreparedStatement ps;
        try {
            
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dieta.getIdDieta());
            ResultSet rs=ps.executeQuery();
            // ps.getGeneratedKeys();
            while (rs.next()) {
                DietaComida dietaComida = new DietaComida();
                dietaComida.setIdDietaComida(rs.getInt("idDietaComida"));
                dietaComida.setDieta(dieta);
                dietaComida.setComida(cData.buscarComida(rs.getInt("idComida")));
                dComidas.add(dietaComida);
                System.out.println(dietaComida);
            }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
        }
        return dComidas;
    }
    
//    public ArrayList<DietaComida> listarComida(Dieta dieta) {
//        ArrayList<Comida> dComidas = new ArrayList<>();
//        ComidaData dComida = new ComidaData();
//        Comida comida = new Comida();
//        String sql = "SELECT comida.idComida FROM dietaComida, comida "
//                + "WHERE idDieta = ? AND estado = 1 AND dietaComida.idComida!=comida.idcomida";
//        PreparedStatement ps;
//        try {
//            
//            ps = conexion.prepareStatement(sql);
//            ps.setInt(1, dieta.getIdDieta());
//            ResultSet rs=ps.executeQuery();
//            // ps.getGeneratedKeys();
//            while (rs.next()) {
//                comida = dComidas.buscarComida((rs.getInt("comida.idcomida");
//                dietaComida.setDieta(dieta);
//                dietaComida.setComida(cData.buscarComida(rs.getInt("idComida")));
//                dComidas.add(dietaComida);
//                System.out.println(dietaComida);
//            }
//                ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
//        }
//        return dComidas;
//    }
//    
    
    
//        public void finalizarDieta(int idDieta) {
//        String sql = "UPDATE dieta SET fechaFin = CURRENT_DATE WHERE idDieta = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setInt(1, idDieta);
//            int fila = ps.executeUpdate();
//            if (fila == 1) {
//                JOptionPane.showMessageDialog(null, "Dieta finalizada con éxito.");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al finalizar la dieta: " + ex.getMessage());
//        }
//    }
//        
//        public void guardarDieta(Dieta dieta) {
//        String sql = "INSERT INTO dieta (idPaciente, fechaInicio, fechaFin, pesoInicial, pesoBuscado) "
//                   + "VALUES (?, ?, ?, ?, ?)";
//        PreparedStatement ps;
//        try{
//            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, dieta.getPaciente().getIdPaciente());
//            ps.setObject(2, ((LocalDate)dieta.getFechaInicial()));
//            ps.setObject(3, ((LocalDate)dieta.getFechaFinal()));
//            ps.setDouble(4, dieta.getPesoInicial());
//           
//
//            int fila = ps.executeUpdate();
//            if (fila == 1) {
//                JOptionPane.showMessageDialog(null, "Dieta guardada con éxito.");
//            }
//
//            try (ResultSet rs = ps.getGeneratedKeys()) {
//                if (rs.next()) {
//                    dieta.setIdDieta(rs.getInt(1));
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al guardar la dieta: " + ex.getMessage());
//        }
//    }

    @Override
    public String toString() {
        return "DietaComidaData{" + "conexion=" + conexion + ", dieta=" + dieta + ", comida=" + comida + '}';
    }
    
}

