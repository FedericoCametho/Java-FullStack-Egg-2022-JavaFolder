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
public class Meses {
    
    private final String[] meses = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto", "septiembre","octubre","noviembre","diciembre"};
    private String mesSecreto;
    
    public Meses(){
        this.mesSecreto = this.meses[6];
    }
    
    public String getMesSecreto(){
        return this.mesSecreto;
    }
    
    
    
}
