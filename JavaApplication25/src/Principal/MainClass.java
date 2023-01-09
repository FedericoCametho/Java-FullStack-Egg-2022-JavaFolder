
package Principal;

import Principal.Dominio.equipo.EquipoService;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainClass {


    public static void main(String[] args) throws Exception {
        
        EquipoService equipoService = new EquipoService();
        
        try{
            equipoService.crearEquipo("Union Vecinal", "La Plata", "East", "Atlantic");
        } catch(Exception ex){
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            equipoService.imprimirEquipos();
        } catch (Exception e){
            throw e;
        }
        
    }
    
}
