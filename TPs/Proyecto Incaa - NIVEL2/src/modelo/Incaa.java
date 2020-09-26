package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	private List<Pelicula> catalogo = new ArrayList<Pelicula>();

	public Incaa() {
	}

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	public Pelicula traerPelicula(int idPelicula) {
		Pelicula p = null;
		int i = 0;
		boolean encontrado = false;
		while (i < catalogo.size() && encontrado == false) {
			if (catalogo.get(i).getIdPelicula() == idPelicula) {
				p = catalogo.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}

	public Pelicula traerPelicula(String pelicula) {
		Pelicula p = null;
		boolean encontrado = false;
		int i = 0;
		while (i < catalogo.size() && encontrado == false) {
			if (catalogo.get(i).getPelicula().equals(pelicula)) {
				p = catalogo.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}

	public List<Pelicula> traerPelicula(Genero genero) {
		List<Pelicula> p3 = new ArrayList<Pelicula>();
		for(int i=0; i<catalogo.size(); i++) {
			if (catalogo.get(i).getGenero().equals(genero)) {
				p3.add(new Pelicula(catalogo.get(i).getIdPelicula(), catalogo.get(i).getPelicula(),
						catalogo.get(i).getGenero()));
			}
		}
		return p3;

	}

	public boolean agregarPelicula(String pelicula, Genero genero) throws Exception {
		if (traerPelicula(pelicula) != null) {
			throw new Exception("Pelicula ya ingresada");
		} else {
			catalogo.add(new Pelicula(traerId() + 1, pelicula, genero));
			return true;
		}
	}

	public boolean modificarPelicula(int idPelicula, String pelicula, Genero genero) throws Exception {
		Pelicula peliculaEncontrada = traerPelicula(idPelicula);
		if (peliculaEncontrada == null) {
			throw new Exception("La pelicula no existe");
		} else {
			peliculaEncontrada.setIdPelicula(idPelicula);
			peliculaEncontrada.setPelicula(pelicula);
			peliculaEncontrada.setGenero(genero);
			return true;
		}
	}

	public boolean eliminarPelicula(int idPelicula) throws Exception {
		Pelicula peliculaEncontrada = traerPelicula(idPelicula);
		if (peliculaEncontrada == null) {
			throw new Exception("La pelicula no existe");
		} else {
			catalogo.remove(peliculaEncontrada);
			return true;
		}
	}

	public int traerId() {
		int mayor = 0;
		if (catalogo.size() != 0) {
			mayor = catalogo.get(0).getIdPelicula();
		}
		int actual;
		for (int i = 0; i < catalogo.size(); i++) {
			actual = catalogo.get(i).getIdPelicula();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

}
