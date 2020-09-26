package modelo;

import java.time.LocalDate;

public class Administrativo extends Empleado implements IPorPresentismo {
	private float sueldoMensual;

	public Administrativo(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo,
			float sueldoMensual) {
		super(nombre, apellido, dni, fechaNacimiento, legajo);
		this.sueldoMensual = sueldoMensual;
	}

	public float getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(float sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

	@Override
	public int diasAusente() {
		int diasAusente = 4;
		float sueldoXDia= sueldoMensual / 31;
		float sueldoXDiasAusente = sueldoXDia * diasAusente;
		return (int) (sueldoMensual - sueldoXDiasAusente);

	}
}
