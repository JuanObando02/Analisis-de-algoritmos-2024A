package radix_short;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Con_listas {
	
	public static void main(String[] args) {
		int cantidad=10;
		
        List<Integer> myList = new ArrayList<>();
        generarNumerosAleatorios(myList, cantidad);

        System.out.println("Lista original:");
        System.out.println(myList);
        
        // Llamar a la función radixSort para ordenar la lista
        myList = radixSort(myList);
        
        System.out.println("Lista ordenada:");
        System.out.println(myList);
    }
	
	static List<Integer> radixSort(List<Integer> lista_1) { 
        // Encuentra el maximo numero para saber la cantidad de digitos
		
        int m = obtenerMaximo(lista_1);
        int exp=1;
        while( m/exp >= 1 ) {
        	lista_1=count_lista(lista_1,exp);
        	exp*=10;
        }
        return lista_1;
            
    }
	
    public static List<Integer> count_lista(List<Integer> lista, int exp) {
    	
        // Crear un array de listas de tamaño 10 (0-9)
        List<Integer>[] arrayDeListas = new ArrayList[10];
        
        // Inicializar cada posición del array con una nueva lista vacía
        for (int i = 0; i < arrayDeListas.length; i++) {
            arrayDeListas[i] = new ArrayList<>();
        }
        
        // Agregar los números a las listas correspondientes
        for (int num : lista) {
            arrayDeListas[(num / exp) % 10].add(num);
            //          identificar el numero a ordenar
        }
        
        // Crear una nueva lista para almacenar los elementos ordenados
        List<Integer> lista_ordenada = new ArrayList<>();
        
        // Recorrer el array de listas y agregar los elementos ordenados a la nueva lista
        for (List<Integer> lista_del_arreglo : arrayDeListas) {
        	lista_ordenada.addAll(lista_del_arreglo);
        }
        
        return lista_ordenada;
    }
    
    public static void generarNumerosAleatorios(List<Integer> lista, int cantidad) {
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            lista.add(rand.nextInt(1000)); // Generar un número aleatorio entre 0 y 999
        }
    }
    
    static int obtenerMaximo(List<Integer> lista) {
        int max = lista.get(0);
        for (int num : lista) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    
}
