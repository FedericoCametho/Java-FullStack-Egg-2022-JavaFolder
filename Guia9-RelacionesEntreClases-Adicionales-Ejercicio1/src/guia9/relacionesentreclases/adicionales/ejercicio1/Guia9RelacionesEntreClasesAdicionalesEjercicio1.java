/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9.relacionesentreclases.adicionales.ejercicio1;

import Servicio.ServicioAdopcion;

/**
 *
 * @author FedeC
 */
public class Guia9RelacionesEntreClasesAdicionalesEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ServicioAdopcion serv = new ServicioAdopcion();
        
        serv.generarAdopciones();
        serv.mostrarPersonasYPerros();
        
        
    }
    
}
