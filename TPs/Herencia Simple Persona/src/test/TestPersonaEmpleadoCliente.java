package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Persona;

public class TestPersonaEmpleadoCliente {

	public static void main(String[] args) {
		LocalDate fecha1 = LocalDate.of(1996, 04, 26);
		LocalDate fecha2 = LocalDate.now();
		LocalDate fecha3 = LocalDate.of(1995, 12, 20);
		LocalDate fecha4 = LocalDate.of(1987, 03, 27);
		
		Empleado empleado1 = new Empleado("Martin", "Torrents", 39642511, fecha1, 123456789, 30000);
	    Persona persona1 = new Empleado("Martin", "Torrents", 39642511, fecha1, 123456789, 30000);
		Cliente cliente1 = new Cliente("Mariano", "Ribe", 39277077, fecha3, "20-39277077-2", 3200.20f);
		System.out.println(empleado1.getNombre() + " " + empleado1.getApellido() + " es empleado y su edad es "
				+ empleado1.calcularEdad(fecha2));
		System.out.println("Calcular sueldo: " + empleado1.calcularSueldo(12));
		System.out.println(empleado1.hablar());
		System.out.println(cliente1.getNombre() + " " + cliente1.getApellido() + " es cliente y su edad es "
				+ cliente1.calcularEdad(fecha2));
		System.out.println("Estado de credito: " + cliente1.estadoCredito());
		Persona personas[] = new Persona[2];
		personas[0] = new Empleado("Walter", "Gazzanego", 32830433, fecha4, 12345, 30000);
		personas[1] = new Cliente("Mariano", "Ribe", 39277077, fecha3, "20-39277077-2", 3200.20f);

		for (int i = 0; i < 2; i++) {
			Persona persona = personas[i];
			System.out.println(persona);
			System.out.println("Edad: " + persona.calcularEdad(fecha2));
			if (persona instanceof Empleado) {
				Empleado empleado = (Empleado) persona;
				System.out.println("Sueldo: " + empleado.calcularSueldo(2));
			}
		}

	}
}
