package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;

public class Beneficio implements Serializable, Comparable{

	private static final long serialVersionUID = 1700015941437531107L;
	
	private Long id;
	private Integer ganancia;
	
	
	@Override
	public boolean equals(Object o){
		
		if(o==null || !(o instanceof Beneficio)) return false;
		
		Beneficio b= (Beneficio)o;
		
		return b.getId()!=null && b.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode(){
		
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
		
	}
	
	public Integer getGanancia() {
		return ganancia;
	}
	public void setGanancia(Integer ganancia) {
		this.ganancia = ganancia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Compara dos objetos de tipo "Beneficio" en funcion de su valor
	 * @param arg0
	 * @return un valor menor que cero si el beneficio generado por la venta del
	 * objeto que invoca el metodo es menor que el beneficio generado por la venta
	 * del objeto parametro, cero si el beneficio benerado por la venta del objeto
	 * que invoca el metodo es igual que el beneficio generado por la venta del
	 * objeto parametro y un valor mayor que cero si el beneficio generado por
	 * la venta del objeto que invoca el metodo es mayor que el generado por la
	 * venta del producto que tiene asociado el objeto de "Beneficio" parametro. 
	 */
	public int compareTo(Object arg0) {
		Beneficio b = (Beneficio) arg0;
		
		return (this.getGanancia().compareTo(b.getGanancia()));
	}
}