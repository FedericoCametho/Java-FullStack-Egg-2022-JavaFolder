
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import libreria.entidades.Cliente;


public class ClienteDAO extends DAO{
    
    public void crearCliente(Cliente c) throws Exception{
        try{
            if (c==null){
                throw new Exception("Debe indicar un cliente valido");
            }
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
    
    public void eliminarCliente(Cliente c)throws Exception{
        try{
            if (c == null){
                throw new Exception("Debe indicar un cliente valido");
            }
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void editarCliente(Cliente c)throws Exception{
        try{
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Cliente> listarClientes()throws Exception{
        try{
            Collection<Cliente> listado =  em.createQuery("SELECT c FROM Cliente c").getResultList();
            if (listado.isEmpty()){
                throw new Exception("No existen Clientes registrados en la base de datos");
            }
            return listado;
        }catch(Exception e){
            throw e;
        }
    }
    
    public Cliente buscarClientePorDNI(Long dni) throws Exception{
        try{
            if (dni == null){
                throw new Exception("Debe ingresar un dni valido para la busqueda");
            }
            List<Cliente> listado =  em.createQuery("SELECT c FROM Cliente c WHERE c.documento = :dni").setParameter("dni", dni).getResultList();
            return (listado.isEmpty()) ? null : listado.get(0);
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public Cliente buscarClientePorID(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID valido para la busqueda");
            }
            Cliente c = em.find(Cliente.class, id);
            if (c == null){
                throw new Exception("No se encontro el cliente con el ID indicado");
            }
            return c;
        }catch(Exception e){
            throw e;
        }
    }
    
}
