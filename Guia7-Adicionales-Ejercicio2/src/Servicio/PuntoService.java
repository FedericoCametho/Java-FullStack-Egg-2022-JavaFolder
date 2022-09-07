/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Punto;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class PuntoService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Punto crearPunto(){
        System.out.println("Ingrese las cordenadas x e y del primer punto presionando enter luego de cada coordenada");
        double x1 = leer.nextInt();
        double y1 = leer.nextInt();
        
        System.out.println("Ingrese las cordenadas x e y del primer punto presionando enter luego de cada coordenada");
        double x2 = leer.nextInt();
        double y2 = leer.nextInt();

        return new Punto(x1, y1, x2, y2);
    }
    
    public double distanciaEntrePuntos(Punto p){
        double[] punto1 = p.getPunto1();
        double[] punto2 = p.getPunto2();
        return Math.sqrt(Math.pow((punto1[0]-punto2[0]),2) + Math.pow((punto1[1]-punto2[1]),2));
    }
    
}
