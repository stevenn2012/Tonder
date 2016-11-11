package co.edu.usa.adf.Tonder.datos;

import co.edu.usa.adf.Fix_width_framework.FixedWidthField;

public class PersonaHobbie {

	@FixedWidthField(posicion=0, width=9) private int idPersona;
	@FixedWidthField(posicion=1, width=9) private int idHobbie;
	
	public PersonaHobbie() {
	}
	
	public PersonaHobbie(int idPersona, int idHobbie) {
		super();
		this.idPersona = idPersona;
		this.idHobbie = idHobbie;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdHobbie() {
		return idHobbie;
	}

	public void setIdHobbie(int idHobbie) {
		this.idHobbie = idHobbie;
	}

	@Override
	public String toString() {
		return "PersonaHobbie [idPersona=" + idPersona + ", idHobbie=" + idHobbie + "]";
	}
}
