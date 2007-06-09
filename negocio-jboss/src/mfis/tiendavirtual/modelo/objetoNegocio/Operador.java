package mfis.tiendavirtual.modelo.objetoNegocio;

public class Operador {
	private Long id;
	private String login;
	
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



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

}
