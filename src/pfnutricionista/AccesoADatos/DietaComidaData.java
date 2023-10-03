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
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                //insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción añadida con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error acceder a la tabla Inscripcion.");
        }
    }
}

