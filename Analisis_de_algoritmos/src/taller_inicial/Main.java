package taller_inicial;

public class Main {
	
	final static int n = 5;
	
	public static void main(String[]args) {
		//punto 1.
		int[] arreglo = {3,6,1,-10,-3,6,5,-6};
		System.out.println("suma maxima continua: "+ Suma_maxima_contigua.sumamaxima(arreglo));
		
		//punto 2.
		int  matriz[][]= new int[n][n];
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				matriz[i][j] = (int) (Math.random() * (30 - 10 + 1)+ 10);//numeros de 30 a 10
			}
			
		}
		System.out.println("Matriz creada:");//impresion de matriz
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf(" %d ",matriz[i][j]);
			}
			System.out.println();
		}
		
		buscar(matriz,12);
		
		
	}
	
	public static int sumamaxima(int [] arreglo) {
		if (arreglo.length==0) {
			return 0;
		}
		//definimos dos varibles para guardar los maximos
		
		int maximoactual = arreglo[0];
		int maximoglobal = arreglo[0];
		//{2,6,2,-10,-3,4,5,-6}
		//{0,1,2,  3, 4,5,6, 7}
		for(int i = 1 ;i < arreglo.length;i++) {
			//
			maximoactual = Math.max(arreglo[i], (maximoactual + arreglo[i]));
			System.out.println(maximoactual);
			//
			maximoglobal = Math.max(maximoglobal, maximoactual);
			System.out.println(maximoglobal);
		}
		return maximoglobal;
		
	}
	
	public static void buscar(int [][]arreglo,int elemento) {
		for(int i=0; i<arreglo.length ;i++) {
			for (int j=0;j<arreglo.length;j++) {
				if(elemento==arreglo[i][j]) {
					System.out.println("El numero: "+elemento+
							"\nSe encontro en la posicion: (fila:"+(i+1)+",columna:"+(j+1)+")");
				}
			}
		}
	}
	
}

