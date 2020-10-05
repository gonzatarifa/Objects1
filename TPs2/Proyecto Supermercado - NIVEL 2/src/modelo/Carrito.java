package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItemCarrito = new ArrayList<ItemCarrito>(4);
	private Cliente cliente;

	public Carrito() {
	}

	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItem(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItemCarrito="
				+ lstItemCarrito + ", cliente=" + cliente + "]";
	}

	public boolean agregarItem(Producto producto, int cantidad) throws Exception {
		boolean agregado = false;
		if (traerItemCarrito(producto) != null) {
			traerItemCarrito(producto).setCantidad(traerItemCarrito(producto).getCantidad() + cantidad);
		} else {
			lstItemCarrito.add(new ItemCarrito(traerIdItemCarrito() +1, producto, cantidad));
			agregado = true;
		}
		return agregado;
	}

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		ItemCarrito itemEncontrado = traerItemCarrito(producto);
		if (itemEncontrado == null) {
			throw new Exception("El item no existe");
		} else if (cantidad < itemEncontrado.getIdItem()) {
			itemEncontrado.setCantidad((itemEncontrado.getCantidad() - cantidad));
		} else if (itemEncontrado.getCantidad() == cantidad) {
			lstItemCarrito.remove(itemEncontrado);
			return true;
		}
		return false;
	}

	public int traerIdItemCarrito() {
		int mayor = 0;
		if (lstItemCarrito.size() != 0) {
			mayor = lstItemCarrito.get(0).getIdItem();
		}
		int actual;
		for (int i = 0; i < lstItemCarrito.size(); i++) {
			actual = lstItemCarrito.get(i).getIdItem();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

	public ItemCarrito traerItemCarrito(int idItem) {
		ItemCarrito it = null;
		for (int i = 0; i < lstItemCarrito.size(); i++) {
			if (lstItemCarrito.get(i).getIdItem() == idItem) {
				it = lstItemCarrito.get(i);
			}
		}
		return it;
	}

	public ItemCarrito traerItemCarrito(Producto producto) {
		ItemCarrito it = null;
		for (int i = 0; i < lstItemCarrito.size(); i++) {
			if (lstItemCarrito.get(i).getProducto().equals((producto))) {
				it = lstItemCarrito.get(i);
			}
		}
		return it;
	}

	public float calcularTotal() {
		float total = 0;
		for (int i = 0; i < lstItemCarrito.size(); i++) {
			total = total + lstItemCarrito.get(i).calcularSubTotal();
		}
		return total;
	}
}
