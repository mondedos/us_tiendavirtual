package org.mfis.tiendaVirtual.vista.objetoVista;

import org.mfis.tiendaVirtual.persistencia.objetoNegocio.Producto;

public class ProductoDetallado extends Producto{

	private static final long serialVersionUID = -6211300702766860200L;
	
	private String paginaInicial;

	//METODOS
	
	public String paginaInicial(){
		return this.paginaInicial;
	}
	
	
	//GETTERS AND SETTERS
	
	public String getPaginaInicial() {
		return paginaInicial;
	}

	public void setPaginaInicial(String paginaInicial) {
		this.paginaInicial = paginaInicial;
	}
	
	

}
