/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadAprendizaje;

/**
 *
 * @author FedeC
 */
public class Matematica {
    
    private double num1;
    private double num2;

    public Matematica(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public Matematica(){
        
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
    
    public double devolverMayor(){
        return Math.max(num1, num2);
    }
    
    public double calcularPotencia(){
        return Math.pow(Math.round(Math.max(num1, num2)), Math.round(Math.min(num1, num2)));
    }
    
    public double calcularRaiz(){
        return Math.sqrt(Math.abs(Math.min(num1, num2)));
    }
    
    
}
