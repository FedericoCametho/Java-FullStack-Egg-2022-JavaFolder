/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia7.adicionales.ejercicio6;

import Entidad.Ahorcado;
import Servicio.AhorcadoService;


/**
 *
 * @author FedeC
 */
public class Guia7AdicionalesEjercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AhorcadoService aServ = new AhorcadoService();
        Ahorcado a = aServ.crearJuego();
        aServ.juego(a);
        
        
    }
    
}
