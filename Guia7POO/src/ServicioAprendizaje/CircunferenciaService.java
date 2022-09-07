/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.Circunferencia;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class CircunferenciaService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Circunferencia crearCircunferencia(){
        System.out.println("Ingrese el radio");
        return new Circunferencia(leer.nextDouble());
    }
    
    
    
}
