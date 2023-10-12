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
import javax.swing.JOptionPane;
import pfnutricionista.entidades.Comida;

/**
 *
 * @author ivanm
 */
public class ComidaData {
 private  Connection conexion = null;

//ok
    public ComidaData() {
        this.conexion=Conexion.getConnection();
    }

    public void guardarComida (Comida comida){
        String sql = "INSERT INTO comida (nombre, cantCalorias, detalle, horario, estado)"
                + " VALUES ( ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {          
                ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, comida.getNombre());
                ps.setInt(2, comida.getCantCalorias());
                ps.setString(3, comida.getDetalle());
                ps.setString(4, comida.getHorario());
                ps.setBoolean(5, true);
                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Comida añadida con exito.");
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

    public Comida buscarComida(String nombre){
        Comida comida = new Comida();
        nombre = nombre+"%";
        String sql = "SELECT idComida, nombre, detalle, horario, cantCalorias FROM comida "
                + "WHERE nombre LIKE ? AND estado=true";
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setHorario(rs.getString("horario"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comida.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Error. La comida no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comida.");
        }
        return comida;
    }
    
    public void modificarComida(Comida comida) {
        ComidaData comidaData = new ComidaData();
        Comida comidaId = new Comida();
        String sql = "UPDATE comida SET nombre = ?, cantCalorias = ?, detalle = ?, horario = ? WHERE idComida = ?";
        PreparedStatement ps;
        comidaId = comidaData.buscarComida(comida.getNombre());
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setInt(2, comida.getCantCalorias());
            ps.setString(3, comida.getDetalle());
            ps.setString(4, comida.getHorario());
            ps.setInt(5, comidaId.getIdComida());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Los datos de la comida furon modiificados exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La comida no existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comida.");
        }
    }

    public void eliminarComida(int idComida) {
        PreparedStatement ps;
        try {
            String sql = "UPDATE comida SET estado = 0 WHERE idComida = ? ";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idComida);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino la Comida. ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comida. ");
        }
    }

}

