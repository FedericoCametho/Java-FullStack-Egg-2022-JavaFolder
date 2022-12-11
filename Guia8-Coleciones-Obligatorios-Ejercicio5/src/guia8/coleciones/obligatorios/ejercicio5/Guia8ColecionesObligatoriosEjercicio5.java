/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia8.coleciones.obligatorios.ejercicio5;

import Servicio.ServicioPaises;

/**
 *
 * @author FedeC
 */
public class Guia8ColecionesObligatoriosEjercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ServicioPaises serv = new ServicioPaises();
        
        serv.cargarPaises();
        System.out.println("******************** MOSTRANDO LISTA DE PAISES ********************");
        serv.mostrarPaises();
        System.out.println("******************** MOSTRANDO LISTA DE PAISES ALFABETICAMENTE ********************");
        serv.mostrarPaisesOrdenadosAlfabeticamente();
        System.out.println("******************** ELIMINANDO UN PAIS DE LA LISTA ********************");
        serv.eliminarPais();
    }
    
}
