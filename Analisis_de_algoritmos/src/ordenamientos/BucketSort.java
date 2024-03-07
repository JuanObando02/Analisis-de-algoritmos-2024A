package ordenamientos;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	
	public static void main(String[] args) {
		
		int longitudArreglo=5000;
        int[] array = generateReversedArray(longitudArreglo);
        
        System.out.println("Array original:");
        printArray(array);
        
        long startTime = System.nanoTime();
        bucketSort(array);
        long endTime = System.nanoTime();
        
        System.out.println("Array ordenado:");
        printArray(array);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }
    
	public static void bucketSort(int[] array) {
        int n = array.length;
        
        // Encontrar el valor máximo y mínimo del array
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : array) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        
        // Calcular el rango del bucket
        int range = maxVal - minVal + 1;
        
        // Crear cubetas
        ArrayList<Integer>[] buckets = new ArrayList[range];
        for (int i = 0; i < range; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Agregar elementos a las cubetas
        for (int i = 0; i < n; i++) {
            int bucketIndex = array[i] - minVal;
            buckets[bucketIndex].add(array[i]);
        }
        
        // Ordenar cada cubeta y fusionarlas
        int index = 0;
        for (int i = 0; i < range; i++) {
            Collections.sort(buckets[i]);
            for (int num : buckets[i]) {
                array[index++] = num;
            }
        }
    }
    
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
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
