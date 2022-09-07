/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Circunferencia;
import ServicioAprendizaje.CircunferenciaService;

/**
 *
 * @author FedeC
 */
public class Ejercicio2 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Circunferencia c1 = new Circunferencia(180);
        
        CircunferenciaService cirSer = new CircunferenciaService();
        
        Circunferencia c2 = cirSer.crearCircunferencia();
        
        
        System.out.println(c1.getInfo());
        
        System.out.println(c2.getInfo());
        
        c1.crearCircunferencia();
        System.out.println(c1.getInfo());
        
    }
    
}
