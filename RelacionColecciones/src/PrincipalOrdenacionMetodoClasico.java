import java.util.*;






public class PrincipalOrdenacionMetodoClasico {

	public static void main(String[] args) {
			
		
		LinkedList<Persona> listadoPersonas=new LinkedList<Persona>(  );
		

		listadoPersonas.add( new Persona("22B", "PEPE", "SOL ", 25));
		
		listadoPersonas.add(new Persona("21X", "PEPE", "ADSFFL ", 25));
		
		listadoPersonas.add( new Persona("45X", "LOLA", "ADSFFL ", 55));
		
		Collections.sort(listadoPersonas);
		
		System.out.println("Ordenado por nombre");
		for (Persona p: listadoPersonas){
			System.out.println(p);
		}
		
		ComparadorPorDNI comp=new ComparadorPorDNI();
		Collections.sort(listadoPersonas, comp);
		
		System.out.println("Ordenado por DNI");
		for (Persona p: listadoPersonas){
			System.out.println(p);
		}
		
	
		
 		
	}
	
	
	

}
