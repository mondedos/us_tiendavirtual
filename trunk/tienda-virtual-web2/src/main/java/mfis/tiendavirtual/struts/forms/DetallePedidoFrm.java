package mfis.tiendavirtual.struts.forms;

import org.apache.struts.action.ActionForm;

/**
 * @struts.form name="detallePedidoFrm"
 * @author Edgar
 *
 */
public class DetallePedidoFrm extends ActionForm{

	private static final long serialVersionUID = -1719202495236935508L;
	
	private String nuevoEstado;

	
	
	public String getNuevoEstado() {
		return nuevoEstado;
	}

	public void setNuevoEstado(String nuevoEstado) {
		this.nuevoEstado = nuevoEstado;
	}
	

}
