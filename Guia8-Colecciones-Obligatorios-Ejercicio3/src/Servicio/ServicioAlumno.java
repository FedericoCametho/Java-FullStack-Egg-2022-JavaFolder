/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class ServicioAlumno {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private List<Alumno> listaAlumnos;
    
    public ServicioAlumno(){
        this.listaAlumnos = new ArrayList<Alumno>();
    }
    
    public void agregarNota(Alumno a, Integer nota){
        a.getNotas().add(nota);
    }
    
    public boolean quitarNota(Alumno a, Integer nota){
        if (a.getNotas().contains(nota)) {
            a.getNotas().remove(nota);
            return true;
        } else {
            return false;
        }
    }
    
    public double cargarAlumnos(){
        do {
          this.listaAlumnos.add(this.crearAlumno());
        } while (this.menuOpcion());
        
        System.out.println("Ingrese el nombre del alumno para calcular la nota final");
        String nom = leer.next();
        for (Alumno alu : this.listaAlumnos){
            if (alu.getNombre().equals(nom)){
                System.out.println("La nota final del alumno "+alu.getNombre()+" es: ");
                return this.notaFinal(alu);
            }
        }
        System.out.println("El alumno ingresado no se encontro");
        return -1;
        //return listaAlumnos;
    }
    
    public void cargarAlumnos2(){
        do {
          this.listaAlumnos.add(this.crearAlumno());
        } while (this.menuOpcion());
    }
    
    
    private double notaFinal(Alumno a){
        return a.getNotas().stream().mapToDouble(n -> n).sum() / a.getNotas().size();
    }
    
    public double notaFinal(){
        System.out.println("Ingrese el nombre del alumno para calcular la nota final");
        String nom = leer.next();
        for (Alumno alu : this.listaAlumnos){
            if (alu.getNombre().equals(nom)){
                System.out.println("La nota final del alumno "+alu.getNombre()+" es: ");
                return alu.getNotas().stream().mapToDouble(n -> n).sum() / alu.getNotas().size();
            }
        }
        System.out.println("El alumno no se encontro");
        return -1;
    }
    
    
    private Alumno crearAlumno(){
        System.out.println("Ingrese el nombre del alumno");
        Alumno a = new Alumno(this.leer.next());
        for (int i=0; i<3; i++){
            System.out.println("Ingrese la calificacion numero "+ (i+1));
            a.getNotas().add((Integer)this.leer.nextInt());
        }
        return a;
    }
    
    private boolean menuOpcion(){
        int opcion;
        do {
            System.out.println("1. Ingresar otro alumno");
            System.out.println("2. Salir");
            opcion = this.leer.nextInt();
        } while ((opcion < 1) || (opcion > 2));
        return opcion==1;  
    }
    
}
