package test;

import java.time.LocalDate;

import modelo.Administrativo;
import modelo.Cliente;
import modelo.Cobrador;
import modelo.Empleado;
import modelo.Operario;
import modelo.Persona;
import modelo.Vendedor;

public class TestHerenciaMultiple {

	public static void main(String[] args) {

		LocalDate fecha1 = LocalDate.of(1996, 4, 26);
		LocalDate fecha2 = LocalDate.of(1995, 12, 20);
		LocalDate fecha3 = LocalDate.of(1987, 3, 27);
		LocalDate fecha4 = LocalDate.of(2000, 8, 3);
		LocalDate fecha5 = LocalDate.of(1993, 3, 12);
		LocalDate fecha6 = LocalDate.of(1991, 9, 23);

		Persona cliente1 = new Cliente("Martin", "Torrents", 39642511, fecha1, "20-39642511-5", 30000.0f);
		Cliente cliente2 = new Cliente("Mariano", "Ribe", 39277077, fecha2, "20-39277077-2", 30000);
		Empleado cobrador1 = new Cobrador("Walter", "Gazzanego", 32830433, fecha3, 12345678, cliente2, 4200.0f);
		Empleado vendedor1 = new Vendedor("Alejandro", "Torrents", 42828864, fecha4, 123456, cliente2, 4200.0f);
		Empleado administrativo1 = new Administrativo("Mariel", "Torrents", 37277166, fecha5, 1234567, 40000.0f);
		Empleado operario1 = new Operario("Guillermo", "Torrents", 36403567, fecha6, 123456789, 3200.0f);

		System.out.println("La edad de " + cliente1.getNombre() + " " + cliente1.getApellido() + " es: "
				+ cliente1.calcularEdad(LocalDate.now()));
		System.out.println("La edad de " + cliente2.getNombre() + " " + cliente2.getApellido() + " es: "
				+ cliente2.calcularEdad(LocalDate.now()));
		System.out.println("El estado de credito de " + cliente2.getNombre() + " " + cliente2.getApellido() + " es: "
				+ cliente2.estadoCredito());
		System.out.println("El sueldo de " + cobrador1.getNombre() + " " + cobrador1.getApellido() + " es: "
				+ cobrador1.calcularSueldo());
		System.out.println("El sueldo de " + vendedor1.getNombre() + " " + vendedor1.getApellido() + " es: "
				+ vendedor1.calcularSueldo());
		System.out.println("El sueldo de " + administrativo1.getNombre() + " " + administrativo1.getApellido() + " es: "
				+ administrativo1.calcularSueldo());
		System.out.println("El sueldo de " + operario1.getNombre() + " " + operario1.getApellido() + " es: "
				+ operario1.calcularSueldo());
	}

}
