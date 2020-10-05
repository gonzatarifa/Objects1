package test;

import modelo.Incaa;

public class TestIncaa {

	public static void main(String[] args) {
		Incaa i1 = new Incaa();
		try {
			System.out.println("Peliculas agregadas");
			System.out.println("**************1*****************");
			System.out.println(i1.agregarPelicula("Star Wars 3"));
			System.out.println("**************2*****************");
			System.out.println(i1.agregarPelicula("Tron"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("**************3*****************");
			System.out.println(i1.agregarPelicula("El redentor"));
			System.out.println("**************4*****************");
			System.out.println(i1.agregarPelicula("Guardianes de la galaxia"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(" ");
		System.out.println("Peliculas por Id");
		System.out.println("**************5*****************");
		System.out.println(i1.traerPelicula(1));
		System.out.println("**************6*****************");
		System.out.println(i1.traerPelicula(2));
		System.out.println("**************7*****************");
		System.out.println(i1.traerPelicula(3));
		System.out.println("**************8*****************");
		System.out.println(i1.traerPelicula(4));
		System.out.println(" ");
		System.out.println("Peliculas por parte");
		System.out.println("**************9*****************");
		System.out.println(i1.traerPelicula("Star"));
		System.out.println("**************10****************");
		System.out.println(i1.traerPelicula("Tr"));
		System.out.println("**************11****************");
		System.out.println(i1.traerPelicula("El reden"));
		System.out.println("**************12****************");
		System.out.println(i1.traerPelicula("Guardianes"));
		System.out.println(" ");
		System.out.println("Modificar peliculas");

		try {
			System.out.println("**************13****************");
			System.out.println(i1.modificarPelicula(1, "La era de hielo"));
			System.out.println("**************14****************");
			System.out.println(i1.modificarPelicula(2, "Karate kid 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(" ");
		System.out.println("Traer peliculas modificadas");
		System.out.println("**************15****************");
		System.out.println(i1.traerPelicula(1));
		System.out.println("**************16****************");
		System.out.println(i1.traerPelicula(2));
		System.out.println(" ");
		System.out.println("Eliminar peliculas");

		try {
			System.out.println("**************17****************");
			System.out.println(i1.eliminarPelicula(1));
			System.out.println("**************18****************");
			System.out.println(i1.eliminarPelicula(6));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
