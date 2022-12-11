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
public abstract class Barco {
    
    protected String matricula;
    protected double eslora;
    protected int anio;
    
    
    public Barco (String m, double e, int a){
        this.matricula = m;
        this.eslora = e;
        this.anio = a;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public int getAnio() {
        return anio;
    }
    
    public double getModulo(){
        return this.eslora * 10;
    }
    
}
