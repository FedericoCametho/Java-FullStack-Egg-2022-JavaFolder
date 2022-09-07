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
public class Punto {
    
    private double[] punto1;
    private double[] punto2;
    
    public Punto(){
        
    }
    
    public Punto(double x1, double y1, double x2, double y2){
        this.punto1 = new double[2];
        this.punto2 = new double[2];
        this.punto1[0] = x1;
        this.punto1[1] = y1;   
        this.punto2[0] = x2;
        this.punto2[1] = y2;
    }

    public double[] getPunto1() {
        return punto1;
    }

    public void setPunto1(double[] punto1) {
        this.punto1 = punto1;
    }

    public double[] getPunto2() {
        return punto2;
    }

    public void setPunto2(double[] punto2) {
        this.punto2 = punto2;
    }
    
    
    
    
}
