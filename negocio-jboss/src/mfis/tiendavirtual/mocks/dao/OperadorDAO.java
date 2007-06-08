package mfis.tiendavirtual.mocks.dao;

import java.util.ArrayList;
import mfis.tiendavirtual.mocks.persistence.Operador;
import mfis.tiendavirtual.mocks.persistence.Pedido;
public class OperadorDAO {

	public static Operador getOperador(int id){

		return  new Operador("operador1");
	}

	public static Operador getOperador(String login){

		return  new Operador(login);
	}

	public static Pedido siguientePedido(int id) {

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

		System.out.println("Se ha obtenido el siguiente pedido para el operador " + id);

		return p;
	}
}
