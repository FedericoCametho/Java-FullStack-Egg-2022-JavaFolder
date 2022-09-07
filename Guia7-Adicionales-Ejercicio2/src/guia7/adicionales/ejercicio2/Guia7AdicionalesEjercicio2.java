/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia7.adicionales.ejercicio2;

import Entidad.Punto;
import Servicio.PuntoService;

/**
 *
 * @author FedeC
 */
public class Guia7AdicionalesEjercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PuntoService pServ = new PuntoService();
      
        Punto p = pServ.crearPunto();
  
        System.out.println("La distancia entre los puntos es de: ".format("%.2f",pServ.distanciaEntrePuntos(p)));
            
        
    }
    
}
