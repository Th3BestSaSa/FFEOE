package ficherosTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

public class CrearDocumento {
	private static Scanner teclado= new Scanner(System.in);

	// Files.createDirectories(ruta); // Está comentado
	//Files.createFile(ruta);           // Esto falla porque la carpeta 'documentos' no existe
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("NOMBRE CARPETA");
		String nombreCarpeta=teclado.nextLine();
		System.out.println("NOMBRE ARCHIVO");
		String nombreArchivo=teclado.nextLine();
		crearDocumento(nombreCarpeta, nombreArchivo);
		
	}

	

	private static void crearDocumento(String nombreCarpeta, String nombreArchivo) {
		Path ruta = Paths.get(nombreCarpeta, nombreArchivo);
		 if (Files.exists(ruta)) {
				System.out.println("El archivo existe.");
			} else {
				if (Files.notExists(ruta)) {
					// createDirectories crea toda la ruta necesaria
					try {
						Path carpeta= ruta.getParent();
						if (carpeta!= null) {
							Files.createDirectories(carpeta);
						}
									
						Files.createFile(ruta);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Carpeta creada con éxito.");
				} else {
					System.out.println("La carpeta ya existía.");
				}
	}
	}
}
