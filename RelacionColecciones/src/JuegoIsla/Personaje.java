package JuegoIsla;

import java.util.HashSet;
import java.util.Iterator;

public class Personaje {
	private static final int MAXIMO_FRUTA = 20;
	private static final int MAXIMO_EDAD = 20;
	private static final int MINIMO_EDAD = 10;
	private static final int MINIMO = 0;
	private String nombre;
	private int edad;
	private Isla isla;
	private HashSet<Fruta> mochila;// la mochila se creara vacia
	private static int cantidadFrutaCojida;

	public Personaje(String nombre, Isla isla) throws JuegoException {
		super();
		this.nombre = nombre;
		this.setEdad(MINIMO_EDAD);
		this.isla = isla;
		this.mochila = new  HashSet<Fruta>();
		isla.admitirVecino();
	}

	public Personaje(String nombre, int edad, Isla isla) throws JuegoException {
		super();
		this.nombre = nombre;
		this.setEdad(edad);
		this.isla = isla;
		this.mochila =new  HashSet<Fruta>();
		isla.admitirVecino();
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) throws JuegoException {
		if (edad > MAXIMO_EDAD || edad < MINIMO_EDAD) {
			throw new JuegoException("Error la edad es in correcta");
		}
		this.edad = edad;
	}

	public Isla getIsla() {
		return isla;
	}

	public void recolectarFruta(Fruta nuevaFruta) throws JuegoException {

	    if (mochila.size() >= MAXIMO_FRUTA) {
	        throw new JuegoException("Error el limite de la mochila ha sido superado");
	    }

	    boolean encontrada = buscarFruta(nuevaFruta);

	    if (!encontrada) {
	        mochila.add(nuevaFruta);
	    }
	}

	private boolean buscarFruta(Fruta nuevaFruta) throws JuegoException {
		boolean encontrada = false;

	    Iterator<Fruta> it = mochila.iterator();

	    while (it.hasNext() && !encontrada) {
	        Fruta f = it.next();
	        if (f.equals(nuevaFruta)) {
	            f.setCantidad(f.getCantidad() + 1);
	            encontrada = true;
	        }
	    }
		return encontrada;
	}


	public void regalarFrutas(Personaje otro, Fruta frutaRegalar) throws JuegoException {
		if (!(otro.isla.equals(this.isla))) {
			throw new JuegoException("No son de la misma isla");
		} else {
			if(this.mochila.remove(frutaRegalar)) {
				otro.mochila.add(frutaRegalar);
			}
			
		}
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", edad=" + edad + ", isla=" + isla.getNombre() + ", mochila=" + mochila
				+ "]";
	}

	public void cumpleaños() {
		this.edad++;
	}

	public void setIsla(Isla isla, Isla otra) throws JuegoException {
		if (otra.getCapacidad() <= otra.getPoblacion()) {
			throw new JuegoException("Error");
		} else {

			otra.admitirVecino();
			isla.despedirVecino();
			isla = otra;

		}

		this.isla = isla;
	}

}
