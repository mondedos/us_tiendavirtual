package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 3637806027003634918L;
	
	private Integer id;	
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


	public Integer getId() {
		return id;
	}
	
	protected void setId(Integer id) {
		this.id = id;
	}
	
	public String getReferencia() {
		return Referencia;
	}
	
	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

}
