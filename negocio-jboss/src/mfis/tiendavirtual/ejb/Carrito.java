package mfis.tiendavirtual.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

public class Carrito implements Serializable {

	private static final long serialVersionUID = 1282127809357789898L;

	private String totalSinIVA = "0";
	private String totalConIVA = "0";
	private List<LineaPedido> lineasPedido = null;
	
	
	
	
	public void addLineaPedido(LineaPedido lp, Float precio) {
		if(lineasPedido == null) {
			lineasPedido = new ArrayList<LineaPedido>();
		}
		lineasPedido.add(lp);
		float totalNoIva = Float.parseFloat(this.totalSinIVA);
		this.totalSinIVA = "" + (totalNoIva + 	precio.floatValue() * lp.getUnidades() ) ;
		this.totalConIVA = "" + (totalNoIva + 	precio.floatValue() * lp.getUnidades() ) * 1.16f ;
	}
	
	public void removeLineaPedido(int id) {
		LineaPedido lp = (LineaPedido) lineasPedido.get(id);
		Producto p = (Producto) (lp).getCompra();
		lineasPedido.remove(id);
		float totalNoIva = Float.parseFloat(this.totalSinIVA);
		this.totalSinIVA = "" + (totalNoIva - 	p.getPrecio().floatValue() * lp.getUnidades());
		this.totalConIVA = "" + (totalNoIva + 	p.getPrecio().floatValue() * lp.getUnidades()) * 1.16f ;
	}

	public int getNumProductos() {
		int total = 0;
		Iterator it = lineasPedido.iterator();
		while (it.hasNext()) {
			LineaPedido l = (LineaPedido) it.next();
			total += l.getUnidades();
		}

		return total;
	}
	
	
	
	
	

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	public String getTotalConIVA() {
		return totalConIVA;
	}
	public void setTotalConIVA(String totalConIVA) {
		this.totalConIVA = totalConIVA;
	}
	public String getTotalSinIVA() {
		return totalSinIVA;
	}
	public void setTotalSinIVA(String totalSinIVA) {
		this.totalSinIVA = totalSinIVA;
	}
	
	public String toString() {
		String res = "";
		ListIterator li;
		LineaPedido lP;
		
		li = lineasPedido.listIterator();
		while (li.hasNext()) {
			lP = (LineaPedido) li.next();
			
			res += lP.toString() + "\n\r";
		}
		res += "\r\n=================================================================\r\n";
		res += "\r\nTotal sin IVA: " + getTotalSinIVA() + "\r\n";
		res += "Total con IVA: " + getTotalConIVA() + "\r\n";
		
		return (res);
	}

}
