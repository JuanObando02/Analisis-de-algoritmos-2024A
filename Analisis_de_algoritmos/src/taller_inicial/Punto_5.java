package taller_inicial;

import java.util.Scanner;

public class Punto_5 {//juego de la vida
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la matriz:");
        int M = scanner.nextInt();
        scanner.close();

        // Crear la matriz inicial
        boolean[][] matriz = new boolean[M][M];

        // Inicializar la matriz con valores aleatorios (vivos o muertos)
        inicializarMatriz(matriz);

        // Mostrar la matriz inicial
        System.out.println("Matriz inicial:");
        mostrarMatriz(matriz);

        // Ejecutar el juego de la vida durante 10 generaciones
        for (int generacion = 1; generacion <= 10; generacion++) {
            System.out.println("\nGeneración " + generacion + ":");
            matriz = aplicarReglas(matriz);
            mostrarMatriz(matriz);
        }
    }

    // Inicializar la matriz con valores aleatorios (vivos o muertos)
    public static void inicializarMatriz(boolean[][] matriz) {
    	
        int M = matriz.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matriz[i][j] = Math.random() < 0.5; // Probabilidad de 0.5 para estar vivo o muerto
            }
        }
        
    }

    // Mostrar la matriz en la consola
    public static void mostrarMatriz(boolean[][] matriz) {
        int M = matriz.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] ? "■ " : "□ ");
            }
            System.out.println();
        }
    }

    // Aplicar las reglas del juego de la vida a la matriz y devolver la nueva matriz
    public static boolean[][] aplicarReglas(boolean[][] matriz) {
    	
        int M = matriz.length;
        boolean[][] nuevaMatriz = new boolean[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
            	
                int vecinasVivas = contarVecinasVivas(matriz, i, j);
                if (matriz[i][j]) { // Si la célula está viva
                	
            //•	Si una célula está viva y tiene dos o tres vecinas vivas, sobrevive.
            //•	Si una célula está viva y tiene más de tres vecinas vivas, muere.
                	
                    nuevaMatriz[i][j] = (vecinasVivas == 2 || vecinasVivas == 3);
                    
                } else { // Si la célula está muerta
            //•	Si una célula está muerta y tiene tres vecinas vivas, nace.
                    nuevaMatriz[i][j] = (vecinasVivas == 3);
                }
                
            }
        }

        return nuevaMatriz;
    }

    // Contar el número de vecinas vivas de una célula en la posición (i, j)
    public static int contarVecinasVivas(boolean[][] matriz, int i, int j) {
    	
        int M = matriz.length;
        int contador = 0;
        //iteramos en las filas desde una antes 
        for (int x = Math.max(0, i - 1); x <= Math.min(M - 1, i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(M - 1, j + 1); y++) {
            	
            	// si x es distinto de i o y es distinto de j 
            	
                if (x != i || y != j) { // Excluir la propia célula
                    if (matriz[x][y]) {//si la celula esta viva sumar al contador
                        contador++;
                    }
                }
            }
        }

        return contador;
    }
}
