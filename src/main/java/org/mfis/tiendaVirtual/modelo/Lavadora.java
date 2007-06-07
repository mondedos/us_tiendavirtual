package modelo;

public class Lavadora extends Producto{
	long id_item_3;
	String clasificacionEnergetica;
	Boolean secadora;
	public String getClasificacionEnergetica() {
		return clasificacionEnergetica;
	}

	public void setClasificacionEnergetica(String clasificacionEnergetica) {
		this.clasificacionEnergetica = clasificacionEnergetica;
	}

	public Boolean getSecadora() {
		return secadora;
	}

	public void setSecadora(Boolean secadora) {
		this.secadora = secadora;
	}
	
}
