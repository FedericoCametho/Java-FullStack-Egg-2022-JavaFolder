/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Operacion;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Ejercicio3 {
    
    public static void main (String[] args){
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        Operacion op = new Operacion();
        Operacion op2 = new Operacion(15, 3);
        
        op.crearOperacion();
        
        System.out.println("Sumar op : "+ op.getNum1()+" + "+op.getNum2()+ " = "+ op.sumar());
        System.out.println("Restar op : "+ op.getNum1()+" - "+op.getNum2()+ " = "+ op.restar());
        System.out.println("Multiplicar op : "+ op.getNum1()+" * "+op.getNum2()+ " = "+ op.multiplicar());
        System.out.println("Dividir op : "+ op.getNum1()+" / "+op.getNum2()+ " = "+ op.dividir());
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("Sumar op2 : "+ op2.getNum1()+" + "+op2.getNum2()+ " = "+ op2.sumar());
        System.out.println("Restar op2 : "+ op2.getNum1()+" - "+op2.getNum2()+ " = "+ op2.restar());
        System.out.println("Multiplicar op2 : "+ op2.getNum1()+" * "+op2.getNum2()+ " = "+ op2.multiplicar());
        System.out.println("Dividir op2 : "+ op2.getNum1()+" / "+op2.getNum2()+ " = "+ op2.dividir());
        
    }
    
}
