package test;

import modelo.Medico;
import modelo.Paciente;

public class TestConsultorio2 {
	public static void main(String[] args) {
		Paciente paciente1 = new Paciente("José", "Pérez", 1.80f, 85);
		Paciente paciente2 = new Paciente("Jorge", "Fernández", 1.60f, 90);
		
		Medico medico1 = new Medico("Daniel","López","Clinico");
		
		paciente1.setPeso(0);
		paciente2.setPeso(0);
		
		System.out.println("Visita2:");
		System.out.println("Paciente " + paciente1.traerNombreCompleto() + ": IMC " + medico1.calcularIMC(paciente1));
		System.out.println("Paciente " + paciente2.traerNombreCompleto() + ": IMC " + medico1.calcularIMC(paciente2));
	}
}
