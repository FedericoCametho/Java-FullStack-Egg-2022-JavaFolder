/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9.relacionesentreclases.obligatorios.ejercicio1;

import Entidad.Perro;
import Entidad.Persona;

/**
 *
 * @author FedeC
 */
public class Guia9RelacionesEntreClasesObligatoriosEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Perro largui = new Perro("Largui", "Salchicha callejero", "chico", 12);
        Perro coco = new Perro("Coquichulo", "Doberman", "Grande toro", 7);
        
        Persona p1 = new Persona("Fede", "Cametho", 33, 1111, largui);
        Persona p2 = new Persona("Mari", "Flammini", 32, 222, coco);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
    }
    
}
