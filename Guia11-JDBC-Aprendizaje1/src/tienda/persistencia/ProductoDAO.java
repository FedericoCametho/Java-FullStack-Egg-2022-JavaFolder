
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteService;

public class ProductoDAO extends DAO {

    public Collection<Producto> listarProductos() throws Exception {
        
        try {
            String sql = "SELECT * FROM producto";
            this.consultarDB(sql);
            Producto prod =  null;
            
            Collection<Producto> listado = new ArrayList();
            
            while (resultado.next()){
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                Fabricante fab = this.buscarFabricantePorCodigo(resultado.getInt(4));
                prod.setCodigoFabricante(fab);
                
                listado.add(prod);
            }
            this.desconectarDB();
            return listado;
        } catch (Exception e){
            this.desconectarDB();
            throw e;
        }
    }
    
    public ArrayList<String> listarNombreProductos() throws Exception {
        
        try {
            String sql = "SELECT nombre FROM producto";
            this.consultarDB(sql);
            Producto prod =  null;
            
            ArrayList<String> listado = new ArrayList();
            
            while (resultado.next()){
               listado.add(resultado.getString(1));
            }
            this.desconectarDB();
            return listado;
        } catch (Exception e){
            this.desconectarDB();
            throw e;
        }
    }
    
    private Fabricante buscarFabricantePorNombre(String nombre) throws Exception{
        FabricanteService fabService = new FabricanteService();
        try{
            return fabService.buscarFabricantePorNombre(nombre);
        } catch (Exception e){
            throw e;
        }
    }
    
    private Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception{
        FabricanteService fabService = new FabricanteService();
        try{
            return fabService.buscarFabricantePorCodigo(codigo);
        } catch (Exception e){
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosRangoPrecio(double bottom, double top) throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE precio BETWEEN '"+bottom+"' and '"+top+"';";
            this.consultarDB(sql);
            Collection<Producto> listado = new ArrayList();
            Producto prod = null;
            
            while (resultado.next()){
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                Fabricante fab = this.buscarFabricantePorCodigo(resultado.getInt(4));
                prod.setCodigoFabricante(fab);
                
                listado.add(prod);
            }
            this.desconectarDB();
            return listado;
        } catch(Exception e){
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema"); 
        }                        
    }
    
    public Collection<Producto> listarPortatiles() throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portatil%'";
            this.consultarDB(sql);
            Collection<Producto> listado = new ArrayList();
            Producto prod = null;
            
            while (resultado.next()){
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                Fabricante fab = this.buscarFabricantePorCodigo(resultado.getInt(4));
                prod.setCodigoFabricante(fab);
                
                listado.add(prod);
            }
            this.desconectarDB();
            return listado;
        } catch (Exception e){
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema"); 
        }
    }
    
    public Producto buscarProductoMasBarato() throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE precio = (SELECT MIN(precio) FROM producto)";
            this.consultarDB(sql);
            Producto prod = new Producto();
            resultado.next();
            prod.setCodigo(resultado.getInt(1));
            prod.setNombre(resultado.getString(2));
            prod.setPrecio(resultado.getDouble(3));
            Fabricante fab = this.buscarFabricantePorCodigo(resultado.getInt(4));
            prod.setCodigoFabricante(fab);
            
            this.desconectarDB();
            return prod;
        }catch(Exception e){
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema"); 
        }
    }
    
    public void altaProducto(Producto prod) throws Exception{
        try{
            if (prod == null){
                throw new Exception ("Debe indicarse un producto a insertar en la Base de Datos");
            }

            // validamos que el fabricante pueda o no estar en la base de datos, para agregarlo si es necesario
            Fabricante fab = this.buscarFabricantePorNombre(prod.getCodigoFabricante().getNombre());
            if (fab == null){
                try {
                    FabricanteService fabService = new FabricanteService();
                    fab = fabService.altaFabricante(prod.getCodigoFabricante().getNombre());
                } catch (Exception e){
                    throw e;
                }
            } 
            
            // insertamos el producto en la base de datos de productos
            
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ( '"+ prod.getNombre() + "' , '" + prod.getPrecio() + "' , '" + fab.getCodigo() + "');";
            
            this.insertarModificarEliminar(sql);
        } catch(Exception e){
            throw e;
        }
    }
    
    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE codigo ='"+ codigo+"';";
            this.consultarDB(sql);
            Producto prod = null;
            while (resultado.next()){
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                Fabricante fab = this.buscarFabricantePorCodigo(resultado.getInt(4));
                prod.setCodigoFabricante(fab);
            } 
            
            this.desconectarDB();
            return prod;
        }catch(Exception e){
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema"); 
        }
    }
    
    public Producto buscarProductoPorNombre(String nombre) throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE nombre ='"+ nombre+"';";
            this.consultarDB(sql);
            Producto prod = null;
            while (resultado.next()){
                prod = new Producto();
                prod.setCodigo(resultado.getInt(1));
                prod.setNombre(resultado.getString(2));
                prod.setPrecio(resultado.getDouble(3));
                Fabricante fab = this.buscarFabricantePorCodigo(resultado.getInt(4));
                prod.setCodigoFabricante(fab);
            } 

            this.desconectarDB();
            return prod;
        }catch(Exception e){
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema"); 
        }
    }
    
    public void editarNombreProducto(Producto prod, String nuevoNombre) throws Exception{
        try{
            // validaciones
            if (nuevoNombre == null){
                throw new Exception ("Debe ingresar un nombre valido para actualizar en el producto");
            }
            if (prod == null){
                throw new Exception("Debe seleccionar un producto valido para actualizar sus atributos");
            }
            String sql = "UPDATE producto SET nombre = '"+nuevoNombre+"' WHERE codigo = '"+prod.getCodigo()+"';";
            
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void editarPrecioProducto(Producto prod, Double nuevoPrecio) throws Exception{
        try{
            // validaciones
            if (nuevoPrecio == null){
                throw new Exception ("Debe ingresar un Precio valido para actualizar en el producto");
            }
            if (prod == null){
                throw new Exception("Debe seleccionar un producto valido para actualizar sus atributos");
            }
            String sql = "UPDATE producto SET precio = '"+nuevoPrecio+"' WHERE codigo = '"+prod.getCodigo()+"';";
            
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void editarCodigoFabricanteProducto(Producto prod, Integer nuevoCodigoFabricante) throws Exception{
        try{
            // validaciones
            if (nuevoCodigoFabricante == null){
                throw new Exception ("Debe ingresar un nombre valido para actualizar en el producto");
            }
            if (prod == null){
                throw new Exception("Debe seleccionar un producto valido para actualizar sus atributos");
            }
            if (this.buscarFabricantePorCodigo(nuevoCodigoFabricante) == null){
                throw new Exception("El codigo de fabricante nuevo no corresponde a un fabricante de la base de datos actual");
            }
            
            String sql = "UPDATE producto SET codigo_fabricante = '"+nuevoCodigoFabricante+"' WHERE codigo = '"+prod.getCodigo()+"';";
            
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
}
