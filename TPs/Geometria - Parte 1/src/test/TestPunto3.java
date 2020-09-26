package test;

import modelo.Punto;

public class TestPunto3 {

	public static void main(String[] args) {
		Punto p1 = new Punto(1, 2);
		Punto p2 = new Punto(3, 4);
		
		System.out.println("Coordenadas punto1: " + p1.toString());
		System.out.println("Coordenadas punto2: " + p2.toString());
		System.out.println("Iguales: " + p1.equals(p2));
		System.out.println("La distancia entre el punto 1 y 2 es: " + p1.calcularDistancia(p2));

	}
}
