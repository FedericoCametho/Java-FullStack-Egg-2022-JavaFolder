
package libreria.servicios;


import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.EditorialDAO;


public class EditorialService {
    
    private final EditorialDAO DAO;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public EditorialService(){
        this.DAO = new EditorialDAO();
    }
    
    public void crearEditorial(String nombre) throws Exception{
        try {
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido para la Editorial");
            }
            
            if (this.buscarEditorialPorNombre(nombre) != null){
                throw new Exception("El nombre ingresado ya corresponde a una Editorial de la base de datos");
            }
            
            Editorial e = new Editorial(nombre);
            this.DAO.crearEditorial(e);
            
        } catch (Exception e){
            throw e;
        }
    }
    
    public void eliminarEditorial(Long id) throws Exception{
        try{
            if (id ==  null){
                throw new Exception("Debe ingresar un ID valido para eliminar la Editorial");
            }
            Editorial e = this.buscarEditorialPorID(id);
            if (e == null){
                throw new Exception("El ID ingresado no corresponde a una Editorial registrada en la base de datos.");
            }
            
            this.DAO.eliminarEditorial(e);
            
        } catch (Exception ex){
            throw ex;
        }
    }
    
    public void editarEditorial(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception ("Debe indicar un ID valido");
            }
            Editorial e = this.buscarEditorialPorID(id);
            if (e == null){
                throw new Exception("El id ingresado no corresponde a una Editorial de la base de datos");
            }
            System.out.println("Ingrese el nuevo nombre para asignarle la Editorial("+e.getNombre()+")");
            e.setNombre(this.leer.next());
            this.DAO.editarEditorial(e);
        }catch (Exception ex){
            throw ex;
        }
    }
    
    public void mostrarListadoEditoriales() throws Exception{
        try {
            Collection<Editorial> lista = this.DAO.listarEditoriales();
        
            if (lista.isEmpty()){
                throw new Exception("No existen Editoriales registradas en la base de datos");  
            }
            System.out.println("********  IMPRIMIENDO LISTADO DE EDITORIALES  ********");
            for (Editorial e : lista){
                System.out.println(e.toString());
            }
        } catch (Exception ex){
            throw ex;
        }
    }
    
    public void mostrarLibrosDeUnaEditorial(Long id)throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID de una Editorial valido");
            }
            Editorial e = this.buscarEditorialPorID(id);
            if (e == null){
                throw new Exception("La Editorial ingresada no se encuentra en la base de Datos");
            }

            Collection<Libro> listado = new LibroService().buscarLibrosPorEditorial(e);
                    
            System.out.println("************ IMPRIMIENDO LISTADO DE LIBROS DE LA EDITORIAL: "+e.getNombre()+"*************");
            for (Libro l : listado){
                System.out.println(l.toString());
            }
    
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Editorial buscarEditorialPorNombre(String nombre) throws Exception{
        try {
            if(nombre == null){
                throw new Exception("Debe ingresar un nombre valido para la busqueda de la Editorial");
            }
            return this.DAO.buscarEditorialPorNombre(nombre);
        } catch(Exception e){
            throw e;
        }      
    }
    
    public Editorial buscarEditorialPorID(Long id) throws Exception{
        try {
            return this.DAO.buscarEditorialPorID(id);
        } catch(Exception e){
            throw e;
        }      
    }
    
    public Editorial chequearEditorial(String nombre)throws Exception{
        try{
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido");
            }
            Editorial e = this.buscarEditorialPorNombre(nombre);
            if (e == null){
                this.crearEditorial(nombre);
                return this.buscarEditorialPorNombre(nombre);
            } else {
                return e;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
