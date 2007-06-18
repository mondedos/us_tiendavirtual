package mfis.tiendavirtual.modelo.objetoNegocio;

public class Dvd extends Producto {
	private static final long serialVersionUID = 7381549180331432954L;
	
	private String conectores;
	private String formato;
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Dvd)) return false;
		
		Dvd d= (Dvd)o;
		
		return d.getId()!=null && d.getId().equals(this.getId());
	}
	
	public String getConectores() {
		return conectores;
	}
	public void setConectores(String conectores) {
		this.conectores = conectores;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public String toString() {
		String res = "";
		
		res += "DVD" + "\n";
		res+=super.toString();
		
		return (res);
	}
}