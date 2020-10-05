package modelo;

import java.util.Arrays;

public class ArregloUnidimensional {
	private int[] vector;

	public ArregloUnidimensional(int[] vector) {
		super();
		this.vector = vector;
	}

	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public int traerElMenor() {
		int menor;
		menor = vector[0];
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] < menor) {
				menor = vector[i];
			}
		}
		return menor;
	}

	public int traerElMayor() {
		int mayor;
		mayor = vector[0];
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] > mayor) {
				mayor = vector[i];
			}
		}
		return mayor;
	}

	public double calcularPromedio() {
		double promedio = 0;
		for (int i = 1; i < vector.length; i++) {
			promedio = promedio + vector[i];
		}
		promedio = promedio / vector.length;
		return promedio;
	}

	public int[] ordenarAscendente() {
		int aux;
		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
				if (vector[j] > vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}
		}
		return vector;
	}

	public int[] ordenarDescendente() {
		int aux;
		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
				if (vector[j] < vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}
		}
		return vector;
	}

	public double traerFrecuencia(int numero) {
		int i;
		double cveces = 0;
		double frecuencia = 0;
		for (i = 0; i < vector.length; i++) {
			if (vector[i] == numero) {
				cveces++;
			}
		}
		frecuencia = (cveces / (vector.length));
		return frecuencia;

	}

	public int traerModa() {
		double auxfrecuencia = 0;
		int mayor = 0;
		for (int i = 0; i < vector.length; i++) {
			if (traerFrecuencia(vector[i]) > auxfrecuencia) {
				auxfrecuencia = traerFrecuencia(vector[i]);
				mayor = vector[i];
			}
		}
		return mayor;
	}

	@Override
	public String toString() {
		return "ArregloUnidimensional [vector=" + Arrays.toString(vector) + "]";
	}
	
}
