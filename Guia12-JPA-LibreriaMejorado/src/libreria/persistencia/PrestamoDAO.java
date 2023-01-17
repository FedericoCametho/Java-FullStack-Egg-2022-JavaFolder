
package libreria.persistencia;

import java.util.Collection;
import java.util.Date;
import libreria.entidades.Cliente;
import libreria.entidades.Prestamo;


public class PrestamoDAO extends DAO{
    
    public void crearPrestamo(Prestamo p) throws Exception{
        try{
            if (p == null){
                throw new Exception("Debe ingresar un prestamo valido");
            }
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
    
    public void eliminarPrestamo(Prestamo p)throws Exception{
        try{
            if (p == null){
                throw new Exception("Debe ingresar un prestamo valido");
            }
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public void editarPrestamo(Prestamo p)throws Exception{
        try{
            if (p == null){
                throw new Exception("Debe ingresar un prestamo valido para modificar");
            }
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Prestamo> listarPrestamos() throws Exception{
        try{
            Collection<Prestamo> listado = em.createQuery("SELECT p FROM Prestamo p").getResultList();
            if (listado.isEmpty()){
                throw new Exception("No existen prestamos registrados en la base de datos");
            }
            return listado;
        }catch(Exception e){
            throw e;
        }
    }
    
    public void registrarDevolucion(Prestamo p) throws Exception{
        try{
            if (p == null){
                throw new Exception("Debe ingresar un prestamo Valido");
            }
            
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }
    }
    
    public Prestamo buscarPrestamoPorID(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID valido para la busqueda");
            }
            Prestamo p = em.find(Prestamo.class, id);
            if (p == null){
                throw new Exception("No se encontro ningun prestamo para el ID ingresado");
            }
            return p;
        }catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Prestamo> listarPrestamosPorCliente(Cliente c) throws Exception{
        try{
            if (c == null){
                throw new Exception("Debe indicar un cliente valido");
            }
            return em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente = :cli").setParameter("cli",c).getResultList();
            
            
        }catch(Exception e){
            throw e;
        }
    }
    
}
