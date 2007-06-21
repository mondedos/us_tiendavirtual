package mfis.tiendavirtual.struts.forms;

import org.apache.struts.action.ActionForm;

/**
 * @author DVF
 * @struts.form name="loginFrm"
 *
 */
public class LoginForm extends ActionForm {
	//	Esta clase no se usa de momento, esta de ejemplo
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String clave;

	public LoginForm(){
		super();
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}