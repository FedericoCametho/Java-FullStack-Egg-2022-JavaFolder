/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia6;

import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
 *
 * @author FedeC
 */
public class EjerciciosAdicionales {
    
    public static void main(String[] args){

        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");


/*
        // Ejercicio Adicional 1
        System.out.println("Ingrese una cantidad de minutos determinadad");
        int min = leer.nextInt();
        int[] diasHoras = conversionDiasHoras(min);
        System.out.println("El equivalente son: "+ diasHoras[0]+" dias y "+ diasHoras[1]+" horas");
     
        
        // Ejercicio Adicional 2
        int A = 1;
        int B = 2;
        int C = 3;
        int D = 4;
        System.out.println("A:"+A+" B:"+B+" C:"+C+" D:"+D);
        int aux = A;
        A = D;
        D = B;
        B = C;
        C = aux;
        System.out.println("A:"+A+" B:"+B+" C:"+C+" D:"+D);
      

        // Ejercicio Adicional 3
        String[] vocales = {"A","E","U","I","O"};
        System.out.println("Ingrese una letra");
        String letra = leer.next();
        if (Arrays.asList(vocales).contains(letra.toUpperCase())){
            System.out.println("LA Letra ingresada "+ letra+ " es una vocal");
        } else {
            System.out.println("LA letra "+ letra + " NOOOO es una vocal");
        }

 
        // Ejercicio Adicional 4
        int num;
        String[] romanos = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        do {
            System.out.println("Ingrese un numero");
            num = leer.nextInt();
        } while (num < 1 || num > 10);
        System.out.println("El equivalente de "+ num + "En romanos es: "+ romanos[num-1]);


        // Ejercicio Adicional 5
        String opcion;
        do {
            System.out.println("Ingrese su categoria de socio A - B - C");
            opcion = leer.next().toUpperCase();            
        } while (!opcion.equals("A") && !opcion.equals("B") && !opcion.equals("C"));
        
      
        System.out.println("Ingrese el MONTO del TRATAMIENTO");
        double monto = leer.nextDouble();
        switch (opcion.toUpperCase()){
            case "A":
                System.out.println("El importe en efectivo a pagar para socio A es: "+ monto*0.5);
                break;
            case "B":
                System.out.println("El importe en efectivo a pagar para socio B es: "+ monto*0.65);
                break;
            case "C":
                System.out.println("El importe en efectivo a pagar para socio C es: "+ monto);
                break;
        }
        


        // Ejercicio Adicional 6
        int contador = 0;
        double alturasTotal = 0;
        double alturas160 = 0;
        double alturaActual;
        double limite = 1.6;
        int cantTotal = 10;
        System.out.println("Cargando altura de "+cantTotal+" personas");
        for (int i=0; i<cantTotal; i++){
            System.out.println("Ingrese la altura de la persona "+(i+1));
            alturaActual = leer.nextDouble();
            if (alturaActual<limite){
                alturas160+= alturaActual;
                contador++;
            }
            alturasTotal+= alturaActual;
        }
        System.out.println("El PROMEDIO GENERAL de las ESTATURAS es: "+ Math.round(alturasTotal/cantTotal*100.0)/100.0);
        System.out.println("El Promedio de las alturas menores a 1.60 es de: "+ Math.round(alturas160/contador*100.0)/100.0);




        // Ejercicio Adicional 7  bucle while
        System.out.println("Ingrese la cantidad de numeros a introducir");
        int n = leer.nextInt();
        int max = -1;
        int min = 999999999;
        int tot = 0;
        int num;
      
        
        int cont = 0;
        while (cont < n){
            System.out.println("Ingrese un total de "+ n+" numeros presionando enter luego de cada uno:");
            num = leer.nextInt();
            cont++;
            
            tot+= num;
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        System.out.println("El maximo numero ingresado es: "+max);
        System.out.println("El Minimo numero ingresado es: "+min);
        System.out.println("El Promedio de los "+n+" numeros ingresados es: "+ Math.round(tot/n*100.0)/100.0);
        

        
         // Ejercicio Adicional 7  bucle do - while
        System.out.println("Ingrese la cantidad de numeros a introducir");
        int n = leer.nextInt();
        int max = -1;
        int min = 999999999;
        int tot = 0;
        int cont = 0;
        int num;
        System.out.println("Ingrese un total de "+ n+" numeros presionando enter luego de cada uno:");
        do {
          num = leer.nextInt();
          cont++;
          tot+= num;
           
          min = Math.min(num,min);
          max = Math.max(num,max);
           
        } while (cont < n);

        System.out.println("El maximo numero ingresado es: "+max);
        System.out.println("El Minimo numero ingresado es: "+min);
        System.out.println("El Promedio de los "+n+" numeros ingresados es: "+ Math.round(tot/n*100.0)/100.0);

        
        // Ejercicio Adicional 8
        int num;
        int cont = 0;
        int pares = 0;
        int impares = 0 ;
        do{
            System.out.println("Ingrese un numero");
            num = leer.nextInt();
            if (num >= 0){
                if (num%2 == 0){
                    pares++;
                } else {
                    impares++;
                }
                cont++;
            }
        } while (num%5 != 0);
        System.out.println("Cantidad Total: "+ cont);
        System.out.println("Cantidad Pares: "+ pares);
        System.out.println("Cantidad Impares: "+ impares);

        

        // Ejercicio Adicional 9
        
        System.out.println("Ingrese el dividendo");
        int num1 = leer.nextInt();
        System.out.println("Ingrese el divisor");
        int num2 = leer.nextInt();
        int aux = num1;
        int cociente = 0;
        while (aux > num2){
            aux = aux- num2;
            cociente++;
        }
        System.out.println("El cociente de la division "+ num1+"/"+num2+" es: "+cociente);
   


        // Ejercicio Adicional 10
        int num1 = (int) (Math.random()*10);
        int num2 = (int) (Math.random()*10);
        int resultado = num1*num2;
        System.out.println("Trate de adivinar el resultado de la multiplicacion de los dos numeros Aleaotorios");
        int resp = leer.nextInt();
        if (resp != resultado){
            System.out.println("Respuesta incorrecta, tiene otro intento");
            resp = leer.nextInt();
        }
        if (resp == resultado) {
            System.out.println("Felicitaciones, acertaste!!! La multiplicacion de "+ num1 + " y " + num2 + " es igual a "+ resultado);
        } else {
            System.out.println("Lamentamos que hayas agotado tus intentos!  La multiplicacion de "+ num1 + " y " + num2 + " es igual a "+ resultado);
        }



        // Ejercicio Adicional 11
        System.out.println("Ingrese un numero entero");
        int num = leer.nextInt();
        int digitos;
        if (num == 0){
            digitos = 1;
        } else {
            digitos = 0;
            int aux = num;
            while (aux > 0){
                digitos++;
                aux = aux / 10;
            }
        }
        System.out.println("El numero "+num+" tiene "+digitos+ " digitos");



        // Ejercicio Adicional 12
        
        String contador = "";
        for (int i=0;i<10;i++){
            for (int j=0;j<10; j++){
                for (int k=0;k<10;k++){
                    
                    if (i==3){
                        contador += "E"+"-";
                    }else{
                        contador += i+"-";
                    }
                    if (j==3){
                        contador += "E"+"-";
                    } else {
                        contador += j+"-";
                    }
                    if (k==3){
                        contador += "E";  
                    } else {
                        contador += k+"";
                    }
                    
                    System.out.println(contador);
                    contador = "";
                }
            }
        }

        // Ejercicio Adicional 13
        System.out.println("Ingrese la cantidad de numeros de la escalera");
        int num = leer.nextInt();
        System.out.println("Imprimiendo escalera3"
                + "");
        for (int i=1; i<= num; i++){
            for (int j=1; j<= i; j++){
                System.out.print(j);
            }
            System.out.println("");
        }


        // Ejercicio Adicional 14
        
        System.out.println("Ingrese la cantidad de familias");
        int fam = leer.nextInt();
        int edades = 0;
        int totHijos = 0;
        for (int i=0; i< fam; i++){
            System.out.println("Ingrese la cantidad de hijos que tiene esta familia");
            int hijos = leer.nextInt();
            totHijos += hijos;
            for (int j=0 ; j<hijos; j++){
                System.out.println("Ingrese la edad del "+(j+1)+" hijo");
                edades += leer.nextInt();
            }
        }
        System.out.println("La media de edad de los hijos de todas las familias es: "+ Math.round(edades/totHijos));
        

        
        // Ejercicio Adicional 15
        
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
        
  

        // Ejercicio Adicional 16
        
        int cantidad = 3;
        String nombre;
        int edad;
        boolean continuar = true;
        int contador = 0;
        
        while (continuar && cantidad > contador){
            contador++;
            System.out.println("Ingrese el nombre de la persona "+ (contador));
            nombre = leer.next();
            
            System.out.println("Ingrese la edad de la Persona "+ (contador));
            edad = leer.nextInt();
            
            System.out.println(nombre+" Tiene "+ edad + " años de edad. " + nombre + esMayor(edad));

    
            if (contador < cantidad){
                continuar = chequeoContinuar(leer);
            } 
        }
        
 

        // Ejercicio Adicional 17
        
        
        System.out.println("Ingrese un numero");
        if(esPrimo(leer.nextInt())){
            System.out.println("El numero Ingresado ES Primo");
        } else {
            System.out.println("El numero ingresado NOO es primo");
        }
        
 

        
        // Ejercicio Adicional 18
        
        int dimF = 5;
        int [] array = new int[dimF];
        cargarArray(array, leer);
        System.out.println("La suma de los elementos del array es: "+ calcularSuma(array));
       


        // Ejercicio Adicional 19
        
        int dimF = 5;
        int [] array1 = new int[dimF];
        int [] array2 = new int[dimF];
        System.out.println("Cargando Array numero 1");
        cargarArray(array1, leer);
        System.out.println("Cargando Array numero 2");
        cargarArray(array2, leer);
        System.out.println("Array 1: "+ mostrarVector(array1));
        System.out.println("Array 2: "+ mostrarVector(array2));
        if (compararVectores(array1, array2)){
            System.out.println("Ambos Arrays son iguales");
        } else {
            System.out.println("Los Arrays ingresados son distintos");
        }
           
 

       
       // Ejercicio Adicional 20

       int dimF = 10;
       int [] array = new int[dimF];
       cargarVectorAleatorio(array);
        System.out.println("Array: "+mostrarVector(array));



       // Ejercicio Adicional 21
       int dimF = 5;
       double[] vector = new double [dimF];
       cargarVectorAlumnos(vector);
       System.out.println("Vector de notas de alumnos: "+ mostrarVectorAlumnos(vector));
       mostrarAprobados(vector);
       

        
        // Ejercicios Adicional 22
        int n = 5;
        int m = 8;
        int matriz[][] = new int[n][m];
        cargarMatrizAleatoria(matriz);
        mostrarMatriz(matriz);
   


        // Ejercicio Adicional 23
        
        String palabra;
        int cantPalabras = 5;
        int limiteInferior = 3;
        int limiteSuperior = 5;
        int dimF = 20;
        String [][] matriz = new String[dimF][dimF];
        int [] filasOcupadas = new int[matriz.length];
        inicializarFilas(filasOcupadas);

        for (int i=0; i <  cantPalabras; i++){
            System.out.println("Ingrese una palabra de entre "+ limiteInferior+" y "+limiteSuperior+" caracteres");
            palabra = leer.next();
            if (palabra.length()<3 || palabra.length()>5){
                i--;
            } else {
               agregarPalabra(matriz, palabra, filasOcupadas);
            }
        }
        rellenarMatriz(matriz);
        mostrarMatrizCaracteres(matriz);

      

        // Ejercicio Adicional 24
        
        System.out.println("Ingrese el termino de la sucesion fibonacci que desea calcular");
        int n = leer.nextInt();
        System.out.println("El termino "+n+" de la sucesion de fibonacci es: "+fibonacci(n));
  */
        

        
        

    }
    
