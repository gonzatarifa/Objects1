package test;

import java.util.Arrays;

import modelo.ArregloUnidimensional;

public class ArregloUnidimensionalTest {

	public static void main(String[] args) {
		int[] vector = { 1, 3, 3, 2, 2, 2 };
		ArregloUnidimensional vec = new ArregloUnidimensional(vector);

		System.out.println(vec);
		System.out.println("Menor: " + vec.traerElMenor());
		System.out.println("Mayor: " + vec.traerElMayor());
		System.out.println("Promedio: " + vec.calcularPromedio());
		System.out.println("Ordenar ascendente: " + Arrays.toString(vec.ordenarAscendente()));
		System.out.println("Ordenar descendente: " + Arrays.toString(vec.ordenarDescendente()));
		System.out.println("Frecuencia: " + vec.traerFrecuencia(2));
		System.out.println("Moda: " + vec.traerModa());
	}
}
