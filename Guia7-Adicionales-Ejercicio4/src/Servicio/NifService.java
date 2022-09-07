/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Nif;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class NifService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Nif crearNif(){
        System.out.println("Ingrese un numero de DNI");
        Nif n = new Nif(leer.nextLong());
        return n;
    }

    
}
