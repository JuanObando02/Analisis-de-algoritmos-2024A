package ShellSortExample;

import java.util.Arrays;

public class ShellSortExample {
	public static void shellSort(int[] arr) {
        int n = arr.length;
  
        // Comienza con una brecha grande, luego la reduce
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Hace el mismo proceso que el insertion sort pero con la brecha
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                arr[j] = temp;
                System.out.println( Arrays.toString(arr)+" "+(gap));
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 60, 5, 3};
        
        // Clonamos el array original para mantenerlo intacto y comparar después
        int[] arrCopy = arr.clone();
        
        // Llamamos a Shell Sort
        shellSort(arr);
         
        
        System.out.println("Array ordenado: " + Arrays.toString(arr));
        
        // Verificamos con la implementación de Java para asegurarnos de que el arreglo se haya ordenado correctamente
        Arrays.sort(arrCopy);
        System.out.println("Array ordenado con Arrays.sort(): " + Arrays.toString(arrCopy));
    }
