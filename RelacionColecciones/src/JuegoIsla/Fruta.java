package JuegoIsla;

import java.util.Objects;

public class Fruta {
	public String nombre;
	public int cantidad;
	public Fruta(String nombre) {
		super();
		this.nombre = nombre;
		this.cantidad = 1;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) throws JuegoException {
		if (cantidad<0) {
			throw new JuegoException("La cantidad introducida es inferior a la minima");
		}
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruta other = (Fruta) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
	
}
