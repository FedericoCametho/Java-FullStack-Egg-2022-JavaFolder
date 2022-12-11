/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9.relacionesentreclases.obligatorios.ejercicio2;

import Entidad.Juego;
import Entidad.Jugador;
import Entidad.RevolverDeAgua;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Guia9RelacionesEntreClasesObligatoriosEjercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        RevolverDeAgua r = new RevolverDeAgua();
        r.llenarRevolver();
        ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
        
        System.out.println(r.toString());
        
        System.out.println("Ingrese la cantidad de jugadores (entre 1 y 6) - si selecciona una opcion fuera del rango se incluiran 6 jugadores");
        int cant = leer.nextInt();
        cant = (cant > 6 || cant < 1) ? 6 : cant;

        for (int i=0; i<cant; i++){
            listaJugadores.add(new Jugador(i+1));
        }
        
        Juego juego = new Juego();
        juego.llenarJuego(listaJugadores, r);
        listaJugadores.forEach(j -> System.out.println(j.getNombre()));
        System.out.println("**************" + juego.ronda().getNombre()+" se MOJO");
        
    }
    
}
