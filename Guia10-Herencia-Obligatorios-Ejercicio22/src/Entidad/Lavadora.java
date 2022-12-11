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
public class Lavadora extends Electrodomestico{
    
    private String carga;
    
    public Lavadora(){
        
    }
    public Lavadora(double p, String c, char con, double pe, String car){
        super(p,c,con,pe);
        this.carga = car;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }
    
    
    
}
