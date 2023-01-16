
package Libreria.Servicios;

import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EditorialService {
    
    private EntityManager em;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    
    public EditorialService(){
        this.em = Persistence.createEntityManagerFactory("Guia12-JPA-LibreriaPU").createEntityManager();
    }
    
    public Editorial crearEditorial(String nombre) throws Exception{
        try {
            if (nombre == null){
                throw new Exception("Debe ingresar un nombre valido para la Editorial");
            }
            
            if (this.buscarEditorialPorNombre(nombre) != null){
                throw new Exception("El nombre ingresado ya corresponde a una Editorial de la base de datos");
            }
            
            Editorial ed = new Editorial(nombre);

            em.getTransaction().begin();
            em.persist(ed);
            em.getTransaction().commit();
       
            return ed;
        }catch (Exception e){
            throw e;
        }   
    }
    
    public void eliminarEditorial() throws Exception{
        System.out.println("Ingresee el ID de la Editorial ");
        Long id = leer.nextLong();
        
        try{
            if (id ==  null){
                throw new Exception("Debe ingresar un ID valido para eliminar la Editorial");
            }
            Editorial e = this.buscarEditorialPorID(id);
            if (e == null){
                throw new Exception("El ID ingresado no corresponde a una Editorial registrada en la base de datos.");
            } else {
                em.getTransaction().begin();
                em.remove(e);
                em.getTransaction().commit();
            }         
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void editarEditorial() throws Exception{
        System.out.println("Ingresee el ID de la Editorial ");
        Long id = leer.nextLong();
        
        try{
            if (id ==  null){
                throw new Exception("Debe ingresar un ID valido para editar la Editorial");
            }
            Editorial e = this.buscarEditorialPorID(id);
            if (e == null){
                throw new Exception("El ID ingresado no corresponde a una Editorial registrada en la base de datos.");
            } else {
                System.out.println("Ingrese el nuevo nombre a modificar de la Editorial:     "+ e.getNombre());
                e.setNombre(leer.next());
                em.getTransaction().begin();
                em.merge(e);
                em.getTransaction().commit();
            }         
        } catch (Exception e){
            throw e;
        }
    }
    
    public void mostrarListadoEditoriales() throws Exception{
       try {
           List<Editorial> lista = em.createQuery("SELECT e FROM Editorial e").getResultList();
           if (!lista.isEmpty()){
               System.out.println("********  IMPRIMIENDO LISTADO DE EDITORIALES  ********");
               lista.forEach(e -> System.out.println(e.toString()));
           } else {
               throw new Exception("No existen editoriales registradas en la base de datos");
           }
       } catch (Exception e){
           throw e;
       }
        
        
    }
    
    public Editorial buscarEditorialPorID(Long id){
        try {
            return em.find(Editorial.class, id);
        } catch (Exception e){
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorNombre(String nombre){
        try {
            List<Editorial> lista = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nom").setParameter("nom", nombre).getResultList();
            return (lista.isEmpty()) ? null : lista.get(0);
        } catch (Exception e){
            throw e;
        }
    }
    
    
    public void mostrarLibrosDeUnaEditorial(String nombre) throws Exception{
       try{
           if (nombre == null){
               throw new Exception("Debe ingresar un nombre de Editorial valido");
           }
           Editorial e = this.buscarEditorialPorNombre(nombre);
           if (e == null){
               throw new Exception("La Editorial ingresada no se encuentra en la base de Datos");
           }

           List<Libro> listado = em.createQuery("SELECT l FROM Libro l WHERE l.editorial = :edit").setParameter("edit", e).getResultList();
           System.out.println("************ IMPRIMIENDO LISTADO DE LIBROS DE LA EDITORIAL: "+e.getNombre()+"*************");
           listado.forEach(l -> System.out.println(l.toString()));


       }catch(Exception e){
           throw e;
       }
   }
}
