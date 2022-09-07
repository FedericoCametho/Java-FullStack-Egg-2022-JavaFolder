/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadAprendizaje;

import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Rectangulo {
    
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    public Rectangulo(){
        
    }
    
    public double getBase() {
        return this.base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    public double getSuperficie(){
        return this.getBase()*this.getAltura();
    }
    
    public double getPerimetro(){
        return (this.getBase()+this.getAltura()) * 2;
    }
    
    
    
    
}
