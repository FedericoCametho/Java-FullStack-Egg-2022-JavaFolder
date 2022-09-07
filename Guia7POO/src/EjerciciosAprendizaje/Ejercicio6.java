/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Cafetera;

/**
 *
 * @author FedeC
 */
public class Ejercicio6 {
    
    
    public static void main (String args[]){
        
        Cafetera cafecito = new Cafetera(5000, 2500);
        System.out.println("Cantidad Actual: "+cafecito.getCantidadActual());
        
        cafecito.servirTaza(300);
        System.out.println("Cantidad Actual: "+cafecito.getCantidadActual());
        
        cafecito.llenarCafetera();
        System.out.println("Cantidad Actual: "+cafecito.getCantidadActual());
        
        
        cafecito.vaciarCafetera();
        System.out.println("Cantidad Actual: "+cafecito.getCantidadActual());
        
        cafecito.agregarCafe(3666);
        System.out.println("Cantidad Actual: "+cafecito.getCantidadActual());
        
    }
}
