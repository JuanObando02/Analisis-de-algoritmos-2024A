package radix_short;
import java.util.Arrays;
import java.util.Random;
 
public class RadixSort {
	
	public static void main(String[] args) {
		
        int longitudArreglo = 100; // Longitud del arreglo aleatorio
        int[] arr = generarArregloAleatorio(longitudArreglo);
        
        System.out.println("Arreglo original:");
        printArray(arr, longitudArreglo);
        
        long startTime = System.nanoTime(); // Iniciar temporizador
        radixSort(arr, longitudArreglo);
        
        long endTime = System.nanoTime(); 
        long tiempoEjecucion = endTime -startTime;
        
        System.out.println("Arreglo ordenado:");
        printArray(arr, longitudArreglo);
        System.out.println("\n Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos.");
        System.out.println("\n Tiempo de ejecución: " + convertirNanosegundosASegundos(tiempoEjecucion)+ " segundos");
    }
	
	public static double convertirNanosegundosASegundos(long nanosegundos) {
		return nanosegundos / 1_000_000_000.0;
	}
	
    
    static int obtener_maximo(int arr[], int n) {
    	
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max) {
            	max = arr[i];
            }
        return max;
        
    }
 
   //usando el metodo de countSort
    static void counting_Sort(int arr[], int exp) {
    	
        int n = arr.length;
        int output[] = new int[n]; //arreglo para ordenar
        int count[] = new int[10]; 
        Arrays.fill(count, 0); //inicializar el arreglo en 0

        // Almacena el conteo de numeros en el arreglo
        for (int i = 0; i < n; i++) {
        	
            count[(arr[i] / exp) % 10]++;
            //contamos la cantidad de veces que esta ese numero
        
        }
        System.out.println("\nCuenta de los digitos en el arreglo:");
        printArray(count,count.length);
        System.out.println("0 1 2 3 4 5 6 7 8 9 indices");
        
        //hacer una sumatoria de los elementos del arreglo
        //para saber la posicion de cada uno en el arreglo
        for (int i = 1; i < 10; i++) {
        	
            count[i] += count[i - 1];
        }
        System.out.println("\nSumatoria de los elementos en el arreglo:");
        printArray(count,count.length);
        System.out.println("0 1 2 3 4 5 6 7 8 9 indices\n");
 
        // Construye el array de salida
        for (int i = n - 1; i >= 0; i--) {
        	
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            //
            count[(arr[i] / exp) % 10]--;
            
        }
        System.out.println("Arreglo ordenado:");
        printArray(output,output.length);
 
        // Copia el array de salida al array original arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
 
    
    static void radixSort(int arr[], int n) { 
        // Encuentra el maximo numero para saber la cantidad de digitos
        int m = obtener_maximo(arr, n);
        int exp=1;
        while( m/exp >= 1 ) {
        	counting_Sort(arr,exp);
        	exp*=10;
        }
        
            
    }
 
    // Funcion para imprimir un array
    static void printArray(int arr[], int n) {
    	
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        
    }
 
    // Funcion para generar un arreglo aleatorio de longitud especifica
    static int[] generarArregloAleatorio(int longitud) {
    	
        int[] arr = new int[longitud];
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            arr[i] = random.nextInt(1000); // Rango de numeros aleatorios de 0 a 999
        }
        return arr;
    }
 
}
