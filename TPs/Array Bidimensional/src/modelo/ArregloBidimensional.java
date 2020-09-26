package modelo;

public class ArregloBidimensional {
	private double[][] matrizA;

	public ArregloBidimensional(double[][] matrizA) {
		super();
		this.matrizA = matrizA;
	}

	public double[][] getMatrizA() {
		return matrizA;
	}

	public void setMatrizA(double[][] matrizA) {
		this.matrizA = matrizA;
	}

	public double[][] sumar(double[][] matrizB) {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				matrizB[i][j] = matrizA[i][j] + matrizB[i][j];
			}
		}
		return matrizB;
	}

	public double[][] restar(double[][] matrizB) {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				matrizB[i][j] = matrizA[i][j] - matrizB[i][j];
			}
		}
		return matrizB;
	}

	public double[][] transpuesta() {
		double aux;
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < i; j++) {
				aux = matrizA[i][j];
				matrizA[i][j] = matrizA[j][i];
				matrizA[j][i] = aux;
			}
		}
		return matrizA;
	}

	public double[][] multiplicar(double numero) {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				matrizA[i][j] = numero * matrizA[i][j];
			}
		}
		return matrizA;
	}

	public double[][] multiplicar(double[][] matrizB) {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				matrizB[i][j] = matrizA[i][j] * matrizB[i][j];
			}
		}
		return matrizB;
	}
}
