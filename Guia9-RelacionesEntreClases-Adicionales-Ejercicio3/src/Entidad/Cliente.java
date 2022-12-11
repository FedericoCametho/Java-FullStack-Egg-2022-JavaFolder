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
public class Cliente {
    
    private String nomYape;
    private int dni;
    private String email;
    private String domicilio;
    private int telefono;

    public Cliente(String nomYape, int dni, String email, String domicilio, int telefono) {
        this.nomYape = nomYape;
        this.dni = dni;
        this.email = email;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getNomYape() {
        return nomYape;
    }

    public void setNomYape(String nomYape) {
        this.nomYape = nomYape;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
