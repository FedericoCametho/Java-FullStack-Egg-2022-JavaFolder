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
public class YateLujo extends BarcoAMotor {
    
    private int camarotes;
    
    public YateLujo(String m, double e, int a, double p, int c){
        super(m,e,a,p);
        this.camarotes = c;
    }

    public int getCamarotes() {
        return camarotes;
    }
    
    @Override
    public double getModulo(){
        return super.getModulo() + this.camarotes;
    }
    
}
