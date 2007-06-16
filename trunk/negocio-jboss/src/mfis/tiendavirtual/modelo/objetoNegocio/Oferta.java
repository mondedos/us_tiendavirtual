package mfis.tiendavirtual.modelo.objetoNegocio;


public class Oferta extends Item{
	private static final long serialVersionUID = 3703914346061263238L;
	
	private Producto principal;
	private Producto secundario;
	
	public Oferta(){}
	
	public Oferta(Producto principal, Producto secundario){
		
		this.principal= principal;
		this.secundario= secundario;
		
	}
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Oferta)) return false;
		
		Oferta of= (Oferta)o;
		
		return of.getId()!=null && of.getId().equals(this.getId());
	}
	
	
	public Float obtenerPrecio(){
		Float precio= secundario.obtenerPrecio();
		precio= precio-(precio*new Float(0.1));
		
		return precio+principal.obtenerPrecio();
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
