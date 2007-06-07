package modelo;



public class LineaPedido {
	long id;
 Item compra;
 Float precioUnidad;
  int unidades;
  
public Item getCompra() {
	return compra;
}
public void setCompra(Item compra) {
	this.compra = compra;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Float getPrecioUnidad() {
	return precioUnidad;
}
public void setPrecioUnidad(Float precioUnidad) {
	this.precioUnidad = precioUnidad;
}
public int getUnidades() {
	return unidades;
}
public void setUnidades(int unidades) {
	this.unidades = unidades;
}
  

}
