package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> lstProducto = new ArrayList<Producto>();
	private List<Cliente> lstCliente = new ArrayList<Cliente>();
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();

	public Supermercado() {
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		if (traerProducto(producto) != null) {
			throw new Exception("El producto ya existe");
		} else {
			lstProducto.add(new Producto(traerIdProducto() + 1, producto, precio));
			return true;
		}
	}

	public Producto traerProducto(int idProducto) {
		Producto p = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstProducto.size() && encontrado == false) {
			if (lstProducto.get(i).getIdProducto() == idProducto) {
				p = lstProducto.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}

	public Producto traerProducto(String producto) {
		Producto p = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstProducto.size() && encontrado == false) {
			if (lstProducto.get(i).getProducto().equals(producto)) {
				p = lstProducto.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		Carrito carritoEncontrado = traerCarrito(productoEncontrado);
		if (carritoEncontrado != null || productoEncontrado == null) {
			throw new Exception("Producto no encontrado o se encuentra en otro carrito");
		} else {
			lstProducto.remove(productoEncontrado);
			return true;
		}
	}

	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
		if (traerCliente(cliente) != null) {
			throw new Exception("El cliente ya existe");
		} else {
			lstCliente.add(new Cliente(traerIdCliente() + 1, cliente, dni, direccion));
			return true;
		}
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception {
		Cliente clienteEncontrado = traerCliente(idCliente);
		Carrito carritoEncontrado = traerCarrito(clienteEncontrado);
		if (clienteEncontrado == null || carritoEncontrado != null) {
			throw new Exception("El cliente no existe o existe en otro carrito");
		} else {
			lstCliente.remove(clienteEncontrado);
			return true;
		}
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
		Carrito carritoEncontrado = traerCarrito(idCarrito);
		if (carritoEncontrado == null) {
			throw new Exception("El carrito no existe");
		} else {
			lstCarrito.remove(carritoEncontrado);
			return true;
		}
	}

	public Cliente traerCliente(int idCliente) {
		Cliente c = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstCliente.size() && encontrado == false) {
			if (lstCliente.get(i).getIdCliente() == idCliente) {
				c = lstCliente.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}

	public Cliente traerCliente(String cliente) {
		Cliente c = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstCliente.size() && encontrado == false) {
			if (lstCliente.get(i).getCliente().equals(cliente)) {
				c = lstCliente.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}

	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		boolean encontrado = false, agregado = false;
		int i = 0;
		while (i < lstCarrito.size() && encontrado == false) {
			if (lstCarrito.get(i).getFecha().equals(fecha)) {
				if (lstCarrito.get(i).getHora().equals(hora)) {
					encontrado = true;
				}
			}
			i++;
		}
		if (encontrado == true) {
			throw new Exception("El carrito ya existe");
		} else {
			lstCarrito.add(new Carrito(traerIdCarrito() + 1, fecha, hora, cliente));
			agregado = true;
		}
		return agregado;
	}

	public List<Carrito> traerCarrito(LocalTime hora) {
		List<Carrito> c = new ArrayList<Carrito>();
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getHora().equals(hora)) {
				c.add(new Carrito(lstCarrito.get(i).getIdCarrito(), lstCarrito.get(i).getFecha(),
						lstCarrito.get(i).getHora(), lstCarrito.get(i).getCliente()));
			}
		}
		return c;
	}

	public List<Carrito> traerCarrito(LocalDate fecha) {
		List<Carrito> c = new ArrayList<Carrito>();
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getFecha().equals(fecha)) {
				c.add(new Carrito(lstCarrito.get(i).getIdCarrito(), lstCarrito.get(i).getFecha(),
						lstCarrito.get(i).getHora(), lstCarrito.get(i).getCliente()));

			}
		}
		return c;
	}

	public Carrito traerCarrito(Cliente cliente) {
		Carrito c = null;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().equals(cliente)) {
				c = lstCarrito.get(i);
			}
		}
		return c;
	}

	public Carrito traerCarrito(Producto producto) {
		Carrito c = null;
		for (int i = 0; i < lstCarrito.size(); i++) {
			for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
				if (lstCarrito.get(i).getLstItem().get(j).getProducto().equals(producto)) {
					c = lstCarrito.get(i);
				}
			}
		}
		return c;
	}

	public float calcularTotal(Cliente cliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().equals(cliente)) {
				encontrado = true;
				for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
					total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
				}
			}
		}
		if (!encontrado) {
			throw new Exception("El cliente no existe");
		}
		return total;
	}

	public float calcularTotal(int dniCliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().getDni() == dniCliente) {
				encontrado = true;
				for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
					total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
				}
			}
		}
		if (!encontrado) {
			throw new Exception("El cliente no existe");
		}
		return total;
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		float total = 0;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getFecha().isAfter(fechaInicio) && lstCarrito.get(i).getFecha().isBefore(fechaFin)) {
				for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
					total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
				}
			}
		}
		return total;
	}

	public float calcularTotal(LocalDate fecha) {
		float total = 0;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getFecha().equals(fecha)) {
				for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
					total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
				}
			}
		}
		return total;
	}

	public float calcularTotal(int mes, int anio) throws Exception {
		float total = 0;
		if (mes < 1 || mes > 12) {
			throw new Exception("El mes es incorrecto");
		}
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getFecha().getMonthValue() == mes && lstCarrito.get(i).getFecha().getYear() == anio) {
				for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
					total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
				}
			}
		}
		return total;
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().equals(cliente)) {
				encontrado = true;
				if (lstCarrito.get(i).getFecha().isBefore(fechaFin)
						&& lstCarrito.get(i).getFecha().isAfter(fechaInicio)) {
					for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
						total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
					}
				}
			}
		}
		if (encontrado == false) {
			throw new Exception("El cliente no existe");
		}
		return total;
	}

	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().equals(cliente)) {
				encontrado = true;
				if (lstCarrito.get(i).getFecha().equals(fecha)) {
					for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
						total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
					}
				}
			}
		}
		if (encontrado == false) {
			throw new Exception("El cliente no existe");
		}
		return total;
	}

	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		if (mes < 1 || mes > 12) {
			throw new Exception("El mes es incorrecto");
		}
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().equals(cliente)) {
				encontrado = true;
				if (lstCarrito.get(i).getFecha().getMonthValue() == mes
						&& lstCarrito.get(i).getFecha().getYear() == anio) {
					for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
						total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
					}
				}
			}
		}
		if (encontrado == false) {
			throw new Exception("El cliente no existe");
		}
		return total;
	}

	public float calcularTotal(int mes, int anio, int dniCliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		if (mes < 1 || mes > 12) {
			throw new Exception("El mes es incorrecto");
		}
		for (int i = 0; i < lstCarrito.size(); i++) {
			if (lstCarrito.get(i).getCliente().getDni() == dniCliente) {
				encontrado = true;
				if (lstCarrito.get(i).getFecha().getMonthValue() == mes
						&& lstCarrito.get(i).getFecha().getYear() == anio) {
					for (int j = 0; j < lstCarrito.get(i).getLstItem().size(); j++) {
						total = total + lstCarrito.get(i).getLstItem().get(j).calcularSubTotal();
					}
				}
			}
		}
		if (encontrado == false) {
			throw new Exception("El cliente no existe");
		}
		return total;
	}

	public Carrito traerCarrito(int idCarrito) {
		Carrito c = null;
		boolean encontrado = false;
		int i = 0;
		while (i < lstCarrito.size() && encontrado == false) {
			if (lstCarrito.get(i).getIdCarrito() == idCarrito) {
				c = lstCarrito.get(i);
			}
			i++;
		}
		return c;
	}

	public int traerIdProducto() {
		int mayor = 0;
		if (lstProducto.size() != 0) {
			mayor = lstProducto.get(0).getIdProducto();
		}
		int actual;
		for (int i = 0; i < lstProducto.size(); i++) {
			actual = lstProducto.get(i).getIdProducto();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

	public int traerIdCliente() {
		int mayor = 0;
		if (lstCliente.size() != 0) {
			mayor = lstCliente.get(0).getIdCliente();
		}
		int actual;
		for (int i = 0; i < lstCliente.size(); i++) {
			actual = lstCliente.get(i).getIdCliente();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

	public int traerIdCarrito() {
		int mayor = 0;
		if (lstCarrito.size() != 0) {
			mayor = lstCarrito.get(0).getIdCarrito();
		}
		int actual;
		for (int i = 0; i < lstCarrito.size(); i++) {
			actual = lstCarrito.get(i).getIdCarrito();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

}
