import java.util.*;






public class PrincipalOrdenacionClaseAnonima {

	public static void main(String[] args) {
			
		
		LinkedList<Persona> listadoPersonas=new LinkedList<Persona>(  );
		listadoPersonas.add( new Persona("22B", "PEPE", "SOL ", 25));	
		listadoPersonas.add(new Persona("21X", "PEPE", "ADSFFL ", 25));	
		listadoPersonas.add( new Persona("45X", "LOLA", "ADSFFL ", 55));

		
		//Clase anónima
		Comparator<Persona> comparador = new Comparator<Persona>() {

			@Override
			public int compare(Persona persona1, Persona persona2) {
				return persona1.getDni().compareTo(persona2.getDni());
			}
			
		};
		Collections.sort(listadoPersonas, comparador);
		
		System.out.println("Ordenado por DNI");
		for (Persona p: listadoPersonas){
			System.out.println(p);
		}
		
	
	}
	
	
	

}
