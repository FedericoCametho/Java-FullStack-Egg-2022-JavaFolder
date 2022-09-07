/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadAprendizaje;

/**
 *
 * @author FedeC
 */
public class Cafetera {
    
    private double capacidadMaxima;
    private double cantidadActual;
    
    public Cafetera(){
        
    }
    
    public Cafetera(double capMax, double capActual){
        this.capacidadMaxima = capMax;
        this.cantidadActual = capActual;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
    public void llenarCafetera(){
        this.cantidadActual = this.getCapacidadMaxima();
    }
    
    public void servirTaza(double taza){
        if (taza < this.getCantidadActual()){
            this.cantidadActual = this.getCantidadActual() - taza;
            System.out.println("Se lleno la taza!!");
        } else{ 
            System.out.println("La taza se lleno con "+this.getCantidadActual());
            this.cantidadActual = 0;
        }
    }
    
    
    
    public void vaciarCafetera(){
        this.setCantidadActual(0);
    }
    
    public void agregarCafe(double cantidad){
        if (this.getCantidadActual() + cantidad <= this.getCapacidadMaxima()){
            this.cantidadActual = this.getCantidadActual() + cantidad;
        } else {
            this.cantidadActual = this.getCapacidadMaxima();
        }
    }
    
    
    
}
