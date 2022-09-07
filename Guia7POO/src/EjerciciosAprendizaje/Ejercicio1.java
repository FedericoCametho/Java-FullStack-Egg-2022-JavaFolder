/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Libro;
import ServicioAprendizaje.LibroService;

/**
 *
 * @author FedeC
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LibroService libroServ = new LibroService();
        
        Libro lib1 = new Libro("192930","El secreto de sus Ojos","Damian Zifron",260);
        
        Libro lib2 = libroServ.crearLibroManualmente();
        
        
        System.out.println(lib1.toString());
        
        System.out.println(lib2.toString());
        
    }
    
}
