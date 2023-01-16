
package libreria.servicios;

import java.util.Date;
import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;


public class PrestamoService {
    
    private final PrestamoDAO DAO;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public PrestamoService(){
        this.DAO = new PrestamoDAO();
    }
    
    
    public void crearPrestamo(Date fechaPrestamo, Libro li, Cliente cli) throws Exception{
        try{
            if (fechaPrestamo == null){
                throw new Exception("Debe ingresar una fecha de prestamo valida");
            }
            if (li == null){
                throw new Exception("Debe ingresar un libro valido");
            }
            if (cli == null){
                throw new Exception("Debe ingresar un cliente valido");
            }
            
            new LibroService().registrarPrestamoLibro(li);
            
            Prestamo p = new Prestamo(fechaPrestamo, li, cli);
            this.DAO.crearPrestamo(p);
            
        } catch(Exception e){
            throw e;
        }
                
    }
    
    public void eliminarPrestamo(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID de prestamo valido");
            }
            Prestamo p = this.buscarPrestamoPorID(id);
            if (p == null){
                throw new Exception("El Id ingresado no corresponde a un prestamo registrado en la base de datos");
            }
            this.DAO.eliminarPrestamo(p);
        }catch(Exception e){
            throw e;
        }
    }
    
    public void editarPrestamo(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe indicar un ID valido");
            }
            Prestamo p = this.buscarPrestamoPorID(id);
            if (p == null){
                throw new Exception("El ID ingresado no corresponde a un Prestamo registrado en nuestra base de datos");
            }
            int opcion = this.menuEdicionPrestamo();
            if (opcion != 4){
                switch(opcion){
                    case 1: System.out.println("Ingresaremos la nueva fecha de devolucion para el prestamo que finaliza"
                            + "el dia ("+p.getFechaDevolucion()+")");
                            System.out.println("Ingrese el dia");
                            Integer dia = leer.nextInt();
                            System.out.println("Ingrese el mes");
                            Integer mes = leer.nextInt();
                            System.out.println("Ingrese el año");
                            Integer anio = leer.nextInt();
                            
                            if (dia == null || mes == null || anio == null){
                                throw new Exception("Debe indicar un dia, mes y anio valido");
                            }
                            Date nuevaFechaDev = new Date(anio-1900,mes,dia);   
                            if (nuevaFechaDev == null){
                                throw new Exception("Debe ingresar una fecha valida");
                            }
                            if(nuevaFechaDev.before(p.getFechaPrestamo())){
                                throw new Exception("La nueva fecha de devolucion debe ser posterior a la fecha de Prestamo");
                            }
                            p.setFechaDevolucion(nuevaFechaDev);
                            this.DAO.editarPrestamo(p);
                            
                        break;
                    case 2: System.out.println("Comenzaremos a Editar el libro del prestamo ("+p.getLibro().toString()+")");
                            LibroService lService = new LibroService();
                            lService.mostrarListadoLibros();
                            System.out.println("Seleccione el ISBN del libro que quiere solicitar Prestamo");
                            Libro l = lService.buscarLibroPorISBN(leer.nextLong());
                            if (l == null){
                                throw new Exception("Debe indicar un nuevo Libro valido dentro de nuestra base de datos");
                            }
                            p.setLibro(l);
                            this.DAO.editarPrestamo(p);
                        break;
                    case 3:System.out.println("Comenzaremos a Editar el Cliente del prestamo ("+p.getCliente().toString()+")");
                            ClienteService cService = new ClienteService();
                            cService.mostrarListadoClientes();
                            System.out.println("Seleccione el ID del nuevo Cliente a registrar en el prestamo o presione 0 (cero) si desea cargar un nuevo cliente antes de seleccionarlo");
                            Long idCli = leer.nextLong();
                            if (idCli == 0){
                                System.out.println("*** PROCEDIMIENTO PARA DAR DE ALTA CLIENTE NUEVO ***");
                                System.out.println("Ingrese el DNI del Cliente");
                                Long dni = leer.nextLong();
                                System.out.println("Ingrese el nombre del Cliente");
                                String nom = leer.next();
                                System.out.println("Ingrese el APellido del cliente");
                                String ape = leer.next();
                                System.out.println("Ingrese el telefono del cliente");
                                String tel = leer.next();
                                cService.crearCliente(dni, nom, ape, tel);
                            }
                            Cliente cli = cService.buscarClientePorID(idCli);
                            
                            p.setCliente(cli);
                            this.DAO.editarPrestamo(p);
                        break;
                }
            }
            
        }catch(Exception e){
            throw e;
        }
    }
    
    private int menuEdicionPrestamo(){
        int op;
        do {
            System.out.println("Ingrese el atributo que desea modificar");
            System.out.println("1. Fecha De Devolucion");
            System.out.println("2. Libro");
            System.out.println("3. Cliente");
            System.out.println("4. Salir");
            op = leer.nextInt();
        } while (op < 0 || op > 4);
        return op;
    }
    
    public void registrarDevolucion(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID valido");
            }
            Prestamo p = this.buscarPrestamoPorID(id);
            if (p == null){
                throw new Exception("No se encontro un prestamo para el ID ingresado");
            }
            p.setFechaDevolucion(new Date());
            new LibroService().registrarDevolucionLibro(p.getLibro());
            this.DAO.registrarDevolucion(p);
        } catch(Exception e){
            throw e;
        }
    }
    
    public void mostrarListadoPrestamos()throws Exception{
        try{
            Collection<Prestamo> listado = this.DAO.listarPrestamos();
            if (listado.isEmpty()){
                throw new Exception("No existen prestamos registrados en la base de datos");
            }
            System.out.println(" ********************  IMPRIMIENDO LISTADO DE PRESTAMOS **************");
            for (Prestamo p : listado){
                System.out.println(p.toString());
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public Prestamo buscarPrestamoPorID(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un ID valido para la busqueda del prestamo");
            }
            return this.DAO.buscarPrestamoPorID(id);
            
        }catch(Exception e){
            throw e;
        }
    }
    
}
