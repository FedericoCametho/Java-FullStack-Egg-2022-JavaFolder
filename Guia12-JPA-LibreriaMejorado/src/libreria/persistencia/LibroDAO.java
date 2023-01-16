
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;


public class LibroDAO extends DAO{
    
    public void crearLibro(Libro lib) throws Exception{
        try{
            if (lib == null){
                throw new Exception("Debe ingresar un libro valido para su alta");
            }
            
            em.getTransaction().begin();
            em.persist(lib);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
    
    public void eliminarLibro(Libro lib) throws Exception{
        try{
            if (lib == null){
                throw new Exception("Debe ingresar un libro valido");
            }
            em.getTransaction().begin();
            em.remove(lib);
            em.getTransaction().commit();
        } catch(Exception e){
            throw e;
        }
    }
    
    public void editarLibro(Libro lib) throws Exception{
        try{
            if (lib == null){
                throw new Exception ("Debe ingresar un libro valido para editar");
            }
            em.getTransaction().begin();
            em.merge(lib);
            em.getTransaction().commit();
        } catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Libro> listarLibros() throws Exception{
        try {
            Collection<Libro> listado = em.createQuery("SELECT l FROM Libro l").getResultList();
            if (listado.isEmpty()){
                throw new Exception("No existen libros registrados en la base de datos");
            }
            return listado;
        }catch (Exception e){
            throw e;
        }
    }
    
    public Libro buscarLibroPorISBN(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe indicar un ID valido");
            }
            Libro lib = em.find(Libro.class, id);
            if (lib == null){
                throw new Exception("No se encontro la Editorial con el nombre indicado");
            }
            return lib;
        }catch (Exception e){
            throw e;
        }
    }
    
    public Libro buscarLibroPorTitulo(String titulo)  throws Exception{
        try {
            if (titulo == null){
                throw new Exception ("Debe ingresar un titulo valido para la busqueda");
            }
            List<Libro> listado = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :tit").setParameter("tit", titulo).getResultList();
            return (listado.isEmpty()) ? null : listado.get(0);
        } catch (Exception e){
            throw e;
        }
    }
    
    public Collection<Libro> buscarLibrosPorAutor(Autor a)throws Exception {
        try{
            if (a == null){
                throw new Exception("Debe ingresar un autor valido");
            }
            Collection<Libro> listado = em.createQuery("SELECT l FROM Libro l WHERE l.autor = :aut").setParameter("aut", a).getResultList();
            if (listado.isEmpty()){
                throw new Exception("No se encontraron libros para el autor ingresado");
            }
            return listado;
        }catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Libro> buscarLibrosPorEditorial(Editorial e)throws Exception {
        try{
            if (e == null){
                throw new Exception("Debe ingresar una Editorial valida");
            }
            Collection<Libro> listado = em.createQuery("SELECT l FROM Libro l WHERE l.editorial = :edi").setParameter("edi", e).getResultList();
            if (listado.isEmpty()){
                throw new Exception("No se encontraron libros para la Editorial ingresada");
            }
            return listado;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void registrarPrestamoLibro(Libro l) throws Exception{
        try{
            if (l == null){
                throw new Exception("Debe ingresar un libro valido");
            }
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }
    }
    
    
    
}
