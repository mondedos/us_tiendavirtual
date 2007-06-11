package mfis.tiendavirtual.modelo.objetoNegocio;

public class PequenoElectrodomestico extends Producto{
	private static final long serialVersionUID = -4165224331513685415L;
	
	private String caracteristicas;
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof PequenoElectrodomestico)) return false;
		
		PequenoElectrodomestico p= (PequenoElectrodomestico)o;
		
		return p.getId()!=null && p.getId().equals(this.getId());
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}



}
