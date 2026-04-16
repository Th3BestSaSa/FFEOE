package ficherosTexto;

public class Alumno {
	public String codigo;
	public String nombre;
	public String correo;
	public double nota;
	public Alumno(String codigo, String nombre, String correo, double nota) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.correo = correo;
		this.nota = nota;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public double getNota() {
		return nota;
	}
	@Override
	public String toString() {
		return  codigo + "|" + nombre + "|" + correo + "|" + nota ;
	}
	
	
}
