package co.edu.usa.adf.Tonder.logic;

import java.util.ArrayList;
import co.edu.usa.adf.Fix_width_framework.FrameWidth;
import co.edu.usa.adf.Tonder.datos.Hobbie;
import co.edu.usa.adf.Tonder.datos.Persona;
import co.edu.usa.adf.Tonder.datos.PersonaHobbie;

public class AdminDatos {
	public FrameWidth<Persona> personas;
	public FrameWidth<PersonaHobbie> personaHobbies;
	public FrameWidth<Hobbie> hobbies;

	public AdminDatos() {
		initPersistence();
	}

	public void cargarDatos() {
		try {
			personas.leerArchivo();
			hobbies.leerArchivo();
			personaHobbies.leerArchivo();
			innerPersonaHobbies();
		} catch (Exception e) {
			System.out.println("CargarDatos error: " + e);
		}
	}

	public void initPersistence() {
		try {
			personas = new FrameWidth<Persona>("datos/descriptores/dPersona.txt");
			personaHobbies = new FrameWidth<PersonaHobbie>("datos/descriptores/dPersonaHobbie.txt");
			hobbies = new FrameWidth<Hobbie>("datos/descriptores/dHobbie.txt");
		} catch (Exception e) {
			System.out.println("initPersistence error: " + e);
		}
	}
	
	public int savePersons(Persona persona) {
		try {
			persona.setPassword(EncriptacionMD5.getMD5(persona.getPassword()));
			persona.setId(personas.size() + 1);
			personas.add(persona);
			personas.guardarDatos(false);
			for (int i = 0; i < personas.size(); i++)
				System.out.println(personas.getDato(i));
		} catch (Exception e) {
			System.out.println("savePersons error: " + e);
		}
		return persona.getId();
	}

	public ArrayList<Integer> saveHobbies(ArrayList<Hobbie> hobbies) {
		try {
			ArrayList<Integer> size = new ArrayList<Integer>();
			for (Hobbie a : hobbies) {
				a.setId(this.hobbies.size());
				size.add(a.getId());
				this.hobbies.add(a);
			}
			this.hobbies.guardarDatos(false);
			return size;
		} catch (Exception e) {
			System.out.println("SaveHobbies error: " + e);
			return null;
		}

	}

	public void savePersonaHobbies(int idPersona , ArrayList<Integer> idHobbies) {
		try {
			
			for (Integer a : idHobbies){
				personaHobbies.add(new PersonaHobbie(idPersona,a));
			}

			personaHobbies.guardarDatos(false);
			innerPersonaHobbies();
		} catch (Exception e) {
			System.out.println("savePersonaHobbies error : " + e);
			e.printStackTrace();
		}
	}

	public void innerPersonaHobbies() {
		try {
			for (int i = 0; i < personaHobbies.size(); i++) {
				PersonaHobbie phobie = personaHobbies.getDato(i);
				Hobbie hobbie = null;
				for (int j = 0; j < hobbies.size(); j++) {
					if (hobbies.getDato(j).getId() == phobie.getIdHobbie()) {
						hobbie = hobbies.getDato(j);
						break;
					}
				}
				for (int j = 0; j < personas.size(); j++) {
					if (personas.getDato(j).getId() == phobie.getIdPersona()) {
						Persona persona = personas.getDato(j);
						persona.addHobbie(hobbie);
						personas.setDato(j, persona);
						break;
					}
				}
			}
			System.out.println("::::::::::::::::: Datos a Trabajar ::::::::::::::::::");
			for (int i = 0; i < personas.size(); i++)
				System.out.println(personas.getDato(i));
		} catch (Exception e) {
			System.out.println("innerPersonaHobbies error: " + e);
		}
	}
}
