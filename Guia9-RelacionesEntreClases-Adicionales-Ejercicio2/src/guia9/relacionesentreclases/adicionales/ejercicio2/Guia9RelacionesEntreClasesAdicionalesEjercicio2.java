/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia9.relacionesentreclases.adicionales.ejercicio2;


import Servicio.ServicioCine;

/**
 *
 * @author FedeC
 */
public class Guia9RelacionesEntreClasesAdicionalesEjercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServicioCine ser = new ServicioCine();
        ser.mostrarSala();
        ser.acomodarEspectadores();
        System.out.println("***********************************************************");
        ser.mostrarSala();
        
    }
    
}
