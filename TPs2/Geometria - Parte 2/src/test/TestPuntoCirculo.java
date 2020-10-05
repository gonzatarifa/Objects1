package test;

import modelo.Circulo;
import modelo.Punto;

public class TestPuntoCirculo {

	public static void main(String[] args) {
		Punto p1 = new Punto(1,2);
		Punto p2 = new Punto(3,4);
		
		Circulo c1 = new Circulo(p1,2);
		Circulo c2 = new Circulo(p2,3);
		
		System.out.println("Punto:");
		System.out.println("Coordenadas punto1: "+ p1.toString());
		System.out.println("Coordenadas punro2: "+p2.toString());
		System.out.println("Los puntos son iguales: " + p1.equals(p2));
		System.out.println("La distancia entre los puntos es: " + p1.calcularDistancia(p2));
		System.out.println(" ");
		System.out.println("Circulo:");
		System.out.println("Coordenadas circulo1: " + c1.toString());
		System.out.println("Coordenadas circulo2: " + c2.toString());
		c1.setRadio(p2.getX());
		c2.setRadio(p1.getY());
		System.out.println("Coordenadas circulo1: " + c1.toString());
		System.out.println("Coordenadas circulo2: " + c2.toString());
		System.out.println("Calcular perimetro circulo1: " + c1.calcularPerimetro());
		System.out.println("Calcular perimetro circulo2: " + c2.calcularPerimetro());
		System.out.println("Calcular area circulo1: " + c1.calcularArea());
		System.out.println("Calcular area circulo2: " + c2.calcularArea());
		System.out.println("Calcular distancia: " + c1.calcularDistancia(c2));
	
	}

}
