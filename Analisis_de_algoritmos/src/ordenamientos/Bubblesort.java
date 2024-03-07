package ordenamientos;

public class Bubblesort {
    
    public static void main(String[] args) {
    	int longitudArreglo=5000;
        int[] array = generateReversedArray(longitudArreglo);
        System.out.println("Arreglo original:");
        printArray(array);
        System.out.println("______________________________");

        long startTime = System.nanoTime();
        ordenamientoBurbuja(array);
        long endTime = System.nanoTime();
        
        System.out.println("Arreglo ordenado:");
        printArray(array);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }

    static void ordenamientoBurbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio de elementos si están en el orden incorrecto
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    static void printArray(int arr[]) {
    	int size = arr.length;
        for (int i = 0; i < size; i++)
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
