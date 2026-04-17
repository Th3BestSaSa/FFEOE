package ficherosTexto;

public class Producto {
	public String codigo;
	public String nombre;
	public int cantidad;
public Producto(String codigo, String nombre, int cantidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

public String getCodigo() {
		return codigo;
	}

public String getNombre() {
		return nombre;
	}

public int getCantidad() {
		return cantidad;
	}

	

}
