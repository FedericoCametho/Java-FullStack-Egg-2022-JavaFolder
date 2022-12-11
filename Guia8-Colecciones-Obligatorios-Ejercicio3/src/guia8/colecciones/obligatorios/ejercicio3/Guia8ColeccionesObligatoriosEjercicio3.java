/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia8.colecciones.obligatorios.ejercicio3;

import Entidad.Alumno;
import Servicio.ServicioAlumno;
import java.util.List;


/**
 *
 * @author FedeC
 */
public class Guia8ColeccionesObligatoriosEjercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // como lo pide el enunciado de la guia
        ServicioAlumno ser = new ServicioAlumno();
        double prom1 = ser.cargarAlumnos();
        if (prom1!=-1){
            System.out.println("El promedio del alumno es: "+prom1);
        }
        
        
        // como yo creo que queda mejor el manejo de datos
        ser.cargarAlumnos2();          
        double prom = ser.notaFinal();
        if (prom!=-1){
            System.out.println("El promedio del alumno es: "+prom);
        }

        
        
        
    }
    
}
