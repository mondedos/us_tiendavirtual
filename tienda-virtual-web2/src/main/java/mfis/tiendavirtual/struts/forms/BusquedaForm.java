package mfis.tiendavirtual.struts.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author DVF
 * @struts.form name="busquedaFrm"
 *
 */
public class BusquedaForm extends ActionForm {
	/**
	 *
	 */

	private String categoria;
	private String marca;
	private String avanzada;
	private String min;
	private String max;

	public String getAvanzada() {
		return avanzada;
	}
	public void setAvanzada(String avanzada) {
		this.avanzada = avanzada;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}



}
