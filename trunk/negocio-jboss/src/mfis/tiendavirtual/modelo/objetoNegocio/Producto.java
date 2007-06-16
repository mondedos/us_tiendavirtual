package mfis.tiendavirtual.modelo.objetoNegocio;



public class Producto extends Item{
	private static final long serialVersionUID = -5095001429299706684L;
	
	private String marca;
	private String modelo;
	private Float precio;
	private String dimensiones;
	private Float ganancia;
	private String foto;
	private String descripcion;
	
	public Producto()
	{}
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Producto)) return false;
		
		Producto p= (Producto)o;
		
		return p.getId()!=null && p.getId().equals(this.getId());
	}
	
	
	public Float obtenerPrecio(){
		return this.getPrecio();
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Float getGanancia() {
		return ganancia;
	}
	public void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}


}
