package modelo;

public class Punto {
	private double x;
	private double y;

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Punto p) {
		return ((x == p.getX()) && (y == p.getY()));
	}

	public double calcularDistancia(Punto p) {
		double op1, op2, distancia;
		op1 = Math.pow(this.x - p.getX(), 2);
		op2 = Math.pow(this.y - p.getY(), 2);
		distancia = Math.sqrt(op1 + op2);
		return distancia;
	}

}
