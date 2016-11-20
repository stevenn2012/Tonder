package co.edu.usa.adf.Tonder.logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import co.edu.usa.adf.Tonder.datos.Persona;

public class TonderLogic {

	public static AdminDatos admin;

	public TonderLogic() {
		System.out.println("Cargando... ");
		admin = new AdminDatos();

	}

	public double compatibilidad(Persona persona) {
		System.out.println("Welcome to Tonder");
		Hashtable<Double, Persona> tabla= new Hashtable<Double, Persona>();
		System.out.println("Filtrando...");
		ArrayList<Persona> fil = filtro(persona);
		double porcentaje= 0.0;
		for (int i = 0; i < fil.size(); i++) {
			/*System.out.println(fil.get(i));
			System.out.println("\t Porcentaje color: " + compareColor(persona, fil.get(i)));
			System.out.println("\t Porcentaje edad: " + compareEdad(persona, fil.get(i)));
			System.out.println("\t Porcentaje Hobbies: " + compareHobbies(persona, fil.get(i)));
			System.out.println("\t Porcentaje Zodiaco: " + compareZodiaco(persona, fil.get(i)));
			System.out.println();*/
			porcentaje=compareColor(persona, fil.get(i))+compareEdad(persona, fil.get(i))+
					compareHobbies(persona, fil.get(i))+compareZodiaco(persona, fil.get(i));
			tabla.put(porcentaje, fil.get(i));
		}
		ArrayList<Persona> result=top5Personas(tabla);
		for (Persona persona2 : result) {
			System.out.println(persona2.getApellido()+" "+persona2.getNombre());
		}
		return 0.0;
	}

	private ArrayList<Persona> top5Personas(Hashtable<Double, Persona> tabla) {
		ArrayList<Persona> persons= new ArrayList<Persona>();
		Set<Double> keys= new HashSet<Double>();
		keys=tabla.keySet();
		List<Double> lista = new ArrayList<Double>(keys);
		Collections.sort(lista);
		int cont=0;
		for (int i = lista.size()-1; cont < 5; i--) {
			persons.add(tabla.get(lista.get(i)));
			cont++;
		}
		return persons;
	}

	public ArrayList<Persona> filtro(Persona persona) {
		ArrayList<Persona> listaPersonas = admin.personas.getDatos();
		ArrayList<Persona> filtroPersonas = new ArrayList<Persona>();
		for (int i = 0; i < listaPersonas.size(); i++) {
			boolean valid = true;
			if (!listaPersonas.get(i).getPais().equalsIgnoreCase(persona.getPais()))
				valid = false;
			if (!listaPersonas.get(i).getCiudad().equalsIgnoreCase(persona.getCiudad()))
				valid = false;
			if (listaPersonas.get(i).getSexo() != persona.getOrientacionSexual())
				valid = false;
			if (valid)
				filtroPersonas.add(listaPersonas.get(i));
		}
		System.out.println("Se obtuvieron: " + filtroPersonas.size() + " / " + listaPersonas.size() + " personas");
		return filtroPersonas;
	}

	public double compareZodiaco(Persona persona1, Persona persona2) {
		DatosCompatibilidad compatibilidad = new DatosCompatibilidad();

		int indice1 = signoZodiacal(persona1.getFechaNacimiento());
		int indice2 = signoZodiacal(persona2.getFechaNacimiento());

		double compati = compatibilidad.getCompatibilidad(indice1 - 1, indice2 - 1);
		double resultado = (compati * 30) / 80;
		return resultado;
	}

