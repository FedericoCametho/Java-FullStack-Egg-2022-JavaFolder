/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia8.colecciones.obligatorios.ejercicio6;

import Entidad.Producto;
import Servicio.ServicioProducto;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Guia8ColeccionesObligatoriosEjercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        ServicioProducto serv = new ServicioProducto();
        
        serv.cargarVariosProductos();
        serv.mostrarProductos();
        System.out.println("Agregando un nuevo producto");
        System.out.println("Ingrese el nombre del producto nuevo");
        String nom = leer.next();
        System.out.println("Ingrese el precio del producto nuevo");
        Producto produ = new Producto(nom, leer.nextDouble());
        serv.cargarUnProducto(produ);
        System.out.println("Ingrese el nombre del producto que desea elimnar");
        serv.eliminarProducto(leer.next());
        serv.mostrarProductos();
        System.out.println("Ingrese el nombre del producto que desea modificar su precio");
        String nombreBuscar = leer.next();
        System.out.println("Ingrese el nuevo precio del producto");
        serv.modificarPrecio(nombreBuscar, leer.nextDouble());
        serv.mostrarProductos();
    }
    
}
