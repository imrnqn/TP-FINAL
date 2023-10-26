/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista;


import java.time.LocalDate;
import pfnutricionista.AccesoADatos.ComidaData;
import pfnutricionista.AccesoADatos.Conexion;
import pfnutricionista.AccesoADatos.DietaComidaData;
import pfnutricionista.AccesoADatos.DietaData;
import pfnutricionista.AccesoADatos.PacienteData;
import pfnutricionista.entidades.Comida;
import pfnutricionista.entidades.Dieta;
import pfnutricionista.entidades.DietaComida;
import pfnutricionista.entidades.Paciente;

/**
 *
 * @author ivanm
 */
public class PFNutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Conexion.getConnection();
        
        //Comida comida1 = new Comida(1, "Pechuga a la plancha","", 300, true);
        //Paciente paciente1 = new Paciente(1, "Carlos", "Perez", 33859634, "Av. San Martina 530", "11-56934823", true);
        //Paciente paciente2 = new Paciente(4, "Roberto", "Fernandez", 25896387, "Saavedra", "11-85522553", true);
        
        //Dieta dieta1 = new Dieta(1, "Dieta baja en calorias", paciente1, LocalDate.of(2023, 9, 1), 100, 70, LocalDate.of(2023, 10, 3),true);
        
        System.out.println("fin ");
        
        //DietaComidaData dietaComidaData1 = new DietaComidaData();
        //dietaComidaData1.guardarDietaComida(dieta1, comida1);
        
        //PacienteData pacienteData1 = new PacienteData();
        
        //pacienteData1.guardarPaciente(paciente2);
        //pacienteData1.modificarPaciente(paciente2);
        //pacienteData1.eliminarPaciente(4);
        //System.out.println(pacienteData1.buscarPaciente("P","",0));
        
        DietaComidaData dcData = new DietaComidaData();
        DietaData dData = new DietaData();
        Dieta dieta;
        dieta=dData.buscarDieta(33859634);
        dcData.listarDietaComida(dieta);
        
        
        System.out.println("fin 2");
    }
    
}
