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
public class Jugador {
    
    private int id;
    private String nombre;
    private boolean mojado;
    
    public Jugador(int id){
        this.id = id;
        this.nombre = "Jugador "+this.id;
        this.mojado = false;
    }
    
    public boolean disparo(RevolverDeAgua r){
        this.mojado = r.mojar();
        r.siguienteChorro();
        return this.mojado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
    
    
}
