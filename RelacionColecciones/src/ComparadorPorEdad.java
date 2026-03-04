import java.util.Comparator;


public class ComparadorPorEdad implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		int resul;
		if ( o1.getEdad() > o2.getEdad())
			resul=1;
		else
			if ( o1.getEdad() < o2.getEdad())
				resul=-1;
			else
				resul=0;
		
		return resul;
	}

}
