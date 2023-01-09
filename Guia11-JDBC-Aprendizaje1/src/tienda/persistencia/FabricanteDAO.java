
package tienda.persistencia;

import tienda.entidades.Fabricante;

public class FabricanteDAO extends DAO{
    
    public Fabricante buscarFabricantePorNombre (String nombre) throws Exception{
        
        try {
            String sql = "SELECT * FROM Fabricante WHERE nombre = '" + nombre + "';";
            this.consultarDB(sql);
            Fabricante fab = null;
            
            while (resultado.next()){
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString(2));  
            } 
            this.desconectarDB();
            return fab;
            
        } catch (Exception e){           
            this.desconectarDB();
            throw e;       
        }
    }
    
    public void altaFabricante(Fabricante fab) throws Exception{
        try{
            if (fab == null){
                throw new Exception("Debe indicar un fabricante para insertarlo en la Base de Datos");
            }
            
            String sql = "INSERT INTO fabricante (nombre) "
                    +"VALUES ('" + fab.getNombre() + "'); ";
            
            this.insertarModificarEliminar(sql);
            
        } catch(Exception e){
            throw e;
        }
    }
    
    public Fabricante buscarFabricantePorCodigo (Integer codigo) throws Exception{
        
        try {
            String sql = "SELECT * FROM Fabricante WHERE codigo = '" + codigo + "';";
            this.consultarDB(sql);
            Fabricante fab = null;
            
            while (resultado.next()){
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString(2));  
            } 
            this.desconectarDB();
            return fab;
            
        } catch (Exception e){           
            this.desconectarDB();
            throw e;       
        }
    }
    
}
