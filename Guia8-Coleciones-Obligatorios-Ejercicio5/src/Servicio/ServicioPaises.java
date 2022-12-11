/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author FedeC
 */
public class ServicioPaises {
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private Set<String> listaPaises;
    
    public ServicioPaises(){
        this.listaPaises = new HashSet<String>(); 
    }
    
    public void cargarPaises(){
        do {
            System.out.println("Ingrese un Pais a cargar");
            this.listaPaises.add(leer.next());
        } while (this.menuOpcion());
    }
    
    public void mostrarPaises(){
        this.listaPaises.forEach(pais -> System.out.println("- "+ pais));
    }
    
    public void mostrarPaisesOrdenadosAlfabeticamente(){
        List<String> copia = new ArrayList(this.listaPaises);
        Collections.sort(copia);
        copia.forEach(pais -> System.out.println("- "+ pais));
    }
    
    public boolean eliminarPais(){
        System.out.println("Ingrese el pais que desea eliminar");
        String pais = this.leer.next();
        
        if (this.listaPaises.contains(pais)){
            this.listaPaises.remove(pais);
            this.mostrarPaises();
            return true;
        } else {
            System.out.println("El pais "+ pais + " no se encuentra en la lista");
            return false;
        }
    }
    
    private boolean menuOpcion(){
        int opcion;
        do {
            System.out.println("1. Ingresar otro Pais");
            System.out.println("2. Salir");
            opcion = this.leer.nextInt();
        } while ((opcion < 1) || (opcion > 2));
        return opcion==1;  
    }
}
