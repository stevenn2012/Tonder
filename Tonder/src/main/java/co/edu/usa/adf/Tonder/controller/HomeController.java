package co.edu.usa.adf.Tonder.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import co.edu.usa.adf.Tonder.datos.Hobbie;
import co.edu.usa.adf.Tonder.datos.Person;
import co.edu.usa.adf.Tonder.datos.Persona;
import co.edu.usa.adf.Tonder.logic.TonderLogic;

@Controller
public class HomeController {
	public static TonderLogic datos = new TonderLogic();
	public static TreeMap<Integer, Double> compatible = new TreeMap<Integer, Double>();
	public static Persona persona = null;
	
	@RequestMapping(value = "/inicio" , method = RequestMethod.POST)
	public String session(@ModelAttribute("persona") Person persona , ModelMap model){
		System.out.println(":::::::::::::::::::::::::::Logeo::::::::::::::::::::::::::::");
		model.addAttribute("usuario", persona.getUsuario());
		model.addAttribute("password",persona.getPassword());
		System.out.println(" user "+persona.getUsuario()+", Password "+persona.getPassword());
		
		int id = datos.validarUsuario(persona.getUsuario(), persona.getPassword());
		System.out.println("Id: "+id);
		if(id !=-1){
			HomeController.persona = datos.logearPersona(id);
			compatible = datos.compatibilidad(HomeController.persona);
			System.out.println(HomeController.persona);
			System.out.println(compatible);
			return "plataforma";
		}else{
			return "home";
		}
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView person() {
		return new ModelAndView("home", "persona", new Person());
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String submit(@ModelAttribute("persona") Person persona, BindingResult result, ModelMap model)
			throws IOException {

		model.addAttribute("nombre", persona.getNombre());
		model.addAttribute("apellido", persona.getApellido());
		model.addAttribute("usuario", persona.getUsuario());
		model.addAttribute("password", persona.getPassword());
		model.addAttribute("correo", persona.getCorreo());
		model.addAttribute("sexo", persona.getSexo());
		model.addAttribute("orientacionSexual", persona.getOrientacionSexual());
		model.addAttribute("fechaNacimiento", persona.getFechaNacimiento());

		model.addAttribute("color", persona.getColor());
		model.addAttribute("about", persona.getAbout());
		model.addAttribute("pais", persona.getPais());
		model.addAttribute("ciudad", persona.getCiudad());
		model.addAttribute("rutaImagen", persona.getRutaImagen());
		model.addAttribute("hobbies1", persona.getHobbie1());
		model.addAttribute("hobbien2", persona.getHobbie2());
		model.addAttribute("hobbies3", persona.getHobbie3());
		model.addAttribute("hobbies4", persona.getHobbie4());
		Persona per = new Persona(0, persona.getNombre(), persona.getApellido(), persona.getUsuario(),
				persona.getPassword(), persona.getCorreo(), persona.getSexo(), persona.getOrientacionSexual(),
				persona.getFechaNacimiento(), persona.getColor(), persona.getAbout(), persona.getPais(),
				persona.getCiudad(), persona.getRutaImagen());
		int idPersona = TonderLogic.admin.savePersons(per);

		ArrayList<Hobbie> hobbies = new ArrayList<Hobbie>();
		hobbies.add(new Hobbie(0, persona.getHobbie1()));
		hobbies.add(new Hobbie(0, persona.getHobbie2()));
		hobbies.add(new Hobbie(0, persona.getHobbie3()));
		hobbies.add(new Hobbie(0, persona.getHobbie4()));
		ArrayList<Integer> idHobbies = new ArrayList<Integer>();
		idHobbies = TonderLogic.admin.saveHobbies(hobbies);
		TonderLogic.admin.savePersonaHobbies(idPersona, idHobbies);
		return "home";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
