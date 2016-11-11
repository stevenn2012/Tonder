package co.edu.usa.adf.Tonder.datos;

import co.edu.usa.adf.Fix_width_framework.FixedWidthField;

public class Hobbie {

	@FixedWidthField(posicion=0, width=9) private int id;
	@FixedWidthField(posicion=1, width=50) private String nombre;
	
	public Hobbie() {
	}

	public Hobbie(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Hobbie [id=" + id + ", nombre=" + nombre + "]";
	}
}
