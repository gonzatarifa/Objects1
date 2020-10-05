package test;

import modelo.Numero;

public class TestNumero {

	public static void main(String[] args) {
		Numero n = new Numero(3);
		
		System.out.println("El resultado de la suma es: " + n.sumar(3));
		System.out.println("El resultado de la multiplicacion es: " + n.multiplicar(3));
		System.out.println("Es par: " + n.esPar());
		System.out.println("Es primo: " + n.esPrimo());
		System.out.println("Convertir a String: " + n.convertirAString());
		System.out.println("Convertir a double: " + n.convertirDouble());
		System.out.println("El resultado de la potencia es: " + n.calcularPotencia(2));
		System.out.println("Pasar a base 2: " + n.pasarBase2());
		System.out.println("El factorial es: " + n.calcularFactorial(3));
		System.out.println("El numero combinatorio es: " + n.numeroCombinatorio(2));
		
	}
}
