import java.util.Comparator;


public class ComparadorPorDNI implements Comparator<Persona> {

	public ComparadorPorDNI() {
	
	}
	
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		return  p1.getDni().compareTo(p2.getDni());
	}

}
