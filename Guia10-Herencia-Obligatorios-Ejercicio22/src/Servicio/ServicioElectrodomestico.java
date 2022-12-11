/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Electrodomestico;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class ServicioElectrodomestico {
    
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private double precioBase;
    private HashMap<Character, Double> valoresConsumo;
    private HashMap<double[], Double> valoresPeso;
    
    public ServicioElectrodomestico(){
        this.precioBase = 1000;
        this.cargarTablaConsumo(this.valoresConsumo);
        this.cargarTablaPeso(this.valoresPeso);
    }
    
    private void cargarTablaConsumo(HashMap<Character, Double> tabla){
        tabla.put(new Character('A'), new Double(1000));
        tabla.put(new Character('B'), new Double(800));
        tabla.put(new Character('C'), new Double(600));
        tabla.put(new Character('D'), new Double(500));
        tabla.put(new Character('E'), new Double(300));
        tabla.put(new Character('F'), new Double(100));
    }
    
    private void cargarTablaPeso(HashMap<double[], Double> tabla){
        double[] limites = {1,19};
        double[] limites2 = {20,49};
        double [] limites3 = {50,79};
        double [] limites4 = {80, 9999999};
        tabla.put(limites, new Double(100));
        tabla.put(limites2, new Double(500));
        tabla.put(limites3, new Double(800));
        tabla.put(limites4, new Double(1000));
    }
    
    public void crearElectrodomestico(Electrodomestico e){
        System.out.println("Ingrese el color");
        String color = this.leer.next();
        System.out.println("Ingrese el consumo energetico");
        char consumo = this.leer.next().charAt(0);
        System.out.println("Ingrese le peso del electrodomestico");
        double peso = this.leer.nextDouble();
        e = new Electrodomestico(this.precioBase, color, consumo, peso);   
    }
    
    
    public double precioFinal(Electrodomestico e){
        return e.getPrecio() + this.valoresConsumo.get(e.getConsumo()) + this.adicionalPeso(e);
    }
    
    
    private double adicionalPeso(Electrodomestico e){
        for (double[] key : this.valoresPeso.keySet()){
            if (e.getPeso() >= key[0] && e.getPeso() <= key[1]){
                return this.valoresPeso.get(key);
            }
        }
        return 0;
    }
}
