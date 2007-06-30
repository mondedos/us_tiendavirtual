package mfis.tiendavirtual.struts.vista;

public class PayPal {
	
	private String nombreArticulo;
	private String precioArticulo;
	private String numeroUnidades;
	private String number;
	private String item;
	private String amount;
	
	
	public PayPal(
			String nombreArticulo, String precioArticulo, String numeroUnidades, String item, String amount, String number){
		this.nombreArticulo= nombreArticulo;
		this.precioArticulo= precioArticulo;
		this.numeroUnidades= numeroUnidades;
		this.item= item;
		this.amount= amount;
		this.number= number;
	}
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	public String getPrecioArticulo() {
		return precioArticulo;
	}
	public void setPrecioArticulo(String precioArticulo) {
		this.precioArticulo = precioArticulo;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getNumeroUnidades() {
		return numeroUnidades;
	}


	public void setNumeroUnidades(String numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}
	
	

}
