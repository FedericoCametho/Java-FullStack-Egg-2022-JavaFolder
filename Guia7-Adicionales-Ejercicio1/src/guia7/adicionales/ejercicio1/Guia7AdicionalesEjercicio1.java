/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia7.adicionales.ejercicio1;

import Entidad.Cancion;

/**
 *
 * @author FedeC
 */
public class Guia7AdicionalesEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cancion c = new Cancion ("Fix you", "Coldplay");
        
        Cancion c1 = new Cancion();
        c1.setAutor("u2");
        c1.setTitulo("beautiful day");
        
        System.out.println(c.getTitulo()+" "+c.getAutor());
        System.out.println(c1.getTitulo()+" "+c1.getAutor());
        
    }
    
}
