
package libreria.persistencia;


import java.util.Collection;
import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO{
    
    public void crearAutor(Autor a) throws Exception{
        try{
            if ( a == null){
                throw new Exception("Debe indicar el autor");
            }
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
    
    public void eliminarAutor(Autor a) throws Exception{
        try {
            if (a == null){
                throw new Exception("Debe indicar el autor");
            }
            
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch (Exception e){
            throw e;
        }
    }
    
    public void editarAutor(Autor a) throws Exception{
        try {
            if (a == null){
                throw new Exception("Debe indicar el autor");
            }
            
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        }catch (Exception e){
            throw e;
        }
    }
    
    public Collection<Autor> listarAutores() throws Exception{
        try{
            Collection<Autor> listado = em.createQuery("SELECT a FROM Autor a").getResultList();
            if (listado.isEmpty()){
                throw new Exception("No existen autores registrados en la base de datos");
            }
            return listado;
        } catch(Exception e){
            throw e;
        }
    }
    
    public Autor buscarAutorPorNombre(String nombre) throws Exception{
        try{
            if (nombre == null){
                throw new Exception("Debe indicar un nombre valido");
            }
                   
            List<Autor> listado = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nom").setParameter("nom", nombre).getResultList();
            if (listado.isEmpty()){
                System.out.println("No se encontro el Autor con el nombre indicado");
                return null;
            } else {
                return listado.get(0);
            }
        }catch (Exception e){
            throw e;
        }
    }
    
    public Autor buscarAutorPorID(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception ("Debe indicar un ID valido");
            }
            Autor a = em.find(Autor.class, id);
            if (a == null){
                throw new Exception("No se encontro la persona con el ID indicado");
            }
            return a;
        }catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Autor> buscarAutorPorNombreFlexible(String nombre) throws Exception{
        try{
            if (nombre == null){
                throw new Exception("Debe indicar un nombre valido");
            }
            String sql = "SELECT a FROM Autor a WHERE a.nombre LIKE '%"+nombre+ "%'";
            Collection<Autor> listado = em.createQuery(sql).getResultList();
            if (listado.isEmpty()){
                throw new Exception("No se encontraron autores que incluyan el nombre ingresado");
            }
            return listado;
        }catch(Exception e){
            throw e;
        }
    }
    
}
