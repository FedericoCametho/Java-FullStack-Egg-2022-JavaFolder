/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioAprendizaje;

import EntidadAprendizaje.Cadena;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class CadenaService {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public int mostrarVocales(String frase){
        int cant = 0;
        for (char l: frase.toCharArray()){
            String letra = (l+"").toUpperCase();
            if (letra.equals("A") || letra.equals("E") || letra.equals("I") || letra.equals("O") || letra.equals("U")){
                cant++;
            }
        }
        return cant;
    }
    
    public void invertirFrase(String frase){
        String aux = "";
        for (char letra: frase.toCharArray()){
            aux = letra+aux;
        }
        System.out.println(aux);
    }
    
    public int vecesRepetido(String caracter, String frase){
        int cont = 0;
        for (char l: frase.toCharArray()){
            String letra = l+"";
            if (letra.equals(caracter)){
                cont++;
            }
        }
        return cont;
    }
    
    public boolean compararLongitud(String frase, String nuevaFrase){
        return frase.length()==nuevaFrase.length();
    }
    
    public void unirFrase(Cadena cadena, String frase2){
        System.out.println(cadena.getFrase().concat(frase2));
    }
    
    public void reemplazar(Cadena cadena, String letra){
        if(cadena.getFrase().contains("a")){
            System.out.println(cadena.getFrase().replace("a", letra));
        }
    }
    
    public boolean contiene(Cadena cadena, String letra){
        return cadena.getFrase().contains(letra);
    }
    
}
