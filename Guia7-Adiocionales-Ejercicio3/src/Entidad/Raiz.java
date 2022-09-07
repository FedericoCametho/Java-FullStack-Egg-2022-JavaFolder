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
public class Raiz {
    
    private double a;
    private double b;
    private double c;

    public Raiz(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Raiz(){
        
    }

    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return this.c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    
    
    
    public double getDiscriminante(){
        return (Math.pow(this.getB(),2)-(4*a*c));
    }
    
    public boolean tieneRaices(){
        return this.getDiscriminante()>0;
    }
    
    public boolean tieneRaiz(){
        return this.getDiscriminante()==0;
    }
    
    public void obtenerRaices(){
        if (this.tieneRaices()){
            System.out.println("1er Raiz = "+ this.resolverRaizPositivo());
            System.out.println("2nda Raiz = "+ this.resolverRaizNegativo());
        }
    }
    
    public void obtenerRaiz(){
        if (this.tieneRaiz()){
            System.out.println("Unica Raiz = "+ this.resolverRaizPositivo());
        }
    }
    
    public void calcular(){
        if (this.tieneRaices()){
            this.obtenerRaices();
        } else {
            if (this.tieneRaiz()){
                this.obtenerRaiz();
            } else {
                System.out.println("La ecuacion de 2ndo grado planteada no tiene solucion");
            }
        }
    }
    
    private double resolverRaizPositivo(){
        return (-b+Math.sqrt(Math.pow(this.getB(),2)-(4*a*c)))/(2*a);
    }
    
    private double resolverRaizNegativo(){
        return (-b-Math.sqrt(Math.pow(this.getB(),2)-(4*a*c)))/(2*a);
    }
    
}
