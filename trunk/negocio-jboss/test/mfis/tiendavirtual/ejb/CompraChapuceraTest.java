package mfis.tiendavirtual.ejb;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
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
	public void compraChapucera() throws Exception{
		
		List carritoPersist = this.crearCarrito();
<<<<<<< .mine

=======
>>>>>>> .r311
		Carrito carrito =
			(Carrito)carritoPersist.remove(carritoPersist.size()-1);
<<<<<<< .mine
		Iterator it = carritoPersist.iterator();
=======
	
		daoGenerico.persistirObjeto(carritoPersist.get(0));
		daoGenerico.persistirObjeto(carritoPersist.get(1));
		
>>>>>>> .r311
<<<<<<< .mine
		while(it.hasNext()){	
			Item o=(Item)it.next();
			daoGenerico.persistirObjeto(o);
=======
		try{
				this.gp.registrarPedido(carrito,this.STRING_PRUEBA);
>>>>>>> .r311
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally{
		// Borrar el carrito.
			ListIterator it1 = 
				carritoPersist.listIterator(carritoPersist.size());
			Pedido pedido = ((LineaPedido)carritoPersist.get(2)).getPedido();
			
			while(it1.hasPrevious())
				 daoGenerico.eliminarObjeto(it1.previous());
			
			daoGenerico.eliminarObjeto(pedido);
		}
	}
	
	// Crea un carrito.
	@SuppressWarnings("unchecked")
	private List crearCarrito(){

		List objectPersist = new LinkedList();
		
		
		Lavadora lavadora = CreateObjetosNegocio.getInstance().createLavadora();
		lavadora.setPrecio(new Float(300));
		LineaPedido lineaPedido1 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(
					null, lavadora);
		lineaPedido1.setPrecioUnidad(new Float(300));
		
		
		Televisor televisor = CreateObjetosNegocio.getInstance().createTelevisor();
		televisor.setPrecio(new Float(850));
		LineaPedido lineaPedido2 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(
					null, televisor);
		lineaPedido2.setPrecioUnidad(new Float(850));		
		
<<<<<<< .mine
		// Oferta oferta = CreateObjetosNegocio.getInstance().createOferta();
		//LineaPedido lineaPedido3 = 
			// CreateObjetosNegocio.getInstance().createLineaPedido(pedido, oferta);
		//objectPersist.add(oferta);
		objectPersist.add(pedido);
		objectPersist.add(lineaPedido1);
		objectPersist.add(lineaPedido2);
		// objectPersist.add(lineaPedido3);
=======
>>>>>>> .r311
		
		List<LineaPedido> lineas = new LinkedList<LineaPedido>();
		lineas.add(lineaPedido1);
		lineas.add(lineaPedido2);
<<<<<<< .mine
		// lineas.add(lineaPedido3);
=======
>>>>>>> .r311
		
		Carrito carrito = new Carrito();
		carrito.setLineasPedido(lineas);
		carrito.setTotalConIVA("1250");
		carrito.setTotalSinIVA("1100");
		
		
		// Objetos a persistir.
		objectPersist.add(lavadora);
		objectPersist.add(televisor);
		objectPersist.add(lineaPedido1);
		objectPersist.add(lineaPedido2);
		objectPersist.add(carrito);

		return objectPersist;
	}
}