    // METODOS ESTATICOS
    
    public static int fibonacci(int n){
        int res = 0;
        if(n!=0){
            if(n==1) {
                res = 1;
            } else {
                res+= fibonacci(n-1) + fibonacci(n-2); 
            }
        }
        
        return res;
    }
    
    
    public static void mostrarMatrizCaracteres(String [][] matriz){
        for (String[] fila: matriz){
            for (String elem: fila){
                System.out.print(elem+" ");
            }
            System.out.println("");
        }
    }
    
    public static void rellenarMatriz(String[][] matriz){
        for (int i=0; i<matriz.length;i++){
            for (int j=0; j <matriz[0].length; j++){
                if (matriz[i][j] == null){
                    matriz[i][j] = ""+(int)Math.round(Math.random()*9);
                }
            }
        }
    }
    
    public static void inicializarFilas(int[] filas){
        for(int i=0; i< filas.length; i++){
            filas[i] = -1;
        }
    }
    public static void agregarPalabra(String[][] matriz, String palabra, int[] filasOcupadas){
        int fila = (int)Math.round(Math.random()*(matriz.length-1));
        while (filasOcupadas[fila] != -1){
           fila = (int)Math.round(Math.random()*(matriz.length-1)); 
        }
        filasOcupadas[fila] = 1;
        
        int columna = (int)Math.round(Math.random()*(matriz[0].length-palabra.length()));

        for (int i = columna; i < columna + palabra.length(); i++){
            matriz[fila][i] = ""+palabra.charAt(i-columna);
        }

    }
    
