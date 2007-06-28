package mfis.tiendavirtual.modelo.objetoNegocio;

public class Frigorifico extends Producto {
	private static final long serialVersionUID = 6480318486447715038L;
	
	private String clasifEnergetica;
	private Boolean combi;
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Frigorifico)) return false;
		
		Frigorifico f = (Frigorifico)o;
		
		return f.getId()!=null && f.getId().equals(this.getId());
	}
	
	@Override
	public String getTipoItem(){
		return "Frigorifico";
	}

	public String getClasifEnergetica() {
		return clasifEnergetica;
	}

	public void setClasifEnergetica(String clasifEnergetica) {
		this.clasifEnergetica = clasifEnergetica;
	}
	
	public Boolean getCombi() {
		return combi;
	}

	public void setCombi(Boolean combi) {
		this.combi = combi;
	}
	
	public String toString() {
		String res = "";
		
		
		res+=super.toString();
		
		return (res);
	}
}