	@SuppressWarnings("deprecation")
	private int signoZodiacal(Date fecha1) {
		int result = 0;
		if ((fecha1.getMonth() == 2 && fecha1.getDate() >= 21) || (fecha1.getMonth() == 3 && fecha1.getDate() <= 20)) {
			System.out.println("Aries");
			result = 1;
		} else if ((fecha1.getMonth() == 3 && fecha1.getDate() >= 21)
				|| (fecha1.getMonth() == 4 && fecha1.getDate() <= 21)) {
			System.out.println("Tauro");
			result = 2;
		} else if ((fecha1.getMonth() == 4 && fecha1.getDate() >= 22)
				|| (fecha1.getMonth() == 5 && fecha1.getDate() <= 21)) {
			System.out.println("Geminis");
			result = 3;
		} else if ((fecha1.getMonth() == 5 && fecha1.getDate() >= 22)
				|| (fecha1.getMonth() == 6 && fecha1.getDate() <= 22)) {
			System.out.println("Cancer");
			result = 4;
		} else if ((fecha1.getMonth() == 6 && fecha1.getDate() >= 23)
				|| (fecha1.getMonth() == 7 && fecha1.getDate() <= 23)) {
			System.out.println("Leo");
			result = 5;
		} else if ((fecha1.getMonth() == 7 && fecha1.getDate() >= 24)
				|| (fecha1.getMonth() == 8 && fecha1.getDate() <= 23)) {
			System.out.println("Virgo");
			result = 6;
		} else if ((fecha1.getMonth() == 8 && fecha1.getDate() >= 24)
				|| (fecha1.getMonth() == 9 && fecha1.getDate() <= 23)) {
			System.out.println("Libra");
			result = 7;
		} else if ((fecha1.getMonth() == 9 && fecha1.getDate() >= 24)
				|| (fecha1.getMonth() == 10 && fecha1.getDate() <= 22)) {
			System.out.println("Escorpio");
			result = 8;
		} else if ((fecha1.getMonth() == 10 && fecha1.getDate() >= 23)
				|| (fecha1.getMonth() == 11 && fecha1.getDate() <= 21)) {
			System.out.println("Sagitario");
			result = 9;
		} else if ((fecha1.getMonth() == 11 && fecha1.getDate() >= 22)
				|| (fecha1.getMonth() == 0 && fecha1.getDate() <= 20)) {
			System.out.println("Capricornio");
			result = 10;
		} else if ((fecha1.getMonth() == 0 && fecha1.getDate() >= 21)
				|| (fecha1.getMonth() == 1 && fecha1.getDate() <= 18)) {
			System.out.println("Acuario");
			result = 11;
		} else if ((fecha1.getMonth() == 1 && fecha1.getDate() >= 19)
				|| (fecha1.getMonth() == 2 && fecha1.getDate() <= 20)) {
			System.out.println("Piscis");
			result = 12;
		}
		return result;
	}

	public double compareEdad(Persona persona1, Persona persona2) {
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
		long edadM = 0, edadF = 0;
		if (persona1.getSexo() == 'M' && persona2.getSexo() == 'F') {
			edadM = ((new Date().getTime() - persona1.getFechaNacimiento().getTime()) / MILLSECS_PER_DAY) / 365;
			edadF = ((new Date().getTime() - persona2.getFechaNacimiento().getTime()) / MILLSECS_PER_DAY) / 365;
		} else if (persona2.getSexo() == 'M' && persona1.getSexo() == 'F') {
			edadM = ((new Date().getTime() - persona2.getFechaNacimiento().getTime()) / MILLSECS_PER_DAY) / 365;
			edadF = ((new Date().getTime() - persona1.getFechaNacimiento().getTime()) / MILLSECS_PER_DAY) / 365;
		} else {
			edadM = ((new Date().getTime() - persona2.getFechaNacimiento().getTime()) / MILLSECS_PER_DAY) / 365;
			edadF = ((new Date().getTime() - persona1.getFechaNacimiento().getTime()) / MILLSECS_PER_DAY) / 365;
			System.out.println("\t * Edades -> M: " + edadM + ", F: " + edadF);
			if ((edadF >= ((edadM / 2) + 7)) || (edadM >= ((edadF / 2) + 7)))
				return 20;
			else
				return 0;
		}
		System.out.println("\t * Edades -> M: " + edadM + ", F: " + edadF);
		if (edadF >= ((edadM / 2) + 7))
			return 20;
		else
			return 0;
	}

	public double compareHobbies(Persona persona1, Persona persona2) {
		double porcent = 0;
		try {
			for (int i = 0; i < persona1.getHobbies().size(); i++)
				for (int j = 0; j < persona2.getHobbies().size(); j++)
					if (persona1.getHobbie(i).getNombre().equalsIgnoreCase(persona2.getHobbie(j).getNombre()))
						porcent += 10;
			return porcent;
		} catch (Exception e) {
			return porcent;
		}
	}

	public double compareColor(Persona persona1, Persona persona2) {
		if (persona1.getColor().equalsIgnoreCase(persona2.getColor()))
			return 10;
		else
			return 0;
	}
}
