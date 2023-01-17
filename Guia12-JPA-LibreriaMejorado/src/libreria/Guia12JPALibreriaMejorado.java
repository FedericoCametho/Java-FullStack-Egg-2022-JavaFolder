
package Libreria;


import java.util.Collection;
import java.util.Date;
import libreria.entidades.Autor;
import libreria.entidades.Libro;
import libreria.servicios.AutorService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Editorial;
import libreria.servicios.ClienteService;
import libreria.servicios.PrestamoService;


public class Guia12JPALibreriaMejorado {

    
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        //EntityManager em = Persistence.createEntityManagerFactory("Guia12-JPA-LibreriaPU").createEntityManager();
        AutorService aService = new AutorService();
        EditorialService eService = new EditorialService();
        LibroService lService = new LibroService();
        ClienteService cService = new ClienteService();
        PrestamoService pService = new PrestamoService();
        
        int opcion;
        do {
            opcion = menu(leer);
            switch (opcion){
                case 1:try{
                        opcion = subMenuAlta(leer);
                        switch(opcion){
                            case 1:
                                System.out.println("Ingrese el titulo del libro");
                                String tit = leer.next();
                                System.out.println("Ingrese la cantidad de ejemplares del libro");
                                Integer ejemp = leer.nextInt();
                                System.out.println("Ingrese la cantidad de ejemplares prestados del libro");
                                Integer ejemPrestados = leer.nextInt();
                                System.out.println("Ingrese el nombre del autor");
                                String nombreAutor = leer.next();
                                System.out.println("Ingrese el nombre de la Editorial");
                                String nombreEditorial = leer.next();
                                
                                Autor aut = aService.chequearAutor(nombreAutor);
                                Editorial edit = eService.chequearEditorial(nombreEditorial);
                                lService.crearLibro(tit, ejemp, ejemPrestados, aut, edit);
                                break;
                            case 2:
                               System.out.println("Ingrese el nombre del Autor");
                               aService.crearAutor(leer.next());
                               break;
                            case 3:
                                    System.out.println("Ingrese el nombre de la Editorial");
                                    eService.crearEditorial(leer.next());
                                    break;
                            case 4:
                                    System.out.println("Ingrese el DNI del Cliente");
                                    Long dni = leer.nextLong();
                                    System.out.println("Ingrese el nombre del Cliente");
                                    String nom = leer.next();
                                    System.out.println("Ingrese el APellido del cliente");
                                    String ape = leer.next();
                                    System.out.println("Ingrese el telefono del cliente");
                                    String tel = leer.next();
                                    cService.crearCliente(dni, nom, ape, tel);
                                    break;
                            case 5:
                                    Libro l = lService.buscarLibroPorISBN(seleccionarISBNLibrosDisponibles(lService, leer));
                                    System.out.println("Ingrese el cliente que solicita el prestamo o el numero 0(cero) si el cliente no esta registrado");
                                    Long idCliente = seleccionarIDCliente(cService,leer);
                                    Cliente c;
                                    if (idCliente == 0){
                                        System.out.println("*** PROCEDIMIENTO PARA DAR DE ALTA CLIENTE NUEVO ***");
                                        System.out.println("Ingrese el DNI del Cliente");
                                        dni = leer.nextLong();
                                        System.out.println("Ingrese el nombre del Cliente");
                                        nom = leer.next();
                                        System.out.println("Ingrese el APellido del cliente");
                                        ape = leer.next();
                                        System.out.println("Ingrese el telefono del cliente");
                                        tel = leer.next();
                                        cService.crearCliente(dni, nom, ape, tel);
                                        c = cService.buscarClientePorID(seleccionarIDCliente(cService,leer));
                                    } else {
                                        c = cService.buscarClientePorID(idCliente);
                                    }
                                    
                                    
                                    pService.crearPrestamo(new Date() , l, c);
                        }
                    }catch (Exception e){
                        throw e;
                    }
                    break;
                case 2: try{
                            opcion = subMenuBaja(leer);
                            switch(opcion){
                                case 1:             
                                    lService.eliminarLibro(seleccionarISBNLibro(lService, leer));
                                    break;
                                case 2:
                                   aService.eliminarAutor(seleccionarIDAutor(aService,leer));
                                   break;
                                case 3:
                                    eService.eliminarEditorial(seleccionarIDEditorial(eService,leer));
                                    break;
                                case 4:
                                    cService.eliminarCliente(seleccionarIDCliente(cService,leer));
                                    break;
                                case 5:
                                    pService.eliminarPrestamo(seleccionarIDPrestamo(pService,leer));
                            }
                    }catch (Exception e){
                        throw e;
                    }
                    break;
                case 3: try {
                            opcion = subMenuEditar(leer);
                            switch(opcion){
                                case 1:
                                    lService.editarLibro(seleccionarISBNLibro(lService, leer));
                                    break;
                                case 2:
                                    aService.editarAutor(seleccionarIDAutor(aService,leer));
                                    break;
                                case 3:
                                    eService.editarEditorial(seleccionarIDEditorial(eService,leer));
                                    break;
                                case 4:
                                    cService.editarCliente(seleccionarIDCliente(cService, leer));
                                    break;
                                case 5:
                                    pService.editarPrestamo(seleccionarIDPrestamo(pService, leer));
                                    break;
                               }                
                    } catch (Exception e){
                        throw e;
                    }
                    break;
                case 4:try{
                        opcion = subMenuListar(leer);
                        switch(opcion){
                            case 1:
                                lService.mostrarListadoLibros();
                                break;
                            case 2:
                                aService.mostrarListadoAutores();
                                break;
                            case 3:
                                eService.mostrarListadoEditoriales();
                                break;
                            case 4:
                                cService.mostrarListadoClientes();
                                break;
                            case 5:
                                pService.mostrarListadoPrestamos();
                                break;
                        }
                    } catch(Exception e){
                        throw e;
                    }
                        
                    break;
                case 5: try{
                        opcion = subMenuBusquedaLibro(leer);
                        if (opcion == 1){
                            Libro l = lService.buscarLibroPorISBN(seleccionarISBNLibro(lService, leer));
                            if (l!= null){
                                System.out.println(l.toString());
                            } else {
                                System.out.println("No se encontro el libro solicitado");
                            }
                        } else {
                            if (opcion == 2){
                                System.out.println("Ingrese el Titulo del Libro a Buscar");
                                Libro l = lService.buscarLibroPorTitulo(leer.next());
                                if (l!= null){
                                    System.out.println(l.toString());
                                } else {
                                    System.out.println("No se encontro el libro solicitado");
                                }
                            } else {
                                if (opcion == 3){
                                    System.out.println("Ingrese el Autor del cual desea buscar los libros");
                                    aService.mostrarLibrosDeUnAutor(seleccionarIDAutor(aService, leer));
                                } else {
                                    if ( opcion == 4){
                                        System.out.println("Ingrese la Editorial de la cual desea buscar los libros");
                                        eService.mostrarLibrosDeUnaEditorial(seleccionarIDEditorial(eService, leer));
                                    }
                                }
                            }
                        }
                    } catch (Exception e){
                        throw e;
                    }
                    break;
                case 6: try{
                        System.out.println("Ingrese el nombre del Autor a buscar");
                        Collection<Autor> lista = aService.buscarAutorPorNombreFlexible(leer.next());
                        
                        if (lista.isEmpty()){
                            System.out.println("No se encontro el autor solicitado en nuestra base de datos");
                        } else {
                            for (Autor a: lista){
                                System.out.println(a.toString());
                            }
                        }
                    }catch(Exception e){
                        throw e;
                    }
                    break;
                case 7: try{
                    System.out.println("******** MENU DE DEVOLUCION DE LIBROS ****************");
                    Long id = seleccionarIDPrestamo(pService,leer);
                    do {
                        System.out.println("Confirma que devuelve el libro?");
                        System.out.println("1. SI");
                        System.out.println("2. NO");
                        opcion = leer.nextInt();
                    } while (opcion < 0 || opcion > 2);
                    
                    if (opcion == 1){
                        pService.registrarDevolucion(id);
                    }
                    
                    
                    }catch(Exception e){
                        throw e;
                    }
                    break;
                case 8: try{
                    pService.mostrarPrestamosCliente(cService.buscarClientePorID(seleccionarIDCliente(cService,leer)));
                } catch(Exception e){
                    throw e;
                }
                break;
            }
            
            
        } while (opcion != 9);
        
        
    }
    
    public static Long seleccionarISBNLibro(LibroService lService, Scanner leer) throws Exception{
        try{
            lService.mostrarListadoLibros();
            System.out.println("Ingrese el ISBN del libro");
            return leer.nextLong();
        } catch (Exception e){
            throw e;
        } 
    }
    
    public static Long seleccionarISBNLibrosDisponibles(LibroService lService, Scanner leer) throws Exception{
        try{
            lService.mostrarListadoLibrosDisponibles();
            System.out.println("Ingrese el ISBN del libro");
            return leer.nextLong();
        } catch (Exception e){
            throw e;
        } 
    }
    
    public static Long seleccionarIDEditorial(EditorialService eService, Scanner leer) throws Exception{
        try{
            eService.mostrarListadoEditoriales();
            System.out.println("Ingrese el id de la Editorial");
            return leer.nextLong();
        } catch (Exception e){
            throw e;
        } 
        
    }
    
    public static Long seleccionarIDAutor(AutorService aService, Scanner leer) throws Exception{
        try{
            aService.mostrarListadoAutores();
            System.out.println("Ingrese el id del Autor");
            return leer.nextLong();
        } catch (Exception e){
            throw e;
        } 
    }
    
    public static Long seleccionarIDCliente(ClienteService cService, Scanner leer) throws Exception{
        try{
            cService.mostrarListadoClientes();
            System.out.println("Ingrese el id del Cliente");
            return leer.nextLong();
        } catch (Exception e){
            throw e;
        } 
    }
    
    public static Long seleccionarIDPrestamo(PrestamoService pService, Scanner leer) throws Exception{
        try{
            pService.mostrarListadoPrestamos();
            System.out.println("Ingrese el id del Prestamo");
            return leer.nextLong();
        } catch (Exception e){
            throw e;
        } 
    }
    
    public static int menu(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE OPCIONES--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Dar de ALTA un Libro/Autor/Editorial/Cliente/Prestamo.");
            System.out.println("2. Dar de BAJA un Libro/Autor/Editorial/Cliente/Prestamo.");
            System.out.println("3. EDITAR/MODIFICAR un Libro/Autor/Editorial/Cliente/Prestamo.");
            System.out.println("4. Lista todos los Libros/Autores/Editoriales/Cliente/Prestamos que hay.");
            System.out.println("5. Buscar un Libro.");
            System.out.println("6. Buscar un Autor por Nombre.");
            System.out.println("7. Devolver un libro.");
            System.out.println("8. Buscar los Prestamos de un Cliente.");
            System.out.println("9. Salir");
            System.out.println("---------------------------------------------------------------------------------");
                    
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 9);
        
        return opcion;
    }
    
    public static int subMenuAlta(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE ALTAS--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Dar de ALTA un Libro.");
            System.out.println("2. Dar de ALTA un Autor.");
            System.out.println("3. Dar de ALTA una Editorial.");
            System.out.println("4. Dar de ALTA un Cliente.");
            System.out.println("5. Dar de ALTA un Prestamo.");
            System.out.println("6. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 6);
        
        return opcion;
    }
    
    public static int subMenuBaja(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE BAJAS--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Dar de BAJA un Libro.");
            System.out.println("2. Dar de BAJA un Autor.");
            System.out.println("3. Dar de BAJA una Editorial.");
            System.out.println("4. Dar de BAJA un Cliente.");
            System.out.println("5. Dar de BAJA un Prestamo.");
            System.out.println("6. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 6);
        
        return opcion;
    }
    
    public static int subMenuEditar(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE MODIFICACIONES--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Editar/Modificar un Libro.");
            System.out.println("2. Editar/Modificar un Autor.");
            System.out.println("3. Editar/Modificar una Editorial.");
            System.out.println("4. Editar/Modificar un Cliente.");
            System.out.println("5. Editar/Modificar un Prestamo.");
            System.out.println("6. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 6);
        
        return opcion;
    }
    
    public static int subMenuListar(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE SELECCION DE LISTADO--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Listar todos los Libros.");
            System.out.println("2. Listar todos los Autores.");
            System.out.println("3. Listar todas las Editoriales.");
            System.out.println("4. Listar todos los Clientes.");
            System.out.println("5. Listar todos los Prestamos.");
            System.out.println("6. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 6);
        
        return opcion;
    }
    
    public static int subMenuBusquedaLibro(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE BUSQUEDA DE LIBRO--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Buscar Libro por ISBN.");
            System.out.println("2. Buscar Libro por Titulo.");
            System.out.println("3. Buscar Libro/s por Autor.");
            System.out.println("4. Buscar Libro/s por Editorial.");
            System.out.println("5. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 5);
        
        return opcion;
    }
    
    
}

