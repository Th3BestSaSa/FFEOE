package principal;

import java.util.ArrayList;
import java.util.Scanner;

import empresa.*;

public class PrincipalEjemploColeccionesObjeto {

	

	public static void main(String[] args) {

		// Crear un coleccion donde puedo guardar Empleados

		// Tienen un orden y se guardan contiguos y admite elementos repetidos

		try {
			ArrayList<Empleado> empleados = new ArrayList<Empleado>();

			// A�adir al final
			empleados.add(new Empleado("22", "PEPE", 1500));
			empleados.add(new Empleado("21", "PEPA", 1300));
			empleados.add(new Empleado("99", "ROSA", 1200));
			empleados.add(new Empleado("98", "ROSARIO", 1150));

			// A�adir en cualquier posicion. Requiere desplazar !! Ojo!!!
			empleados.add(2, new Empleado("101", "MATEO", 1180));

			// Sevilla Alcala Malaga Cordoba Carmona
			// 0 1 2 3 4

			System.out.println("Hay " + empleados.size() + " empleados");

			// Antes
			for (int i = 0; i < empleados.size(); i++) {

				System.out.println(empleados.get(i));
			}

			// Borrar por posicion. Requiere desplazar. !!Ojo!!!
			 empleados.remove(2);

			Empleado nuevo = new Empleado("101", "NUEVO", 1180);

			// Saber si un elemento est� en la colecci�n. Cuidado contains llama a equals, depende como programemos equals
			//funcionar� contains
			if (empleados.contains(nuevo)) {
				System.out.println("Ya est� repetida");
			} else {
				System.out.println("OK, la incluimos");
				empleados.add(nuevo);
			}

			mostrar(empleados);

		} catch (EmpleadoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void mostrar(ArrayList<Empleado> empleados) {
		for (Empleado e : empleados) {
			System.out.println(e);
		}

	}

}
