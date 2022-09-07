/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia7.adicionales.ejercicio5;

import Entidad.Meses;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Guia7AdicionalesEjercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int limite = 3;
        Meses m = new Meses();
        

        System.out.println("Ingrese el nombre del mes en minusculas");
        String opcion = leer.next().toLowerCase().trim();
        int intentos = 1;
        while ((!opcion.equals(m.getMesSecreto()) && (intentos < limite) )){
            System.out.println("No ha acertado. Aun le quedan "+(limite-intentos)+" para adivinar. Intente introduciendo otro mes: ");
            intentos++;
            opcion= leer.next().toLowerCase().trim();
        }
        
        
        if (opcion.equals(m.getMesSecreto())){
            System.out.println("Ha acertado!!! El mes secreto es: "+m.getMesSecreto());
        } else {
            System.out.println("Lo lamentamos, no ha acertado. Pruebe mas tarde.");
        }
    }
    
}
