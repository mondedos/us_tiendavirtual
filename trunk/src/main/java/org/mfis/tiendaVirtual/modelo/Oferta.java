package modelo;

public class Oferta extends Item{
long id;
Producto principal;
Producto secundario;


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Producto getPrincipal() {
	return principal;
}
public void setPrincipal(Producto principal) {
	this.principal = principal;
}
public Producto getSecundario() {
	return secundario;
}
public void setSecundario(Producto secundario) {
	this.secundario = secundario;
}


}
