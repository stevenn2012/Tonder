package co.edu.usa.adf.Tonder.logic;

import java.util.Date;

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
		savePersons();
		saveHobbies();
		savePersonaHobbies();
		innerPersonaHobbies();
	}
	
	public void cargarDatos(){
		try {
			personas.leerArchivo();
			hobbies.leerArchivo();
			personaHobbies.leerArchivo();
			innerPersonaHobbies();
		} catch (Exception e) {
			System.out.println("CargarDatos error: "+e);
		}
	}

	public void initPersistence(){
		try {
			personas = new FrameWidth<Persona>("datos/descriptores/dPersona.txt");
			personaHobbies = new FrameWidth<PersonaHobbie>("datos/descriptores/dPersonaHobbie.txt");
			hobbies = new FrameWidth<Hobbie>("datos/descriptores/dHobbie.txt");
		} catch (Exception e) {
			System.out.println("initPersistence error: "+e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void savePersons(){
		try {
			personas.add(new Persona(0, "Steven", "Puerto", "Stevenn2012", "abc123", "2012stevenn@gmail.com", 'M', 'F', new Date(94, 7, 26), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(1, "Mario", "Ortega", "bellyoz", "abc1234", "2012stevenn@gmail.com", 'M', 'F', new Date(95, 0, 20), "negro", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(2, "Santiago", "Sanchez", "thiago", "abc1235", "2012stevenn@gmail.com", 'M', 'F', new Date(95, 1, 21), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(3, "Natalia", "Narvaez", "naty", "abc1236", "2012stevenn@gmail.com", 'F', 'M', new Date(95, 2, 22), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(4, "Juliana", "Diaz", "julidr", "abc1237", "2012stevenn@gmail.com", 'F', 'M', new Date(96, 3, 23), "blue", "asdf .l.", "Colombia", "Villao", "C:/"));
			personas.add(new Persona(5, "Miguel", "Rivera", "migey", "abc1238", "2012stevenn@gmail.com", 'M', 'F', new Date(96, 4, 24), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(6, "Juan Felipe", "Torres", "juanfe", "abc1239", "2012stevenn@gmail.com", 'M', 'F', new Date(97, 5, 25), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(7, "Daniel", "Junca", "sawdark", "abc1230", "2012stevenn@gmail.com", 'M', 'F', new Date(97, 6, 26), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(8, "Daniela", "Pedraza", "juvia", "abc1231", "2012stevenn@gmail.com", 'F', 'M', new Date(98, 7, 27), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(9, "Jeimy", "Ladino", "aleladino", "abc1232", "2012stevenn@gmail.com", 'F', 'M', new Date(98, 8, 28), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(10, "Jeniffer", "Aguirre", "jenyA", "abc1233", "2012stevenn@gmail.com", 'F', 'M', new Date(99, 9, 29), "blue", "asdf .l.", "Venezuela", "Bogotá", "C:/"));
			personas.add(new Persona(11, "Camila", "Morales", "camim", "abc1234", "2012stevenn@gmail.com", 'F', 'M', new Date(99, 10, 30), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			personas.add(new Persona(12, "Juliana", "Murillo", "juli2", "abc1235", "2012stevenn@gmail.com", 'F', 'M', new Date(95, 11, 31), "blue", "asdf .l.", "Colombia", "Bogotá", "C:/"));
			
			personas.guardarDatos(false);
			for (int i = 0; i < personas.size(); i++) System.out.println(personas.getDato(i));
		} catch (Exception e) {
			System.out.println("savePersons error: "+e);
		}
	}

	private void saveHobbies() {
		try {
			hobbies.add(new Hobbie(0, "Estudiar"));
			hobbies.add(new Hobbie(1, "Viajar"));
			hobbies.add(new Hobbie(2, "Jugar video juegos"));
			hobbies.add(new Hobbie(3, "Leer"));
			hobbies.add(new Hobbie(4, "Comer"));
			hobbies.add(new Hobbie(5, "Dormir"));
			hobbies.add(new Hobbie(6, "Caminar"));
			hobbies.add(new Hobbie(7, "Vagar"));
			hobbies.add(new Hobbie(8, "Tomar"));
			hobbies.add(new Hobbie(9, "Bailar"));
			
			hobbies.guardarDatos(false);
			for (int i = 0; i < hobbies.size(); i++) System.out.println(hobbies.getDato(i));
		} catch (Exception e) {
			System.out.println("SaveHobbies error: "+e);
		}
	}
	
	private void savePersonaHobbies() {
		try {
			personaHobbies.add(new PersonaHobbie(0, 0));
			personaHobbies.add(new PersonaHobbie(0, 2));
			personaHobbies.add(new PersonaHobbie(0, 5));
			personaHobbies.add(new PersonaHobbie(0, 7));
			
			personaHobbies.add(new PersonaHobbie(1, 7));
			personaHobbies.add(new PersonaHobbie(1, 4));
			personaHobbies.add(new PersonaHobbie(1, 1));
			personaHobbies.add(new PersonaHobbie(1, 0));
			
			personaHobbies.add(new PersonaHobbie(2, 9));
			personaHobbies.add(new PersonaHobbie(2, 8));
			personaHobbies.add(new PersonaHobbie(2, 7));
			personaHobbies.add(new PersonaHobbie(2, 6));
			
			personaHobbies.add(new PersonaHobbie(3, 3));
			personaHobbies.add(new PersonaHobbie(3, 2));
			personaHobbies.add(new PersonaHobbie(3, 1));
			personaHobbies.add(new PersonaHobbie(3, 9));
			
			personaHobbies.add(new PersonaHobbie(4, 1));
			personaHobbies.add(new PersonaHobbie(4, 8));
			personaHobbies.add(new PersonaHobbie(4, 5));
			personaHobbies.add(new PersonaHobbie(4, 3));
			
			personaHobbies.guardarDatos(false);
			for (int i = 0; i < personaHobbies.size(); i++) System.out.println(personaHobbies.getDato(i));
		} catch (Exception e) {
			System.out.println("savePersonaHobbies error : "+e);
			e.printStackTrace();
		}
	}
	
	private void innerPersonaHobbies(){
		try {
			for (int i = 0; i < personaHobbies.size(); i++) {
				PersonaHobbie phobie = personaHobbies.getDato(i);	
				Hobbie hobbie = null;				
				for (int j = 0; j < hobbies.size(); j++){
					if(hobbies.getDato(j).getId() == phobie.getIdHobbie()){
						hobbie = hobbies.getDato(j);
						break;
					}
				}			
				for (int j = 0; j < personas.size(); j++){
					if(personas.getDato(j).getId() == phobie.getIdPersona()){
						Persona persona = personas.getDato(j);
						persona.addHobbie(hobbie);
						personas.setDato(j, persona);
						break;
					}
				}
			}
			System.out.println("::::::::::::::::: Datos a Trabajar ::::::::::::::::::");
			for (int i = 0; i < personas.size(); i++) System.out.println(personas.getDato(i));
		} catch (Exception e) {
			System.out.println("innerPersonaHobbies error: "+e);
		}
	}
}
