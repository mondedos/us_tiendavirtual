package mfis.tiendavirtual.modelo.objetoNegocio;

public class Dvd extends Producto {
	
	private Long id_item_3;
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
	public Long getId() {
		return id_item_3;
	}
	public void setId(Long id) {
		this.id_item_3 = id;
	}
}
