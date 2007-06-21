package mfis.tiendavirtual.struts.forms;

import org.apache.struts.action.ActionForm;

/**
 * 
 * @author Edgar
 * @struts.form name="pedidoFrm"
 *
 */
public class PedidoForm extends ActionForm{

	private static final long serialVersionUID = -5213355890334300217L;
	
	private String nombreUsuario;
	private String direccionUsuario;
	
	public String getDireccionUsuario() {
		return direccionUsuario;
	}
	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}