    public static void mostrarMatriz(int[][] matriz){
        for (int[] fila: matriz){
            for (int elem: fila){
                System.out.print(elem+" ");
            }
            System.out.println("");
        }
    }
    
    public static void cargarMatrizAleatoria(int[][] matriz){
       for (int i=0; i < matriz.length;i++){
           for (int j=0; j< matriz[0].length; j++){
            matriz[i][j] = (int)Math.round(Math.random()*9);
        }
       }
    }
    
    public static void mostrarAprobados(double[] vector){
        for (double elem: vector){
            if (elem >= 7){
                System.out.println(elem);
            }
        }
    }
    
    public static String mostrarVectorAlumnos(double[] vector ){
        String aux = "";
        for (double elem: vector){
            aux+= (elem/100.0*100.0)+" | ";
        }
        return aux;
    }
    
    public static double notaPromedioAlumno(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        double nota = 0;
        System.out.println("Primer Trabajo Practico: ");
        nota += leer.nextDouble()*0.1;
        System.out.println("Segundo Trabajo Practico: ");
        nota += leer.nextDouble()*0.15;
        System.out.println("Primero Integrador: ");
        nota += leer.nextDouble()*0.25;
        System.out.println("Segundo Integrador: ");
        nota += leer.nextDouble()*0.50;
        
        return nota;
    }
    
