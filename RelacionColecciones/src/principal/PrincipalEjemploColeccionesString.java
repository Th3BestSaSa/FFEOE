package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalEjemploColeccionesString {

	private static Scanner teclado=new Scanner (System.in);
	
	public static void main(String[] args) {

		// Crear un coleccion donde puedo guardar String. String[] ciudadades=new
		// String[20];

		// Tienen un orden y se guardan contiguos y admite elementos repetidos
		ArrayList<String> ciudades = new ArrayList<String>();
		
		
		//A�adir al final
		ciudades.add("Sevilla"); 
		ciudades.add("Alcala");
		ciudades.add("Cordoba");
		ciudades.add("Carmona");
		
		
		//A�adir en cualquier posicion. Requiere desplazar !! Ojo!!!
		ciudades.add(2, "Malaga");
		
	
		// Sevilla Alcala Malaga Cordoba Carmona
		// 0 1 2 3 4

		System.out.println("Hay " + ciudades.size() + " ciudades");

		//Antes. Podemos recorrer el arrayList as� o con el forEach ( m�todo mostrarCiudades)
		for (int i = 0; i < ciudades.size(); i++) {

			System.out.println(ciudades.get(i));
		}
		
		System.out.println(ciudades);
		
		

		//Borrar por posicion. Requiere desplazar. !!Ojo!!!
		ciudades.remove(2);
		
		//Despues
		System.out.println("Despues:");
		mostrarCiudades( ciudades);
		
		System.out.println("Introduce una nueva ciudad");
		String ciudadNueva=teclado.nextLine();
		
		// Saber si un elemento est� en la colecci�n
		if ( ciudades.contains(ciudadNueva)) {
			System.out.println("Ya est� repetida");
		}else {
			System.out.println("OK, la incluimos");
			ciudades.add(ciudadNueva);
		}
		
		mostrarCiudades( ciudades);

	}

	private static void mostrarCiudades(ArrayList<String> ciudades) {
		for (String ciudad : ciudades) {
			System.out.println(ciudad);
		}
		
	}

}
