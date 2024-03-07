package ordenamientos;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
        
		int longitudArreglo=5000;
		int[] arr = generateReversedArray(longitudArreglo);
		
        System.out.println("Array Original: " + Arrays.toString(arr));
        // Llamamos a Shell Sort
        long startTime = System.nanoTime(); // Iniciar temporizador
        shellSort(arr);
        long endTime = System.nanoTime(); 
        long tiempoEjecucion = endTime -startTime;
        
        System.out.println("Array ordenado: " + Arrays.toString(arr));
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos.");
    }
	
	public static void shellSort(int[] arr) {
		
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
                
            }
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
