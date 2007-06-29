package mfis.tiendavirtual.struts.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author DVF
 * @struts.form name="busquedaFrm"
 *
 */
public class BusquedaForm extends ActionForm {
	
	private static final long serialVersionUID = -3969146354667840299L;

	private String categoria;
	private String marca;
	private String min;
	private String max;
	private Boolean chk_avanzada;
	
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
	
	public Boolean getChk_avanzada() {
		return (chk_avanzada);
	}
	
	public void setChk_avanzada(Boolean chk_avanzada) {
		this.chk_avanzada = chk_avanzada;
	}
}