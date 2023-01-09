
package Principal.Persistencia;

import Principal.Dominio.equipo.Equipo;
import java.util.ArrayList;
import java.util.Collection;

public final class EquipoDAO extends DAO{
    
    public void insertarEquipo(Equipo equipo) throws Exception{
        
        try {
            if (equipo == null){
                throw new Exception("Debe indicarse un equipo que sea distinto a NULL para insertarlo");
            }
            
            String sql = "INSERT INTO equipo (nombre, ciudad, conferencia, division) " +
                        "VALUES ( '" + equipo.getNombre() + "' , '" + equipo.getCiudad() + "' , '" 
                                    + equipo.getConferencia() + "' , '" + equipo.getDivision() + "' );";
            
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
    // estos metodos de modificacion se pueden hacer para modificar los distintos atributos
    // en este ejemplo se implementa el metodo para modificar la ciudad de un equipo, pero si se quiere modificar mas de un
    // atributo entonces se puede crear un metodo con la sentencia SQL que se encargue de modificar los atributos que se 
    //  quiere modificar
    
    public void modificarEquipoCiudad(Equipo equipo) throws Exception{
        
        try {
            if (equipo == null){
                throw new Exception("Debe indicarse un equipo que sea distinto a NULL para modificarlo");
            }
            
            String sql = "UPDATE equipo SET ciudad = '" + equipo.getCiudad() + 
                          "' WHERE nombre = '" + equipo.getNombre() + "';";
            
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void modificarEquipoConferencia(Equipo equipo) throws Exception{
        
        try {
            if (equipo == null){
                throw new Exception("Debe indicarse un equipo que sea distinto a NULL para modificarlo");
            }
            
            String sql = "UPDATE equipo SET ciudad = '" + equipo.getConferencia() + 
                          "' WHERE nombre = '" + equipo.getNombre() + "';";
            
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void eliminarEquipoPorNombre(String nombreEquipo) throws Exception{
        try {
            if (nombreEquipo == null){
                throw new Exception("Debe indicarse un equipo que sea distinto a NULL para eliminarlo");
            }
            String sql = "DELETE FROM equipo WHERE nombre = '" + nombreEquipo + ";'";           
            this.insertarModificarEliminar(sql);
            
        } catch (Exception e){
            throw e;
        }
        
    }  
    
    
    // METODO DE CONSULTA CON UN UNICO RESULTADO , por clave primaria por ejemplo
    public Equipo buscarEquipoPorNombre (String nombre) throws Exception{
        
        try {
            String sql = "SELECT * FROM equipo WHERE nombre = '" + nombre + "';";
            this.consultarDB(sql);
            Equipo equipo = null;
            
            while (resultado.next()){
                equipo = new Equipo();
                equipo.setNombre(resultado.getString(1));
                equipo.setCiudad(resultado.getString(2));
                equipo.setConferencia(resultado.getString(3));
                equipo.setDivision(resultado.getString(4));   
            } 
            this.desconectarDB();
            return equipo;
            
        } catch (Exception e){           
            this.desconectarDB();
            throw e;       
        }
    }
    
    // METODO DE CONSULTA por algun criterio, CON VARIOS O MUCHOS RESULTADOS POSIBLES PARA LISTAR
    public Collection<Equipo> listarEquiposPorConferencia (String conferencia) throws Exception{
        
        try {
            String sql = "SELECT * FROM equipo WHERE conferencia = '" + conferencia + "';";
            this.consultarDB(sql);
            
            Equipo equipo = null;
            Collection<Equipo> listaEquipos = new ArrayList();
            while (resultado.next()){
                equipo = new Equipo();
                equipo.setNombre(resultado.getString(1));
                equipo.setCiudad(resultado.getString(2));
                equipo.setConferencia(resultado.getString(3));
                equipo.setDivision(resultado.getString(4));
                listaEquipos.add(equipo);
            } 
            this.desconectarDB();
            return listaEquipos;
            
        } catch (Exception e){ 
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema");       
        }
    }
    
    public Collection<Equipo> listarEquipos () throws Exception{
        
        try {
            String sql = "SELECT * FROM equipo;";
            this.consultarDB(sql);
            
            Equipo equipo = null;
            Collection<Equipo> listaEquipos = new ArrayList();
            while (resultado.next()){
                equipo = new Equipo();
                equipo.setNombre(resultado.getString(1));
                equipo.setCiudad(resultado.getString(2));
                equipo.setConferencia(resultado.getString(3));
                equipo.setDivision(resultado.getString(4));
                listaEquipos.add(equipo);
            } 
            this.desconectarDB();
            return listaEquipos;
            
        } catch (Exception e){ 
            e.printStackTrace();
            this.desconectarDB();
            throw new Exception("Error de Sistema");       
        }
    }
    
}
