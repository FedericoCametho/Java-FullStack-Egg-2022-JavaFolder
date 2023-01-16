
package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class LibroService {
    private EntityManager em;
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    
    public LibroService(){
        this.em = Persistence.createEntityManagerFactory("Guia12-JPA-LibreriaPU").createEntityManager();
    }
    
    public Libro crearLibro() throws Exception{
        try{
            Libro lib = new Libro();
            System.out.println("Ingrese el titulo del libro");
            lib.setTitulo(leer.next());
            System.out.println("Ingrese la cantidad de ejemplares del libro");
            lib.setEjemplares(leer.nextInt());
            System.out.println("Ingrese la cantidad de ejemplares prestados del libro");
            lib.setEjemplaresPrestados(leer.nextInt());
            lib.setEjemplaresRestantes();
            System.out.println("Ingrese el nombre del autor");
            lib.setAutor(this.chequearAutor(leer.next()));
            System.out.println("Ingrese el nombre de la Editorial");
            lib.setEditorial(this.chequearEditorial(leer.next()));

            em.getTransaction().begin();
            em.persist(lib);
            em.getTransaction().commit();

            return lib;
        } catch (Exception e){
            throw e;
        }
        
    }
    
    
    public void eliminarLibro() throws Exception{
        System.out.println("Ingresee el ISBN del Libro ");
        Long isbn = leer.nextLong();
        
        try{
            if (isbn ==  null){
                throw new Exception("Debe ingresar un ISBN valido para eliminar el Libro");
            }
            Libro l = this.buscarLibroPorISBN(isbn);
            if (l == null){
                throw new Exception("El ISBN ingresado no corresponde a un Libro registrado en la base de datos.");
            } else {
                em.getTransaction().begin();
                em.remove(l);
                em.getTransaction().commit();
            }         
        } catch (Exception e){
            throw e;
        }
        
    }
    
    public void editarLibro() throws Exception{
        System.out.println("Ingresee el ISBN del Libro ");
        Long isbn = leer.nextLong();
        
        try{
            if (isbn ==  null){
                throw new Exception("Debe ingresar un ISBN valido para modificar el Libro");
            }
            Libro l = this.buscarLibroPorISBN(isbn);
            if (l == null){
                throw new Exception("El ISBN ingresado no corresponde a un Libro registrado en la base de datos.");
            } else {
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
                                Autor a = this.chequearAutor(nombreAutor);
                                l.setAutor(a);
                                break;
                        case 5: System.out.println("Ingrese el nombre de la nueva Editorial del libro");
                                String nombreEditorial = leer.next();
                                Editorial e = this.chequearEditorial(nombreEditorial);
                                l.setEditorial(e);
                                break;                    
                    }
                    em.getTransaction().begin();
                    em.merge(l);
                    em.getTransaction().commit();
                }
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
            List<Libro> listado = em.createQuery("SELECT l FROM Libro l").getResultList();
            
            if (!listado.isEmpty()){
                System.out.println("********  IMPRIMIENDO LISTADO DE LIBROS  ********");
                listado.forEach( l -> System.out.println(l.toString()));
            } else {
                throw new Exception("No existen libros registrados en la Base de Datos");
            }
            
        } catch (Exception e){
            throw e;
        }
    }
    
    public Libro buscarLibroPorISBN(Long isbn){
        try {
            return em.find(Libro.class, isbn);
        } catch (Exception e){
            throw e;
        }
    }
    
    public Libro buscarLibroPorTitulo(String titulo){
        try {
            List<Libro> listado = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :tit").setParameter("tit", titulo).getResultList();
            return (listado.isEmpty()) ? null : listado.get(0);
        } catch (Exception e){
            throw e;
        }
    }
    
    
    private Autor chequearAutor(String nombre) throws Exception{
        try{
            AutorService service = new AutorService();
            Autor a = service.buscarAutorPorNombre(nombre);
            return (a==null) ? service.crearAutor(nombre) : a;
        } catch (Exception e){
            throw e;
        }
    }
    
    private Editorial chequearEditorial(String nombre) throws Exception{
        try{
            EditorialService service = new EditorialService();
            Editorial e = service.buscarEditorialPorNombre(nombre);
            return (e==null) ? service.crearEditorial(nombre) : e;
        } catch (Exception e){
            throw e;
        }
    }
    
    
}
