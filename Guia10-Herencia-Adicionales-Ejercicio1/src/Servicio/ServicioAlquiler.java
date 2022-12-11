/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Alquiler;
import Entidad.Barco;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author FedeC
 */
public class ServicioAlquiler {
    
    public ArrayList<Alquiler> alquileres;
    
    public ServicioAlquiler(){
        this.alquileres = new ArrayList<Alquiler>();
    }
    
    public Alquiler crearAlquiler(Barco b){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre");
        String nom = leer.next();
        System.out.println("Ingrese el dni");
        int dni = leer.nextInt();
        int pos;
        do{
            System.out.println("Ingrese la posicion de amarre");
            pos = leer.nextInt();
        } while (this.alquileres.stream().map(a -> a.getPosicion()).collect(Collectors.toList()).contains(pos));
        
        System.out.println("Ingrese la fecha de devolucion [ dia -> mes -> anio");
        int dia = leer.nextInt();
        int mes = leer.nextInt();
        int anio = leer.nextInt();
        LocalDate devolucion = LocalDate.of(anio,mes,dia);
        
        Alquiler a = new Alquiler(nom, dni, LocalDate.now(), devolucion, pos, b);
        this.alquileres.add(a);
        return a;
    }
    
    
    public double calcularAlquiler(Alquiler a){
        return (ChronoUnit.DAYS.between(a.getFechaAlquiler(), a.getFechaDevolucion())) * a.getBarco().getModulo();
    }
    
    
    public void mostrarAlquileres(){
        this.alquileres.forEach(a -> System.out.println(a.getBarco().getMatricula() + " - Paga de alquiler: " + this.calcularAlquiler(a)));
    }
    
}
