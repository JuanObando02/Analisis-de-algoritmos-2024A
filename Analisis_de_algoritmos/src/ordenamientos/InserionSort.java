package ordenamientos;

import java.util.Arrays;

public class InserionSort {

	public static void main(String[] args) {
		
		int longitudArreglo=50;
        int[] array = generateReversedArray(longitudArreglo);

        System.out.println("Array sin ordenar: " + Arrays.toString(array));

        long startTime = System.nanoTime();
        insertionSort(array);
        long endTime = System.nanoTime();

        System.out.println("Array ordenado: " + Arrays.toString(array));
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }
	
	public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
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
