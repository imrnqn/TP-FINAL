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
    
    public void eliminarDietaComida (int idComida, int idDieta) {
        PreparedStatement ps;
        try {
            String sql = "UPDATE dietacomida SET estado = 0 WHERE idComida = ? AND idDieta = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idComida);
            ps.setInt(2, idDieta);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino el la comida de la dieta. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabal DietaComida. ");
        }
    }
    
    public ArrayList<Comida> listarDietaComida(Dieta dieta) {
//        ArrayList<DietaComida> listaComidas = new ArrayList<>();
//        ComidaData comidaData = new ComidaData();
//        DietaComida dietaComida = new DietaComida();
        ArrayList<Comida> listaComidas = new ArrayList<>();
        ComidaData comidaData = new ComidaData();
        Comida comida = new Comida();
        String sql = "SELECT idDietaComida, idComida, idDieta FROM dietaComida WHERE idDieta = ? AND estado = 1";
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dieta.getIdDieta());
            ResultSet rs=ps.executeQuery();
            // ps.getGeneratedKeys();
            while (rs.next()) {
//               dietaComida.setIdDietaComida(rs.getInt("idDietaComida"));
//               dietaComida.setDieta(dieta);
//               dietaComida.setComida(comidaData.buscarComida(rs.getInt("idComida")));
//              listaComidas.add(dietaComida);
                comida = comidaData.buscarComida(rs.getInt("idcomida"));
                listaComidas.add(comida);
            }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
        }
        System.out.println(listaComidas);
        return listaComidas;
    }
    
    public ArrayList<Comida> listarComida(Dieta dieta) {
        ArrayList<Comida> listaComidas = new ArrayList<>();
        ComidaData comidaData = new ComidaData();
        Comida comida = new Comida();
        String sql = "SELECT comida.idComida FROM comida WHERE comida.estado = true AND comida.idComida "
                + "NOT IN (SELECT dietacomida.idComida FROM dietacomida WHERE dietacomida.idDieta = ?)";
        
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dieta.getIdDieta());
            ResultSet rs;
            rs=ps.executeQuery();
            //ps.getGeneratedKeys();
            while (rs.next()) {
                comida = comidaData.buscarComida(rs.getInt("comida.idcomida"));
                listaComidas.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
        }
        System.out.println(listaComidas);
        return listaComidas;
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
    
    

    @Override
    public String toString() {
        return "DietaComidaData{" + "conexion=" + conexion + ", dieta=" + dieta + ", comida=" + comida + '}';
    }
    
}

