package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;
import java.util.Date;

public class Deprecated implements Serializable{

	private static final long serialVersionUID = -628372451563985956L;
	
	private Integer id;
	private Date fecha;
	
	
	@Override
	public boolean equals(Object o){
		
		if(o==null || !(o instanceof Beneficio)) return false;
		
		Deprecated b= (Deprecated)o;
		
		return b.getId()!=null && b.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode(){
		
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
		
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
