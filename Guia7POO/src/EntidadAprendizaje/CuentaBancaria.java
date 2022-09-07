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
public class CuentaBancaria {
    
    private int numeroCuenta;
    private long DNICliente;
    private int saldoActual;
    private double interes;

    public CuentaBancaria(int numeroCuenta, long DNICliente, int saldoActual, double interes) {
        this.numeroCuenta = numeroCuenta;
        this.DNICliente = DNICliente;
        this.saldoActual = saldoActual;
        this.interes = interes;
    }
    
    public CuentaBancaria(){
        
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getDNICliente() {
        return DNICliente;
    }

    public void setDNICliente(long DNICliente) {
        this.DNICliente = DNICliente;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
    
    public void ingresar(double ingreso){
        this.saldoActual = this.getSaldoActual() + (int)ingreso;
    }
    
    public void retirar(double retiro){
        if (this.getSaldoActual() - retiro < 0){
            this.saldoActual = 0;
        } else {
            this.saldoActual = this.getSaldoActual()-(int)retiro;
        }
    }
    
    public void extraccionRapida(){
        if (this.getSaldoActual() > 0){
            this.saldoActual = this.getSaldoActual() - (int)(this.getSaldoActual()*0.2);
        }
    }
    
    public double consultarSaldo(){
        return this.getSaldoActual();
    }
    
    public String consultarDatos(){
        String aux;
        aux = "Numero de cuenta : "+ this.getNumeroCuenta() + " | DNI: "+this.getDNICliente() + " | Saldo Actual: "+ this.getSaldoActual() + " | Intereses: "+ this.getInteres();
        return aux;
    
    }   
    
    
}
