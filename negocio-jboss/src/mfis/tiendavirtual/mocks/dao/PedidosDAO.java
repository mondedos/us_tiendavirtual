package mfis.tiendavirtual.mocks.dao;

import java.util.ArrayList;
import java.util.Date;

import mfis.tiendavirtual.mocks.persistence.Carrito;
import mfis.tiendavirtual.mocks.persistence.Item;
import mfis.tiendavirtual.mocks.persistence.Operador;
import mfis.tiendavirtual.mocks.persistence.Pedido;

@Deprecated
public class PedidosDAO {

	public static void registrarPedido(Carrito c, String direccion) {
		System.out.println("Se ha registrado un nuevo pedido");
	}

	public static Pedido getPedido(int id) {

		Pedido p = new Pedido();
		p.setDireccion("Avda. Reina Mercedes, s/n");
		p.setEstado("Served");
		p.setFechaCancelled(null);
		p.setFechaPlaced(null);
		p.setFechaServed(null);
		p.setFechaTransient(null);
		p.setLineasPedido(new ArrayList());
		p.setOp(new Operador("operador1"));
		p.setReferencia("0000012");
		p.setTotal("1000");

		System.out.println("Se ha obtenido un pedido");

		return p;
	}

	public static void actualizarEstado(Pedido p, String estado, Date fecha) {
		System.out.println("Estado del pedido actualizado");
	}

	public static void anadeBeneficio(Pedido p) {
		System.out.println("Beneficio de Pedido anadido");
	}

	public static void anadeBeneficio(Item i) {
		System.out.println("Beneficio de Item anadido");
	}
}
