package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;

public class Operador implements Serializable{
	private static final long serialVersionUID = 3877420448506150102L;
	
	private Integer id;
	private String login;
	
	public Operador(){}
	
	public Operador(String login){
		this.login= login;
	}
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Operador)) return false;
		
		Operador op= (Operador)o;	
		
		return op.getId()!=null && op.getId().equals(this.getId());
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
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

}
