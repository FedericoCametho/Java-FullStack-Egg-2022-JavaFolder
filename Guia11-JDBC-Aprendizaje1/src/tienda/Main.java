
package tienda;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
          String objeto = null;
          String resultado;
          switch (objeto) 
            {default: { resultado = "ok";}}
          System.out.println(resultado);
    }
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//        
//        
//        ProductoService prodService = new ProductoService();
//        FabricanteService fabService = new FabricanteService();
//        
//       
//        int opcion;
//            do{
//            opcion = menu(leer);
//            switch(opcion){
//                case 1: try{
//                    prodService.listarNombreProductos();
//                    } catch(Exception e){
//                        throw e;
//                    }
//                    break;
//                case 2: try{
//                        prodService.listarNombrePrecioProductos();
//                    } catch (Exception e){
//                        throw e;
//                    }
//                    break;
//                case 3: try{
//                        prodService.listarProductosRangoPrecio();
//                    }catch(Exception e){
//                        throw e;
//                    }
//                    break;
//                case 4: prodService.listarPortatiles();
//                    break;
//                case 5: prodService.buscarProductoMasBarato();
//                    break;
//                case 6: try {
//                    System.out.println("Ingrese el Nombre del producto");
//                    String nom = leer.next();
//                    System.out.println("Ingrese el Precio del producto");
//                    Double precio = leer.nextDouble();
//                    Fabricante fab = cargarFabricante(leer);
//                    prodService.altaProducto(nom, precio, fab);
//                } catch (Exception e){
//                    throw e;
//                } 
//                    break;
//                case 7: try{
//                    Fabricante fab = cargarFabricante(leer);
//                    fabService.altaFabricante(fab.getNombre());
//                } catch (Exception e){
//                    throw e;
//                }
//                break;
//                case 8: prodService.editarProducto();
//                    break;
//            }
//        } while (opcion != 9);
//        
//    }
//    
//    public static int menu(Scanner leer){
//        int opcion;
//        do {    
//            System.out.println("---------------------------------------------------------------------------------");
//            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
//            System.out.println("1. Lista el nombre de todos los productos que hay en la tabla producto.");
//            System.out.println("2. Lista los nombres y los precios de todos los productos de la tabla producto.");
//            System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202.");
//            System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
//            System.out.println("5. Listar el nombre y el precio del producto más barato.");
//            System.out.println("6. Ingresar un producto a la base de datos.");
//            System.out.println("7. Ingresar un fabricante a la base de datos");
//            System.out.println("8. Editar un producto con datos a elección.");
//            System.out.println("9. Salir");
//            System.out.println("---------------------------------------------------------------------------------");
//                    
//            opcion = leer.nextInt();
//        } while (opcion < 1 || opcion > 9);
//        
//        return opcion;
//    }
//    
//    public static Fabricante cargarFabricante(Scanner leer){
//        System.out.println("Ingrese el nombre del fabricante");
//        String nom = leer.next();
//        return new Fabricante(nom);
//    }
}
