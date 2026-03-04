package JuegoIsla;


public class Isla {
	private static final int MINIMO_POBLACION = 3;
	private static final int MINIMO = 0;
	private String nombre;
	private int capacidad;
	private int poblacion;

	public Isla(String nombre, int capacidad) throws JuegoException {
		super();
		this.nombre = nombre;
		this.setCapacidad(capacidad);
		this.poblacion = MINIMO;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getPoblacion() {
		return poblacion;
	}

	private void setCapacidad(int capacidad) throws JuegoException {
		if (capacidad < MINIMO_POBLACION) {
			throw new JuegoException("La capacidad introducida es inferior a la minima");
		}
		this.capacidad = capacidad;
	}

	public void admitirVecino() throws JuegoException {
		if (poblacion >= capacidad) {
			throw new JuegoException("No se puede admitir al vecino, se ha superado la capacidad de la isla");
		}
		this.poblacion++;
	}

	public void despedirVecino() throws JuegoException {
		if (poblacion <= MINIMO) {
			throw new JuegoException("No se puede despedir al vecino, no hay quien desedir");
		}
		this.poblacion--;
	}

	@Override
	public String toString() {
		return "Isla [nombre=" + nombre + ", capacidad=" + capacidad + ", poblacion=" + poblacion + "]";
	}

}
