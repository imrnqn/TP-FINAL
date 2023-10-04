/*
 * Conexion a BD
 *
 */
package pfnutricionista.AccesoADatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "pfnutricionista";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    private static Connection conexion;
    
    // CONSTRUCTOR

    private Conexion() {
    }
    
    public static Connection getConnection(){
        
        if (conexion == null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                
    //CONFIGURACION CONEXION BD
                conexion = DriverManager
                        .getConnection(URL+DB,USUARIO,PASSWORD);
                        
                
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " Error al conectarse a la BD.");
            } catch (ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Error de carga Drivers.");
            }
        }
    return conexion;
    }
    
}
