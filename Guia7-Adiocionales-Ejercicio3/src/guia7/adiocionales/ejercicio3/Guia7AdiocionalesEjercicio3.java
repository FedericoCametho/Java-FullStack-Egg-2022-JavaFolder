/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia7.adiocionales.ejercicio3;

import Entidad.Raiz;

/**
 *
 * @author FedeC
 */
public class Guia7AdiocionalesEjercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Raiz r = new Raiz(2,-14,24);
        Raiz r2 = new Raiz(-1,4,-4);
        
        
        r.calcular();
        System.out.println("-----------------------");
        r2.calcular();
       
    }
    
}
