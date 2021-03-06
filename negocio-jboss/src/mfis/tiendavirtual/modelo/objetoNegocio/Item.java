package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;

public abstract class Item implements Serializable{
	private static final long serialVersionUID = 3637806027003634918L;
	
	private Long id;	
	private String Referencia;
	
	
	@Override
	public boolean equals(Object o){
		
		if(o==null || !(o instanceof Item)) return false;
		
		Item i= (Item)o;
		
		return i.getId()!=null && i.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode(){
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
	}
	
	
	/**
	 * Obtiene el precio de un determinado Item
	 * Aplicacion del patron double dispatch
	 * @return precio del item
	 */
	public abstract Float obtenerPrecio();
	
	/**
	 * Obtiene la categoria del item
	 */
	public abstract String getTipoItem();
	
	/**
	 * Obtiene el nombre del articulo
	 */
	public abstract String getNombreArticulo();
	
	public abstract Float getGananciaArticulo();


	public Long getId() {
		return id;
	}
	
	public void setId(Long id){
		this.id= id;
	}
	
	public String getReferencia() {
		return Referencia;
	}
	
	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

}
