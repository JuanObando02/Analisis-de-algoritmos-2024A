package mergesort;

public class Merge_Sort {

	public static void main(String[] args) {
		int x = 0;
		// Crear un arreglo con 10 numeros enteros positivos
		int[] arregloModificar = generateReversedArray(5000);
		for (int i = 0; i < arregloModificar.length; i++) {
			int aleatorio = (int) (Math.random() * 100) + 1;
			arregloModificar[i] = aleatorio;
		}
		System.out.println("Arreglo original:");
		System.out.print("A=[\t");
		for (int i : arregloModificar) {
			System.out.print(i + "\t");
		}
		System.out.println("]");

		// Merge Sort
		long startTime = System.nanoTime();
		int n = arregloModificar.length;
		int[] arregloAux = new int[n];
		for (int Tamaño = 1; Tamaño < n; Tamaño *= 2) {
			for (int Izquierda = 0; Izquierda < n - 1; Izquierda += 2 * Tamaño) {
				int Mitad = Math.min(Izquierda + Tamaño - 1, n - 1);
				int Derecha = Math.min(Izquierda + 2 * Tamaño - 1, n - 1);
				if (Derecha >= n) {
					Derecha = n - 1;
				}

				// Combinar dos subarreglos ordenados en uno solo
				int i = Izquierda;
				int j = Mitad + 1;
				int k = Izquierda;

				while (i <= Mitad && j <= Derecha) {
					if (arregloModificar[i] <= arregloModificar[j]) {
						arregloAux[k++] = arregloModificar[i++];
					} else {
						arregloAux[k++] = arregloModificar[j++];
					}
				}
				while (i <= Mitad) {
					arregloAux[k++] = arregloModificar[i++];
				}
				while (j <= Derecha) {
					arregloAux[k++] = arregloModificar[j++];
				}
				for (i = Izquierda; i <= Derecha; i++) {
					arregloModificar[i] = arregloAux[i];
				}
			}
			x++;
			//System.out.println();
			//System.out.println("Paso: " + x);
			//System.out.print("B=[\t");
			//for (int i : arregloAux) {
				//System.out.print(i + "\t");
			//}
			//System.out.println("]");
		}
		long endTime = System.nanoTime(); 
        long tiempoEjecucion = endTime -startTime;
		//System.out.println();
		System.out.println("Arreglo final:");
		System.out.print("A=[\t");
		for (int i : arregloModificar) {
			System.out.print(i + "\t");
		}
		System.out.println("]");
		System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos.");
	}
	
	public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i; // Array invertido para representar el peor caso
        }
        return array;
    }
}
