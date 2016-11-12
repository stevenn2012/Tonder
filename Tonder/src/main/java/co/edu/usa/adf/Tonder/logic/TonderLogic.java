package co.edu.usa.adf.Tonder.logic;

import java.util.ArrayList;
import java.util.Date;

import co.edu.usa.adf.Tonder.datos.Persona;

public class TonderLogic {
	
	private AdminDatos admin;
	
	public TonderLogic() {
		System.out.println("Cargando... ");
		admin = new AdminDatos();
		System.out.println("Welcome to Tonder");
		
		System.out.println("Filtrando...");
		ArrayList<Persona> fil = filtro(admin.personas.getDato(0));
		for (int i = 0; i < fil.size(); i++) {
			System.out.println(fil.get(i));
			System.out.println("\t Porcentaje color: "+compareColor(admin.personas.getDato(0), fil.get(i)));
			System.out.println("\t Porcentaje edad: "+compareEdad(admin.personas.getDato(0), fil.get(i)));
			System.out.println("\t Porcentaje Hobbies: "+compareHobbies(admin.personas.getDato(0), fil.get(i)));
			System.out.println();
		}
	}

	public ArrayList<Persona> filtro(Persona persona){
		ArrayList<Persona> listaPersonas = admin.personas.getDatos();
		ArrayList<Persona> filtroPersonas = new ArrayList<Persona>();
		for (int i = 0; i < listaPersonas.size(); i++) {
			boolean valid = true;
			if(!listaPersonas.get(i).getPais().equalsIgnoreCase(persona.getPais())) valid = false;
			if(!listaPersonas.get(i).getCiudad().equalsIgnoreCase(persona.getCiudad())) valid = false;
			if(listaPersonas.get(i).getSexo() != persona.getOrientacionSexual()) valid = false;
			if(valid) filtroPersonas.add(listaPersonas.get(i));
		}
		System.out.println("Se obtuvieron: "+filtroPersonas.size()+" / "+listaPersonas.size()+" personas");
		return filtroPersonas;
	}
	
	public double compareZodiaco(Persona persona1, Persona persona2){
		return 0;
	}
	
	public double compareEdad(Persona persona1, Persona persona2){
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
		long edadM = 0, edadF = 0 ;
		if(persona1.getSexo()=='M' && persona2.getSexo()=='F'){
			edadM = ((new Date().getTime() - persona1.getFechaNacimiento().getTime())/MILLSECS_PER_DAY)/365;
			edadF = ((new Date().getTime() - persona2.getFechaNacimiento().getTime())/MILLSECS_PER_DAY)/365;
		}else if(persona2.getSexo()=='M' && persona1.getSexo()=='F'){
			edadM = ((new Date().getTime() - persona2.getFechaNacimiento().getTime())/MILLSECS_PER_DAY)/365;
			edadF = ((new Date().getTime() - persona1.getFechaNacimiento().getTime())/MILLSECS_PER_DAY)/365;
		}else{
			edadM = ((new Date().getTime() - persona2.getFechaNacimiento().getTime())/MILLSECS_PER_DAY)/365;
			edadF = ((new Date().getTime() - persona1.getFechaNacimiento().getTime())/MILLSECS_PER_DAY)/365;
			System.out.println("\t * Edades -> M: "+edadM+", F: "+edadF);
			if((edadF >= ((edadM/2)+7)) || (edadM >= ((edadF/2)+7))) return 20;
			else return 0;
		}
		System.out.println("\t * Edades -> M: "+edadM+", F: "+edadF);
		if(edadF >= ((edadM/2)+7)) return 20;
		else return 0;
	}
	
	public double compareHobbies(Persona persona1, Persona persona2){
		double porcent = 0;
		try {
			for (int i = 0; i < persona1.getHobbies().size(); i++)
				for (int j = 0; j < persona2.getHobbies().size(); j++) 
					if(persona1.getHobbie(i).getNombre().equalsIgnoreCase(persona2.getHobbie(j).getNombre())) porcent+=10;
			return porcent;
		} catch (Exception e) {
			return porcent;
		}
	}
	
	public double compareColor(Persona persona1, Persona persona2){
		if(persona1.getColor().equalsIgnoreCase(persona2.getColor())) return 10;
		else return 0;
	}
}
