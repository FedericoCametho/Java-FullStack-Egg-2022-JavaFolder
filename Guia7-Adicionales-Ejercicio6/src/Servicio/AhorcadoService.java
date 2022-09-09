/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Ahorcado;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author FedeC
 */
public class AhorcadoService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Ahorcado crearJuego(){
        System.out.println("Ingrese una cantidad de intentos limite para esta partida");
        int cantIntentos = leer.nextInt();
        System.out.println("Ingrese la palabra que quiera que se adivine");
        return new Ahorcado(leer.next(), cantIntentos);
    }
    
    private int getLongitud(Ahorcado a){
        return a.getPalabra().length;
    }
    
    private boolean buscar(char letra, Ahorcado a){
        boolean encontre = false;
        int i = 0;
        char[] palabra = a.getPalabra();
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        if (Arrays.toString(palabra).contains(""+letra)){
            while (i<palabra.length){
                if (palabra[i] == letra){
                    posiciones.add(i);
                    encontre = true;
                }
                i++;
            }
        }
        if (encontre){
            int limite = posiciones.toArray().length;
            System.out.println("La letra "+ letra+ " se encuentra en la palabra oculta");
            modificarPalabraOculta(a.getPalabraOculta(), posiciones, letra);
            a.incrementarCantEncontradas(limite);
        } else{
            System.out.println("La letra "+ letra + " NO se encuentra en la palabra escondida");
            a.incrementarChances();
        }
        return encontre;
    }
    
    private boolean encontradas(char letra, Ahorcado a){
        boolean aux = this.buscar(letra, a);
        System.out.println("Se han encontrado: "+ a.getCantEncontradas()+ " letras");
        System.out.println("Faltan encontrar: "+ (a.getPalabra().length-a.getCantEncontradas()));
        
        return aux;
    }
    
    private void modificarPalabraOculta(char[] palabra, ArrayList<Integer> posiciones, char letra){
        int limite = posiciones.toArray().length;
        for(int i=0; i< limite; i++){
            palabra[posiciones.get(i)] = letra; 
        }
    }
    
    private int intentos(Ahorcado a){
        return a.getLimiteJugadas()-a.getChancesActual();
    }
    
    public void juego(Ahorcado a){
        System.out.println("------------------------------------------------------------------");
        System.out.println("La longitud de la palabra a adivinar es: "+ a.getPalabra().length);
        boolean encontre = false;
        while (a.getChancesActual() < a.getLimiteJugadas() && !encontre){
            a.mostrarPalabraOculta();
            System.out.println("Intentos totales " + a.getLimiteJugadas());
            System.out.println("Intentos restantes: "+ this.intentos(a));
            System.out.println("Ingrese su intento de adivinar la letra");
            this.encontradas(leer.next().charAt(0), a);
            encontre = a.getCantEncontradas() == a.getPalabraOculta().length;
            System.out.println("------------------------------------------------------------------");
        }
        if( encontre){
            System.out.println("FELICITACIOOOOOONES ADIVINASTE!!");
        } else {
            System.out.println("FRACASADO RAAANCIO TE QUEDASTE SIN CHANCES");
        }
        System.out.println("La palabra oculta es: ");a.mostrarSolucion();
    }

}

