package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {
	private List<Producto> lstProducto = new ArrayList<Producto>();

	public AdmProducto() {
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

}
