package taller_inicial;

import java.util.Scanner;

public class Punto_3 {//buscar primos en un vector
	
	 public static boolean esPrimo(int num) {
	        if (num <= 1) {
	            return false;
	        }
	        
	        for (int i = 2; i < num; i++) {
	            if (num % i == 0) {
	                return false;
	            }//el numero no es primo
	        }
	        return true;
	  }
	 
	 public static void buscarPrimos(int n, int[] V) {
	        boolean primoEncontrado = false;

	        Scanner scanner = new Scanner(System.in);
	        
	 
	        for (int i = 0; i < n; i++) {
	        	
	        	//bucle de ingreso y verificación
	        	
	            System.out.print("Ingrese el elemento V[" + i + "]: ");
	            V[i] = scanner.nextInt();
	            
	            if (esPrimo(V[i])) {
	                primoEncontrado = true;
	                System.out.println("El número primo " + V[i] + " se encuentra en la posición " + i);
	            }
	        }

	        if (!primoEncontrado) {
	            System.out.println("No se encontraron números primos en el vector.");
	        }
	        scanner.close();
	        
	    }
	 
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        int n;
	        
	        do {//Validamos el tamaño del vector
	        	
	        	System.out.println("Ingrese el tamaño del vector (mayor a 0):");
	        	n = scanner.nextInt();
	        	
	        }while(n<=0);
	        
        	int[] V = new int[n];


	        buscarPrimos(n, V);
	  
	 	System.out.println("Fin del programa.");
	 	scanner.close();
	 	
	 }
	 
	 
	
}
