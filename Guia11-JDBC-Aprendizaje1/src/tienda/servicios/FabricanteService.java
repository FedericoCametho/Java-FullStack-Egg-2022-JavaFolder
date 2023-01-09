
package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteService {
    
    private FabricanteDAO dao;

    
    public FabricanteService(){
        this.dao = new FabricanteDAO();
    }
    
    public Fabricante altaFabricante(String nombre) throws Exception{
        
        try {
            // validacion de datos
            if (nombre == null){
                System.out.println("Debe ingresar un nombre de fabricante");
            }
            if (this.buscarFabricantePorNombre(nombre)!= null){
                System.out.println("El nombre ingresado ya pertenece a un producto en la base de datos");
            }
            Fabricante fab = new Fabricante(nombre);
            this.dao.altaFabricante(fab);
            fab.setCodigo(this.buscarFabricantePorNombre(nombre).getCodigo());
            return fab;
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception{
        try {
            //Validamos
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            Fabricante fab = dao.buscarFabricantePorNombre(nombre);

            return fab;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception{
        try {
            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }

            Fabricante fab = dao.buscarFabricantePorCodigo(codigo);

            return fab;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
