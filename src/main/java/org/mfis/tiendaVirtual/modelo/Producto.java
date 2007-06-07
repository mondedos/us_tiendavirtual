package modelo;

import java.math.BigDecimal;

public class Producto extends Item{
long id;	
String marca;
String modelo;
Float precio;
String dimensiones;
Integer ganancia;
String foto;
String descripcion;
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
public Integer getGanancia() {
	return ganancia;
}
public void setGanancia(Integer ganancia) {
	this.ganancia = ganancia;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
