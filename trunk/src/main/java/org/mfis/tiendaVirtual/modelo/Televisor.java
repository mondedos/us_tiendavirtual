package modelo;

public class Televisor extends Producto{
String tamano;
Boolean TDT;
Boolean peana;


public Boolean getPeana() {
	return peana;
}
public void setPeana(Boolean peana) {
	this.peana = peana;
}
public String getTamano() {
	return tamano;
}
public void setTamano(String tamano) {
	this.tamano = tamano;
}
public Boolean getTDT() {
	return TDT;
}
public void setTDT(Boolean tdt) {
	TDT = tdt;
}


}
