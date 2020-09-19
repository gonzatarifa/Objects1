package modelo;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola = new ArrayList<Producto>();

	public Supermercado() {
	}

	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		if (traerProducto(producto) != null) {
			throw new Exception("El producto ya existe!");
		} else {
			gondola.add(new Producto(traerId() + 1, producto, precio));
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

	// Consulta: Como hacer para saber si existe en otro carrito
	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		if (productoEncontrado == null) {
			throw new Exception("El producto no existe");
		} else {
			gondola.remove(productoEncontrado);
			return true;
		}
	}

	public int traerId() {
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

}
