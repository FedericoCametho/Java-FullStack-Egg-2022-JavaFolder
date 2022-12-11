/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia8.colecciones.obligatorios.ejercicio4;

import Servicio.ServicioPelicula;

/**
 *
 * @author FedeC
 */
public class Guia8ColeccionesObligatoriosEjercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ServicioPelicula serv = new ServicioPelicula();
        
        serv.cargarPeliculas();
        System.out.println("IMPRIMIENDO TODAS LAS PELICULAS ************************");
        serv.mostrarPeliculas();
        System.out.println("*********************** ************************");
        System.out.println("IMPRIMIENDO LAS PELICULAS DE MAYOR DURACION A UNA HORA************************");
        serv.mostrarPeliculasDuracionMayor();
        System.out.println("*********************** ************************");
        System.out.println("IMPRIMIENDO LAS PELICULAS EN ORDEN DESCENDENTE DE DURACION************************");
        serv.mostrarPeliculasOrdenadasDuracionDescendente();
        System.out.println("*********************** ************************");
        System.out.println("IMPRIMIENDO LAS PELICULAS EN ORDEN ASCENDENTE DE DURACION************************");
        serv.mostrarPeliculasOrdenadasDuracionAscendente();
        System.out.println("*********************** ************************");
        System.out.println("IMPRIMIENDO LAS PELICULAS EN ORDEN ASCENDENTE SEGUN TITULOS************************");
        serv.mostrarPeliculasAlfabeticaTitulo();
        System.out.println("*********************** ************************");
        System.out.println("IMPRIMIENDO LAS PELICULAS EN ORDEN ASCENDENTE DE DIRECTORES************************");
        serv.mostrarPeliculasAlfabeticaDirector();
        System.out.println("*********************** ************************");
    }
    
}
