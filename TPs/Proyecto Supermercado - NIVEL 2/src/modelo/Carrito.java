package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem = new ArrayList<ItemCarrito>();
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

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente + "]";
	}

	public boolean agregarItem(Producto producto, int cantidad) {
		lstItem.add(new ItemCarrito(traerIdItemCarrito() + 1, producto, cantidad));
		return true;
	}

	public boolean eliminarItem(Producto producto, int cantidad) {
		ItemCarrito itemEncontrado = traerItemCarrito(producto);
		lstItem.remove(itemEncontrado);
		return true;
	}

	public ItemCarrito traerItemCarrito(Producto producto) {
		ItemCarrito it = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstItem.size() && encontrado == false) {
			if (lstItem.get(i).getProducto().equals(producto)) {
				it = lstItem.get(i);
				encontrado = true;
			}
			i++;
		}
		return it;
	}

	public ItemCarrito traerItemCarrito(int idItem) {
		ItemCarrito it = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstItem.size() && encontrado == false) {
			if (lstItem.get(i).getIdItem() == idItem) {
				it = lstItem.get(i);
				encontrado = true;
			}
			i++;
		}
		return it;
	}

	public int traerIdItemCarrito() {
		int mayor = 0;
		if (lstItem.size() != 0) {
			mayor = lstItem.get(0).getIdItem();
		}
		int actual;
		for (int i = 0; i < lstItem.size(); i++) {
			actual = lstItem.get(i).getIdItem();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

	public float calcularTotal() {
		float total = 0;
		for (int i = 0; i < lstItem.size(); i++) {
			total = total + lstItem.get(i).calcularSubTotal();
		}
		return total;
	}
}
