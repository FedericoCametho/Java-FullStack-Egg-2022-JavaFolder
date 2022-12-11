/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;

/**
 *
 * @author FedeC
 */

public class Armadura {
    
    private String colorPrimario;
    private String colorSecundario;
    private int resistencia;
    private int salud;
    private ArrayList<Dispositivo> dispositivos;
    private Generador bateria;
    
    
    public Armadura(String cp, String cs, int r, int s, Bota bi, Bota bd, Guante gi, Guante gd, Consola c, Sintetizador sz, Generador b){
        this.colorPrimario = cp;
        this.colorSecundario = cs;
        this.resistencia = r;
        this.salud = s;
        this.dispositivos = new ArrayList();
        this.bateria = b;
        this.dispositivos.add(bi);
        this.dispositivos.add(bd);
        this.dispositivos.add(gi);
        this.dispositivos.add(gd);
        this.dispositivos.add(c);
        this.dispositivos.add(sz);
    }
    
    
    
}
