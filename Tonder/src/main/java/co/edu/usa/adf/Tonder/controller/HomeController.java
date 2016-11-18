package co.edu.usa.adf.Tonder.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.edu.usa.adf.Tonder.datos.Hobbie;
import co.edu.usa.adf.Tonder.datos.Person;
import co.edu.usa.adf.Tonder.datos.Persona;
import co.edu.usa.adf.Tonder.logic.AdminDatos;
import co.edu.usa.adf.Tonder.logic.TonderLogic;

@Controller
public class HomeController {
	public TonderLogic datos = new TonderLogic();

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
		System.out.println("fechaaaa " + persona.getFechaNacimiento());

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
		System.out.println("nombre " + persona.getNombre());
		System.out.println("apellido " + persona.getApellido());
		System.out.println("usuario " + persona.getUsuario());
		System.out.println("password" + persona.getPassword());
		System.out.println("corre " + persona.getCorreo());
		System.out.println("sexo " + persona.getSexo());
		System.out.println("orientacion " + persona.getOrientacionSexual());

		System.out.println("fecha de nacimiento " + persona.getFechaNacimiento());
		System.out.println("color " + persona.getColor());
		System.out.println("about " + persona.getAbout());
		System.out.println("pais " + persona.getPais());
		System.out.println("ciudad " + persona.getCiudad());
		// handleFormUpload(file);
		System.out.println("ruta imagen " + persona.getRutaImagen());
		System.out.println("hobbie1 " + persona.getHobbie1());
		System.out.println("hobbie2 " + persona.getHobbie2());
		System.out.println("hobbie3 " + persona.getHobbie3());
		System.out.println("hobbie4 " + persona.getHobbie4());

		Persona per = new Persona(0, persona.getNombre(), persona.getApellido(), persona.getUsuario(),
				persona.getPassword(), persona.getCorreo(), persona.getSexo(), persona.getOrientacionSexual(),
				persona.getFechaNacimiento(), persona.getColor(), persona.getAbout(), persona.getPais(),
				persona.getCiudad(), persona.getRutaImagen());
		int idPersona = datos.admin.savePersons(per);

		ArrayList<Hobbie> hobbies = new ArrayList<Hobbie>();
		hobbies.add(new Hobbie(0, persona.getHobbie1()));
		hobbies.add(new Hobbie(0, persona.getHobbie2()));
		hobbies.add(new Hobbie(0, persona.getHobbie3()));
		hobbies.add(new Hobbie(0, persona.getHobbie4()));
		ArrayList<Integer> idHobbies = new ArrayList<Integer>();
		idHobbies = datos.admin.saveHobbies(hobbies);
		datos.admin.savePersonaHobbies(idPersona, idHobbies);
		return "home";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
