package mfis.tiendavirtual.modelo.dao;

public class IlegalChangedStateOrder extends Exception{

	public IlegalChangedStateOrder(String message){
		super(message);
	}
	
	public IlegalChangedStateOrder(){
		super();
	}
}
