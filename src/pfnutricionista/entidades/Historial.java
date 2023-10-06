/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.entidades;

import java.time.LocalDate;


/**
 *
 * @author cdc_3
 */
public class Historial {
    private int idHistorial;
    private Paciente paciente;
    private double peso;
    private LocalDate fechaRegistro;

    public Historial(int idHistorial, Paciente paciente, double peso, LocalDate fechaRegistro) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.peso = peso;
        this.fechaRegistro = fechaRegistro;
    }

    public Historial(Paciente paciente, double peso, LocalDate fechaRegistro) {
        this.paciente = paciente;
        this.peso = peso;
        this.fechaRegistro = fechaRegistro;
    }

    public Historial() {
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Historial{" + "idHistorial=" + idHistorial + ", paciente=" + paciente + ", peso=" + peso + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    
    
}
