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
public class Ahorcado {
    
    private char[] palabra;
    private char[] palabraOculta;
    private int cantEncontradas;
    private int limiteJugadas;
    private int chancesActual;
    
    
    public Ahorcado(String palabra, int maxIntentos){
        this.palabra = new char[palabra.length()];
        this.cargarPalabra(this.palabra, palabra);
        this.cantEncontradas = 0;
        this.limiteJugadas = maxIntentos;
        this.palabraOculta = new char[palabra.length()];
        this.inicializarPalabraOculta(this.palabraOculta);
        this.chancesActual = 0;
    }
    
    private void inicializarPalabraOculta(char[] palabra){
        int limite = palabra.length;
        for (int i = 0; i < limite ; i++){
            palabra[i] = '_';
        }
    }
    
    private void cargarPalabra(char[] palabra, String dato){
        int limite = dato.length();
        for (int i = 0; i < limite; i++){
            palabra[i] = dato.charAt(i);
        }
    }
    
    public int getCantEncontradas(){
        return this.cantEncontradas;
    }
    
    public void incrementarCantEncontradas(int num){
        this.cantEncontradas = this.getCantEncontradas() + num;
    }
    
    public int getLimiteJugadas(){
        return this.limiteJugadas;
    }
    
    public char[] getPalabraOculta(){
        return this.palabraOculta;
    }
    
    public void setLimiteJugadas(int num){
        this.limiteJugadas = num;
    }

    public int getChancesActual() {
        return chancesActual;
    }

    public void incrementarChances() {
        this.chancesActual++;
    }
    
    
    
    public void mostrarPalabraOculta(){
        System.out.println(this.palabraOculta);
    }
    
    public void mostrarSolucion(){
        System.out.println(this.palabra);
    }
    
    public char[] getPalabra(){
        return this.palabra;
    }
    
}
