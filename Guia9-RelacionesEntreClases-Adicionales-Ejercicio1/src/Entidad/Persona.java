/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author FedeC
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private int edad;
    private int documento;
    private Perro perro;
    
    public Persona(String nom, String ape, int edad, int dni, Perro perro){
        this.nombre = nom;
        this.apellido = ape;
        this.edad = edad;
        this.documento = dni;
        this.perro = perro;
    }
    
    public Persona(String nom, String ape, int edad, int dni){
        this.nombre = nom;
        this.apellido = ape;
        this.edad = edad;
        this.documento = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }
    
    @Override
    public String toString(){
        return this.nombre + " " + this.apellido + " " + this.edad + " tiene un perro llamado " +
                this.perro.getNombre() + " de raza " +this.perro.getRaza()+ " y "+this.perro.getEdad()+" anios de edad";
    }
    
}
