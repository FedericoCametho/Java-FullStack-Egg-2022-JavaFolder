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
public class Velero extends Barco{
    
    private int mastiles;
    
    public Velero(String m, double e, int a, int mas){
        super(m,e,a);
        this.mastiles = mas;
    }

    public int getMastiles() {
        return mastiles;
    }
    
    @Override
    public double getModulo(){
        return super.getModulo() + this.mastiles;
    }
}
