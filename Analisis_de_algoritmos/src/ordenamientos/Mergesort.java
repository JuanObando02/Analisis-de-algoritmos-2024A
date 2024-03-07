package ordenamientos;

public class Mergesort {
	
	public static void main(String[] args) {
		int longitudArreglo=50;
        int[] arr = generateReversedArray(longitudArreglo);
        
        Mergesort mergeSort = new Mergesort();
        System.out.println("Array original:");
        printArray(arr);
        
        long startTime = System.nanoTime();
        mergeSort.sort(arr);
        long endTime = System.nanoTime();
        
        System.out.println("Array ordenado:");
        printArray(arr);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }
    
    // Función principal para ordenar el array
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }
    
    // Función recursiva para dividir el array y combinarlo
    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Ordenar la mitad izquierda
            mergeSort(arr, left, mid, temp);
            
            // Ordenar la mitad derecha
            mergeSort(arr, mid + 1, right, temp);
            
            // Combinar las mitades ordenadas
            merge(arr, left, mid, right, temp);
        }
    }
    
    // Función para combinar dos mitades ordenadas
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // Copiar los elementos a un array temporal
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        // Comparar elementos y combinar en orden
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        
        // Copiar los elementos restantes de la mitad izquierda, si hay
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
        
        // Copiar los elementos restantes de la mitad derecha, si hay
        while (j <= right) {
            arr[k] = temp[j];
            k++;
            j++;
        }
    }
    
    static void printArray(int arr[]) {
    	int n=arr.length;
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

