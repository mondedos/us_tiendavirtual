package mfis.tiendavirtual.mocks.persistence;

import java.math.BigDecimal;

/**
 * @deprecated usar mfis.tiendavirtual.modelo.objetoNegocio.Producto
 */
@Deprecated
public class Producto extends Item{

	/**
	 *
	 */
	private static final long serialVersionUID = -969951229983587597L;

	private String marca;
	private String modelo;
	private String dimensiones;
	private BigDecimal precio;
	private BigDecimal ganancia;
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public BigDecimal getGanancia() {
		return ganancia;
	}
	public void setGanancia(BigDecimal ganancia) {
		this.ganancia = ganancia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
