/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadAprendizaje;

import java.util.Date;

/**
 *
 * @author FedeC
 */
public class Persona {
    
    private String nombre;
    private long edad;
    private String sexo;
    private double peso;
    private double altura;
    private Date fechaNacimiento;
    
    
    public Persona(){
        
    }
    
    public Persona(String nom, String sexo, double peso, double altura, Date fechaNac){
        this.nombre = nom;
        this.fechaNacimiento = fechaNac;
        this.edad = (new Date().getTime() - this.fechaNacimiento.getTime())/1000/3600/24/365;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    public String mostrarPersona(){
        return "Nombre: "+ this.nombre + " - Edad: "+ this.edad+ " - Fecha de Nacimiento"+this.fechaNacimiento.toString()+ " - Altura: "+ this.altura + " - Peso: "+ this.peso;
    }
    
    
    
}
