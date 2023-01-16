
package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Libro;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AutorService {
    
    private EntityManager em;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    
    public AutorService(){
        this.em = Persistence.createEntityManagerFactory("Guia12-JPA-LibreriaPU").createEntityManager();
    }
    
    public Autor crearAutor(String nombre) throws Exception{
        try {
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido para el autor");
            }
            
            if (this.buscarAutorPorNombre(nombre) != null){
                throw new Exception("El nombre ingresado ya corresponde a un autor de la base de datos");
            }
            
            Autor a = new Autor(nombre);

            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
       
            return a;
        }catch (Exception e){
            throw e;
        }   
    }
    
    public void eliminarAutor() throws Exception{
        System.out.println("Ingresee el ID del autor ");
        Long id = leer.nextLong();
        
        try{
            if (id ==  null){
                throw new Exception("Debe ingresar un ID valido para eliminar el Autor");
            }
            Autor a = this.buscarAutorPorID(id);
            if (a == null){
                throw new Exception("El ID ingresado no corresponde a un Autor registrado en la base de datos.");
            } else {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
            }         
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void editarAutor() throws Exception{
        System.out.println("Ingresee el ID del autor ");
        Long id = leer.nextLong();
        
        try{
            if (id ==  null){
                throw new Exception("Debe ingresar un ID valido para editar el Autor");
            }
            Autor a = this.buscarAutorPorID(id);
            if (a == null){
                throw new Exception("El ID ingresado no corresponde a un Autor registrado en la base de datos.");
            } else {
                System.out.println("Ingrese el nuevo nombre a modificar del autor:     "+ a.getNombre());
                a.setNombre(leer.next());
                em.getTransaction().begin();
                em.merge(a);
                em.getTransaction().commit();
            }         
        } catch (Exception e){
            throw e;
        }
    }
    
    public void mostrarListadoAutores() throws Exception{
        try {
            List<Autor> lista = em.createQuery("SELECT a FROM Autor a").getResultList();
        
            if (!lista.isEmpty()){
                    System.out.println("********  IMPRIMIENDO LISTADO DE AUTORES  ********");
                   lista.forEach(a -> System.out.println(a.toString()));
               } else {
                   throw new Exception("No existen Autores registrados en la base de datos");
               }
        } catch (Exception e){
            throw e;
        }
    }
    
    public Autor buscarAutorPorID(Long id) throws Exception{
        try {
            if(id == null){
                throw new Exception ("Debe ingresar un id valido");
            }
            
           return em.find(Autor.class, id);

        } catch (Exception e){
            throw e;
        }
    }
    
    
    public List<Autor> buscarAutorPorNombreFlexible(String nombre){
        try {
            String sql = "SELECT a FROM Autor a WHERE a.nombre LIKE '%"+nombre+ "%'";
            List<Autor> lista = em.createQuery(sql).getResultList();
            return (lista.isEmpty()) ?  null : lista;
        } catch (Exception e){
            throw e;
        }
    }
    
    public Autor buscarAutorPorNombre(String nombre){
        try {
            List<Autor> lista = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nom ").setParameter("nom", nombre).getResultList();
            return (lista.isEmpty()) ?  null : lista.get(0);
        } catch (Exception e){
            throw e;
        }
    }
    
    public void mostrarLibrosDeUnAutor(String nombre) throws Exception{
        try{
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre de autor valido");
            }
            Autor a = this.buscarAutorPorNombre(nombre);
            if (a == null){
                throw new Exception("El autor ingresado no se encuentra en la base de Datos");
            }

            List<Libro> listado = em.createQuery("SELECT l FROM Libro l WHERE l.autor = :aut").setParameter("aut", a).getResultList();
            System.out.println("************ IMPRIMIENDO LISTADO DE LIBROS DEL AUTOR: "+a.getNombre()+"*************");
            listado.forEach(l -> System.out.println(l.toString()));
    
        }catch(Exception e){
            throw e;
        }
    }
    
    
    
    
}
