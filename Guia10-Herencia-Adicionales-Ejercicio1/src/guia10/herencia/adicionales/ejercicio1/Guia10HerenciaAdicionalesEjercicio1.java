/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10.herencia.adicionales.ejercicio1;

import Entidad.Barco;
import Entidad.BarcoAMotor;
import Entidad.Velero;
import Entidad.YateLujo;
import Servicio.ServicioAlquiler;

/**
 *
 * @author FedeC
 */
public class Guia10HerenciaAdicionalesEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        ServicioAlquiler servAlq = new ServicioAlquiler();
        
        Barco b1 = new Velero("Velero", 10, 2002, 5);
        Barco b2 = new BarcoAMotor("Motoneta", 20, 2015, 400);
        Barco b3 = new YateLujo("Yate lujo", 15, 2022, 400, 10);
        
        servAlq.crearAlquiler(b1);
        servAlq.crearAlquiler(b2);
        servAlq.crearAlquiler(b3);
        
        servAlq.mostrarAlquileres();
        
    }
    
}
