package modelo;

import java.util.Date;
import java.util.Set;

public class Pedido {
long id;
String direccion;
Date fechaPedido;
Date fechaCancelacion;
Date fechaDeServicio;
Float precioTotal;
Date fechaTransient;

Operador operador;//?	

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}



public Date getFechaCancelacion() {
	return fechaCancelacion;
}

public void setFechaCancelacion(Date fechaCancelacion) {
	this.fechaCancelacion = fechaCancelacion;
}

public Date getFechaDeServicio() {
	return fechaDeServicio;
}

public void setFechaDeServicio(Date fechaDeServicio) {
	this.fechaDeServicio = fechaDeServicio;
}

public Date getFechaPedido() {
	return fechaPedido;
}

public void setFechaPedido(Date fechaPedido) {
	this.fechaPedido = fechaPedido;
}



public Operador getOperador() {
	return operador;
}

public void setOperador(Operador operador) {
	this.operador = operador;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Date getFechaTransient() {
	return fechaTransient;
}

public void setFechaTransient(Date fechaTransient) {
	this.fechaTransient = fechaTransient;
}

public Float getPrecioTotal() {
	return precioTotal;
}

public void setPrecioTotal(Float precioTotal) {
	this.precioTotal = precioTotal;
}


}
