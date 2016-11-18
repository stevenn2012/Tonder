package co.edu.usa.adf.Tonder.datos;

import java.util.Date;

import co.edu.usa.adf.Fix_width_framework.FixedWidthField;

public class Person {
	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String password;
	private String correo;
	private char sexo; // M or F
	private char orientacionSexual; // M or F
	private Date fechaNacimiento;
	private String color;
	private String about;
	private String pais;
	private String ciudad;
	private String rutaImagen;
	private String hobbie1;
	private String hobbie2;
	private String hobbie3;
	private String hobbie4;

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

	public String getHobbie1() {
		return hobbie1;
	}

	public void setHobbie1(String hobbie1) {
		this.hobbie1 = hobbie1;
	}

	public String getHobbie2() {
		return hobbie2;
	}

	public void setHobbie2(String hobbie2) {
		this.hobbie2 = hobbie2;
	}

	public String getHobbie3() {
		return hobbie3;
	}

	public void setHobbie3(String hobbie3) {
		this.hobbie3 = hobbie3;
	}

	public String getHobbie4() {
		return hobbie4;
	}

	public void setHobbie4(String hobbie4) {
		this.hobbie4 = hobbie4;
	}

}
