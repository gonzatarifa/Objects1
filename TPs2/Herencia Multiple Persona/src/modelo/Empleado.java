package modelo;

import java.time.LocalDate;

public abstract class Empleado extends Persona {
	private long legajo;

	public Empleado(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo) {
		super(nombre, apellido, dni, fechaNacimiento);
		this.legajo = legajo;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}
	
	public float calcularSueldo() {
		float cantHoras= 4.0f;
		float sueldoXHora = 1500.0f;
		return cantHoras * sueldoXHora;
	}

}
