package co.edu.usa.adf.Tonder.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import co.edu.usa.adf.Tonder.datos.Persona;

public class TonderLogic {

	public static AdminDatos admin;

	public TonderLogic() {
		System.out.println("Cargando... ");
		admin = new AdminDatos();
		admin.cargarDatos();
	}

	public int validarUsuario(String user, String password){
		ArrayList<Persona> personas = admin.personas.getDatos();
		int id=-1;
		for (int i = 0; i < personas.size(); i++) {
			Persona persona = personas.get(i);
			System.out.println("Validar Usuario:::::::::::::::::::");
			System.out.println(persona.getUsuario()+", "+user+", "+persona.getUsuario().equalsIgnoreCase(user));
			System.out.println(persona.getPassword()+", "+EncriptacionMD5.getMD5(password)+", "+persona.getPassword().equals(EncriptacionMD5.getMD5(password)));
			if(persona.getUsuario().equalsIgnoreCase(user) && persona.getPassword().equals(EncriptacionMD5.getMD5(password))){
				id = persona.getId();
			}
		}
		return id;
	}
	
	public Persona logearPersona(int id){
		ArrayList<Persona> personas = admin.personas.getDatos();
		for (int i = 0; i < personas.size(); i++) {
			Persona persona = personas.get(i);
			if(persona.getId() == id){
				return persona;
			}
		}
		return null;
	}
	
	public TreeMap<Integer, Double> compatibilidad(Persona persona) {
		System.out.println("Welcome to Tonder");
		
		HashMap<Integer, Double> tabla= new HashMap<Integer, Double>();
		
		System.out.println("Filtrando...");
		ArrayList<Persona> fil = filtro(persona);
		System.out.println(fil);
		double porcentaje= 0.0;
		for (int i = 0; i < fil.size(); i++) {
			porcentaje=compareColor(persona, fil.get(i))+compareEdad(persona, fil.get(i))+
					compareHobbies(persona, fil.get(i))+compareZodiaco(persona, fil.get(i));
			tabla.put(fil.get(i).getId(), porcentaje);
		}
		System.out.println("Filtro: "+fil);
		System.out.println("Filtro Size: "+fil.size());
		
		TreeMap<Integer, Double> result = top5Personas(tabla);
		
		System.out.println("Result: "+result);
		System.out.println("Result Size: "+result.size());
		
		TreeMap<Integer, Double> result2 = new TreeMap<Integer, Double>();
		for (Map.Entry<Integer,Double> entry : result.entrySet()) {
	        Double value = entry.getValue();
	        int key = entry.getKey();
	        if(persona.getId() != key){
				result2.put(key, value);
			}
		}
		return result2;
	}

	public static Persona buscarPersonaPorId(int id){
		for (int i = 0; i < admin.personas.size(); i++) {
			if(admin.personas.getDato(i).getId() == id){
				return admin.personas.getDato(i);
			}
		}
		return null;
	}
	
	public TreeMap<Integer, Double> top5Personas(HashMap<Integer, Double> tabla) {
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<Integer, Double> sorted_map = new TreeMap<Integer, Double>(bvc);
        map.putAll(tabla);
     	sorted_map.putAll(map);
     
		Set<Integer> keys= new HashSet<Integer>();
		keys=sorted_map.keySet();
		List<Integer> lista = new ArrayList<Integer>(keys);
		try {
			for (int i = 5; i < lista.size(); i++) {
				sorted_map.remove(lista.get(i));
			}
		} catch (Exception e) {
		}
		return sorted_map;
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
			//System.out.println("Aries");
			result = 1;
		} else if ((fecha1.getMonth() == 3 && fecha1.getDate() >= 21)
				|| (fecha1.getMonth() == 4 && fecha1.getDate() <= 21)) {
			//System.out.println("Tauro");
			result = 2;
		} else if ((fecha1.getMonth() == 4 && fecha1.getDate() >= 22)
				|| (fecha1.getMonth() == 5 && fecha1.getDate() <= 21)) {
			//System.out.println("Geminis");
			result = 3;
		} else if ((fecha1.getMonth() == 5 && fecha1.getDate() >= 22)
				|| (fecha1.getMonth() == 6 && fecha1.getDate() <= 22)) {
			//System.out.println("Cancer");
			result = 4;
		} else if ((fecha1.getMonth() == 6 && fecha1.getDate() >= 23)
				|| (fecha1.getMonth() == 7 && fecha1.getDate() <= 23)) {
			//System.out.println("Leo");
			result = 5;
		} else if ((fecha1.getMonth() == 7 && fecha1.getDate() >= 24)
				|| (fecha1.getMonth() == 8 && fecha1.getDate() <= 23)) {
			//System.out.println("Virgo");
			result = 6;
		} else if ((fecha1.getMonth() == 8 && fecha1.getDate() >= 24)
				|| (fecha1.getMonth() == 9 && fecha1.getDate() <= 23)) {
			//System.out.println("Libra");
			result = 7;
		} else if ((fecha1.getMonth() == 9 && fecha1.getDate() >= 24)
				|| (fecha1.getMonth() == 10 && fecha1.getDate() <= 22)) {
			//System.out.println("Escorpio");
			result = 8;
		} else if ((fecha1.getMonth() == 10 && fecha1.getDate() >= 23)
				|| (fecha1.getMonth() == 11 && fecha1.getDate() <= 21)) {
			//System.out.println("Sagitario");
			result = 9;
		} else if ((fecha1.getMonth() == 11 && fecha1.getDate() >= 22)
				|| (fecha1.getMonth() == 0 && fecha1.getDate() <= 20)) {
			//System.out.println("Capricornio");
			result = 10;
		} else if ((fecha1.getMonth() == 0 && fecha1.getDate() >= 21)
				|| (fecha1.getMonth() == 1 && fecha1.getDate() <= 18)) {
			//System.out.println("Acuario");
			result = 11;
		} else if ((fecha1.getMonth() == 1 && fecha1.getDate() >= 19)
				|| (fecha1.getMonth() == 2 && fecha1.getDate() <= 20)) {
			//System.out.println("Piscis");
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

class ValueComparator implements Comparator<Integer> {
    Map<Integer, Double> base;

    public ValueComparator(Map<Integer, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(Integer a, Integer b) {
        if (base.get(a) >= base.get(b)) {
        	return -1;
        } else {
        	return 1;
        } // returning 0 would merge keys
    }
}
