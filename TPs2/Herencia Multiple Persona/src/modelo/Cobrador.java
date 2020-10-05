package modelo;

import java.time.LocalDate;

public class Cobrador extends Empleado implements IPorComision {
	private Cliente cartera;
	private float comisionFija;

	public Cobrador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo, Cliente cartera,
			float comisionFija) {
		super(nombre, apellido, dni, fechaNacimiento, legajo);
		this.cartera = cartera;
		this.comisionFija = comisionFija;
	}

	public Cliente getCartera() {
		return cartera;
	}

	public void setCartera(Cliente cartera) {
		this.cartera = cartera;
	}

	public float getComisionFija() {
		return comisionFija;
	}

	public void setComisionFija(float comisionFija) {
		this.comisionFija = comisionFija;
	}

	@Override
	public float calcularComision() {
		float suma = 0;
		suma = suma + comisionFija;
		return suma;
	}

}
