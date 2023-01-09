
package tienda.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoService {
    
    private ProductoDAO dao;
    
    public ProductoService(){
        this.dao = new ProductoDAO();
    }
    
    public ArrayList<String> listarNombreProductos() throws Exception{
        try {
            ArrayList<String> listado = dao.listarNombreProductos();
            listado.forEach(nom -> System.out.println(nom));
            return listado;
        } catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Producto> listarNombrePrecioProductos() throws Exception{
        try{
            Collection<Producto> listado = dao.listarProductos();
            this.imprimirListadoNombrePrecio(listado);
            return listado;
        } catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosRangoPrecio() throws Exception{
        try {
            double top = 202;
            double bottom = 120;
            Collection<Producto> listado = dao.listarProductosRangoPrecio(bottom, top);
            this.imprimirListadoProductos(listado);
            return listado;
        } catch(Exception e){
            throw e;
        }
        
    }
    
    public Collection<Producto> listarPortatiles() throws Exception{
        try{
            Collection<Producto> listado = dao.listarPortatiles();
            this.imprimirListadoProductos(listado);
            return listado;
        }catch(Exception e){
            throw e;
        }
    }
    
    public Producto buscarProductoMasBarato() throws Exception{
        try{
          Producto prod = dao.buscarProductoMasBarato();
          this.imprimirProducto(prod);
          return prod;
        } catch(Exception e){
            throw e;
        }
    }
    
    public void altaProducto(String nombre, Double precio, Fabricante codigoFabricante) throws Exception{
        try{
            // validacion de datos
            
            if (nombre == null){
                throw new Exception ("Debe indicar el nombre del producto");
            }
            if (precio == null){
                throw new Exception ("Debe indicar el precio del producto");
            }
            if (codigoFabricante == null){
                throw new Exception ("Debe indicar el Fabricante del producto");
            }
            if (this.buscarProductoPorNombre(nombre) != null){
                throw new Exception("Ya existe un producto con el nombre ingresado");
            }

            // creamos el objeto y lo insertamos en la BD con el DAO
            Producto prod = new Producto(nombre, precio, codigoFabricante);
            this.dao.altaProducto(prod);
        } catch (Exception e){
            throw e;
        }
    }
    
    public void editarProducto() throws Exception{
        try{
            int opcion;
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            boolean ok = false;


            Producto prod = null;
            while (!ok){
                this.imprimirListadoProductos(dao.listarProductos());
                System.out.println("Ingrese el codigo del producto a modificar");
                Integer cod = leer.nextInt();
                prod = this.buscarProductoPorCodigo(cod);
                if (prod != null){
                    ok = true;
                } else {
                    System.out.println("El codigo ingresado no corresponde a un producto de la Base de Datos");
                }
            }

            do {
                System.out.println("Ingrese la opcion del atributo del producto que desea modificar");
                System.out.println("1. Nombre");
                System.out.println("2. Precio");
                System.out.println("3. Codigo de Fabricante");
                System.out.println("4. Salir");
                opcion = leer.nextInt();
            } while (opcion < 1 || opcion > 4);

            switch(opcion){
                case 1: System.out.println("Ingrese el nuevo nombre");
                        String nom = leer.next();
                        this.editarNombre(prod, nom);
                    break;
                case 2: System.out.println("Ingrese el nuevo Precio");
                        Double precio = leer.nextDouble();
                        this.editarPrecio(prod, precio);
                    break;
                case 3: System.out.println("Ingrese el nuevo codigo de fabricante");
                        Integer codF = leer.nextInt();
                        this.editarCodigoFabricante(prod, codF);
                    break;
            }
        } catch (Exception e){
            throw e;
        }
    }    
    
    private void editarNombre(Producto prod, String nuevoNombre) throws Exception{
        try {

            // validacion de datos
            if (nuevoNombre == null){
                throw new Exception ("Debe ingresar un nombre valido para actualizar en el producto");
            }
            if (prod == null){
                throw new Exception("Debe seleccionar un producto valido para actualizar sus atributos");
            }
            
            // se realiza la modificacion
            this.dao.editarNombreProducto(prod, nuevoNombre);
                     
        } catch (Exception e){
            throw e;
        }
        
    }
    
    private void editarPrecio(Producto prod, Double nuevoPrecio) throws Exception{
        try {

            // validacion de datos
            if (nuevoPrecio == null){
                throw new Exception ("Debe ingresar un Precio valido para actualizar en el producto");
            }
            if (prod == null){
                throw new Exception("Debe seleccionar un producto valido para actualizar sus atributos");
            }
            
            // se realiza la modificacion
            this.dao.editarPrecioProducto(prod, nuevoPrecio);
                     
        } catch (Exception e){
            throw e;
        }
        
    }
    
    
    private void editarCodigoFabricante(Producto prod, Integer nuevoCodigoFabricante) throws Exception{
        try {

            // validacion de datos
            if (nuevoCodigoFabricante == null){
                throw new Exception ("Debe ingresar un Codigo de fabricante valido para actualizar en el producto");
            }
            if (prod == null){
                throw new Exception("Debe seleccionar un producto valido para actualizar sus atributos");
            }
            if (new FabricanteService().buscarFabricantePorCodigo(nuevoCodigoFabricante) == null){
                throw new Exception("El codigo de fabricante nuevo no corresponde a un fabricante de la base de datos actual");
            }
            
            // se realiza la modificacion
            this.dao.editarCodigoFabricanteProducto(prod, nuevoCodigoFabricante);
                     
        } catch (Exception e){
            throw e;
        }
        
    }
    
    private void imprimirListadoNombrePrecio(Collection<Producto> lista){
        lista.forEach(p -> System.out.println(p.getNombre() + " - "+ p.getPrecio()));
    }
    
    private void imprimirListadoProductos(Collection<Producto> lista){
        lista.forEach(p -> this.imprimirProducto(p));
    }
    
    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception{
        try {
            if (codigo == null){
                throw new Exception("Debe ingresar un codigo para la busqueda en la Base de Datos");
            }
            Producto prod = this.dao.buscarProductoPorCodigo(codigo);
            return prod;
            
        }catch (Exception e){
            throw e;
        }
    }
    
    public Producto buscarProductoPorNombre(String nombre) throws Exception{
        try {
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre para la busqueda en la Base de Datos");
            }
            Producto prod = this.dao.buscarProductoPorNombre(nombre);
            return prod;
            
        }catch (Exception e){
            throw e;
        }
    }
    
    private String imprimirFabricante(Fabricante f){
       String aux = "[Fabricante :"+ f.getCodigo()+" - "+f.getNombre()+"]";
       return aux;
    }
    
    private void imprimirProducto(Producto p){
        System.out.println(p.getCodigo()+" - "+ p.getNombre()+" - "+ p.getPrecio()+" - "+ this.imprimirFabricante(p.getCodigoFabricante()));
    }
    
    
    
}
