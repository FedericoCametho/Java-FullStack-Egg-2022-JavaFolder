/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadAprendizaje;

import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class Circunferencia {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private double radio;

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public void crearCircunferencia(){
        System.out.println("Ingrese el radio de la circunferencia");
        this.setRadio(leer.nextDouble());
    }
    
    public double area(){
        return Math.pow(this.getRadio(), 2)* Math.PI;
    }
    
    public double perimetro(){
        return 2*Math.PI*this.getRadio();
    }
    
    public String getInfo(){
        String aux = "Radio = "+this.getRadio() + " | Area = "+this.area() + " | Perimetro = "+ this.perimetro();
        return aux;
    }
    
}
