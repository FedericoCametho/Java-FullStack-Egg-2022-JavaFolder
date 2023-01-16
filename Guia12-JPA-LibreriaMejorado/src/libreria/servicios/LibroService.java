
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;


public class LibroService {
    
    private final LibroDAO DAO = new LibroDAO();
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public LibroService(){
        
    }
    
    public void crearLibro(String titulo, Integer ejemplares, Integer ejemplaresPrestados, Autor a, Editorial e)throws Exception{
        try {
            if (titulo == null){
                throw new Exception("Debe ingresar un titulo valido para el libro");
            }
            if (ejemplares == null || ejemplares < 0){
                throw new Exception("Debe ingresar una cantidad de ejemplares valida para el libro");
            }
            if (ejemplaresPrestados == null || ejemplaresPrestados > ejemplares){
                throw new Exception("Debe ingresar una cantidad de ejemplares prestados valida para el libro");
            }
            if (a == null){
                throw new Exception("Debe ingresar un autor valido para el libro");
            }
            if (e == null){
                throw new Exception ("Debe ingresar una editorial valida para el libro");
            }
            Libro lib = new Libro(titulo, ejemplares, ejemplaresPrestados, a, e);
            this.DAO.crearLibro(lib);
            
            
        } catch(Exception ex){
            throw ex;
        }
    }
    
    public void eliminarLibro(Long id) throws Exception{
        try{
            if (id == null){
                throw new Exception("Debe ingresar un id valido");
            }
            Libro lib = this.buscarLibroPorISBN(id);
            if (lib == null){
                throw new Exception("El id ingresado no corresponde a un libro en nuestra base de datos");
            }
            this.DAO.eliminarLibro(lib);
        } catch(Exception e){
            throw e;
        }
    }
    
    public void editarLibro(Long isbn) throws Exception {
        try{
            if (isbn ==  null){
                throw new Exception("Debe ingresar un ISBN valido para modificar el Libro");
            }
            Libro l = this.buscarLibroPorISBN(isbn);
            if (l == null){
                throw new Exception("El ISBN ingresado no corresponde a un Libro registrado en la base de datos.");
            }
            int opcion = this.menuEdicionLibro();
            if (opcion != 6){
                switch(opcion){
                    case 1: System.out.println("El libro "+ l.getTitulo()+" tiene actualmente: "+l.getEjemplares()+" ejemplares");
                            System.out.println("Por favor Ingrese la Nueva Cantidad de Ejemplares Totales: ");
                            l.setEjemplares(leer.nextInt());
                            l.setEjemplaresRestantes();
                            break;
                    case 2: System.out.println("El libro "+ l.getTitulo()+" tiene actualmente: "+l.getEjemplaresPrestados()+" ejemplares PRESTADOS");
                            System.out.println("Por favor Ingrese la Nueva Cantidad de Ejemplares Prestados: ");
                            l.setEjemplaresPrestados(leer.nextInt());
                            l.setEjemplaresRestantes();
                            break;
                    case 3: System.out.println("Ingrese el nuevo titulo del libro: ");
                            l.setTitulo(leer.next());
                            break;
                    case 4: System.out.println("Ingrese el nombre del nuevo autor del libro");
                            String nombreAutor = leer.next();
                            Autor a = new AutorService().chequearAutor(nombreAutor);
                            l.setAutor(a);
                            break;
                    case 5: System.out.println("Ingrese el nombre de la nueva Editorial del libro");
                            String nombreEditorial = leer.next();
                            Editorial e = new EditorialService().chequearEditorial(nombreEditorial);
                            l.setEditorial(e);
                            break;                    
                }
                this.DAO.editarLibro(l);
                
            }         
        } catch (Exception e){
            throw e;
        }
    }
    
