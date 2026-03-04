package Feria;

import java.util.*;

public class Caseta {
	private List<Socio> listaSocios;

	public Caseta() {// corregir
		this.listaSocios = new LinkedList<Socio>();
	}

	public void añadirSocio(Socio s) {
		listaSocios.add(s);
	}
//MODIFICAR DATOS DEL SOCIO
	public void modificarSocio(int numero) {
		Socio socio =buscarPorNumero(numero);
		
	}
	// Eliminación con confirmación (buscamos el socio primero)
	public Socio buscarPorNumero(int numero) {//devuelve null si no lo encuentra 

		Iterator<Socio> iterador;
		Socio socio;
		Socio socioEncontrado= null;
		boolean encontrado = false;

		iterador = listaSocios.iterator();

		while (iterador.hasNext() && !encontrado) {
			socio = iterador.next();

			if (socio.getIdSocio() == numero) {
				encontrado = true;
				socioEncontrado=socio;
			}

		}
		return socioEncontrado;
	}

	public void eliminarSocio(Socio s) {
	
        listaSocios.remove(s);
//		Iterator<Socio> iterador;
//		Socio socio;
//		boolean borrado = false;
//
//		iterador = listaSocios.iterator();
//
//		while (iterador.hasNext() && !borrado) {
//			socio = iterador.next();
//
//			if (socio.getIdSocio() == s.getIdSocio()) {
//				iterador.remove();
//				borrado = true;
//			}
//
//		}
	}

	public List<Socio> mostrarPorFecha() {
		List<Socio> temporal = new ArrayList<>(listaSocios);
		Collections.sort(temporal, new Comparator<Socio>() {
			@Override
			public int compare(Socio socio1, Socio socio2) {
				return socio1.getFechaNacimiento().compareTo(socio2.getFechaNacimiento());
			}
		});
		return temporal;
	}

	public List<Socio> mostrarPorNombre() {
		List<Socio> temporal = new ArrayList<>(listaSocios);
		Collections.sort(temporal, new Comparator<Socio>() {
			@Override
			public int compare(Socio s1, Socio s2) {
				return s1.getNombreCompleto().compareToIgnoreCase(s2.getNombreCompleto());
			}
		});
		return temporal;
	}

	@Override
	public String toString() {
		return "Caseta [listaSocios=" + listaSocios + "]";
	}

}