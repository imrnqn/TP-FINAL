/*
 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.entidades;

/**
 *
 * @author cdc_3
 */
public class Comida {
    private int idComida;
    private String nombre;
    private String detalle;
    private String horario;
    private int cantCalorias;
    private boolean estado;

    public Comida(int idComida, String nombre, String detalle, String horario, int cantCalorias, boolean estado) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.detalle = detalle;
        this.horario = horario;
        this.cantCalorias = cantCalorias;
        this.estado = estado;
    }

    public Comida() {
    }

    public Comida(String nombre, String detalle, String horario, int cantCalorias, boolean estado) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.horario = horario;
        this.cantCalorias = cantCalorias;
        this.estado = estado;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idComida + ", " + nombre + ", " + detalle + ", "+ horario +", "+ cantCalorias;
    }
    
    
    
}
