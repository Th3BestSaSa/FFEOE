package Equipo;

import java.util.*;

public class Equipo {
	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;

	public Equipo(String nombreEquipo) {

		setNombreEquipo(nombreEquipo);
		conjuntoAlumnos = new HashSet<Alumno>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {
		boolean encontrado = conjuntoAlumnos.contains(nuevoAlumno);
		if (encontrado) {
			throw new EquipoException("Alumno exixtente");
		}
		conjuntoAlumnos.add(nuevoAlumno);
	}

	public void borrarAlumno(Alumno alumnoABorrar, HashSet<Alumno> conjuntoAlumnos) throws EquipoException {
		Iterator<Alumno> iterador;
		Alumno alumno;
		boolean borrado = false;

		iterador = conjuntoAlumnos.iterator();

		while (iterador.hasNext() && !borrado) {
			alumno = iterador.next();

			for (Iterator iterator = conjuntoAlumnos.iterator(); iterator.hasNext();) {
				iterador.remove();
				borrado = true;
			}
		}
	}

	public Alumno buscarAlumno(Alumno alumnoBuscado) {
		// buscar por el nombre
		Iterator<Alumno> iterador;
		Alumno alumno;
		iterador = conjuntoAlumnos.iterator();
		boolean encontrado = false;
		boolean existe;
		existe = (encontrado) ? true : false;
		return alumnoBuscado;
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro   Otro equipo que se va a unir
	 * @param nombre Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 * @throws EquipoException
	 */
	public Equipo fusionDeEquipos(Equipo otro, String nombre) throws EquipoException {
		Equipo fusionEquipo = null;
		Iterator<Alumno> iterador1 = this.conjuntoAlumnos.iterator();
		Iterator<Alumno> iterador2 = otro.conjuntoAlumnos.iterator();
		while (iterador1.hasNext()) {
			fusionEquipo.insertarAlumno(iterador1.next());
		}
		while (iterador2.hasNext()) {
			fusionEquipo.insertarAlumno(iterador2.next());
		}
		{
			return fusionEquipo;
		}
	}

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this y
	 * otro)
	 * 
	 * @param otro   Otro equipo
	 * @param nombre Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 * @throws EquipoException
	 */

	public Equipo intersecionDeEquipos(Equipo otro, String nombre) throws EquipoException {
		Equipo interseccionEquipo = null;
		Iterator<Alumno> iterador1 = this.conjuntoAlumnos.iterator();
		Iterator<Alumno> iterador2 = otro.conjuntoAlumnos.iterator();
		while (iterador1.hasNext()) {
			interseccionEquipo.insertarAlumno(iterador1.next());
		}
		while (iterador2.hasNext()) {
			interseccionEquipo.insertarAlumno(iterador2.next());
		}
		{
		}
		return interseccionEquipo;
	}

	@Override
	public String toString() {
	    String resultado = "Equipo: " + nombreEquipo + "\n";
	    resultado += "Lista de alumnos:\n";

	    int i = 1;
	    for (Alumno a : conjuntoAlumnos) {
	        resultado += i + ". " + a + "\n";
	        i++;
	    }

	    return resultado;
	}



}