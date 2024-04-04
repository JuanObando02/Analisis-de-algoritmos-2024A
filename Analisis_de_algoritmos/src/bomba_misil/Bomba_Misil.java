package bomba_misil;

import java.util.Random;
import java.util.Scanner;

public class Bomba_Misil {
		
	public static void main (String[]args){
		Scanner s= new Scanner(System.in);
		System.out.println ("Bienvenido al juego de adivinar el codigo de tres digitos bomba misil: \nuna bomba"
						+"es un digito en la posicion incorrecta, un misil es un digito en la posicion correcta");
		System.out.println ("Adivina un numero de tres digitos (no pueden ser repetidos) ejemplo: 549");
		System.out.println ("Comienza el juego!");
		int numero = random();
		int num,intentos=0;
		boolean estado=true;
		
		while(estado) {
			intentos++;
			System.out.println("Intento: "+intentos);
			num=obtenerNumero("Digita un numero:",s);
			estado=validar(num,numero);
		}
		System.out.println ("El numero:"+numero);
	}
	
	public static int random() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Genera un número aleatorio entre 0 y 999
        if(tiene_repetidos(randomNumber)) {
        	System.out.println ("tiene repetidos: "+randomNumber);
        	return random();
        } else {
        	return randomNumber;	
        }
    }
	
	public static boolean tiene_repetidos(int numero) {
		int unidades,decenas,centenas;
		unidades=(numero/1)%10;
		decenas=(numero/10)%10;
		centenas=(numero/100)%10;
		//System.out.println("unidad="+unidades+"\ndecenas="+decenas+"\ncentenas="+centenas);
		if(unidades==decenas || unidades==centenas || decenas==centenas) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validar(int numero,int adivina) {
			int bombas=0;
			int misiles=0;
			int unidades=(adivina/1)%10;
			int decenas=(adivina/10)%10;
			int centenas=(adivina/100)%10;
			int unid=(numero/1)%10;
			int dece=(numero/10)%10;
			int cente=(numero/100)%10;
			
			if(unidades==unid && decenas==dece && centenas==cente) {
				System.out.println ("\nFelicidades!!!!!! Acertaste el numero.");
				return false;
			}
			if(unidades==dece || unidades == cente) 
					bombas++;
			if(decenas==unid || decenas == cente) 
					bombas++;
			if(centenas == unid || centenas == dece) 
					bombas++;
			if(unidades == unid)
					misiles++;
			if(decenas == dece)
					misiles++;
			if(centenas == cente)
					misiles++;
			System.out.println ("misiles: "+bombas+"\nBombas: "+misiles+"\n");
			return true;
	}
	
	public static int obtenerNumero (String mensaje, Scanner scanner){
		while (true){
			System.out.print(mensaje);
			int numero = scanner.nextInt();
			if ((numero >= 0 && numero <= 999) && !tiene_repetidos(numero)){
				return numero;
			} else {
				System.out.println("Por favor, ingresa un numero de 3 digitos no pueden ser repetidos.");
			}
		}	
	}
}
