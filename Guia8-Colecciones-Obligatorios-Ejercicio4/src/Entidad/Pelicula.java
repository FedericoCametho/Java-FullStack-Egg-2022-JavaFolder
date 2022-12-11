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
public class Pelicula {
    
    private String titulo;
    private String director;
    private double duracion;
    
    public Pelicula(String titulo, String dire, double duracion){
        this.titulo = titulo;
        this.director = dire;
        this.duracion = duracion;
    }
    
    public Pelicula(){
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    
    
}
