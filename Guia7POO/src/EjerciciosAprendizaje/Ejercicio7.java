/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.Persona;
import ServicioAprendizaje.PersonaService;
import java.util.Date;

/**
 *
 * @author FedeC
 */
public class Ejercicio7 {
    
    public static void main (String args[]){
        
        int dimF = 4;
        
        PersonaService pSer = new PersonaService();
        
        Persona p = pSer.crearPersona();
        Persona p1 = new Persona("Federico", "H", 78, 1.76, new Date() );        
        Persona p2 = new Persona("Juan" , "O", 60, 1.76, new Date());
        Persona p3 = new Persona("Mariana","M", 59, 1.62, new Date() );
        
        Persona[] vectorPersonas = new Persona[dimF];
        vectorPersonas[0] = p;
        vectorPersonas[1] = p1;
        vectorPersonas[2] = p2;
        vectorPersonas[3] = p3;
 

        int mayores = 0;
        int bajoPeso = 0;
        int pesoIdeal = 0;
        int sobrePeso = 0;
        
        for (Persona per: vectorPersonas){
            if (pSer.esMayorDeEdad(per)){
                mayores++;   
            }
            
            int imc = pSer.calcularIMC(per);
            System.out.println("IMC: "+ imc);
            if (imc < 0){
                bajoPeso++;
            } else {
                if(imc == 0){
                    pesoIdeal++;
                } else {
                    sobrePeso++;
                }
        }
        

        
        System.out.println("El porcentaje de gente mayor de edad es: "+ (double)mayores/vectorPersonas.length*100.0+"%");
        System.out.println("El porcentaje de gente con Bajo IMC es: "+ (double)bajoPeso / vectorPersonas.length*100.0+"%");
        System.out.println("El porcentaje de gente con Ideal IMC es: "+ (double)pesoIdeal / vectorPersonas.length*100.0+"%");
        System.out.println("El porcentaje de gente con Alto IMC es: "+ (double)sobrePeso / vectorPersonas.length*100.0+"%");
        
        
    }
    
    }
}
