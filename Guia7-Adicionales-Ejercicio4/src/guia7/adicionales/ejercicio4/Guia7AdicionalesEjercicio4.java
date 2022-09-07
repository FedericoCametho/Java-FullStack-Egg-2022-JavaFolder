/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia7.adicionales.ejercicio4;

import Entidad.Nif;
import Servicio.NifService;

/**
 *
 * @author FedeC
 */
public class Guia7AdicionalesEjercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        NifService nServ = new NifService();
        Nif n = nServ.crearNif();
        
        n.mostrar();
        
        
        
    }
    
}
