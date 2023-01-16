
package Libreria;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Libro;
import Libreria.Servicios.AutorService;
import Libreria.Servicios.EditorialService;
import Libreria.Servicios.LibroService;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        //EntityManager em = Persistence.createEntityManagerFactory("Guia12-JPA-LibreriaPU").createEntityManager();
        AutorService aService = new AutorService();
        EditorialService eService = new EditorialService();
        LibroService lService = new LibroService();
        
        int opcion;
        do {
            opcion = menu(leer);
            switch (opcion){
                case 1:try{
                        opcion = subMenuAlta(leer);
                        if (opcion == 1){
                            lService.crearLibro();
                        } else{
                           if(opcion == 2){
                               System.out.println("Ingrese el nombre del Autor");
                               aService.crearAutor(leer.next());
                           } else {
                               if (opcion == 3){
                                    System.out.println("Ingrese el nombre de la Editorial");
                                    eService.crearEditorial(leer.next());
                                }
                           }
                        }
                    }catch (Exception e){
                        throw e;
                    }
                    break;
                case 2: try{
                        opcion = subMenuBaja(leer);
                        if (opcion ==1){
                            lService.eliminarLibro();
                        } else{
                           if(opcion == 2){
                               aService.eliminarAutor();
                           } else {
                               if (opcion == 3){
                                   eService.eliminarEditorial();
                               }
                           }
                        }
                    }catch (Exception e){
                        throw e;
                    }
                    break;
                case 3: try {
                        opcion = subMenuEditar(leer);
                        if (opcion ==1){
                            lService.editarLibro();
                        } else{
                           if(opcion == 2){
                               aService.editarAutor();
                           } else {
                               if (opcion == 3){
                                  eService.editarEditorial(); 
                               }
                               
                           }
                        }
                        
                    } catch (Exception e){
                        throw e;
                    }
                    break;
                case 4:try{
                        opcion = subMenuListar(leer);
                        if (opcion == 1){
                            lService.mostrarListadoLibros();
                        } else {
                            if (opcion == 2){
                                aService.mostrarListadoAutores();
                            } else {
                                if (opcion == 3){
                                    eService.mostrarListadoEditoriales();
                                }
                            }
                        }
                    } catch(Exception e){
                        throw e;
                    }
                        
                    break;
                case 5: try{
                        opcion = subMenuBusquedaLibro(leer);
                        if (opcion == 1){
                            System.out.println("Ingrese el ISBN del libro a buscar");
                            Libro l = lService.buscarLibroPorISBN(leer.nextLong());
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
                                    aService.mostrarLibrosDeUnAutor(leer.next());
                                } else {
                                    if ( opcion == 4){
                                        System.out.println("Ingrese la Editorial de la cual desea buscar los libros");
                                        eService.mostrarLibrosDeUnaEditorial(leer.next());
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
                        List<Autor> lista = aService.buscarAutorPorNombreFlexible(leer.next());
                        
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
            }
            
            
        } while (opcion != 7);
        
        
    }
    
    public static int menu(Scanner leer){
        int opcion;
        do {    
            System.out.println("-------------------------------------MENU DE OPCIONES--------------------------------------------");
            System.out.println("Ingrese la opcion de la consulta/operacion que desea realizar");
            System.out.println("1. Dar de ALTA un Libro/Autor/Editorial.");
            System.out.println("2. Dar de BAJA un Libro/Autor/Editorial.");
            System.out.println("3. EDITAR/MODIFICAR un Libro/Autor/Editorial.");
            System.out.println("4. Lista todos los Libros/Autores/Editoriales que hay.");
            System.out.println("5. Buscar un Libro.");
            System.out.println("6. Buscar un Autor por Nombre.");
            System.out.println("7. Salir");
            System.out.println("---------------------------------------------------------------------------------");
                    
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 7);
        
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
            System.out.println("4. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 4);
        
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
            System.out.println("4. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 4);
        
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
            System.out.println("4. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 4);
        
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
            System.out.println("4. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 4);
        
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
