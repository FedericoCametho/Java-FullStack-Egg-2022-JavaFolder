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
public class Operacion {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private int num1, num2;

    public Operacion(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Operacion(){
        
    }
    
    
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    public void crearOperacion(){
        System.out.println("Ingrese el primer numero para la operacion");
        this.setNum1(leer.nextInt());
        System.out.println("Ingrese el segundo numero para la operacion");
        this.setNum2(leer.nextInt());
    }
    
    public int sumar(){
        return this.getNum1() + this.getNum2();
    }
    
    public int restar(){
        return this.getNum1() - this.getNum2();
    }
    
    public int multiplicar(){
        if ((this.getNum1() == 0) || (this.getNum2() == 0)){
            System.out.println("Multiplicacion por cero");
            return 0;
        } else {
            return this.getNum1() * this.getNum2();
        }
    }
    
    public double dividir(){
        if (this.getNum2() == 0){
            System.out.println("Error: Division por cero");
            return 0;
        } else {
            return (double)this.getNum1() / (double)this.getNum2();
        }
    }
    
}
