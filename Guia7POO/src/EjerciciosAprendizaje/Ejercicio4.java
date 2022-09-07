/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Rectangulo;
import ServicioAprendizaje.RectanguloService;

/**
 *
 * @author FedeC
 */
public class Ejercicio4 {
    public static void main (String arg[]){
        
        
        RectanguloService recService = new RectanguloService();
        
        Rectangulo r = recService.crearRectangulo();
        
        recService.dibujarRectangulo(r);
        
        
        
//        
//        
//        recService.dibujarRectangulo(r);
//        
//        Rectangulo r2 = new Rectangulo(7,3);
//        
//        recService.dibujarRectangulo(r2);
   }
}
