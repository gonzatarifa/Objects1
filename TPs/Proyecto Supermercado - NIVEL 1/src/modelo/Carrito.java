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

	public Carrito() {
	}

	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
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

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem + "]";
	}

	public boolean agregarItem(Producto producto, int cantidad) {
		if (traerItemCarrito(producto) != null) {
			traerItemCarrito(producto).setCantidad(traerItemCarrito(producto).getCantidad() + 1);
		} else {
			lstItem.add(new ItemCarrito(traerIdItem() + 1, producto, cantidad));
			return true;
		}
		return false;
	}

	public ItemCarrito traerCantidad(int cantidad) {
		ItemCarrito ic = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstItem.size() && encontrado == false) {
			if (lstItem.get(i).getCantidad() == cantidad) {
				ic = lstItem.get(i);
				encontrado = true;
			}
			i++;
		}
		return ic;
	}

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		ItemCarrito itemEncontrado = traerItemCarrito(producto);
		if (itemEncontrado == null) {
			throw new Exception("No existe el item que contenga el producto");
		} else if (cantidad < itemEncontrado.getCantidad()) {
			itemEncontrado.setCantidad(itemEncontrado.getCantidad() - cantidad);
		} else if (itemEncontrado.getCantidad() == cantidad) {
			lstItem.remove(itemEncontrado);
			return true;
		}
		return false;
	}

	public ItemCarrito traerItemCarrito(Producto producto) {
		ItemCarrito ic = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstItem.size() && encontrado == false) {
			if (lstItem.get(i).getProducto().equals(producto)) {
				ic = lstItem.get(i);
				encontrado = true;
			}
			i++;
		}
		return ic;
	}

	public ItemCarrito traerItemCarrito(int idItem) {
		ItemCarrito ic = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstItem.size() && encontrado == false) {
			if (lstItem.get(i).getIdItem() == idItem) {
				ic = lstItem.get(i);
				encontrado = true;
			}
			i++;
		}
		return ic;
	}

	public int traerIdItem() {
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
