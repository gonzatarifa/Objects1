package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola = new ArrayList<Producto>();
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();

	public Supermercado() {
	}

	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		if (traerProducto(producto) != null) {
			throw new Exception("El producto ya existe!");
		} else {
			gondola.add(new Producto(traerIdProducto() + 1, producto, precio));
			return true;
		}
	}

	public Producto traerProducto(int idProducto) {
		Producto p = null;
		int i = 0;
		boolean encontrado = false;
		while (i < gondola.size() && encontrado == false) {
			if (gondola.get(i).getIdProducto() == idProducto) {
				p = gondola.get(i);
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
		while (i < gondola.size() && encontrado == false) {
			if (gondola.get(i).getProducto().equals(producto)) {
				p = gondola.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}

	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		if (productoEncontrado == null) {
			throw new Exception("El producto no existe");
		} else {
			productoEncontrado.setProducto(producto);
			productoEncontrado.setPrecio(precio);
			return true;
		}
	}

	public boolean agregarCarrito(LocalDate fecha, LocalTime hora) throws Exception {
		if (traerCarrito(fecha) != null) {
			throw new Exception("El carrito ya existe");
		} else {
			lstCarrito.add(new Carrito(traerIdCarrito() + 1, fecha, hora));
			return true;
		}
	}
	
	public boolean eliminarCarrito(int idCarrito) throws Exception {
		Carrito carritoEncontrado = traerCarrito(idCarrito);
		if(carritoEncontrado == null) {
			throw new Exception("El carrito no existe");
		} else {
			lstCarrito.remove(carritoEncontrado);
			return true;
		}
	}

	public Carrito traerCarrito(int idCarrito) {
		Carrito c = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstCarrito.size() && encontrado == false) {
			if (lstCarrito.get(i).getIdCarrito() == idCarrito) {
				c = lstCarrito.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}

	public Carrito traerCarrito(LocalDate fecha) {
		Carrito c = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstCarrito.size() && encontrado == false) {
			if (lstCarrito.get(i).getFecha().equals(fecha)) {
				c = lstCarrito.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}

	public Carrito traerCarrito(Producto producto) {
		Carrito c = null;
		int i = 0;
		int j = 0;
		boolean encontrado = false;
		while (i < lstCarrito.size() && encontrado == false) {
			while (j < lstCarrito.get(i).getLstItem().size() && encontrado == false) {
				if (lstCarrito.get(i).getLstItem().get(j).getProducto().equals(producto)) {
					c = lstCarrito.get(i);
					encontrado = true;
				}
				j++;
			}
			i++;
		}
		return c;
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		Carrito carritoEncontrado = traerCarrito(productoEncontrado);
		if (productoEncontrado == null || carritoEncontrado != null) {
			throw new Exception("El producto no existe o existe en otro carrito");
		} else {
			gondola.remove(productoEncontrado);
			return true;
		}
	}

	public int traerIdProducto() {
		int mayor = 0;
		if (gondola.size() != 0) {
			mayor = gondola.get(0).getIdProducto();
		}
		int actual;
		for (int i = 0; i < gondola.size(); i++) {
			actual = gondola.get(i).getIdProducto();
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
