
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO{
    
    public void crearEditorial(Editorial e)throws Exception{
        try{
            if (e == null){
                throw new Exception("Debe ingresar una Editorial valida");
            }
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
    
    public void eliminarEditorial(Editorial e) throws Exception{
        try {
            if (e == null){
                throw new Exception("Debe indicar la Editorial");
            }
            
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }catch (Exception ex){
            throw ex;
        }
    }
    
    public void editarEditorial(Editorial e) throws Exception{
        try {
            if (e == null){
                throw new Exception("Debe indicar la Editorial");
            }
            
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        }catch (Exception ex){
            throw ex;
        }
    }
    
    public Collection<Editorial> listarEditoriales()throws Exception{
        try{
            Collection<Editorial> listado = em.createQuery("SELECT e FROM Editorial e").getResultList();
            if (listado.isEmpty()){
                throw new Exception("No existen Editoriales registradas en la base de datos");
            }
            return listado;
        } catch(Exception ex){
            throw ex;
        }
    }
    
    public Editorial buscarEditorialPorNombre(String nombre) throws Exception{
        try{
            if (nombre == null){
                throw new Exception("Debe indicar un nombre valido");
            }
            List<Editorial> listado = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nom").setParameter("nom", nombre).getResultList();
            if (listado.isEmpty()){
                System.out.println("No se encontro la Editorial con el nombre indicado");
                return null;
            } else {
                return listado.get(0);
            }
        }catch (Exception e){
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorID(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe indicar un ID valido");
            }
            Editorial editorial = em.find(Editorial.class, id);
            if (editorial == null){
                throw new Exception("No se encontro la Editorial con el nombre indicado");
            }
            return editorial;
        }catch (Exception e){
            throw e;
        }
    }
    
}
