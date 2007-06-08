package mfis.tiendavirtual.mocks.persistence;

import java.io.Serializable;

public class Operador implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3619425776116001216L;
	private String login;

	public Operador(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


}
