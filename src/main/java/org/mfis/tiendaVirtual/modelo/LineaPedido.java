package modelo;



public class LineaPedido {
	long id;
 Item compra;
 Float precioUnidad;
  int unidades;
  Pedido pedido;
  
  
public Pedido getPedido() {
	return pedido;
}
public void setPedido(Pedido pedido) {
	this.pedido = pedido;
}
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
