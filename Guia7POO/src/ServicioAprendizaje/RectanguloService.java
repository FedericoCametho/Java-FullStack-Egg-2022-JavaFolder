/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.Rectangulo;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class RectanguloService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Rectangulo crearRectangulo(){
        Rectangulo r = new Rectangulo();
        System.out.println("Ingrese la base del rectangulo");
        r.setBase(leer.nextDouble());
        System.out.println("Ingrese la altura del rectangulo");
        r.setAltura(leer.nextDouble());
        
        return r;
    }
    
    public void dibujarRectangulo(Rectangulo r){
        for (int i=0; i< r.getAltura(); i++){
            for (int j=0; j < r.getBase(); j++){
                if (i == 0 || i == r.getAltura()-1){
                    System.out.print("*");
                } else {
                    if (j==0 || j== r.getAltura()-1){
                        System.out.print("*");
                    } else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
            
        }
    }
    
}
