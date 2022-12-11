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
public class BarcoAMotor extends Barco{
    
    protected double potenciaCV;
    
    public BarcoAMotor(String m, double e, int a, double p){
        super(m,e,a);
        this.potenciaCV = p;
    }

    public double getPotenciaCV() {
        return potenciaCV;
    }
    
    @Override
    public double getModulo(){
        return super.getModulo() + this.potenciaCV;
    }
}
