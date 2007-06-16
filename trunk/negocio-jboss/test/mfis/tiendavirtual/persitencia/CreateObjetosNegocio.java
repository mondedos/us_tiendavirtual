package mfis.tiendavirtual.persitencia;

import java.util.Date;

import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;
import mfis.tiendavirtual.modelo.objetoNegocio.Frigorifico;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.PequenoElectrodomestico;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;
import mfis.tiendavirtual.modelo.objetoNegocio.Deprecated;

public class CreateObjetosNegocio {

	private String STRING_PRUEBA = "STRING_PRUEBA";
	private Float FLOAT_PRUEBA = new Float(0); 
	private Boolean BOOLEAN_PRUEBA = new Boolean(false);
	private Date DATE_PRUEBA = new Date();
	private int INT_PRUEBA = 1;
	
	private static CreateObjetosNegocio objetoNegocio;
	
	private CreateObjetosNegocio(){
		
		this.STRING_PRUEBA = "STRING_PRUEBA";
		this.FLOAT_PRUEBA = new Float(0); 
		this.BOOLEAN_PRUEBA = new Boolean(false);
		this.DATE_PRUEBA = new Date();
		this.INT_PRUEBA = 1;
	}
	
	
	public static CreateObjetosNegocio getInstance(){
		
		if(CreateObjetosNegocio.objetoNegocio == null)
			CreateObjetosNegocio.objetoNegocio = new CreateObjetosNegocio();
		
		return CreateObjetosNegocio.objetoNegocio;
	}
//	 Crea un producto con valores por defecto.
	public void createProducto(Producto producto){
		
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
	public Lavadora creatLavadora(){
		
		Lavadora lavadora = new Lavadora();
		this.createProducto(lavadora);
		
		lavadora.setSecadora(this.BOOLEAN_PRUEBA);
		lavadora.setClasifEnergetica(this.STRING_PRUEBA);
		
		return lavadora;
	}

	//	 Crea un frigorifico con valores por defecto.
	public Frigorifico createFrigorifico(){
		
		Frigorifico frigorifico = new Frigorifico();
		this.createProducto(frigorifico);
		
		
		frigorifico.setClasifEnergetica(this.STRING_PRUEBA);
		frigorifico.setCombi(false);
		
		return frigorifico;
	}
	
//	 Crea un frigorifico con valores por defecto.
	public Televisor createTelevisor(){
		
		Televisor televisor = new Televisor();
		this.createProducto(televisor);
		
		
		televisor.setTDT(this.BOOLEAN_PRUEBA);
		televisor.setTamano(this.STRING_PRUEBA);
		televisor.setPeana(this.BOOLEAN_PRUEBA);
		
		return televisor;
	}
	
	//	 Crea un Dvd con valores por defecto.
	public Dvd createDvd(){
		
		Dvd dvd = new Dvd();
		this.createProducto(dvd);
		
		dvd.setFormato(this.STRING_PRUEBA);
		dvd.setConectores(this.STRING_PRUEBA);
		
		return dvd;
	}
	
	//	 Crea un Pequeño electrodoméstico con valores por defecto.
	public PequenoElectrodomestico createPequenoElectrodomestico(){
		
		PequenoElectrodomestico pE = new PequenoElectrodomestico();
		this.createProducto(pE);
		
		pE.setCaracteristicas(this.STRING_PRUEBA);
		
		return pE;
	}
	
	// Crea un operador con valores por defecto.
	public Operador createOperador(){
		
		Operador operador = new Operador();
		operador.setLogin(this.STRING_PRUEBA);		
		
		return operador;
	}
	
	// Crea un pedido con valores por defecto.
	public Pedido createPedido(){
		
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
	
	// Crea una línea de pedido asociada a un pedido y a un item.
	public  LineaPedido createLineaPedido(Pedido pedido, Item item){
		
		LineaPedido lineaPedido = new LineaPedido();
		lineaPedido.setPedido(pedido);
		lineaPedido.setCompra(item);
		lineaPedido.setPrecioUnidad(this.FLOAT_PRUEBA);
		lineaPedido.setUnidades(this.INT_PRUEBA);
		
		return lineaPedido;
	}
	
// Crea un objeto de tipo beneficio.
	public Beneficio createBeneficio(){
		Beneficio beneficio = new Beneficio();
		beneficio.setGanancia(this.INT_PRUEBA);
		
		return beneficio;
	}
	
//	 Crea un objeto de tipo deprecated.
	public Deprecated createDeprecated(){
		Deprecated deprecated = new Deprecated();
		deprecated.setFecha(this.DATE_PRUEBA);
		
		return deprecated;
	}
}
