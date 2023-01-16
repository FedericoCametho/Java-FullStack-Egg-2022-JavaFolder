
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Libro;
import libreria.persistencia.AutorDAO;


public class AutorService {
    
    private final AutorDAO DAO;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public AutorService(){
        this.DAO = new AutorDAO();
    }
    
    public void crearAutor(String nombre) throws Exception{
        try {
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido para el autor");
            }
            
            if (this.buscarAutorPorNombre(nombre) != null){
                throw new Exception("El nombre ingresado ya corresponde a un autor de la base de datos");
            }
            
            Autor a = new Autor(nombre);
            this.DAO.crearAutor(a);
            
        } catch (Exception e){
            throw e;
        }
    }
    
    public void eliminarAutor(Long id) throws Exception{
        try{
            if (id ==  null){
                throw new Exception("Debe ingresar un ID valido para eliminar el Autor");
            }
            Autor a = this.buscarAutorPorID(id);
            if (a == null){
                throw new Exception("El ID ingresado no corresponde a un Autor registrado en la base de datos.");
            }
            
            this.DAO.eliminarAutor(a);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void editarAutor(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception ("Debe indicar un ID valido");
            }
            Autor a = this.buscarAutorPorID(id);
            if (a == null){
                throw new Exception("El id ingresado no corresponde a un Autor de la base de datos");
            }
            System.out.println("Ingrese el nuevo nombre para asignarle al autor("+a.getNombre()+")");
            a.setNombre(this.leer.next());
            this.DAO.editarAutor(a);
        }catch (Exception e){
            throw e;
        }
    }
    
    public void mostrarListadoAutores() throws Exception{
        try {
            Collection<Autor> lista = this.DAO.listarAutores();
        
            if (lista.isEmpty()){
                throw new Exception("No existen Autores registrados en la base de datos");
            }
            System.out.println("********  IMPRIMIENDO LISTADO DE AUTORES  ********");
            for (Autor a : lista){
                System.out.println(a.toString());
            }
        } catch (Exception e){
            throw e;
        }
    }
    
    public void mostrarLibrosDeUnAutor(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID de autor valido");
            }
            Autor a = this.buscarAutorPorID(id);
            if (a == null){
                throw new Exception("El autor ingresado no se encuentra en la base de Datos");
            }

            Collection<Libro> listado = new LibroService().buscarLibrosPorAutor(a);
                    
            System.out.println("************ IMPRIMIENDO LISTADO DE LIBROS DEL AUTOR: "+a.getNombre()+"*************");
            for (Libro l : listado){
                System.out.println(l.toString());
            }
    
        }catch(Exception e){
            throw e;
        }
    }
    
    public Autor buscarAutorPorNombre(String nombre) throws Exception{
        try {
            if(nombre == null){
                throw new Exception("Debe ingresar un nombre valido de Autor a buscar");
            }
            return this.DAO.buscarAutorPorNombre(nombre);
        } catch(Exception e){
            throw e;
        }      
    }
    
    public Autor buscarAutorPorID(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe indicar un ID valido");
            }
            return this.DAO.buscarAutorPorID(id);
        } catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Autor> buscarAutorPorNombreFlexible(String nombre)throws Exception{
        try {
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido para la busqueda");
            }
            Collection<Autor> lista = this.DAO.buscarAutorPorNombreFlexible(nombre);
            if( lista.isEmpty()){
                throw new Exception("No existen autores que incluyan el nombre proporcionado");
            }
            return lista;
        } catch (Exception e){
            throw e;
        }
    }
    
    public Autor chequearAutor(String nombre)throws Exception{
        try{
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido");
            }
            Autor a = this.buscarAutorPorNombre(nombre);
            if (a == null){
                this.crearAutor(nombre);
                return this.buscarAutorPorNombre(nombre);
            } else {
                return a;
            }
        }catch(Exception e){
            throw e;
        }
    }
    
}
