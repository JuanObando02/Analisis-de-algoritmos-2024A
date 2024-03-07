package ordenamientos;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
        
		int longitudArreglo=50;
		int[] arr = generateReversedArray(longitudArreglo);
		
        System.out.println("Array Original: " + Arrays.toString(arr));
        // Llamamos a Shell Sort
        long startTime = System.nanoTime(); // Iniciar temporizador
        SelectionSort.sort(arr);
        long endTime = System.nanoTime(); 
        long tiempoEjecucion = endTime -startTime;
        
        System.out.println("Array ordenado: " + Arrays.toString(arr));
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos.");
    }
	
	public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int n = arr.length;
        
        // Iterar sobre el array
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el índice del mínimo elemento en el subarray no ordenado
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Intercambiar el mínimo elemento encontrado con el primer elemento no ordenado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
	
	public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i; // Array invertido para representar el peor caso
        }
        return array;
    }
}
