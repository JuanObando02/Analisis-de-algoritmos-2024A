package BubbleSort;

import java.util.Random;

public class BubbleSort {
    private int[] array;
    public static void main(String[] args) {
        // DubbleSort
    	int longitudArreglo = 5000; // Longitud del arreglo aleatorio
        int[] array = generarArregloAleatorio(longitudArreglo);
        BubbleSort bubbleSort = new BubbleSort(array);

        // Test1
        System.out.println(bubbleSort);
        System.out.println("______________________________");

        long startTime = System.nanoTime();
        bubbleSort.sort();
        long endTime = System.nanoTime();
        long tiempoEjecucion = endTime -startTime;

        System.out.println(bubbleSort);
        System.out.println("\n Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos.");
        System.out.println("\n Tiempo de ejecución: " + convertirNanosegundosASegundos(tiempoEjecucion)+ " segundos");
    }

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    static int[] generarArregloAleatorio(int longitud) {
    	
        int[] arr = new int[longitud];
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            arr[i] = random.nextInt(1000); // Rango de numeros aleatorios de 0 a 999
        }
        return arr;
    }
    static double convertirNanosegundosASegundos(long nanosegundos) {
		return nanosegundos / 1_000_000_000.0;
	}
}

