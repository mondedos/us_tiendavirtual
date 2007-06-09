package mfis.tiendavirtual.modelo.objetoNegocio;

public class Oferta extends Item{

	private Producto principal;
	private Producto secundario;
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Oferta)) return false;
		
		Oferta of= (Oferta)o;
		
		return of.getId()!=null && of.getId().equals(this.getId());
	}
	
	
	
	public Producto getPrincipal() {
		return principal;
	}
	public void setPrincipal(Producto principal) {
		this.principal = principal;
	}
	public Producto getSecundario() {
		return secundario;
	}
	public void setSecundario(Producto secundario) {
		this.secundario = secundario;
	}


}
