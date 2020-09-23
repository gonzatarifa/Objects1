package modelo;

public class Circulo {
	private Punto origen;
	private double radio;

	public Circulo(Punto origen, double radio) {
		super();
		this.origen = origen;
		this.radio = radio;
	}

	public Punto getOrigen() {
		return origen;
	}

	public void setOrigen(Punto origen) {
		this.origen = origen;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public void setRadio(Punto radio) {
	}

	public boolean equals(Circulo c) {
		return ((origen.equals(c.getOrigen())) && (this.radio == c.getRadio()));
	}

	public String toString() {
		return "(" + origen + "," + radio + ")";
	}

	public double calcularPerimetro() {
		return 2 * Math.PI * radio;
	}

	public double calcularArea() {
		return Math.PI * Math.pow(radio, 2);
	}

	public double calcularDistancia(Circulo c) {
		double op1, op2, distancia;
		op1 = Math.pow(origen.getX() - c.origen.getX(), 2);
		op2 = Math.pow(origen.getY() - c.origen.getY(), 2);
		distancia = Math.sqrt(op1 + op2);
		return distancia;
	}
}