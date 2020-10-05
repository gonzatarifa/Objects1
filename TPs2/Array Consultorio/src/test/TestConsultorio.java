package test;

import modelo.Medico;
import modelo.Paciente;

public class TestConsultorio {

	public static void main(String[] args) {
		Paciente paciente1 = new Paciente("José", "Pérez", 1.80f, 85);
		Paciente paciente2 = new Paciente("Jorge", "Fernández", 1.60f, 90);

		Paciente[] pacientesFrecuentes = { paciente1, paciente2 };
		Medico medico1 = new Medico("Daniel", "López", "Clinico", pacientesFrecuentes);

		System.out.println("Visita 1: ");
		System.out.println("\nMedico: " + medico1.getNombre() + " " + medico1.getApellido());
		System.out.println("Paciente " + paciente1.traerNombreCompleto() + ": IMC " + medico1.calcularIMC(paciente1));
		System.out.println("Paciente " + paciente2.traerNombreCompleto() + ": IMC " + medico1.calcularIMC(paciente2));

		System.out.println("\nNuevos metodos: ");
		System.out.println("Promedio peso pacientes: " + medico1.traerPromedioPeso());
		System.out.println("Paciente con mayor estatura: " + medico1.traerPacienteMayorEstatura());
		System.out.println("Paciente con menor IMC: " + medico1.traerMenorIMC());
	}
}
