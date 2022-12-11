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
public class Electrodomestico {
    
    private final char[] letras = {'A','B','C','D','E','F'};
    private String[] colores = {"Blanco", "Negro", "Rojo", "Azul", "Gris"}; 
    private double precio;
    private String color;
    private char consumo;
    private double peso;
    private double precioFinal;
    
    public Electrodomestico(){
        
    }
    
    public Electrodomestico(double p, String c, char con, double pe){
        this.precio = p;
        this.color = (this.comprobarColor(c)) ? c : "Blanco";
        this.consumo = (this.comprobarLetra(con)) ? con : 'F';
        this.peso = pe;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    private boolean comprobarLetra(char l){
        boolean ok = false;
        int i = 0;
        while (!ok && i < this.letras.length){
           ok = this.letras[i] == l;
           i++;
        }
        return ok;
    }
    
    private boolean comprobarColor(String color){
        boolean ok = false;
        int i = 0;
        while (!ok && i < this.colores.length){
           ok = this.colores[i].equalsIgnoreCase(color);
           i++;
        }
        return ok;
    }
    
}
