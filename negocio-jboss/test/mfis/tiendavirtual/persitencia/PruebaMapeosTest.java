package mfis.tiendavirtual.persitencia;



import java.util.Date;
import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


public class PruebaMapeosTest {
	
	private final String STRING_PRUEBA = "STRING_PRUEBA";
	private final Float FLOAT_PRUEBA = new Float(0); 
	private final Boolean BOOLEAN_PRUEBA = new Boolean(false);
	private final Date DATE_PRUEBA = new Date();
	private final int INT_PRUEBA = 1;
	
	@BeforeClass
	public void before(){
		
		 
	}
	
	// Crea un producto con valores por defecto.
	private void createProducto(Producto producto){
		
		producto.setDescripcion(this.STRING_PRUEBA);
		producto.setDimensiones(this.STRING_PRUEBA);
		producto.setFoto(this.STRING_PRUEBA);
		producto.setGanancia(this.FLOAT_PRUEBA);
		producto.setMarca(this.STRING_PRUEBA);
		producto.setModelo(this.STRING_PRUEBA);
		producto.setPrecio(this.FLOAT_PRUEBA);
		producto.setReferencia(this.STRING_PRUEBA);
	}
	
	// Crea una lavadora con valores por defecto.
	private Lavadora creatLavadora(){
		
		Lavadora lavadora = new Lavadora();
		this.createProducto(lavadora);
		
		lavadora.setSecadora(this.BOOLEAN_PRUEBA);
		lavadora.setClasifEnergetica(this.STRING_PRUEBA);
		
		return lavadora;
	}

	//	 Crea un frigorifico con valores por defecto.
	private Frigorifico createFrigorifico(){
		
		Frigorifico frigorifico = new Frigorifico();
		this.createProducto(frigorifico);
		
		
		frigorifico.setClasifEnergetica(this.STRING_PRUEBA);
		frigorifico.setCombi(false);
		
		return frigorifico;
	}
	
	
	//	 Crea un Dvd con valores por defecto.
	private Dvd createDvd(){
		
		Dvd dvd = new Dvd();
		this.createProducto(dvd);
		
		dvd.setFormato(this.STRING_PRUEBA);
		dvd.setConectores(this.STRING_PRUEBA);
		
		return dvd;
	}
	
	//	 Crea un Pequeño electrodoméstico con valores por defecto.
	private PequenoElectrodomestico createPequnoelectrodomestico(){
		
		PequenoElectrodomestico pE = new PequenoElectrodomestico();
		pE.setCaracteristicas(this.STRING_PRUEBA);
		
		return pE;
	}
	
	// Crea un operador con valores por defecto.
	private Operador createOperador(){
		
		Operador operador = new Operador();
		operador.setLogin(this.STRING_PRUEBA);		
		
		return operador;
	}
	
	// Crea un pedido con valores por defecto.
	private Pedido createPedido(){
		
		Pedido pedido = new Pedido();
		pedido.setDireccion(this.STRING_PRUEBA);
		pedido.setFechaCancelacion(this.DATE_PRUEBA);
		pedido.setFechaDeServicio(this.DATE_PRUEBA);
		pedido.setFechaPedido(this.DATE_PRUEBA);
		pedido.setFechaTransient(this.DATE_PRUEBA);
		pedido.setOperador(this.createOperador());
		pedido.setPrecioTotal(this.FLOAT_PRUEBA);
		
		return pedido;
	}
	
	private Item createItem(){
		Item item = new Item();
		item.setReferencia(this.STRING_PRUEBA);
		
		return item;
	}
	
	// Crea una línea de pedido asociada a un pedido y a un item.
	private LineaPedido createLineaPedido(Pedido pedido, Item item){
		
		LineaPedido lineaPedido = new LineaPedido();
		lineaPedido.setPedido(pedido);
		lineaPedido.setCompra(item);
		lineaPedido.setPrecioUnidad(this.FLOAT_PRUEBA);
		lineaPedido.setUnidades(this.INT_PRUEBA);
		
		return lineaPedido;
	}
	
	
	
	
	
	
	@Test
	public void saveFrigorifico(){
		
		Frigorifico frigorifico = this.createFrigorifico();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(frigorifico);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void saveLavadora(){
		
		Lavadora lavadora = this.creatLavadora();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(lavadora);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void saveDdv(){
		
		Dvd dvd = this.createDvd();
		
		dvd.setFormato(this.STRING_PRUEBA);
		dvd.setConectores(this.STRING_PRUEBA);
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(dvd);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void savePequenoElectrodomestico(){
		
		PequenoElectrodomestico pE = this.createPequnoelectrodomestico();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(pE);
		tx.commit();
		sesion.close();
	}
	
	
	@Test
	public void saveOperador(){
		
		Operador operador = this.createOperador();
			
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(operador);
		tx.commit();
		sesion.close();
	}
	
	
	@Test
	public void savePedido(){
		
		Pedido pedido = this.createPedido();
		Item item1 = this.createItem();
		Item item2 = this.createItem();
		
		LineaPedido lineaPedido1 = this.createLineaPedido(pedido, item1);
		LineaPedido lineaPedido2 = this.createLineaPedido(pedido, item2);
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(lineaPedido1);
		sesion.save(lineaPedido2);
		tx.commit();
		sesion.close();
	}
}
