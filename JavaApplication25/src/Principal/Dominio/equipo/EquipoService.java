
package Principal.Dominio.equipo;

import Principal.Persistencia.EquipoDAO;
import java.util.Collection;

public class EquipoService {
    
    private EquipoDAO dao;
    
    public EquipoService(){
        this.dao = new EquipoDAO();
    }
    
    public void crearEquipo(String nombre,String ciudad,String conferencia,String division) throws Exception{
        
        try {
            // validacion de datos
            if (nombre == null){
                throw new Exception("Debe indicar el nombre del equipo");
            }
            if (ciudad == null){
                throw new Exception("Debe indicar la ciudad del equipo");
            }
            if (conferencia == null){
                throw new Exception("Debe indicar la conferencia del equipo");
            }
            if (division == null){
                throw new Exception("Debe indicar la division del equipo");
            }
            if (this.buscarEquipoPorNombre(nombre) != null){
                throw new Exception("Ya existe un equipo registrado con el nombre ingresado");
            }

            // creacion del equipo
            Equipo equipo =  new Equipo(nombre, ciudad, conferencia, division);
            dao.insertarEquipo(equipo);    
            
        } catch(Exception e){
            throw e;
        }
    }
    
    
    public void modificarConferenciaEquipo(String nombre, String conferenciaActual, String conferenciaNueva) throws Exception {

        try {

            //Validamos
            if (nombre == null ) {
                throw new Exception("Debe indicar el equipo");
            }

            if (conferenciaActual == null) {
                throw new Exception("Debe indicar la conferencia actual");
            }

            if (conferenciaNueva == null) {
                throw new Exception("Debe indicar la conferencia nueva");
            }

            //Buscamos
            Equipo equipo = this.buscarEquipoPorNombre(nombre);

            //Validamos
            if (!equipo.getConferencia().equals(conferenciaActual)) {
                throw new Exception("La Conferencia actual no es la regsitrada en el sistema para el Equipo indicado");
            }

            //Modificamos
            equipo.setConferencia(conferenciaNueva);
            dao.modificarEquipoConferencia(equipo);
            
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminaEquipo(String nombre) throws Exception {

        try {

            //Validamos 
            if (nombre == null ) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            
            // Eliminamos
            dao.eliminarEquipoPorNombre(nombre);
            
        } catch (Exception e) {
            throw e;
        }
    }

    public Equipo buscarEquipoPorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del equipo");
            }

            Equipo equipo = dao.buscarEquipoPorNombre(nombre);

            return equipo;
        } catch (Exception e) {
            throw e;
        }
    }

//    public Equipo buscarEquipoPorId(Integer id) throws Exception {
//
//        try {
//
//            //Validamos
//            if (id == null) {
//                throw new Exception("Debe indicar el id");
//            }
//
//            Equipo equipo = dao.buscarEquipoPorId(id);
//
//            return equipo;
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    public Collection<Equipo> listarEquipos() throws Exception {

        try {

            Collection<Equipo> listaEquipos = dao.listarEquipos();

            return listaEquipos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Equipo> listarEquiposPorConferencia(String conferencia) throws Exception {

        try {

            Collection<Equipo> listaEquipos = dao.listarEquiposPorConferencia(conferencia);

            return listaEquipos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirEquipos() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Equipo> listaEquipos = listarEquipos();

            //Imprimimos los usuarios
            if (listaEquipos.isEmpty()) {
                throw new Exception("No existen Equipos para imprimir");
            } else {
                listaEquipos.forEach(e -> this.imprimirDatosEquipo(e));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void imprimirDatosEquipo(Equipo e){
        System.out.println(e.getNombre() + " - " + e.getCiudad()+ " - " + e.getConferencia() + " - " + e.getDivision());
    }
    
    
    
    
    
}
