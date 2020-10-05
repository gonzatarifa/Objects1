package modelo;

import java.time.LocalDate;

public class Vendedor extends Empleado implements IPorComision {
	private Cliente cartera;
	private float comisionPorcentual;

	public Vendedor(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo, Cliente cartera,
			float comisionPorcentual) {
		super(nombre, apellido, dni, fechaNacimiento, legajo);
		this.cartera = cartera;
		this.comisionPorcentual = comisionPorcentual;
	}

	public Cliente getCartera() {
		return cartera;
	}

	public void setCartera(Cliente cartera) {
		this.cartera = cartera;
	}

	public float getComisionPorcentual() {
		return comisionPorcentual;
	}

	public void setComisionPorcentual(float comisionPorcentual) {
		this.comisionPorcentual = comisionPorcentual;
	}

	@Override
	public float calcularComision() {
		float ventas= 345.50f;
		return ventas * comisionPorcentual;
	}

	

}
