package ordenamientos;

public class Heapsort {
    
    public static void main(String[] args) {
    	
    	int longitudArreglo=5000;
        int[] array = generateReversedArray(longitudArreglo);
        System.out.println("Array original:");
        printArray(array);
        
        long startTime = System.nanoTime();
        heapSort(array);
        long endTime = System.nanoTime();
        
        System.out.println("Array ordenado:");
        printArray(array);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }
    
    public static void heapSort(int[] array) {
        int n = array.length;
        
        // Construir un heap (montículo) máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        
        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            // Mover el elemento raíz (máximo) al final del array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            // Llamar a heapify en el heap reducido
            heapify(array, i, 0);
        }
    }
    
    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Inicializar el más grande como la raíz
        int left = 2 * i + 1; // Índice del hijo izquierdo
        int right = 2 * i + 2; // Índice del hijo derecho
        
        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        
        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        
        // Si el mayor no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            
            // Recursivamente heapify el subárbol afectado
            heapify(array, n, largest);
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
