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
import java.util.ArrayList;
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
            String sql = "DELETE FROM dietacomida WHERE idComida = ? AND idDieta = ?";
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

        ArrayList<Comida> listaComidas = new ArrayList<>();
        ComidaData comidaData = new ComidaData();
        Comida comida = new Comida();
        String sql = "SELECT idDietaComida, idComida, idDieta FROM dietaComida WHERE idDieta = ?";
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dieta.getIdDieta());
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                comida = comidaData.buscarComida(rs.getInt("idComida"));
                listaComidas.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
        }
        
        return listaComidas;
    }
    
    public ArrayList<Comida> listarComidaXcalorias (Dieta dieta, int calorias){
        ArrayList<Comida> listaComidas = new ArrayList<>();
        ComidaData comidaData = new ComidaData();
        Comida comida = new Comida();
        String sql = "SELECT dietacomida.idComida FROM dietacomida WHERE dietacomida.idDieta=? "
                + "NOT IN (SELECT comida.idComida FROM comida WHERE comida.estado=true AND comida.idComida AND comida.cantCalorias<=?)";
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dieta.getIdDieta());
            ps.setInt(2, calorias);
            ResultSet rs;
            rs=ps.executeQuery();
            while (rs.next()) {
                comida = comidaData.buscarComida(rs.getInt("dietacomida.idComida"));
                listaComidas.add(comida);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
        }
        return listaComidas;
    }
    
    public ArrayList<Comida> listarComidaXPorciones (Dieta dieta, int porcentaje){
        ArrayList<Comida> listaComidas = new ArrayList<>();
        ComidaData comidaData = new ComidaData();
        Comida comida = new Comida();
        String sql =   "SELECT dietacomida.idCommida FROM dietacomida WHERE dietacomida.idDietaComida = ? LIMIT ?";
        try {
            PreparedStatement ps;
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dieta.getIdDieta());
            ps.setInt(2, porcentaje);
            ResultSet rs;
            rs=ps.executeQuery();
            while (rs.next()) {
                comida = comidaData.buscarComida(rs.getInt("dietacomida.idComida"));
                listaComidas.add(comida);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
        }
        return listaComidas;
    }
    
    
    public ArrayList<Comida> listarComida(Dieta dieta) {
        ArrayList<Comida> listaComidas = new ArrayList<>();
        ComidaData comidaData = new ComidaData();
        Comida comida = new Comida();
        boolean bandera;
        if (dieta.getIdDieta()>0){
            try {
            String sql = "SELECT dietacomida.idComida FROM dietacomida WHERE dietacomida.idDieta = ?";
            PreparedStatement ps;
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, dieta.getIdDieta());
                ResultSet rs;
                rs=ps.executeQuery();
                bandera = true;
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "El paciente no tiene comidas en la dieta.");
                bandera = false;
            }
            if (bandera){
            String sql = "SELECT comida.idComida FROM comida WHERE comida.estado = true AND comida.idComida "
                            + "NOT IN (SELECT dietacomida.idComida FROM dietacomida WHERE dietacomida.idDieta = ?)";
            try {
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, dieta.getIdDieta());
                ResultSet rs;
                rs=ps.executeQuery();
                while (rs.next()) {
                    comida = comidaData.buscarComida(rs.getInt("comida.idcomida"));
                    listaComidas.add(comida);
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla DietaComida.");
            }
            }
        } else {
            String sql = "SELECT comida.idComida FROM comida WHERE comida.estado = true";
            try {
                PreparedStatement ps;
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs;
                rs=ps.executeQuery();
                while (rs.next()) {
                    comida = comidaData.buscarComida(rs.getInt("comida.idcomida"));
                    listaComidas.add(comida);
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comida.");
            }
        }
        return listaComidas;
    }
}

