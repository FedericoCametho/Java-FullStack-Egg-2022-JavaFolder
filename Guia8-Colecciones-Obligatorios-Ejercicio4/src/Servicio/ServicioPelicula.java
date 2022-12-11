/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class ServicioPelicula {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private List<Pelicula> listaPeli;
    
    public ServicioPelicula(){
        this.listaPeli = new ArrayList<Pelicula>();
    }
    
    private Pelicula cargarPelicula(){
        Pelicula p = new Pelicula();
        System.out.println("Ingrese el Titulo de la pelicula");
        p.setTitulo(leer.next());
        System.out.println("Ingrese el Nombre del director");
        p.setDirector(leer.next());
        System.out.println("Ingrese la duracion de la pelicula");
        p.setDuracion(leer.nextDouble());
        return p;
    }
    
    public void cargarPeliculas(){
        do {
          this.listaPeli.add(this.cargarPelicula());
        } while (this.menuOpcion());   
    }
    
    public void mostrarPeliculas(){
        this.listaPeli.forEach(p -> this.mostrarPeli(p));  
    }
    
    public void mostrarPeliculasDuracionMayor(){
        this.listaPeli.stream().filter(p -> p.getDuracion() > 1).forEach(p -> this.mostrarPeli(p));
    }
    
    public void mostrarPeliculasOrdenadasDuracionDescendente(){
        List<Pelicula> lista = new ArrayList<Pelicula>(this.listaPeli);
        lista.sort(Comparator.comparingDouble(p -> p.getDuracion()));
        lista.forEach(p -> this.mostrarPeli(p));
    }
    
    public void mostrarPeliculasOrdenadasDuracionAscendente(){
        List<Pelicula> lista = new ArrayList<Pelicula>(this.listaPeli);
        lista.sort(Comparator.comparingDouble(p -> p.getDuracion()));
        Collections.reverse(lista);
        lista.forEach(p -> this.mostrarPeli(p));
    }
    
    public void mostrarPeliculasAlfabeticaTitulo(){
        List<Pelicula> lista = new ArrayList<Pelicula>(this.listaPeli);
        Collections.sort(lista, compararTitulo);
        lista.forEach(p -> this.mostrarPeli(p));
    }
    
    public void mostrarPeliculasAlfabeticaDirector(){
        List<Pelicula> lista = new ArrayList<Pelicula>(this.listaPeli);
        Collections.sort(lista, compararDirector);
        lista.forEach(p -> this.mostrarPeli(p));
    }
    
    
    public void mostrarPeliculasAfabeticaDirector(){
        
    }
    
    private void mostrarPeli(Pelicula p){
        System.out.println("---- Pelicula ----");
        System.out.println("Titulo: "+p.getTitulo());
        System.out.println("Director: "+p.getDirector());
        System.out.println("Duracion: "+p.getDuracion());
    }
    
    
    
    private boolean menuOpcion(){
        int opcion;
        do {
            System.out.println("1. Ingresar otra Pelicula");
            System.out.println("2. Salir");
            opcion = this.leer.nextInt();
        } while ((opcion < 1) || (opcion > 2));
        return opcion==1;  
    }
    
    public static Comparator<Pelicula> compararTitulo = new Comparator<Pelicula>(){
        @Override
        public int compare(Pelicula p1, Pelicula p2){
            return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };
    
    public static Comparator<Pelicula> compararDirector = new Comparator<Pelicula>(){
        @Override
        public int compare(Pelicula p1, Pelicula p2){
            return p1.getDirector().compareTo(p2.getDirector());
        }
    };
    
}
