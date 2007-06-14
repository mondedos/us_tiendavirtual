package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;

public class Beneficio implements Serializable{

	private static final long serialVersionUID = 1700015941437531107L;
	
	private Long id;
	private Integer ganancia;
	
	
	@Override
	public boolean equals(Object o){
		
		if(o==null || !(o instanceof Beneficio)) return false;
		
		Beneficio b= (Beneficio)o;
		
		return b.getId()!=null && b.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode(){
		
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
		
	}
	
	
	
	
	
	public Integer getGanancia() {
		return ganancia;
	}
	public void setGanancia(Integer ganancia) {
		this.ganancia = ganancia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
