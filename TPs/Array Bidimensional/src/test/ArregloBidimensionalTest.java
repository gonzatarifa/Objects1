package test;

import java.util.Arrays;

import modelo.ArregloBidimensional;

public class ArregloBidimensionalTest {

	public static void main(String[] args) {
		double[][] matrizA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] matrizB = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		ArregloBidimensional matriz1 = new ArregloBidimensional(matrizA);
		System.out.println("Suma: ");
		System.out.println(Arrays.deepToString(matriz1.sumar(matrizB)));
		System.out.println("Resta: ");
		System.out.println(Arrays.deepToString(matriz1.restar(matrizB)));
		System.out.println("Transpuesta: ");
		System.out.println(Arrays.deepToString(matriz1.transpuesta()));
		System.out.println("Producto de un escalar: ");
		System.out.println(Arrays.deepToString(matriz1.multiplicar(3)));
		System.out.println("Multiplicacion de matrices: ");
		System.out.println(Arrays.deepToString(matriz1.multiplicar(matrizB)));

	}
}
