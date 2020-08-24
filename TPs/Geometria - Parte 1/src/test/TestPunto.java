package test;

import modelo.Punto;

public class TestPunto {

	public static void main(String[] args) {
		Punto p1 = new Punto(1, 2);
		Punto p2 = new Punto(3, 4);

		System.out.println("El primer punto es: " + p1.toString());
		System.out.println("El segundo punto es: " + p2.toString());
		System.out.println("Iguales: " + p1.equals(p2));
	}
}
