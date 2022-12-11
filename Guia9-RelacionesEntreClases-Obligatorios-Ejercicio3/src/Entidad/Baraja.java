/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author FedeC
 */
public class Baraja {
    private List<Carta> mazo;
    private List<Carta> monton;
    
    public Baraja(){
        this.mazo = new ArrayList<Carta>();
        this.monton = new ArrayList<Carta>();
    }
    
    
    private void crearMazo(){
        String[] palos = {"Espada", "Oro", "Basto", "Copa"};
        for (String p : palos){
            for (int i = 1; i<13; i++){
                if (i < 8 || i > 9){
                    this.mazo.add(new Carta(p, i));
                }
            }
        }
    }
    
    public void barajar(){
       this.crearMazo();
       Collections.shuffle(this.mazo);
    }
    
    public Carta siguienteCarta(){
        if (this.mazo.isEmpty()){
            System.out.println("No hay mas cartas en el mazo");
            return null;
        } else{
            Carta c = this.mazo.remove(0);
            this.monton.add(c);
            return c;
        }
    }
    
    public int cartasDisponibles(){
        return this.mazo.size();
    }
    
    public ArrayList<Carta> darCartas(int num){
        if (num > this.mazo.size()){
            System.out.println("No hay cartas suficientes");
            return null;
        } else{
            ArrayList<Carta> cartas = new ArrayList<Carta>();
            for (int i=0; i<num; i++){
                cartas.add(this.siguienteCarta());
            }
            return cartas;
        }
    }
    
    public List<Carta> cartasMonton(){
        return this.monton;
    }
    
    public void mostrarBaraja(){
        this.mazo.forEach(c -> System.out.println(c.toString()));
        System.out.println(this.mazo.size());
    }
    
}
