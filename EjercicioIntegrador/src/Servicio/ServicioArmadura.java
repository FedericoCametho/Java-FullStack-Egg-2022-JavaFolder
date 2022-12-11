/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Armadura;
import Entidad.Bota;
import Entidad.Consola;
import Entidad.Guante;
import Entidad.Sintetizador;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class ServicioArmadura {
    
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private HashMap<String, Integer> materiales;

    public ServicioArmadura(){
        this.inicializarMateriales();
    }
    
    private void inicializarMateriales(){
        this.materiales = new HashMap<String, Integer>();
        this.materiales.put("Hierro", 5000);
        this.materiales.put("Acero", 3000);
        this.materiales.put("Plata", 4000);
    }
    
    public Armadura crearArmadura(){
        System.out.println("Ingrese el color Primario");
        String cp = leer.next();
        System.out.println("Ingrese el color Secundario");
        String cs = leer.next();
        String mat;
        do {
            System.out.println("Seleccione el material");
            this.materiales.keySet().forEach(m -> System.out.println("* " + m));
            mat = leer.next();
        } while (!this.materiales.keySet().contains(mat));        
        
        
        
        
        return new Armadura(cp, cs, this.materiales.get(mat), 100, new Bota(), new Bota(), new Guante(), new Guante(), new Consola(), new Sintetizador(), new Generador());
    }
    
    
    
    
}
