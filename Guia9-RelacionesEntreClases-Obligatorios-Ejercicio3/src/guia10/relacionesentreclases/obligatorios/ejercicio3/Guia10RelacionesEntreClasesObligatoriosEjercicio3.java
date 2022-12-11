/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10.relacionesentreclases.obligatorios.ejercicio3;

import Entidad.Baraja;
import Entidad.Carta;
import java.util.ArrayList;

/**
 *
 * @author FedeC
 */
public class Guia10RelacionesEntreClasesObligatoriosEjercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Baraja mazo = new Baraja();
        mazo.barajar();
        mazo.mostrarBaraja();
        System.out.println("***************************************");
        ArrayList<Carta> cartasDadas = mazo.darCartas(5);
        System.out.println("Cartas disponibles: " + mazo.cartasDisponibles());
        System.out.println(mazo.siguienteCarta().toString());
        System.out.println("Cartas en el monton " + mazo.cartasMonton());
        
        mazo.darCartas(50);
        System.out.println("Cartas disponibles: " + mazo.cartasDisponibles());
        System.out.println("Cartas en el monton " + mazo.cartasMonton());
        System.out.println("*************Las cartas que se dieron al principio fueron: **********");
        cartasDadas.forEach(c -> System.out.println(c.toString()));
        System.out.println("***************************************");
        mazo.darCartas(25);
        mazo.mostrarBaraja();
    }
    
}
