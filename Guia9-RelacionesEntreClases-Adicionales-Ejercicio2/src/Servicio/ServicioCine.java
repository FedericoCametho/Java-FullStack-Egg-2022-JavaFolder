/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Cine;
import Entidad.Espectador;
import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FedeC
 */
public class ServicioCine {
    
    private List<Espectador> espectadores;
    private Cine cine;
    
    public ServicioCine(){
        this.espectadores = new ArrayList<Espectador>();
        this.generarEspectadores();
        this.cine = new Cine(new Pelicula("Batman", 1.5, 14, "Tarantino"), 1000, 8, 6);
    }
    
    
    private void generarEspectadores(){//15, DE LOS CUALES 3 SON MENORES Y UNO NO TIENE PLATA ENTONCES 12 ENTRAN
        this.espectadores.add(new Espectador("Fede", 33, 5000));
        this.espectadores.add(new Espectador("AAAA", 13, 8000));
        this.espectadores.add(new Espectador("BBBB", 21, 6000));
        this.espectadores.add(new Espectador("CCCC", 12, 3000));
        this.espectadores.add(new Espectador("DDDD", 5, 51000));
        this.espectadores.add(new Espectador("EEEE", 54, 500));
        this.espectadores.add(new Espectador("TTTT", 69, 5000));
        this.espectadores.add(new Espectador("KKKK", 44, 5000));
        this.espectadores.add(new Espectador("OOOO", 51, 5000));
        this.espectadores.add(new Espectador("PPPP", 27, 5000));
        this.espectadores.add(new Espectador("WWWW", 32, 5000));
        this.espectadores.add(new Espectador("YYYY", 55, 5000));
        this.espectadores.add(new Espectador("ZZZZ", 87, 5000));
        this.espectadores.add(new Espectador("XXXX", 44, 5000));
        this.espectadores.add(new Espectador("KKKK", 15, 5000));    
        
//        
//        this.espectadores.add(new Espectador("EEEE", 54, 500));
//        this.espectadores.add(new Espectador("TTTT", 69, 5000));
//        this.espectadores.add(new Espectador("KKKK", 44, 5000));
//        this.espectadores.add(new Espectador("OOOO", 51, 5000));
//        this.espectadores.add(new Espectador("PPPP", 27, 5000));
//        this.espectadores.add(new Espectador("WWWW", 32, 5000));
//        this.espectadores.add(new Espectador("YYYY", 55, 5000));
//        this.espectadores.add(new Espectador("ZZZZ", 87, 5000));
//        this.espectadores.add(new Espectador("XXXX", 44, 5000));
//        this.espectadores.add(new Espectador("KKKK", 15, 5000));   
//        this.espectadores.add(new Espectador("EEEE", 54, 500));
//        this.espectadores.add(new Espectador("TTTT", 69, 5000));
//        this.espectadores.add(new Espectador("KKKK", 44, 5000));
//        this.espectadores.add(new Espectador("OOOO", 51, 5000));
//        this.espectadores.add(new Espectador("PPPP", 27, 5000));
//        this.espectadores.add(new Espectador("WWWW", 32, 5000));
//        this.espectadores.add(new Espectador("YYYY", 55, 5000));
//        this.espectadores.add(new Espectador("ZZZZ", 87, 5000));
//        this.espectadores.add(new Espectador("XXXX", 44, 5000));
//        this.espectadores.add(new Espectador("KKKK", 15, 5000));  
//        this.espectadores.add(new Espectador("EEEE", 54, 500));
//        this.espectadores.add(new Espectador("TTTT", 69, 5000));
//        this.espectadores.add(new Espectador("KKKK", 44, 5000));
//        this.espectadores.add(new Espectador("OOOO", 51, 5000));
//        this.espectadores.add(new Espectador("PPPP", 27, 5000));
//        this.espectadores.add(new Espectador("WWWW", 32, 5000));
//        this.espectadores.add(new Espectador("YYYY", 55, 5000));
//        this.espectadores.add(new Espectador("ZZZZ", 87, 5000));
//        this.espectadores.add(new Espectador("XXXX", 44, 5000));
//        this.espectadores.add(new Espectador("KKKK", 15, 5000));  
//        this.espectadores.add(new Espectador("EEEE", 54, 500));
//        this.espectadores.add(new Espectador("TTTT", 69, 5000));
//        this.espectadores.add(new Espectador("KKKK", 44, 5000));
//        this.espectadores.add(new Espectador("OOOO", 51, 5000));
//        this.espectadores.add(new Espectador("PPPP", 27, 5000));
//        this.espectadores.add(new Espectador("WWWW", 32, 5000));
//        this.espectadores.add(new Espectador("YYYY", 55, 5000));
//        this.espectadores.add(new Espectador("ZZZZ", 87, 5000));
//        this.espectadores.add(new Espectador("XXXX", 44, 5000));
//        this.espectadores.add(new Espectador("KKKK", 15, 5000));  
//        
    }
    
    public void acomodarEspectadores(){
        this.espectadores.forEach(e -> this.acomodarEspectador(e));
    }
    
    private void acomodarEspectador(Espectador e){
        if ((this.cine.getTotalAsientos() > this.cine.getOcupados()) && 
                (e.getEdad() >= this.cine.getPeli().getEdadMin()) &&
                (e.getDinero()>= this.cine.getPrecio())){
            int filaAsiento = (int)(Math.random()*this.cine.getSala().length);
            int columnaAsiento = (int)(Math.random()*this.cine.getColumnas().length);
            if (this.cine.getSala()[filaAsiento][columnaAsiento].contains("X")){
                this.acomodarEspectador(e);
            } else {
                this.cine.getSala()[filaAsiento][columnaAsiento] = (filaAsiento+1)+this.cine.getColumnas()[columnaAsiento]+" X ";
                this.cine.setOcupados(this.cine.getOcupados()+1);
            }
        } else
            if (this.cine.getTotalAsientos() - this.cine.getOcupados() == 0){
                System.out.println("La sala esta Completa");
        }
    }
    
    
    public void mostrarSala(){
        for(int i=0; i < this.cine.getSala().length; i++){
            for (int j=0; j < this.cine.getSala()[0].length ; j++){
                if (j < this.cine.getSala()[0].length-1){
                    System.out.print(this.cine.getSala()[i][j] + "|");
                } else {
                    System.out.println(this.cine.getSala()[i][j]);
                }
            }
            System.out.println("");
        }
    }
    
}
