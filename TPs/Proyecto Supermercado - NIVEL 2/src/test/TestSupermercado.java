package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Supermercado;

public class TestSupermercado {
	public static void main(String[] args) {
		Supermercado supermercado1 = new Supermercado();
		Carrito carrito1 = new Carrito();
		System.out.println("Agrego productos: ");
		try {
			System.out.println(supermercado1.agregarProducto("Almendras", 10.0f));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado1.agregarProducto("Tomate", 3.0f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado1.agregarProducto("Cafe", 400.0f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(" ");
		System.out.println("Traigo productos por id: ");
		System.out.println(supermercado1.traerProducto(1));
		System.out.println(supermercado1.traerProducto(2));
		System.out.println(supermercado1.traerProducto(3));

		System.out.println(" ");
		System.out.println("Traigo productos por nombre: ");
		System.out.println(supermercado1.traerProducto("Almendras"));
		System.out.println(supermercado1.traerProducto("Tomate"));
		System.out.println(supermercado1.traerProducto("Cafe"));

		System.out.println(" ");
		System.out.println("Agrego clientes: ");
		try {
			System.out.println(supermercado1.agregarCliente("Martin Torrents", 39642511, "Av juan b justo 3935"));
			System.out.println(supermercado1.agregarCliente("Mariano Ribe", 39277077, "Capello 211"));
			System.out.println(supermercado1.agregarCliente("Walter Gazzanego", 32830433, "Libertad 2345"));
			System.out.println(supermercado1.agregarCliente("Alejandro Torrents", 42828864, "Av juan b justo 3935"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(" ");
		System.out.println("Traigo clientes por id: ");
		System.out.println(supermercado1.traerCliente(1));
		System.out.println(supermercado1.traerCliente(2));
		System.out.println(supermercado1.traerCliente(3));

		System.out.println(" ");
		System.out.println("Traigo clientes por nombre: ");
		System.out.println(supermercado1.traerCliente("Martin Torrents"));
		System.out.println(supermercado1.traerCliente("Mariano Ribe"));
		System.out.println(supermercado1.traerCliente("Walter Gazzanego"));

		System.out.println(" ");
		System.out.println("Agrego carritos: ");
		LocalDate fecha1 = LocalDate.of(2020, 6, 14);
		LocalTime hora1 = LocalTime.of(9, 15);
		LocalDate fecha2 = LocalDate.of(2020, 7, 15);
		LocalTime hora2 = LocalTime.of(9, 30);
		LocalDate fecha3 = LocalDate.of(2020, 8, 16);
		LocalTime hora3 = LocalTime.of(9, 25);
		LocalDate fecha4 = LocalDate.of(2020, 9, 18);
		LocalTime hora4 = LocalTime.of(9, 00);
		try {
			System.out.println(supermercado1.agregarCarrito(fecha1, hora1, supermercado1.traerCliente(1)));
			System.out.println(supermercado1.agregarCarrito(fecha2, hora2, supermercado1.traerCliente(2)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado1.agregarCarrito(fecha3, hora3, supermercado1.traerCliente(3)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println(supermercado1.agregarCarrito(fecha4, hora4, supermercado1.traerCliente(4)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Traigo carritos por fecha: ");
		System.out.println(supermercado1.traerCarrito(fecha4));

		System.out.println(" ");
		System.out.println("Traigo carritos por hora: ");
		System.out.println(supermercado1.traerCarrito(hora4));

		System.out.println(" ");
		System.out.println("Agrego items carrito: ");
		try {
			System.out.println(carrito1.agregarItem(supermercado1.traerProducto(1), 30));
			System.out.println(carrito1.agregarItem(supermercado1.traerProducto(2), 40));
			System.out.println(carrito1.agregarItem(supermercado1.traerProducto(3), 50));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Traigo los items por id: ");
		System.out.println(carrito1.traerItemCarrito(1));
		System.out.println(carrito1.traerItemCarrito(2));
		System.out.println(carrito1.traerItemCarrito(3));

		System.out.println(" ");
		System.out.println("Traigo los items por producto: ");
		System.out.println(carrito1.traerItemCarrito(supermercado1.traerProducto(1)));
		System.out.println(carrito1.traerItemCarrito(supermercado1.traerProducto(2)));
		System.out.println(carrito1.traerItemCarrito(supermercado1.traerProducto(3)));

		System.out.println(" ");
		System.out.println("Calculo los subtotales: ");
		System.out.println(carrito1.traerItemCarrito(1).calcularSubTotal());
		System.out.println(carrito1.traerItemCarrito(2).calcularSubTotal());
		System.out.println(carrito1.traerItemCarrito(3).calcularSubTotal());

		System.out.println(" ");
		System.out.println("Calculo el total: ");
		System.out.println(carrito1.calcularTotal());

		System.out.println(" ");
		System.out.println("Agrego los items al carrito: ");
		try {
			System.out.println(supermercado1.traerCarrito(1).agregarItem(supermercado1.traerProducto(1), 5));
			System.out.println(supermercado1.traerCarrito(1).agregarItem(supermercado1.traerProducto(2), 5));
			System.out.println(supermercado1.traerCarrito(1).agregarItem(supermercado1.traerProducto(3), 5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calculo total por cliente: ");
		try {
			System.out.println(supermercado1.traerCarrito(supermercado1.traerCliente(2))
					.agregarItem(supermercado1.traerProducto(3), 2000));
			System.out.println(supermercado1.traerCarrito(supermercado1.traerCliente(2))
					.agregarItem(supermercado1.traerProducto(2), 40));
			System.out.println(supermercado1.traerCarrito(supermercado1.traerCliente(3))
					.agregarItem(supermercado1.traerProducto(3), 40));
			System.out.println(supermercado1.traerCarrito(supermercado1.traerCliente(4))
					.agregarItem(supermercado1.traerProducto(2), 52));
			System.out.println(supermercado1.calcularTotal(supermercado1.traerCliente(1)));
			System.out.println(supermercado1.calcularTotal(supermercado1.traerCliente(2)));
			System.out.println(supermercado1.calcularTotal(supermercado1.traerCliente(3)));
			System.out.println(supermercado1.calcularTotal(supermercado1.traerCliente(4)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calculo total por dni: ");
		try {
			System.out.println(supermercado1.calcularTotal(39642511));
			System.out.println(supermercado1.calcularTotal(39277077));
			System.out.println(supermercado1.calcularTotal(32830433));
			System.out.println(supermercado1.calcularTotal(42828864));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total entre fechas: ");
		try {
			System.out.println(supermercado1.calcularTotal(fecha1, LocalDate.now()));
			System.out.println(supermercado1.calcularTotal(fecha2, LocalDate.now()));
			System.out.println(supermercado1.calcularTotal(fecha3, LocalDate.now()));
			System.out.println(supermercado1.calcularTotal(fecha4, LocalDate.now()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total por fecha: ");
		try {
			System.out.println(supermercado1.calcularTotal(fecha1));
			System.out.println(supermercado1.calcularTotal(fecha2));
			System.out.println(supermercado1.calcularTotal(fecha3));
			System.out.println(supermercado1.calcularTotal(fecha4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total por dia y anio: ");
		try {
			System.out.println(supermercado1.calcularTotal(6, 2020));
			System.out.println(supermercado1.calcularTotal(7, 2020));
			System.out.println(supermercado1.calcularTotal(8, 2020));
			System.out.println(supermercado1.calcularTotal(9, 2020));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total entre fechas por cliente: ");
		LocalDate fecha5 = LocalDate.of(2020, 5, 13);
		LocalDate fecha6 = LocalDate.of(2020, 5, 14);
		LocalDate fecha7 = LocalDate.of(2020, 5, 15);
		LocalDate fecha8 = LocalDate.of(2020, 5, 16);
		try {
			System.out.println(supermercado1.calcularTotal(fecha5, LocalDate.now(), supermercado1.traerCliente(1)));
			System.out.println(supermercado1.calcularTotal(fecha6, LocalDate.now(), supermercado1.traerCliente(2)));
			System.out.println(supermercado1.calcularTotal(fecha7, LocalDate.now(), supermercado1.traerCliente(3)));
			System.out.println(supermercado1.calcularTotal(fecha8, LocalDate.now(), supermercado1.traerCliente(4)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total por fecha y cliente");
		try {
			System.out.println(supermercado1.calcularTotal(fecha1, supermercado1.traerCliente(1)));
			System.out.println(supermercado1.calcularTotal(fecha2, supermercado1.traerCliente(2)));
			System.out.println(supermercado1.calcularTotal(fecha3, supermercado1.traerCliente(3)));
			System.out.println(supermercado1.calcularTotal(fecha4, supermercado1.traerCliente(4)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total por anio, mes y cliente");
		try {
			System.out.println(supermercado1.calcularTotal(6, 2020, supermercado1.traerCliente(1)));
			System.out.println(supermercado1.calcularTotal(7, 2020, supermercado1.traerCliente(2)));
			System.out.println(supermercado1.calcularTotal(8, 2020, supermercado1.traerCliente(3)));
			System.out.println(supermercado1.calcularTotal(9, 2020, supermercado1.traerCliente(4)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Calcular total por mes, anio y dni");
		try {
			System.out.println(supermercado1.calcularTotal(6, 2020, 39642511));
			System.out.println(supermercado1.calcularTotal(7, 2020, 39277077));
			System.out.println(supermercado1.calcularTotal(8, 2020, 32830433));
			System.out.println(supermercado1.calcularTotal(9, 2020, 42828864));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Elimino items: ");
		try {
			System.out.println(carrito1.eliminarItem(supermercado1.traerProducto(1), 30));
			System.out.println(carrito1.eliminarItem(supermercado1.traerProducto(2), 40));
			System.out.println(carrito1.eliminarItem(supermercado1.traerProducto(3), 50));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Elimino carrito: ");
		try {
			System.out.println(supermercado1.eliminarCarrito(1));
			System.out.println(supermercado1.eliminarCarrito(2));
			System.out.println(supermercado1.eliminarCarrito(3));
			System.out.println(supermercado1.eliminarCarrito(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(" ");
		System.out.println("Elimino productos: ");
		try {
			System.out.println(supermercado1.eliminarProducto(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado1.eliminarProducto(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(supermercado1.eliminarProducto(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Elimino clientes: ");
		try {
			System.out.println(supermercado1.eliminarCliente(1));
			System.out.println(supermercado1.eliminarCliente(2));
			System.out.println(supermercado1.eliminarCliente(3));
			System.out.println(supermercado1.eliminarCliente(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
