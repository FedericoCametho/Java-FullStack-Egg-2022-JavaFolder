/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Ejercicio11 {
    
    public static void main(String args[]){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        
        System.out.println("Ingrese el anio");
        int anio = leer.nextInt();
        
        System.out.println("Ingrese el mes");
        int mes = leer.nextInt();
        
        System.out.println("Ingrese el dia");
        int dia = leer.nextInt(); 
        

        Date fecha2 = new Date();
        fecha2.setDate(dia);
        fecha2.setMonth(mes-1);
        fecha2.setYear(anio-1900);
        
        Date fecha = new Date();
        
        System.out.println(fecha.toString());
        System.out.println(fecha2.toString());
        
        
        long dif = fecha.getTime() - fecha2.getTime();
        System.out.println(pasajeMilisegundos(dif));
        
        
    }
    
    public static String pasajeMilisegundos(long num){
        long minutes = (num/1000)/60;
        long seconds = (num/1000)%60;
        long hours = minutes/60;
        long  dias = hours/24;
        return "Dias : "+dias + " - Horas : "+ hours + " - Minutos: "+minutes+ " - segundos: "+seconds;
        
    }
    
}
