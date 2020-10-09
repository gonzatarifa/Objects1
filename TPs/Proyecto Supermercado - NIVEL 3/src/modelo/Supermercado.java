package modelo;

public class Supermercado {
	private AdmProducto admProducto;
	private AdmCliente admCliente;
	private AdmCarrito admCarrito;

	public Supermercado(AdmProducto admProducto, AdmCliente admCliente, AdmCarrito admCarrito) {
		super();
		this.admProducto = admProducto;
		this.admCliente = admCliente;
		this.admCarrito = admCarrito;
	}

	public AdmProducto getAdmProducto() {
		return admProducto;
	}

	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}

	public AdmCliente getAdmCliente() {
		return admCliente;
	}

	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}

	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}

	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}

}
