package ordenamientos;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int longitudArreglo=5000;
        int[] arr = generateReversedArray(longitudArreglo);
		
        System.out.println("Arreglo original:");
        printArray(arr, longitudArreglo);
        
        long startTime = System.nanoTime(); 
        radixSort(arr, longitudArreglo); 
        long endTime = System.nanoTime(); 
        long tiempoEjecucion = endTime -startTime;
        
        System.out.println("Arreglo ordenado:");
        printArray(arr, longitudArreglo);
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos.");
        
    }
	
	static void radixSort(int arr[], int n) { 
        int m = obtener_maximo(arr, n);
        int exp=1;
        
        while( m/exp >= 1 ) {
        	counting_Sort(arr,exp);
        	exp*=10;
        } 
    }
	
	static void counting_Sort(int arr[], int exp) {
    	
        int n = arr.length;
        int output[] = new int[n]; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
	
	static int obtener_maximo(int arr[], int n) {
    	
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max) {
            	max = arr[i];
            }
        return max;
        
    }
	
	static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i; // Array invertido para representar el peor caso
        }
        return array;
    }
}
