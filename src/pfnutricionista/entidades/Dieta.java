/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.entidades;

import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;

/**
 *
 * @author cdc_3
 */
public class Dieta {
    private int idDieta;
    private String nombre;
    private Paciente paciente;
    private Date fechaInicial;
    private double pesoInicial;
    private double pesoFinal;
    private Date fechaFinal;
    private boolean estado;

    public Dieta() {
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, Date fechaInicial, double pesoInicial, double pesoFinal, Date fechaFinal, boolean estado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public Dieta(String nombre, Paciente paciente, Date fechaInicial, double pesoInicial, double pesoFinal, Date fechaFinal, boolean estado) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return idDieta + ", " + nombre + ", paciente=" + paciente + ", fechaInicial=" + fechaInicial + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", fechaFinal=" + fechaFinal;
    }
    
    
}
