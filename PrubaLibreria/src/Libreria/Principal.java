package Libreria;
import java.util.Scanner;

public class Principal {
	
	private static final String PATRON_1 = ".*abc.*"; // contiene abc
	private static final String PATRON_2 = "^(19|20)[0-9]{2}$"; // año del 1900 al 2099
	private static final String PATRON_3 =  "^@[a-zA-Z0-9_]{3,15}$" ; // usuario red social"
			//empieza por @, letras, números y guiones bajos, 3-15 caracteres
	
	private static final String PATRON_4 = "^[0-9]{4}[ -]?[B-Z]{3}$";
			//4 números, espacio o guion opcional, 3 letras
	
	// MAL: El ? significa "opcional"
	// Este patrón buscaría "¿Dond" o "¿Donde"
	private static final String PATRON_MAL = "¿Donde?"; 

	// BIEN: Escapamos para buscar el símbolo físico ?
	private static final String PATRON_BIEN = "¿Donde\\?";
	
	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena;
		
		System.out.println("Introduce una cadena: ");
		cadena=teclado.nextLine();
		
		if (cadena.matches(PATRON_1)) {
			System.out.println("Encaja ");
		}
		else {
			System.out.println("No encaja");
		}

	}

}
