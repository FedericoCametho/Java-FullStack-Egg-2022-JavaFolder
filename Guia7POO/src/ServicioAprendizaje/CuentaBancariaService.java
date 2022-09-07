/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.CuentaBancaria;
import java.util.Scanner;



/**
 *
 * @author FedeC
 */
public class CuentaBancariaService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public CuentaBancaria crearCuentaBancaria(){
        System.out.println("Ingrese el numero de la cuenta bancaria");
        int numCuenta = leer.nextInt();
        System.out.println("Ingrese el numero de DNI");
        long dni = leer.nextLong();
        System.out.println("Ingrese el saldo actual de la cuenta");
        int saldo = leer.nextInt();
        System.out.println("Ingrese el interes de la cuenta");
        double interes = leer.nextDouble();
        
        return new CuentaBancaria(numCuenta, dni, saldo, interes);
    }
    
}
