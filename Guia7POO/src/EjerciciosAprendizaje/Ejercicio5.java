/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosAprendizaje;

import EntidadAprendizaje.CuentaBancaria;

/**
 *
 * @author FedeC
 */
public class Ejercicio5 {
    
    
    public static void main (String args[]){
        CuentaBancaria cBanc = new CuentaBancaria(7775777,10001123, 25000, 0.15 );

        System.out.println(cBanc.consultarDatos());
        
        
        cBanc.ingresar(15000);
        System.out.println(cBanc.consultarSaldo());
        
        cBanc.extraccionRapida();
        System.out.println(cBanc.consultarSaldo());
        
        cBanc.retirar(15000);
        System.out.println(cBanc.consultarDatos());
        
        
    }
    
    
}
