package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCliente {
	private List<Cliente> lstCliente = new ArrayList<Cliente>();

	public AdmCliente() {
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}

}