    public static void cargarVectorAlumnos(double[] vector){
        for (int i=0; i<vector.length; i++){
            System.out.println("Cargando las notas del alumno "+(i+1));
            vector[i] = notaPromedioAlumno();
        }
    }
    
    public static boolean compararVectores(int[] array1, int[] array2){
        boolean ok = true;
        for (int i=0; i < array1.length && ok; i++){
            ok = array1[i]==array2[i];
        }
        return ok;
    }
    
    public static String mostrarVector(int[] vector ){
        String aux = "";
        for (int elem: vector){
            aux+= elem+" ";
        }
        return aux;
    }
    
    public static void cargarVectorAleatorio(int[] array){
        for (int i=0; i<array.length;i++){
            array[i] = (int)Math.round(Math.random()*100);
        }
    }
    
    public static void cargarArray(int[] array, Scanner leer){
        for (int i=0; i<array.length;i++){
            System.out.println("Ingrese un numero para la posicion "+ (i+1));
            array[i] = leer.nextInt();
        }
    }
    
    public static int calcularSuma(int[] array){
        int suma = 0;
        for (int elem: array){
            suma+= elem;
        }
        return suma;
    }
    
    public static boolean esPrimo(int num){
        boolean aux = true;
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                aux = false;
                break;
            }
        }
        return aux;
    }
    
    
    public static boolean chequeoContinuar(Scanner leer){
        System.out.println("Desea continuar imprimiendo datos de personas? - Si o No");
        return !leer.next().equalsIgnoreCase("No");
    }
    
    public static String esMayor(int edad){
        if (edad > 17){
            return " ES MAYOR DE EDAD";
        } else {
            return " Nooooo Es mayor de edad";
        }
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
    
   
    public static int[] conversionDiasHoras(int min){
        int[] resultado = new int[2];
        resultado[0] = min/60/24;     
        resultado[1] = (int)Math.floor(((double)min/60/24 - resultado[0])*24);
        return resultado;
    }
    
    
    
    public static String formateo (double d){
        String pattern = "#.##";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        String formateado = decimalFormat.format(d);
        return formateado;
    }

    
    
}
