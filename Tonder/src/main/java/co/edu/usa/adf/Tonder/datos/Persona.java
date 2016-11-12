package co.edu.usa.adf.Tonder.datos;

import java.util.ArrayList;
import java.util.Date;

import co.edu.usa.adf.Fix_width_framework.FixedWidthField;

public class Persona {

	@FixedWidthField(posicion=0, width=9) private int id;
	@FixedWidthField(posicion=1, width=50) private String nombre;
	@FixedWidthField(posicion=2, width=50) private String apellido;
	@FixedWidthField(posicion=3, width=20) private String usuario;
	@FixedWidthField(posicion=4, width=20) private String password;
	@FixedWidthField(posicion=5, width=100) private String correo;
	@FixedWidthField(posicion=6, width=1) private char sexo; //M or F
	@FixedWidthField(posicion=7, width=1) private char orientacionSexual; //M or F
	@FixedWidthField(posicion=8, width=11) private Date fechaNacimiento;
	@FixedWidthField(posicion=9, width=15) private String color;
	@FixedWidthField(posicion=10, width=200) private String about;
	@FixedWidthField(posicion=11, width=20) private String pais;
	@FixedWidthField(posicion=12, width=20) private String ciudad;
	@FixedWidthField(posicion=13, width=100) private String rutaImagen;
	
	private ArrayList<Hobbie> hobbies;
	
	public Persona() {
		this.hobbies = new ArrayList<Hobbie>();
	}

	public Persona(int id, String nombre, String apellido, String usuario, String password, String correo, char sexo,
			char orientacionSexual, Date fechaNacimiento, String color, String about, String pais, String ciudad,
			String rutaImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.sexo = sexo;
		this.orientacionSexual = orientacionSexual;
		this.fechaNacimiento = fechaNacimiento;
		this.color = color;
		this.about = about;
		this.pais = pais;
		this.ciudad = ciudad;
		this.rutaImagen = rutaImagen;
		this.hobbies = new ArrayList<Hobbie>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getOrientacionSexual() {
		return orientacionSexual;
	}

	public void setOrientacionSexual(char orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public ArrayList<Hobbie> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<Hobbie> hobbies) {
		this.hobbies = hobbies;
	}
	
	public Hobbie getHobbie(int i) {
		return hobbies.get(i);
	}

	public void addHobbie(Hobbie hobbies) {
		this.hobbies.add(hobbies) ;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario
				+ ", password=" + password + ", correo=" + correo + ", sexo=" + sexo + ", orientacionSexual="
				+ orientacionSexual + ", fechaNacimiento=" + fechaNacimiento + ", color=" + color + ", about=" + about
				+ ", pais=" + pais + ", ciudad=" + ciudad + ", rutaImagen=" + rutaImagen + ", hobbies=" + hobbies + "]";
	}
}
