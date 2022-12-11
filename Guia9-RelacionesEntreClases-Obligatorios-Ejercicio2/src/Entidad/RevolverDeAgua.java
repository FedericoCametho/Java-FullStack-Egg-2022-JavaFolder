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
public class RevolverDeAgua {
    
    private int posActual;
    private int posAgua;
    
    
    public void llenarRevolver(){
        this.posActual = (int)(Math.random()*6 + 1);
        this.posAgua = (int)(Math.random()*6+1);
    }
    
    public boolean mojar(){
        return this.posActual == this.posAgua;
    }
    
    public void siguienteChorro(){
        this.posActual = (int)(Math.random()*6+1);
    }
    
    @Override
    public String toString(){
        return "La posicion ACtual del revolver es: "+this.posActual +" | La posicion del agua es "+this.posAgua;
    }
    
    
    
}