    private int menuEdicionLibro(){
        int opcion;
        do{
            System.out.println("------------ Menu edicion de libro ------------");
            System.out.println("1. Cantidad de Ejemplares del libro.");
            System.out.println("2. Cantidad de Ejemplares Prestados del libro.");
            System.out.println("3. Titulo del libro.");
            System.out.println("4. Autor del libro.");
            System.out.println("5. Editorial del libro.");
            System.out.println("6. Salir.");
            opcion = leer.nextInt();
        } while (opcion < 1 || opcion > 6);
        
        return opcion;
    }
    
    public void mostrarListadoLibros() throws Exception{
        try {
            Collection<Libro> listado = this.DAO.listarLibros();
            
            if (listado.isEmpty()){
                throw new Exception("No existen libros registrados en la Base de Datos");
            }
            
            System.out.println("********  IMPRIMIENDO LISTADO DE LIBROS  ********");
            for (Libro l : listado){
                System.out.println(l.toString());
            }
            
        } catch (Exception e){
            throw e;
        }
    }
    
    public void mostrarListadoLibrosDisponibles() throws Exception{
        try {
            Collection<Libro> listado = this.DAO.listarLibros();
            
            if (listado.isEmpty()){
                throw new Exception("No existen libros registrados en la Base de Datos");
            }
            
            System.out.println("********  IMPRIMIENDO LISTADO DE LIBROS  ********");
            for (Libro l : listado.stream().filter(l-> l.getAlta()).collect(Collectors.toList())){
                System.out.println(l.toString());
            }
            
        } catch (Exception e){
            throw e;
        }
    }
    
    public Libro buscarLibroPorISBN(Long isbn)throws Exception{
        try{
            if (isbn == null){
                throw new Exception("Debe ingresar un isbn valido para la busqueda");
            }
            return this.DAO.buscarLibroPorISBN(isbn);
        } catch (Exception e){
            throw e;
        }
    }
    
    public Libro buscarLibroPorTitulo(String tit)throws Exception{
        try{
            if (tit == null){
                throw new Exception("Debe ingresar un titulo valido para el libro a buscar");
            }
            return this.DAO.buscarLibroPorTitulo(tit);
        } catch(Exception e){
            throw e;
        }
    }
    
    public Collection<Libro> buscarLibrosPorAutor(Autor a) throws Exception{
        try{
            if (a == null){
                throw new Exception("Debe ingresar un autor valido para la busqueda");
            }
            Collection<Libro> listado = this.DAO.buscarLibrosPorAutor(a);
            if (listado.isEmpty()){
                throw new Exception("No se encontraron libros para el autor ingresado");
            }
            return listado;
        }catch (Exception e){
            throw e;
        }
    }
    
    public Collection<Libro> buscarLibrosPorEditorial(Editorial e) throws Exception{
        try{
            if (e == null){
                throw new Exception("Debe ingresar una Editorial valida para la busqueda");
            }
            Collection<Libro> listado = this.DAO.buscarLibrosPorEditorial(e);
            if (listado.isEmpty()){
                throw new Exception("No se encontraron libros para la Editorial ingresada");
            }
            return listado;
        }catch (Exception ex){
            throw ex;
        }
    }
    
    
    public void registrarPrestamoLibro(Libro l) throws Exception{
        try{
            if (l == null){
                throw new Exception ("Debe ingresar un libro valido");
            }
            if (!l.getAlta()){
                throw new Exception("No hay ejemplares disponibles para prestar de dicho libro");
            }
            l.setEjemplaresPrestados(l.getEjemplaresPrestados()+1);
            this.DAO.registrarPrestamoLibro(l);
        }catch(Exception e){
            throw e;
        }
    }
    
    public void registrarDevolucionLibro(Libro l) throws Exception{
        try{
            if (l == null){
                throw new Exception ("Debe ingresar un libro valido");
            }
            
            l.setEjemplaresPrestados(l.getEjemplaresPrestados()-1);
            this.DAO.registrarPrestamoLibro(l);
        }catch(Exception e){
            throw e;
        }
    }
    
    
}
