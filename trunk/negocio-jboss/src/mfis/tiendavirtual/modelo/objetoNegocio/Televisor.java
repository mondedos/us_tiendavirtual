package mfis.tiendavirtual.modelo.objetoNegocio;

public class Televisor extends Producto{
	private static final long serialVersionUID = 2007607369186447320L;
	
	private String tamano;
	private Boolean TDT;
	private Boolean peana;
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Televisor)) return false;
		
		Televisor t= (Televisor)o;
		
		return t.getId()!=null && t.getId().equals(this.getId());
	}
	
	@Override
	public String getTipoItem(){
		return "Televisor";
	}
	
	
	public Boolean getPeana() {
		return peana;
	}
	public void setPeana(Boolean peana) {
		this.peana = peana;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public Boolean getTDT() {
		return TDT;
	}
	public void setTDT(Boolean tdt) {
		TDT = tdt;
	}


}
