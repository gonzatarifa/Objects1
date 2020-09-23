package modelo;

public class Numero {
	private int n;

	public Numero(int n) {
		super();
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int sumar(int n1) {
		int suma;
		suma = n + n1;
		return suma;
	}

	public int multiplicar(int n1) {
		int multiplicacion;
		multiplicacion = n * n1;
		return multiplicacion;
	}

	public boolean esPar() {
		boolean esPar;
		if (n % 2 == 0) {
			esPar = true;
		} else {
			esPar = false;
		}
		return esPar;
	}

	public boolean esPrimo() {
		boolean esPrimo;
		esPrimo = true;
		int i = 2;
		while (i < n) {
			if (n % i == 0) {
				esPrimo = false;
			}
			i++;
		}
		return esPrimo;
	}

	public String convertirAString() {
		String aString;
		aString = String.valueOf(n);
		return aString;
	}

	public double convertirDouble() {
		double aDouble;
		String aString;
		aString = convertirAString();
		aDouble = Double.parseDouble(aString);
		return aDouble;
	}

	public double calcularPotencia(int exp) {
		double potencia;
		potencia = Math.pow(n, exp);
		return potencia;
	}

	public String pasarBase2() {
		int cociente;
		int resto;
		String resultado;
		cociente = n / 2;
		resto = n % 2;
		resultado = "" + (resto) + "";
		while (cociente != 0) {
			resto = cociente % 2;
			cociente = cociente / 2;
			resultado = "" + (resto) + "" + (resultado) + "";
		}
		return resultado;
	}

	public int calcularFactorial(int n) {
		int factorial = 1;
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				factorial = factorial * i;
			}
		} else if (n == 0) {
			factorial = 1;
		} else {
			factorial = -1;
		}
		return factorial;
	}

	public int numeroCombinatorio(int n1) {
		int resultado = 0;
		if (n > 0 && n1 > 0) {
			if (n > n1) {
				resultado = calcularFactorial(n) / (calcularFactorial(n1) * calcularFactorial(n - n1));
			}
		}
		return resultado;
	}

}
