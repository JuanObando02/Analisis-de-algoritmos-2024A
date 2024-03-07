package ordenamientos;

public class Quicksort {
	
	public static void main(String[] args) {
		
		int longitudArreglo=5000;
        int[] array = generateReversedArray(longitudArreglo);
        System.out.println("Array original:");
        printArray(array);
        
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        
        System.out.println("Array ordenado:");
        printArray(array);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }
    
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
    
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
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
