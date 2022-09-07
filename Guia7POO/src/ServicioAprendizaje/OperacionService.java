/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.Operacion;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class OperacionService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Operacion crearOperacion(Operacion op){
        
        System.out.println("Ingrese el primer numero para la operacion");
        op.setNum1(leer.nextInt());
        System.out.println("Ingrese el segundo numero para la operacion");
        op.setNum2(leer.nextInt());
        
        return op;
    }
    
}
