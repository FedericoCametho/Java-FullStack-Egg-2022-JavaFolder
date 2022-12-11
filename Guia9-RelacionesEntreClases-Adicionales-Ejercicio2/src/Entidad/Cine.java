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
public class Cine {
    
    private String[][] sala;
    private Pelicula peli;
    private double precio;
    private String[] columnas = {"A","B","C","D","E","F"};
    private int totalAsientos;
    private int ocupados;
    
    public Cine(Pelicula p, double precio, int filas, int columnas){
        this.inicializarSala(filas, columnas);
        this.peli = p;
        this.precio = precio;
        this.totalAsientos = filas * columnas;
        this.ocupados = 0;
    }
    
      public int getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }
    public String[][] getSala() {
        return sala;
    }

    public void setSala(String[][] sala) {
        this.sala = sala;
    }

    public Pelicula getPeli() {
        return peli;
    }

    public void setPeli(Pelicula peli) {
        this.peli = peli;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    private void inicializarSala(int filas, int columnas){
        this.sala = new String[filas][columnas];
        for(int i=0; i < filas; i++){
            for (int j=0; j < columnas ; j++){
                this.sala[i][j] = (i+1)+this.columnas[j]+"   ";
            }
        }
    }
    
    
    
    
    
//    public void acomodarEspectador(Espectador e){
//        if ((this.totalAsientos - this.ocupados > 0) && 
//                (e.getEdad() >= this.peli.getEdadMin()) &&
//                (e.getDinero()>= this.getPrecio())){
//            int filaAsiento = (int)(Math.random()*this.sala.length);
//            int columnaAsiento = (int)(Math.random()*this.columnas.length);
//            if (this.sala[filaAsiento][columnaAsiento].contains("X")){
//                this.acomodarEspectador(e);
//            } else {
//                this.sala[filaAsiento][columnaAsiento] = (filaAsiento+1)+this.columnas[columnaAsiento]+" X ";
//                this.ocupados++;
//            }
//        } else
//            if (this.totalAsientos - this.ocupados == 0){
//                System.out.println("La sala esta Completa");
//        }
//    }

  
    
    
    
}
