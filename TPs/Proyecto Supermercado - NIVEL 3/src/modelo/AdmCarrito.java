package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCarrito {
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();

	public AdmCarrito() {
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

}
