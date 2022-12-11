/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FedeC
 */
public class Juego {
    
    private List<Jugador> listaJugadores;
    private RevolverDeAgua revolver;
    
    public Juego(){
        this.listaJugadores = new ArrayList<Jugador>();
    }
    
    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverDeAgua r){
        this.listaJugadores = jugadores;
        this.revolver = r;
    }
    
    
    public Jugador ronda(){
        boolean fin = false;
        int i = 0;
        while (!fin){
            fin = this.listaJugadores.get(i).disparo(this.revolver);
            //System.out.println(this.listaJugadores.get(i).getNombre()); debugger de turnos de jugadores
            if (!fin){
                if (i< this.listaJugadores.size()-1){
                    i++;
                } else {
                    i = 0;
                }
            }
        }
        return this.listaJugadores.stream().filter(j -> j.isMojado()==true).findFirst().orElse(null);
    }
    
}
