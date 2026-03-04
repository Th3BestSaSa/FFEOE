import java.util.*;






public class PrincipalOrdenacionConLambda2 {

	public static void main(String[] args) {
			
		
		LinkedList<Persona> listadoPersonas=new LinkedList<Persona>(  );
		listadoPersonas.add( new Persona("22B", "PEPE", "SOL ", 25));	
		listadoPersonas.add(new Persona("21X", "PEPE", "ADSFFL ", 25));	
		listadoPersonas.add( new Persona("45X", "LOLA", "ADSFFL ", 55));

							//expresión lambda como parámetro del método Collecctions.sort
		Collections.sort(listadoPersonas, 
				 (persona1,persona2)->{return persona1.getDni().compareTo(persona2.getDni());}
		);
		
		System.out.println("Ordenado por DNI");
		for (Persona p: listadoPersonas){
			System.out.println(p);
		}
		
		
		
 		
	}
	
	
	

}
