/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Persona;
import ServicioAprendizaje.PersonaService;

/**
 *
 * @author FedeC
 */
public class Ejercicio12 {
    
    public static void main (String args[]){
        PersonaService pServ = new PersonaService();
        
        Persona p = pServ.crearPersona();
        Persona p2 = pServ.crearPersona();
        
        
        System.out.println(pServ.calcularEdad(p));
        
        System.out.println(pServ.menorQue(p, p2));
        
        System.out.println(p.mostrarPersona());
        
        System.out.println(p2.mostrarPersona());
        
    }
    
    
}
