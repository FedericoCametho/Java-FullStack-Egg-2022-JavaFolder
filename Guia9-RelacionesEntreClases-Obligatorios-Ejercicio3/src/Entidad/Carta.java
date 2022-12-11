/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author FedeC
 */
public class Carta {
    private String palo;
    private int numero;
    
    public Carta(String palo, int num){
        this.numero = num;
        this.palo = palo;
    }
    
    @Override
    public String toString(){
        return this.numero + " de " + this.palo;
    }
}
