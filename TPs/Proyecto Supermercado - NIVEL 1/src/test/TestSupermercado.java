package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Supermercado;

public class TestSupermercado {
	public static void main(String[] args) {
		Supermercado s1 = new Supermercado();
		Carrito c1 = new Carrito();

		System.out.println("Agregamos productos: ");
		try {
			System.out.println(s1.agregarProducto("Almendras", 10.0f));
			System.out.println(s1.agregarProducto("Bife Angosto", 100.0f));
			System.out.println(s1.agregarProducto("Langostinos", 100.0f));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Traemos productos por id: ");
		System.out.println(s1.traerProducto(1));
		System.out.println(s1.traerProducto(2));
		System.out.println(s1.traerProducto(3));
		System.out.println(" ");
		System.out.println("Traemos productos por nombre: ");
		System.out.println(s1.traerProducto("Almendras"));
		System.out.println(s1.traerProducto("Bife Angosto"));
		System.out.println(s1.traerProducto("Langostinos"));
		System.out.println(" ");
		System.out.println("Modifico productos: ");

		try {
			System.out.println(s1.modificarProducto(1, "Alfajores", 30.0f));
			System.out.println(s1.modificarProducto(2, "Galletitas", 45.0f));
			System.out.println(s1.modificarProducto(3, "Hamburguesas", 200.0f));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Agregamos items: ");
		System.out.println(c1.agregarItem(s1.traerProducto(1), 20));
		System.out.println(c1.agregarItem(s1.traerProducto(2), 4));
		System.out.println(c1.agregarItem(s1.traerProducto(3), 40));
		System.out.println(c1.agregarItem(s1.traerProducto(2), 45));
		System.out.println(" ");
		System.out.println("Agregamos carritos: ");
		try {
			System.out.println(s1.agregarCarrito(LocalDate.of(2020, 4, 26), LocalTime.of(9, 00)));
			System.out.println(s1.agregarCarrito(LocalDate.of(2019, 5, 25), LocalTime.of(9, 30)));
			System.out.println(s1.agregarCarrito(LocalDate.of(2019, 4, 24), LocalTime.of(9, 00)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(s1.traerCarrito(1).agregarItem(s1.traerProducto(1), 300));
		System.out.println(s1.traerCarrito(2).agregarItem(s1.traerProducto(2), 300));
		System.out.println(s1.traerCarrito(3).agregarItem(s1.traerProducto(3), 300));
		System.out.println(s1.traerCarrito(1));
		System.out.println(" ");
		System.out.println("Traemos item carrito por id: ");
		System.out.println(c1.traerItemCarrito(1));
		System.out.println(c1.traerItemCarrito(2));
		System.out.println(c1.traerItemCarrito(3));
		System.out.println(" ");
		System.out.println("Traemos item carrito por producto: ");
		System.out.println(c1.traerItemCarrito(s1.traerProducto(1)));
		System.out.println(c1.traerItemCarrito(s1.traerProducto(2)));
		System.out.println(c1.traerItemCarrito(s1.traerProducto(3)));
		System.out.println(" ");
		System.out.println("Traer total y subtotal");
		System.out.println(c1.traerItemCarrito(1).calcularSubTotal());
		System.out.println(c1.traerItemCarrito(2).calcularSubTotal());
		System.out.println(c1.traerItemCarrito(3).calcularSubTotal());
		System.out.println(c1.calcularTotal());
		System.out.println(" ");
		System.out.println("Eliminamos Items: ");

		System.out.println(" ");
		System.out.println("Traemos los items: ");
		System.out.println(c1.traerItemCarrito(1));
		System.out.println(c1.traerItemCarrito(2));
		System.out.println(c1.traerItemCarrito(3));
		System.out.println(" ");
		System.out.println("Eliminamos los items: ");
		try {
			System.out.println(c1.eliminarItem(s1.traerProducto(1), 20));
			System.out.println(c1.eliminarItem(s1.traerProducto(2), 5));
			System.out.println(c1.eliminarItem(s1.traerProducto(3), 40));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Eliminamos los carritos: ");
		try {
			System.out.println(s1.eliminarCarrito(1));
			System.out.println(s1.eliminarCarrito(2));
			System.out.println(s1.eliminarCarrito(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(" ");
		System.out.println("Eliminamos los productos: ");
		try {
			System.out.println(s1.eliminarProducto(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(s1.eliminarProducto(2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(s1.eliminarProducto(3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
