/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import java.util.Arrays;

/**
 *
 * @author FedeC
 */
public class Ejercicio10 {
    
    public static void main(String argsp[]){
        
        double [] arrayA = new double[50];
        double [] arrayB = new double[20];
        
        for (int i=0; i<arrayA.length;i++){
            arrayA[i] = Math.random()*10;
        }
        System.out.print("Array A: ");mostrarArreglo(arrayA);
        //ordenarArreglo(arrayA);
        Arrays.sort(arrayA);
        
        System.out.println("");
        System.out.print("Array A: ");mostrarArreglo(arrayA);
        
        //llenarArregloB(arrayB,arrayA);
        arrayB = Arrays.copyOf(arrayA, 20);
        Arrays.fill(arrayB, arrayB.length/2, arrayB.length, 0.5);
        
        System.out.println("");
        System.out.print("Array B: ");mostrarArreglo(arrayB);
        
    }
    

    public static void mostrarArreglo(double [] a){
        for (double elem: a){
            String num = ""+elem;
            System.out.print(num.format("%.2f", elem)+" | ");
        }
    }
    
//    public static void ordenarArreglo(double[] a){
//        for (int i=0; i<a.length; i++){
//            for (int j = 0; j<a.length-1; j++){
//                if (a[j]>a[j+1]){
//                    double aux = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = aux;
//                }
//            }
//        }
//    }
    
    
    
//    public static void llenarArregloB(double[] b, double[] a){
//        for(int i=0; i<10; i++){
//            b[i] = a[i];
//        }      
//    }
//    
    
}