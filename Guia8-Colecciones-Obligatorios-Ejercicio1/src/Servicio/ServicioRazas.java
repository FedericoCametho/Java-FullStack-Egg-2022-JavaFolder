/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author FedeC
 */
public class ServicioRazas {
    
    
   public void agregarEnLista(List<String> lista, String elem){
       lista.add(elem);
   }
   
   public boolean eliminarEnLista(List<String> lista, String elem){
       if (lista.contains(elem)){
           lista.remove(elem);
           return true;
       } else {
           return false;
       }
   }
   
   public ArrayList<String> ordenarLista(List<String> lista){
       ArrayList<String> l = new ArrayList<String>(lista);
       l.sort(Comparator.naturalOrder());
       return l;
   }
    
}
