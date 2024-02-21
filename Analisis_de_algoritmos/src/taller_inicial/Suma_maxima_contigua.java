package taller_inicial;

public class Suma_maxima_contigua {
	
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
	
}
