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
public class Nif {
    
    private long dni;
    private String letra;
    private final String[] tabla = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
    

    public Nif(long dni) {
        this.dni = dni;
        this.letra = calcularLetra(dni);
    }
    
    public Nif (){
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
    
    private String calcularLetra(long dni){
        return this.tabla[(int)dni%23];
    }
    
    public void mostrar(){
        System.out.println(this.getDni()+" - "+this.getLetra().toUpperCase());
    }
    
}
