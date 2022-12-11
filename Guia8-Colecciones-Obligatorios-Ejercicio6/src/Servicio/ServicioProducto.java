/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Producto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class ServicioProducto {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private HashMap<String, Double> listaProductos;
    
    public ServicioProducto(){
        this.listaProductos = new HashMap();
    }
    
    public void cargarVariosProductos(){
        do {
            System.out.println("Ingrese el nombre del producto");
            String nom = this.leer.next();
            System.out.println("Ingrese el precio del producto");
            Producto prod = new Producto(nom, this.leer.nextDouble());
            this.cargarUnProducto(prod);
        } while (this.menuOpcion());
    }
    
    public void cargarUnProducto(Producto prod){
        this.listaProductos.put(prod.getNombre(), prod.getPrecio());
    }
    
    public void cargarVariosProductos2(){
        do {
            this.cargarUnProducto2();
        } while (this.menuOpcion());
    }
    
    public void cargarUnProducto2(){
        System.out.println("Ingrese el nombre del producto");
        String nom = this.leer.next();
        System.out.println("Ingrese el precio del producto");
        this.listaProductos.put(nom, leer.nextDouble());
    }
    
    public void eliminarProducto(String prod){
        if (this.listaProductos.containsKey(prod)){
            this.listaProductos.remove(prod);
        }
    }
    
    public void modificarPrecio(String prod, double nuevoPrecio){
        if (this.listaProductos.containsKey(prod)){
            this.listaProductos.replace(prod, nuevoPrecio);
        }
    }
    
    public void mostrarProductos(){
        System.out.println("********** IMPRIMIENDO  LISTA DE PRODUCTOS ************");
        this.listaProductos.forEach((key,value) -> System.out.println(key+": "+value));
    }
    
    private boolean menuOpcion(){
        int opcion;
        do {
            System.out.println("1. Ingresar otro Producto");
            System.out.println("2. Salir");
            opcion = this.leer.nextInt();
        } while ((opcion < 1) || (opcion > 2));
        return opcion==1;  
    }
    
    
}
