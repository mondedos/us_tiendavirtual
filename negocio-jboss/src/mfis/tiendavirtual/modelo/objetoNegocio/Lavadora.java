package mfis.tiendavirtual.modelo.objetoNegocio;

public class Lavadora extends Producto{
	private static final long serialVersionUID = -5521462502759574352L;
	
	private Boolean secadora;
	private String clasifEnergetica;
	
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Lavadora)) return false;
		
		Lavadora l= (Lavadora)o;
		
		return l.getId()!=null && l.getId().equals(this.getId());
	}
	

	public Boolean getSecadora() {
		return secadora;
	}

	public void setSecadora(Boolean secadora) {
		this.secadora = secadora;
	}
	
	public String getClasifEnergetica() {
		return clasifEnergetica;
	}


	public void setClasifEnergetica(String clasifEnergetica) {
		this.clasifEnergetica = clasifEnergetica;
	}
	
}
