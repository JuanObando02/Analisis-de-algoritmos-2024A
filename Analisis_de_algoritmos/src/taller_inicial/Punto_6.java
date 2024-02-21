package taller_inicial;

import java.util.ArrayList;
import java.util.Scanner;

public class Punto_6 {
	
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	int filaInicial = 0,columnaInicial = 0;
    	do {
	    	System.out.println("Digite la fila inicial:");
	        filaInicial = scanner.nextInt();
	        System.out.println("Digite la columna inicial:");
	        columnaInicial = scanner.nextInt();
	        
    	} while(filaInicial<0 || columnaInicial<0);
    	
        System.out.println("Los movimientos válidos del caballo "
        		+ "desde la posición (" + filaInicial + ", " + columnaInicial + ") son:");
        
        ArrayList<int[]> movimientos = calcularMovimientosCaballo(filaInicial, columnaInicial);
        
        for (int[] movimiento : movimientos) {//imprimo la lista de movimientos
            System.out.println("(" + movimiento[0] + ", " + movimiento[1] + ")");
        }
        scanner.close();
    }

    public static ArrayList<int[]> calcularMovimientosCaballo(int fila, int columna) {
        
    	ArrayList<int[]> movimientos = new ArrayList<>();
        
        //
        int[][] movimiento = {	
           /*fila 1 */  {-2, -1} , {-2, 1}, // Movimientos hacia arriba
           /*fila 2 */  {2, -1}  , {2, 1},   // Movimientos hacia abajo
           /* fila 3 */ {-1, -2} , {1, -2}, // Movimientos hacia la izquierda
           /* fila 4 */ {-1, 2}  , {1, 2}    // Movimientos hacia la derecha
        };

        for (int[] delta : movimiento) {
        	
            int nuevaFila = fila + delta[0];
            int nuevaColumna = columna + delta[1];
            
            if (esMovimientoValido(nuevaFila, nuevaColumna)) {
            	
            	//el movimiento es valido si se encuentran dentro del rando de 8x8
                movimientos.add(new int[]{nuevaFila, nuevaColumna});
                
                //lo agrego a la lista de movimientos validos
                //la lista de movimientos validos guarda un vector de cordenada. 
            }
        }

        return movimientos;// retorno la lista con los movimientos validos
       
    }

    public static boolean esMovimientoValido(int fila, int columna) {
    	//si la 0 <= fila < 8  y 0 <= columna < 8 return true si no false
        return fila >= 0 && fila < 8 && columna >= 0 && columna < 8;
    }
}
