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

	public boolean agregarPelicula(String pelicula) throws Exception {
		if (traerPelicula(pelicula) != null) {
			throw new Exception("La pelicula ya existe");
		} else {
			catalogo.add(new Pelicula(traerId(), pelicula));
			return true;
		}
	}

	public Pelicula traerPelicula(int idPelicula) {
		Pelicula p = null;
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getIdPelicula() == idPelicula) {
				p = catalogo.get(i);
			}
		}
		return p;
	}

	public Pelicula traerPelicula(String partePelicula) {
		Pelicula p = null;
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getPelicula().contains(partePelicula)) {
				p = catalogo.get(i);
			}
		}
		return p;
	}

	public int traerId() {
		int idPelicula = 1;
		for (int i = 0; i < catalogo.size(); i++) {
			idPelicula = idPelicula + 1;
		}
		return idPelicula;
	}

	public boolean modificarPelicula(int idPelicula, String pelicula) throws Exception {
		Pelicula peliculaEncontrada = traerPelicula(idPelicula);
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("La pelicula no existe");
		} else {
			peliculaEncontrada.setIdPelicula(idPelicula);
			peliculaEncontrada.setPelicula(pelicula);
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

}
