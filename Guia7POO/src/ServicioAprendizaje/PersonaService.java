/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.Persona;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class PersonaService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Persona crearPersona(){
        System.out.println("Ingrese el nombre de la persona");
        String nom = leer.next();
 
        System.out.println("Ingrese el sexo - H(Hombre), M(Mujer), O(otro)");
        String sexo = leer.next();
        while (!(sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("O"))){
            System.out.println("La opcion del sexo es incorrecta.");
            System.out.println("Ingrese el sexo - H(Hombre), M(Mujer), O(otro)");
            sexo = leer.next();
        }
        
        System.out.println("Ingrese el peso de la persona en kg");
        double peso = leer.nextDouble();
        
        System.out.println("Ingrese la altura de la persona en metros");
        double altura = leer.nextDouble();
        
        System.out.println("Ingrese la fecha de nacimiento de la persona ");
        System.out.println("Ingrese el anio");
        int anio = leer.nextInt();
        System.out.println("Ingrese el mes");
        int mes = leer.nextInt();
        System.out.println("Ingrese el dia");
        int dia = leer.nextInt(); 
        
        Date fecha = new Date();
        fecha.setDate(dia);
        fecha.setMonth(mes-1);
        fecha.setYear(anio-1900);
        
        
        return new Persona(nom, sexo, peso, altura, fecha);
        
    }
    
    public int calcularIMC(Persona p){
        double imc = p.getPeso()/(Math.pow(p.getAltura(), 2));
        if (imc < 20){
            return -1;
        } else if(imc <=25){
            return 0;
        } else {
            return 1;
        }
    }
    
    public boolean esMayorDeEdad(Persona p ){
        return p.getEdad()>18;
    }
    
    
    public long calcularEdad(Persona p){
        return (new Date().getTime() - p.getFechaNacimiento().getTime())/1000/3600/24/365;

    }
    
    public boolean menorQue(Persona p1, Persona p2){
        return this.calcularEdad(p1) < this.calcularEdad(p2);
    }
    
}
