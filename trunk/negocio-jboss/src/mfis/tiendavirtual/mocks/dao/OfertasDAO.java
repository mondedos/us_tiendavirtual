package mfis.tiendavirtual.mocks.dao;

import java.math.BigDecimal;

import mfis.tiendavirtual.mocks.persistence.Oferta;
import mfis.tiendavirtual.mocks.persistence.Producto;

public class OfertasDAO {

	public static void nuevaOferta(Producto productoA, Producto productoB){
		System.out.println("Se ha creado una nueva oferta");
	}

	public static Oferta getOferta(){

		Producto a = new Producto();
		a.setMarca("Marca Producto A");
		a.setDimensiones("10x10");
		a.setGanancia(new BigDecimal(20));
		a.setModelo("Modelo Producto A");
		a.setPrecio(new BigDecimal(1000));
		a.setReferencia("00000A");
		Producto b = new Producto();
		b.setMarca("Marca Producto B");
		b.setDimensiones("10x10");
		b.setGanancia(new BigDecimal(30));
		b.setModelo("Modelo Producto B");
		b.setPrecio(new BigDecimal(2000));
		b.setReferencia("00000B");

		System.out.println("Se ha recuperado una oferta");
		return new Oferta(a,b);
	}
}
