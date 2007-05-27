package org.mfis.tiendaVirtual.vista.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.mfis.tiendaVirtual.persistencia.objetoNegocio.Producto;
import org.mfis.tiendaVirtual.persistencia.utilidades.UtilidadesPersistencia;
import org.mfis.tiendaVirtual.vista.utilidades.UtilidadesVista;

/**
 * Clase de soporte para la página de consulta de productos de la aplicación
 * 
 * @author Edgar
 */

@Name(ConsultaProducto.CONSULTA_PRODUCTO)
@Scope(ScopeType.CONVERSATION)
public class ConsultaProducto implements Serializable{

	private static final long serialVersionUID = -1787129697170757596L;
	public static final String CONSULTA_PRODUCTO= "consultaProducto";
	
	//ATRIBUTOS DE LA CLASE
	
	private List<Producto> listaProducto;
	
	@In(value=UtilidadesPersistencia.UTILIDADES_PERSISTENCIA, create=true)
	private UtilidadesPersistencia utilidadesPersistencia;
	
	@In(value=UtilidadesVista.UTILIDADES_VISTA, create=true)
	private UtilidadesVista utilidadesVista;

	//METODOS DE LA CLASE
	
	

	@Create
	@Begin(join=true)
	public String inicializar(){
		
		inicializarListaProducto();
		return "";
		
	}
	
	private void inicializarListaProducto(){
		
		listaProducto= utilidadesPersistencia.encontrarTodos(Producto.class);
	}
	
	
	public String verDetalles(ActionEvent evento){
		
		UIComponent objetoPrincipal= evento.getComponent();
		String identificadorProducto= utilidadesVista.obtenerValorAtributo(objetoPrincipal, 0);
		Producto producto= utilidadesPersistencia.buscarPorId(identificadorProducto, Producto.class);
		
		return DetalleProducto.ejecutar(producto);
		
	}
	
	//GETTERS AND SETTERS
	
	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public UtilidadesPersistencia getUtilidadesPersistencia() {
		return utilidadesPersistencia;
	}

	public void setUtilidadesPersistencia(
			UtilidadesPersistencia utilidadesPersistencia) {
		this.utilidadesPersistencia = utilidadesPersistencia;
	}
	
	public UtilidadesVista getUtilidadesVista() {
		return utilidadesVista;
	}

	public void setUtilidadesVista(UtilidadesVista utilidadesVista) {
		this.utilidadesVista = utilidadesVista;
	}
	

}
