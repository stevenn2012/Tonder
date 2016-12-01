package com.edu.usa.adf.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.usa.adf.Tonder.datos.Hobbie;
import co.edu.usa.adf.Tonder.datos.Person;
import co.edu.usa.adf.Tonder.datos.Persona;
import co.edu.usa.adf.Tonder.logic.AdminDatos;
import co.edu.usa.adf.Tonder.logic.TonderLogic;
import junit.framework.TestCase;

public class Test extends TestCase{
	
	TonderLogic logic= new TonderLogic();
	
	public void testValidarUsuario(){
		
		
		String usuario= "stevenn2012";
		String pass= "123456";
		assertEquals(1, logic.validarUsuario(usuario, pass));
	}
	
	public void testFiltro(){
		TonderLogic logic= new TonderLogic();
		
		Persona persona= new Persona();
		persona.setPais("US");
		persona.setCiudad("CA");
		persona.setOrientacionSexual('M');
		
		ArrayList<Persona> result= logic.filtro(persona);
		assertEquals(3, result.size());
		
	}
	
	public void testHobbiesCompatibilidad(){
		Persona p1= new Persona();
		Persona p2= new Persona();
		Hobbie h1= new Hobbie();
		Hobbie h2= new Hobbie();
		Hobbie h3= new Hobbie();
		Hobbie h4= new Hobbie();
		Hobbie h5= new Hobbie();
		Hobbie h6= new Hobbie();
		Hobbie h7= new Hobbie();
		Hobbie h8= new Hobbie();
		ArrayList<Hobbie> hobbies=new ArrayList<Hobbie>();
		h1.setNombre("bailar");
		h1.setId(1);
		p1.addHobbie(h1);
		h2.setNombre("musica");
		h2.setId(2);
		p1.addHobbie(h2);
		h3.setNombre("leer");
		h3.setId(3);
		p1.addHobbie(h3);
		h4.setNombre("jugar");
		h4.setId(4);
		p1.addHobbie(h4);
		
		
		
		h5.setNombre("caminar");
		h5.setId(1);
		p2.addHobbie(h5);
		h6.setNombre("musica");
		h6.setId(2);
		p2.addHobbie(h6);
		h7.setNombre("leer");
		h7.setId(3);
		p2.addHobbie(h7);
		h8.setNombre("viajar");
		h8.setId(4);
		p2.addHobbie(h8);
		
		assertEquals(20.0, logic.compareHobbies(p1, p2), 0);
		
	}
	
	
	public void testZodiaco(){
		Persona p1= new Persona();
		Persona p2= new Persona();
		
			Date d1= new Date();
			d1.setMonth(10);
			d1.setDate(8);
			Date d2= new Date();
			d2.setMonth(9);
			d2.setDate(11);
			p1.setFechaNacimiento(d1);
			p2.setFechaNacimiento(d2);
		
		assertEquals(18.75, logic.compareZodiaco(p1, p2), 0);
		
	}

	
	public void testCompareColor(){
		Persona p1= new Persona();
		Persona p2= new Persona();
		
		p1.setColor("azul");
		p2.setColor("negro");
		
		assertEquals(0.0, logic.compareColor(p1, p2));
	}
}
