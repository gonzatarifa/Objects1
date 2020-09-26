package modelo;

import java.time.LocalDate;

public class Operario extends Empleado implements IPorPresentismo {
	private float valorHora;

	public Operario(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo, float valorHora) {
		super(nombre, apellido, dni, fechaNacimiento, legajo);
		this.valorHora = valorHora;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public int diasAusente() {
		int horasTrabajadas = 4;
		float sueldoXDia = horasTrabajadas * valorHora;
		float SueldoXMes = sueldoXDia * 31;
		int diasAusente = 4;
		float sueldoXDiasAusente = sueldoXDia * diasAusente;
		return (int) (SueldoXMes - sueldoXDiasAusente);
		
	}
	
	

}
