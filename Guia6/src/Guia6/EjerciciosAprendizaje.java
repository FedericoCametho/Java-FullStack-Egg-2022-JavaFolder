/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia6;

import java.util.Scanner;

/**
 *
 * @author FedeC
 */
public class EjerciciosAprendizaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        /* 
        // Ejercicio Aprendizaje 2
        System.out.println("Ingresa tu nombre");
        String nombre = leer.nextLine();
        System.out.println(saludo(nombre));
       
        // Ejercicio Aprendizaje 3
        System.out.println("Ingresa una Frase");
        String frase = leer.nextLine();
        System.out.println("Lower Case: " + frase.toLowerCase());
        System.out.println("Upper Case: " + frase.toUpperCase());
        
        // Ejercicio Aprendizaje 1
        System.out.println("Ingresa un Numero");
        int a = leer.nextInt();
        System.out.println("Ingresa otro Numero");
        int b = leer.nextInt();
        System.out.println("La suma del numero "+ a+ " y "+ b+ " es: "+ sumar(a,b));
        
        // Ejercicio Aprendizaje 4
        System.out.println("Ingresa una cantidad de grados: ");
        double grados = (double)leer.nextInt();
        System.out.println("EL valor ingresado equivale a "+ toFarenheit(grados)+ " F");
        
        
        // Ejercicio Aprendizaje 5
        System.out.println("Ingresa un Numero");
        int num = leer.nextInt();
        System.out.println("EL doble del numero ingresado: " + multiplicar(num,2));
        System.out.println("EL Triple del numero ingresado: " + multiplicar(num,3));
        System.out.println("EL La Raiz Cuadrada del numero ingresado: "+ Math.sqrt((double)num));
        
       
        // Ejercicio Aprendizaje 6
        System.out.println("Ingresa un Numero");
        num = leer.nextInt();
        if (esPar(num)){
            System.out.println("El numero ingresado es par");
        } else{
            System.out.println("El numero es IMPAR");
        }
   
        // Ejercicio Aprendizaje 7
        System.out.println("Ingresa una frase");
        frase = leer.nextLine();
        if (frase.equals("eureka")){
            System.out.println("Frase CORRECTA");
        } else{
            System.out.println("ERROR!!!  " );
        }

         // Ejercicio Aprendizaje 8
        String palabra;
        do {
            System.out.println("Ingresa una frase  -- para terminar ingrese 'fin' --");
            palabra = leer.nextLine();
            if (palabra.length() == 8){
                System.out.println("CORRECTA");
            } else{
                System.out.println("INCORRECTA" );
            }
        } while (!palabra.equalsIgnoreCase("fin"));
       

  
        // Ejercicio Aprendizaje 9
        System.out.println("Ingresa una frase");
        String palabra = leer.nextLine();
        if (palabra.startsWith("A")){
            System.out.println("CORRECTA");
        } else{
            System.out.println("INCORRECTA" );
        }
         
        // Ejercicio Aprendizaje 9 bis con charAt(i)
        System.out.println("Ingresa una frase");
        String palabra = leer.nextLine();
        if (palabra.charAt(0) == 'A'){
            System.out.println("CORRECTA");
        } else{
            System.out.println("INCORRECTA" );
        }
    

        // Ejercicio Aprendizaje 10
        System.out.println("Ingrese un numero LIMITE");
        int limite = leer.nextInt();
        int suma = 0;
        while (suma <= limite) {
            System.out.println("Ingrese un numero");
            suma += leer.nextInt();
        }
  

        // Ejercicio Aprendizaje 11
        System.out.println("Ingrese un numero");
        int a = leer.nextInt();
        System.out.println("Ingrese otro numero");
        int b = leer.nextInt();
        menu();
        int opcion = leer.nextInt();
        boolean ok = true;
        while (opcion > 0 && opcion < 6 && ok){
            if(opcion == 5){ 
                    System.out.println("Esta seguro que desea salir (S/N)");
                    String confirmacion = leer.next();
                    if (confirmacion.toUpperCase().equals("S")){
                         ok = false;
                    } 
           } else {
            
                switch (opcion){
                    case 1: System.out.println("Suma: "+sumar(a,b));

                            break;
                    case 2: System.out.println("Resta: "+restar(a,b));

                            break;
                    case 3: System.out.println("Multiplicacion: "+multiplicar(a,b));

                            break;
                    case 4: System.out.println("Division: "+dividir(a,b));

                            break;
                
                }   
            }
            if (ok){
                menu();
                opcion = leer.nextInt();
            }
           
        } 
        
      
        // Ejercicio Aprendizaje 12
        System.out.println("Ingrese una cadena de caracteres");
        String cadena = leer.next();
        String FDE = "&&&&&";
        int correctas = 0;
        int incorrectas = 0;
        while (!cadena.equals(FDE)){
            if (cadena.length()<=5 && cadena.charAt(0)=='X' && cadena.charAt(cadena.length()-1)=='O'){
                correctas++;
            } else {
                incorrectas++;
            }
            System.out.println("Ingrese una cadena de caracteres");
            cadena = leer.next();
        }
        System.out.println("La cantidad de lecturas correctas es de "+correctas+ " y las incorrectas: "+ incorrectas);
        

        // Ejercicio Aprendizaje 13
        System.out.println("Ingrese la cantidad de elementos por lado que quiere dibujar");
        int lado = leer.nextInt();
        for (int i=0; i<lado; i++){
           for (int j=0;j<lado; j++){
               if (i==0 || i==lado-1){
                   System.out.print("*");
               } else {
                   if (j==0 || j==lado-1){
                       System.out.print("*");
                   } else {
                       System.out.print(" ");
                   }
               }
           }
           System.out.println("");
        }
        
        
        
        // Ejercicio Aprendizaje 14
        System.out.println("Ingrese la cantidad de Euros que desea convertir");
        int euros = leer.nextInt();
        System.out.println("Ingrese la divisa que desea obtener: LIBRA, DOLAR O YEN");
        String divisa = leer.next();
        conversionEuros(euros, divisa);

       
        //  Ejercicio Aprendizaje 15
        int dimF = 100;
        int[] vector = new int[dimF];
        cargarVector(vector);
        mostrarVector(vector);
        System.out.println("");
        mostrarVectorInverso(vector);
   


        // Ejercicio Aprendizaje 16
        System.out.println("Ingrese el tamanio del vector");
        int dimF  = leer.nextInt();
        int[] vector  = new int[dimF];
        cargarVectorAleatorioEnteros(vector);
        mostrarVector(vector);
        System.out.println("Ingrese el elemento que desea buscar");
        int num = leer.nextInt();
        buscarElemento(vector, num);


        // Ejercicio Aprendizaje 17
        System.out.println("Ingrese el tamanio del vector");
        int dimF  = leer.nextInt();
        int[] vector  = new int[dimF];
        cargarVectorAleatorioEnteros(vector);
        mostrarVector(vector);
        contabilizarDigitos(vector);

        
        //Ejercicio Aprendizaje 18 y 19
        int dimF = 4;
        int [][] matriz = new int[dimF][dimF];
        
        cargarMatrizCuadradaAleatoria(matriz);
        mostrarMatrizCuadrada(matriz);
        
        int[][] traspuesta = obtenerTraspuesta(matriz);
        System.out.println("Mostrando traspuesta");
        System.out.println("-----------------------");
        mostrarMatrizCuadrada(traspuesta);
        if (chequearAntiSimetrica(matriz, traspuesta)){
            System.out.println("La matriz es Antisimetrica");
        } else {
            System.out.println("La matriz NOOOOOOOO es Antisimetrica");
        }


        // Ejercicio Aprendizaje 20
        
        matrizMagica();
        

        
        // Ejercicio Aprendizaje 21
        int [][] matrizM = new int[][]{{1,26,36,47,5,6,72,81,95,10},{11,12,13,21,41,22,67,20,10,61},
            {56,78,87,90,9,90,17,12,87,67},{41,87,24,56,97,74,87,42,64,35},{32,76,79,1,36,5,67,96,12,11},
            {99,13,54,88,89,90,75,12,41,76},{67,78,87,45,14,22,26,42,56,78},{98,45,34,23,32,56,74,16,19,18},
            {24,67,97,46,87,13,67,89,93,24},{21,68,78,98,90,67,12,41,65,12}};
        System.out.println("Matriz M ----------");
        mostrarMatrizCuadrada(matrizM);
        
        int[][] matrizP = new int[][]{{36,5,67},{89,90,75},{14,22,26}};
        System.out.println("Matriz P ----------");
        mostrarMatrizCuadrada(matrizP);
        buscarMatrizContenida(matrizM, matrizP);

*/

    }
    
    /// METODOS ESTATICOS
    
    public static void buscarMatrizContenida(int[][] matrizM, int[][] matrizP){ 
        int i = 0;
        boolean encontre = false;
        
        while (!encontre && i<matrizM[0].length){
            int j = 0;
            while(!encontre && j<matrizM[0].length){
                if (matrizM[i][j]==matrizP[0][0]){
                    encontre = chequearMatrices(matrizM, matrizP, i, j );
                    if (encontre){
                        System.out.println("Las cordenadas de inicio de la MatrizP contenida en MAtriz M son "+ i+","+j);
                    }
                }
                j++;
            }
            i++;
        }
    }
    
    public static boolean chequearMatrices(int[][] matrizM, int[][] matrizP, int i,int j){
        boolean ok = true;
        int k = 0;
        while (ok &&  i < matrizP[0].length){
            int l = 0;
            while(ok && j< matrizP[0].length){
                ok = matrizM[i][j]==matrizP[k][l];
                j++;
                l++;
            }
            j = j-matrizP[0].length;
            i++;
            k++;
        }  
        return ok;
    }
    
    public static void matrizMagica(){
        Scanner leer = new Scanner(System.in);
        int dimF = 3;
        int [][] matriz = new int[][]{{2,7,6},{9,5,1},{4,3,8}};
        //cargarMatrizCuadrada(matriz, leer);
        mostrarMatrizCuadrada(matriz);
        int numMagico = obtenerNumMagico(matriz);
        if (diagonalPrincipal(matriz,numMagico) && diagonalOpuesta(matriz,numMagico) && chequearFilas(matriz,numMagico) && chequearColumnas(matriz,numMagico)){
            System.out.println("LA MATRIZ INGRESADA ES UN CUADRADO MAGICO");
        } else{
            System.out.println("NOOO ES MAGICA");
        }
    }
    
    public static int obtenerNumMagico(int[][] matriz){
        int magico = 0;
        for (int num: matriz[0]){
            magico+= num;
        }
        return magico;
    }
    
    public static boolean diagonalPrincipal(int[][] matriz, int numMagico){
        int suma=0;
        for (int i=0; i<matriz[0].length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if (i==j){
                    suma+= matriz[i][j];
                }
            }
        }
        return suma == numMagico;
    }
    
    public static boolean diagonalOpuesta(int[][] matriz, int numMagico){
        int suma=0;
        for (int i=0; i<matriz[0].length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if (i+j == matriz[0].length-1){
                    suma+= matriz[i][j];
                }
            }
        }
        return suma == numMagico;
    }
    
    public static boolean chequearFilas(int[][] matriz, int numMagico){
        boolean ok = true;
        int i=0;
        while (ok && i < matriz[0].length){
            int sumaFila = 0;
            int j=0;
            while (ok && j < matriz[0].length){
                sumaFila+= matriz[i][j];
                j++;
            }
            ok = sumaFila==numMagico;
            i++;
        }
        return ok;
    }
    
    public static boolean chequearColumnas(int[][] matriz, int numMagico){
        boolean ok = true;
        int i=0;
        while (ok && i<matriz[0].length){
            int sumaColumna = 0;
            int j=0;
            while (ok && j<matriz[0].length){
                sumaColumna+= matriz[j][i];
                j++;
            }
            ok = sumaColumna==numMagico;
            i++;
        }
        return ok;
    }
    
    public static void cargarMatrizCuadrada(int[][]matriz, Scanner leer){
        System.out.println("Cargando Matriz Cuadrada de "+ matriz.length +" x "+ matriz.length);
        System.out.println("Ingrese un numero seguido de otro dando la tecla enter ( los numeros deben ser del 1 al 9)");
        int num;
        for (int i =0; i<matriz[0].length;i++){
            for(int j=0; j<matriz[0].length;j++){
                num = leer.nextInt();
                while (num < 0 || num > 10){
                    System.out.println("Numero INCORRECTO: por favor ingrese un numero entre 1 y 9:");
                    num = leer.nextInt();
                }
                matriz[i][j] = num;
            }
        }
    }
    
    public static boolean chequearAntiSimetrica(int[][] matriz, int[][] traspuesta){
        boolean ok = true;
        int i=0;
        
        while (ok && (i < matriz.length)){
            int j=0;
            while (ok && (j < matriz[i].length)){
                if (matriz[i][j] != traspuesta[i][j]){
                    ok = false;
                } else {
                    j++;
                }
            }
            i++;
        }
        return ok;
    }
    
    public static int[][] obtenerTraspuesta(int[][]matriz){
        int[][] traspuesta = new int[matriz.length][matriz.length];
        
        for(int fila=0;fila<matriz[0].length;fila++){
            for(int columna=0; columna<matriz[0].length;columna++){
                traspuesta[columna][fila] = matriz[fila][columna];
            }
        }
        
        return traspuesta;
    }
    
    public static void mostrarMatrizCuadrada(int[][] matriz){
        for(int i=0; i<matriz[0].length; i++){
            for(int j=0; j<matriz[0].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
    public static void cargarMatrizCuadradaAleatoria(int[][] matriz){
        for(int i=0; i<matriz[0].length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matriz[i][j] = (int)Math.round(Math.random()*10);
            }
        }
    }
    
    public static void contabilizarDigitos(int[] vector){
        System.out.println("10");
        int maxDigitos = 5;
        int[] contadores = new int[5];
        for (int elem: vector){
            contadores[String.valueOf(elem).length()-1]++;
        }
        for (int i=0; i<maxDigitos; i++){
            System.out.println("Numeros con "+(i+1)+" digitos: "+ contadores[i]);
        }
    }
    
    
     public static void cargarVectorAleatorioEnteros(int[] vector){
        for (int i=0; i<vector.length; i++){
            vector[i] = (int)Math.round(Math.random()*10000);
        }
    }
    
    
    public static void buscarElemento(int[] vector, int num){
        boolean repetido = false;
        int pos = -1;
        for (int i=0 ; i< vector.length; i++){
            if(vector[i]==num){
                if(pos > -1){
                    repetido = true;
                } else {
                     pos = i;
                } 
            }
        }
        if (pos != -1) {
            System.out.println("El elemento se encuentra en la posicion "+pos);
            if (repetido){
                System.out.println("El elemento esta repetido en el arreglo");
            }
        } else{
            System.out.println("El elemento no se encuentra en el arreglo");
        }
        

    }
    
    public static void cargarVectorAleatorio(double[] vector){
        for (int i=0; i<vector.length; i++){
            vector[i] = Math.round(Math.random()*10);
        }
    }
    
    public static void cargarVector(int[] vector){
        for (int i=0; i<vector.length; i++){
            vector[i] = i+1;
        }
    }
    
    public static void mostrarVector(int[] vector){
        for (int elem: vector){
            System.out.print(elem+ " | ");
        }
    }
    
    public static void mostrarVectorInverso(int[] vector){
        for (int i=vector.length-1; i>0 ;i--){
            System.out.print(vector[i]+ " | ");
        }
    }
    
    public static void conversionEuros(int euros, String divisa){
        switch (divisa.toUpperCase().trim()){
            case "LIBRA":
                System.out.println("Libras: "+ Math.round(euros*0.86*100.0)/100.0);
                break;
            case "DOLAR":
                System.out.println("Dolares: "+ Math.round(euros*1.28611*100.0)/100.0);
                break;
            case "YEN":
                System.out.println("Yenes: "+ Math.round(euros*129.85250*100.0)/100.0);
                break;
            default:
                System.out.println("No poseemos la moneda solicitada para la conversion");
        }
        
    }
    
    public static boolean esPar(int num){
        return num%2==0;
    }
    
    public static int sumar(int a, int b){
        return a+b;
    }
    
    public static int restar(int a, int b){
        return a-b;
    }
    
    public static int multiplicar(int a, int b){
        return a*b;
    }
    
    public static int dividir(int a, int b){
        return a/b;
    }
    
    public static String saludo(String nombre){
        String aux = "Hola "+ nombre;
        return aux;
    }
    
    public static double toFarenheit(double grados){
        return 32+(9*grados/5);
    }
    
    
    public static void menu(){
        System.out.println("MENU");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");
        System.out.println("Elija una opcion");
    }
}
