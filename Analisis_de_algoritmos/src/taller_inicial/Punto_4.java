package taller_inicial;

import java.util.Scanner;

public class Punto_4 {
    public static boolean esMatrizUnitaria(int[][] U) {
    	
        int filas = U.length;
        int columnas = U[0].length; //verificando la longitud de el vector fila (cantidad de columnas)

        if (filas != columnas) {//primer caso
            return false; // No es cuadrada, no puede ser unitaria
        }

        for (int i = 0; i < filas; i++) {//verificacion de la matriz
            for (int j = 0; j < columnas; j++) {
            	
                if (i == j) {//(0,0) (1,1) (2,2) ....
                    
                	if (U[i][j] != 1) {//numeros distintos de 1 en la diagonal.
                        return false; 
                    }
                	
                } else {//(0,1) (0,2) (0,3) .....
                    if (U[i][j] != 0) {
                        return false; // Fuera de la diagonal principal hay un número distinto de 0
                    }
                }
            }
        }
        return true; // Cumple con las condiciones de matriz unitaria
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz: ");
        int columnas = scanner.nextInt();

        int[][] U = new int[filas][columnas];

        // Cargar la matriz U en memoria
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el elemento U[" + i + "][" + j + "]: ");
                U[i][j] = scanner.nextInt();
            }
        }
        

        if (esMatrizUnitaria(U)) {
            System.out.println("La matriz es unitaria");
        } else {
            System.out.println("La matriz NO es unitaria");
        }
        
        for(int i=0;i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				System.out.printf(" %d ",U[i][j]);
			}
			System.out.println();
		}
    }
}
