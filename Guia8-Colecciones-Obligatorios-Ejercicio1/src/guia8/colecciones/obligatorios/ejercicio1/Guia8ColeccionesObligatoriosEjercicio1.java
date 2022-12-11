/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia8.colecciones.obligatorios.ejercicio1;

import Servicio.ServicioRazas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Guia8ColeccionesObligatoriosEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        List<String> listaRazas = new ArrayList<String>();
        ServicioRazas serv = new ServicioRazas();
        
        
        do {
            System.out.println("Ingrese una raza de perros");
            serv.agregarEnLista(listaRazas, leer.next());
        } while (menuOpcion(leer));
        
        listaRazas.forEach(raza -> System.out.println(raza));
        
        System.out.println("Ingrese una raza de perro a buscar");
        if (!serv.eliminarEnLista(listaRazas, leer.next())){
            System.out.println("La raza de perro ingresada no estaba en la lista de razas actuales");
        }
        
        serv.ordenarLista(listaRazas).forEach(raza -> System.out.println(raza));
        
    }

    public static boolean menuOpcion(Scanner leer){
        int opcion;
        do {
            System.out.println("1. Ingresar otra raza");
            System.out.println("2. Salir");
            opcion = leer.nextInt();
        } while ((opcion < 1) || (opcion > 2));
        return opcion==1;  
    }
    
    
}
