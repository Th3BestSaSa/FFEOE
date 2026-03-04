package JuegoIsla;

import java.util.Scanner;

public class Main {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduce la capacidad de la isla Bora Bora");
		int capacidadIsla = Integer.parseInt(teclado.nextLine());
		Isla isla1 = null;
		try {
			isla1 = new Isla("Bora Bora", capacidadIsla);
			System.out.println(isla1);

			// i.despedirVecino();
			System.out.println(isla1);
			Personaje canela = new Personaje("Canela", isla1);
			Personaje q = new Personaje("Aldeana", 17, isla1);
			Personaje b = new Personaje("Blas", 17, isla1);
			Personaje epi = new Personaje("Epi", 17, isla1);
			System.out.println(epi + "Antes del cambio");
			Isla isla2 = new Isla("Hawaii", capacidadIsla);
			epi.setIsla(isla1, isla2);
			System.out.println(isla1);
			System.out.println(isla2);
			System.out.println(epi + "Despues del cambio");
			System.out.println(canela);
			System.out.println(q);
			System.out.println(b);
			Fruta naranja= new Fruta("Naranja");

			epi.recolectarFruta(naranja);
			epi.recolectarFruta(naranja);
			epi.recolectarFruta(naranja);
			epi.recolectarFruta(naranja);
			epi.recolectarFruta(naranja);
			
			System.out.println(epi);
		} catch (JuegoException e) {
			// TODO Auto-generated catch block

		}

	}

}
