/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Perro;
import Entidad.Persona;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class ServicioAdopcion {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private HashSet<Persona> personas;
    private HashSet<Perro> perros;
    
    public ServicioAdopcion(){
        this.personas = new HashSet();
        this.perros = new HashSet();
        this.agregarPersonas();
        this.agregarPerros();
    }
    
    private void agregarPersonas(){
        this.personas.add(new Persona("Federico", "Cametho", 33, 111));
        this.personas.add(new Persona("Juan", "Perez", 22, 222));
        this.personas.add(new Persona("Matias", "Gomez", 18, 333));
        this.personas.add(new Persona("Lucas", "Litch", 80, 444));
        this.personas.add(new Persona("Pedro", "Picapiedra", 65, 555));   
    }
    
    private void agregarPerros(){
        this.perros.add(new Perro("Coco", "Doberman", "GRANDE", 7));
        this.perros.add(new Perro("Largui", "Salchicha", "CHICO", 10));
        this.perros.add(new Perro("Maui", "Callejero", "CHICO", 1));
        this.perros.add(new Perro("Freya", "Pitbull", "MEDIANO", 5));
        this.perros.add(new Perro("Lee", "Golden", "GRANDE", 15));
    }
    
    public void generarAdopciones(){
        this.personas.forEach(p -> this.adoptar(p, this.perros));
    }
    
    private void adoptar(Persona p, HashSet perros){
        System.out.println("Senior " + p.getNombre() + " Ingrese el nombre del perro que desea adoptar");
        this.mostrarPerros();
        String opcion = leer.next();
        Perro dog = this.buscarPerro(opcion);
        if (dog.getNombre().equals("xxxx")){
            System.out.println("El perro elegido no esta disponible, ya fue adoptado");
            this.adoptar(p, perros);
        } else {
            p.setPerro(dog);
            this.perros.remove(dog);
        }
    }
    
    private Perro buscarPerro(String opcion){
        return this.perros.stream().filter(p -> p.getNombre().equals(opcion)).findFirst().orElse(new Perro ("xxxx","xxxx","xxxx",9999));
    }
    
    private void mostrarPerros(){
        this.perros.forEach(perro -> System.out.print(perro.getNombre() +" - "));System.out.println("");
    }
    
    public void mostrarPersonasYPerros(){
        this.personas.forEach(per -> System.out.println(per.toString()));
    }
    
}
