/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Cadena;
import ServicioAprendizaje.CadenaService;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Ejercicio8 {
    
    public static void main (String args[]){
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        Cadena c = new Cadena("Hola Mundo!!");
        
        Cadena c1 = new Cadena();
        System.out.println("Ingrese una frase");
        c1.setFrase(leer.next());
        
        
        CadenaService cServ = new CadenaService();
        
        System.out.println("Cantidad de vocales en la palabra "+ c.getFrase()+" es: "+ cServ.mostrarVocales(c.getFrase()));
        cServ.invertirFrase(c.getFrase());
        
        
        System.out.println("Cantidad de vocales en la palabra "+ c1.getFrase()+" es: "+ cServ.mostrarVocales(c1.getFrase()));
        cServ.invertirFrase(c1.getFrase());
        
        System.out.println("Ingrese una letra que quiera contabilizar en las frases");
        String caracter = leer.next();
        System.out.println("Cantidad de veces que se repite la letra "+caracter+" es: "+ cServ.vecesRepetido(caracter,c.getFrase()));
        System.out.println("Cantidad de veces que se repite la letra "+caracter+" es: "+ cServ.vecesRepetido(caracter,c1.getFrase()));
    
        if (cServ.compararLongitud(c1.getFrase(), "Una frase cualquiera")){
            System.out.println("Ambas frases tienen la misma longitud");
        } else {
            System.out.println("Las frases tienen distintas longitudes");
        }
    
    
    
    }
}
