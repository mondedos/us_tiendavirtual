package org.mfis.tiendaVirtual.persistencia.objetoNegocio;

import java.io.Serializable;

public class Producto implements Serializable{

	
	private static final long serialVersionUID = -8568150240218311154L;
	
	//ATRIBUTOS DE LA CLASE
	
	private Integer id;
	private Integer version;
	private String nombre;
	private String descripcion;
	private String foto;
	
	//METODOS DE LA CLASE
	
	@Override
	public boolean equals(Object o){
		
		if(!(o instanceof Producto)) return false;
		else{
			Producto p= (Producto)o;
			return 
				p.getId()!=null &&
				p.getId().equals(this.getId());
			
		}
	}
	
	@Override
	public int hashCode(){
		
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
		
	}
	
	
	
	//GETTERS AND SETTERS
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	

}
