/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Matematica;

/**
 *
 * @author FedeC
 */
public class Ejercicio9 {
    
    public static void main (String args[]){
        Matematica m = new Matematica();
        
        m.setNum1(Math.random()*10.0);
        m.setNum2(Math.random()*10.0);
        System.out.println("Num1: "+m.getNum1()+ " - Num2: "+m.getNum2());
        System.out.println("Mayor: "+m.devolverMayor());
        System.out.println("Calcular Potencia: "+ m.calcularPotencia());
        System.out.println("Calcular Raiz: "+ m.calcularRaiz());
        
    }
    
}
