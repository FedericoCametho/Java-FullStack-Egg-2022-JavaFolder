
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

public class ClienteService {
    
    private final ClienteDAO DAO;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public ClienteService(){
        this.DAO = new ClienteDAO();
    }
    
    
    public void crearCliente(Long dni, String nom, String ape, String tel) throws Exception{
        try {
            if (dni == null){
                throw new Exception("Debe ingresar un dni valido");
            }
            if (nom == null){
                throw new Exception("Debe ingresar un Nombre valido");
            }
            if (ape == null){
                throw new Exception("Debe ingresar un apellido valido");
            }
            if (tel == null){
                throw new Exception("Debe ingresar un telefono valido");
            }
            if (this.buscarClientePorDNI(dni) != null){
                throw new Exception("El DNI ingresado ya corresponde a un cliente registrado");
            }
            Cliente c = new Cliente(dni,nom,ape,tel);
            this.DAO.crearCliente(c);
            
        } catch (Exception e){
            throw e;
        }
    }
    
    public void eliminarCliente(Long id)throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe indicar un ID valido");
            }
            Cliente c = this.buscarClientePorID(id);
            if (c == null){
                throw new Exception("El ID ingresado no corresponde a un Cliente registrado en la base de datos.");
            }
            this.DAO.eliminarCliente(c);
        }catch(Exception e){
            throw e;
        }
    }
    
    public void editarCliente(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe indicar un ID valido");
            }
            Cliente c = this.buscarClientePorID(id);
            if (c == null){
                throw new Exception("El ID ingresado no corresponde a un Cliente registrado en nuestra base de datos");
            }
            int opcion = this.menuEdicionCliente();
            if (opcion != 5){
                switch(opcion){
                    case 1: System.out.println("Ingrese el nuevo numero de documento para el Cliente con DNI ("+c.getDocumento()+")");
                            Long nuevoDni = leer.nextLong();
                            if (nuevoDni == null){
                                throw new Exception("Debe indicar un nuevo DNI valido");
                            }
                            if (this.buscarClientePorDNI(nuevoDni) != null){
                                System.out.println("El nuevo DNI ingresado corresponde a otro Cliente ya registrado");
                            } else{
                                c.setDocumento(nuevoDni);
                                this.DAO.editarCliente(c);
                            }
                        break;
                    case 2: System.out.println("Ingrese el nuevo nombre para el cliente ("+c.getNombre()+")");
                            String nom = leer.next();
                            if (nom == null){
                                throw new Exception("Debe indicar un nuevo nombre valido");
                            }
                            c.setNombre(nom);
                            this.DAO.editarCliente(c);
                        break;
                    case 3:System.out.println("Ingrese el nuevo Apellido para el cliente ("+c.getApellido()+")");
                            String ape = leer.next();
                            if (ape == null){
                                throw new Exception("Debe indicar un nuevo Apellido valido");
                            }
                            c.setApellido(ape);
                            this.DAO.editarCliente(c);
                        break;
                    case 4:System.out.println("Ingrese el nuevo Telefono para el cliente ("+c.getNombre()+")");
                            String tel = leer.next();
                            if (tel == null){
                                throw new Exception("Debe indicar un nuevo Telefono valido");
                            }
                            c.setTelefono(tel);
                            this.DAO.editarCliente(c);
                        break;
                }
            }
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public void mostrarListadoClientes()throws Exception{
        try{
            Collection<Cliente> listado = this.DAO.listarClientes();
            if (listado.isEmpty()){
                throw new Exception("No hay clientes registrados para la base de datos");
            } 
            System.out.println("************** IMPRIMIENDO LISTADO DE CLIENTES *****************");
            for (Cliente c : listado){
                System.out.println(c.toString());  
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    private int menuEdicionCliente(){
        int op;
        do {
            System.out.println("Ingrese el atributo que desea modificar");
            System.out.println("1. Documento(DNI");
            System.out.println("2. Nombre");
            System.out.println("3. Apellido");
            System.out.println("4. Telefono");
            System.out.println("5. Salir");
            op = leer.nextInt();
        } while (op < 0 || op > 5);
        return op;
    }
    
    public Cliente buscarClientePorID(Long id) throws Exception{
       try{
           if (id == null){
               throw new Exception("Debe ingresar un ID valido para la busqueda del cliente");
           }
           return this.DAO.buscarClientePorID(id);
       } catch(Exception e){
           throw e;
       }
    }
    
    public Cliente buscarClientePorDNI(Long dni) throws Exception{
       try{
           if (dni == null){
               throw new Exception("Debe ingresar un dni valido para la busqueda del cliente");
           }
           return this.DAO.buscarClientePorDNI(dni);
       } catch(Exception e){
           throw e;
       }
    }
    
}
