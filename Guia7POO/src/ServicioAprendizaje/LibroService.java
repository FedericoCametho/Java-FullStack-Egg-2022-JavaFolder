/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.Libro;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class LibroService {
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Libro crearLibroManualmente(){
        System.out.println("Ingrese el ISBN, titulo, autor y numero de paginas presionando enter luego de cada dato");
        return new Libro(leer.next(), leer.next(), leer.next(), leer.nextInt());
    }
    
}
