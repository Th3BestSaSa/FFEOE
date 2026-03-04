package Equipo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipo equipo = new Equipo("AAAAA");
		Alumno a=new Alumno("Jose", "202301434c");
		Alumno b = new Alumno("Maria", "202301435c");
		Alumno c = new Alumno("Carlos", "202301436c");
		Alumno d = new Alumno("Ana", "202301437c");
		Alumno e = new Alumno("Luis", "202301438c");
		Alumno f = new Alumno("Sofia", "202301439c");
		Alumno g = new Alumno("Miguel", "202301440c");
		Alumno h = new Alumno("Valeria", "202301441c");
		Alumno i = new Alumno("Diego", "202301442c");
		Alumno j = new Alumno("Camila", "202301443c");
		Alumno k = new Alumno("Andres", "202301444c");
		try {
			equipo.insertarAlumno(a);
			equipo.insertarAlumno(b);
			equipo.insertarAlumno(c);
			equipo.insertarAlumno(d);
			equipo.insertarAlumno(e);
			equipo.insertarAlumno(f);
			equipo.insertarAlumno(g);
			equipo.insertarAlumno(h);
			equipo.insertarAlumno(i);
			equipo.insertarAlumno(j);
			equipo.insertarAlumno(k);
			System.out.println(equipo);
		} catch (EquipoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
