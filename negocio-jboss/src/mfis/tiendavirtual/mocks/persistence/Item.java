package mfis.tiendavirtual.mocks.persistence;

import java.io.Serializable;

/**
 * @deprecated usar mfis.tiendavirtual.modelo.objetoNegocio.Item
 */
@Deprecated
public class Item implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7020896593936058406L;
	private String referencia;

	public Item () {

	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
