package co.edu.usa.adf.Tonder.logic;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import co.edu.usa.adf.Tonder.datos.Persona;

public class PruebaSort {
	
	public static void main(String[] args){
		Hashtable<Double, Persona> tabla= new Hashtable<Double, Persona>();
		Persona p1= new Persona();
		Persona p2= new Persona();
		Persona p3= new Persona();
		Persona p4= new Persona();
		Persona p5= new Persona();
		Persona p6= new Persona();
		Persona p7= new Persona();
		Persona p8= new Persona();
		Persona p9= new Persona();
		Persona p0= new Persona();
		
		p1.setNombre("Santiago");p1.setApellido("Sanchez");
		p2.setNombre("Mario");p2.setApellido("Ortega");
		p3.setNombre("Steven");p3.setApellido("Puerto");
		p4.setNombre("Michale");p4.setApellido("Leon");
		p5.setNombre("Miguel");p5.setApellido("Rivera");
		p6.setNombre("Nathalia");p6.setApellido("Narvaez");
		p7.setNombre("Paola");p7.setApellido("Sanchez");
		p8.setNombre("Carlos");p8.setApellido("Sanchez");
		p9.setNombre("Juliana");p9.setApellido("Diaz");
		p0.setNombre("Sebastian");p0.setApellido("Diaz");
		
		tabla.put(54.6, p1);
		tabla.put(52.3, p2);
		tabla.put(45.4, p3);
		tabla.put(55.6, p4);
		tabla.put(76.7, p5);
		tabla.put(65.8, p6);
		tabla.put(89.3, p7);
		tabla.put(67.1, p8);
		tabla.put(45.3, p9);
		tabla.put(34.9, p0);
		
		ArrayList<Persona> per= top5Personas(tabla);
		for (Persona persona : per) {
			System.out.println(persona.getNombre()+" "+persona.getApellido());
		}
		
		
	}
	
	private static ArrayList<Persona> top5Personas(Hashtable<Double, Persona> tabla) {
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
}
