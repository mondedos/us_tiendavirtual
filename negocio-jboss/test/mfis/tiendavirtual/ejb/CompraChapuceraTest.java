package mfis.tiendavirtual.ejb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;
import mfis.tiendavirtual.persitencia.CreateObjetosNegocio;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompraChapuceraTest {
	
private GestionPedidosBean gp;
private DaoGenerico daoGenerico;
private String STRING_PRUEBA = "STRING_PRUEBA";
	
	@BeforeClass
	public void inicializar(){
		this.gp= new GestionPedidosBean();
		this.daoGenerico = new DaoGenerico();
	}
	
	@Test
	public void compraChapucera(){
		
		List carritoPersist = this.crearCarrito();
		Iterator it = carritoPersist.iterator();
		Carrito carrito =
			(Carrito)carritoPersist.remove(carritoPersist.size()-1);
		
		while(it.hasNext()){	
			daoGenerico.persistirObjeto(it.next());
		}
		
		this.gp.registrarPedido(carrito,
				this.STRING_PRUEBA);
		
		// Borrar el carrito.
		it = carritoPersist.iterator();
		while(it.hasNext()){	
			daoGenerico.eliminarObjeto(it.next());
		}
		
	}
	
	// Crea un carrito.
	@SuppressWarnings("unchecked")
	private List crearCarrito(){

		List objectPersist = new LinkedList();
		
		
		Pedido pedido = CreateObjetosNegocio.getInstance().createPedido();
		
		Lavadora lavadora = CreateObjetosNegocio.getInstance().createLavadora();
		lavadora.setPrecio(new Float(300));
		LineaPedido lineaPedido1 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(
					pedido, lavadora);
		objectPersist.add(lavadora);
		
		Televisor televisor = CreateObjetosNegocio.getInstance().createTelevisor();
		televisor.setPrecio(new Float(850));
		LineaPedido lineaPedido2 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(pedido, televisor);
		objectPersist.add(televisor);
		
		Oferta oferta = CreateObjetosNegocio.getInstance().createOferta();
		LineaPedido lineaPedido3 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(pedido, oferta);
		objectPersist.add(oferta);
		objectPersist.add(pedido);
		objectPersist.add(lineaPedido1);
		objectPersist.add(lineaPedido2);
		objectPersist.add(lineaPedido3);
		
		List<LineaPedido> lineas = new LinkedList<LineaPedido>();
		lineas.add(lineaPedido1);
		lineas.add(lineaPedido2);
		lineas.add(lineaPedido3);
		
		Carrito carrito = new Carrito();
		carrito.setLineasPedido(lineas);
		carrito.setTotalConIVA("1250");
		carrito.setTotalSinIVA("1100");
		objectPersist.add(carrito);

		return objectPersist;
	}
}
