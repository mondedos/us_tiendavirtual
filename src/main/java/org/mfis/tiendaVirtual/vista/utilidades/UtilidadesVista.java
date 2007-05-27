package org.mfis.tiendaVirtual.vista.utilidades;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;

import oracle.adf.view.faces.component.core.output.CoreOutputText;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Clase de utilidades generales para la capa de vista
 * 
 * @author Edgar
 *
 */
@Name(UtilidadesVista.UTILIDADES_VISTA)
@Scope(ScopeType.EVENT)
public class UtilidadesVista implements Serializable{

	private static final long serialVersionUID = 8280605197863482957L;
	public static final String UTILIDADES_VISTA= "utilidadesVista";
	
	//METODOS DE LA CLASE
	
	/**
	 * Método que obtiene el valor del atributo cuyo número se le pasa como parametro
	 * En caso de que el indice sea erroneo elevara una excepcion ArrayIndexOutOfBoundsException
	 * 
	 * El objeto principal debe de tener uno o mas atributos, estos atributos se insertan de manera de outputText o cualquier
	 * otro objeto que implemente la clase CoreOutputText y que podamos por lo tanto obtener un valor
	 * 
	 *  @param objetoPrincipal
	 *  @param numeroAtributo se inicia en 0
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String obtenerValorAtributo(UIComponent objetoPrincipal, int numeroAtributo){
		
		List<UIComponent> listaAtributos= objetoPrincipal.getChildren();
		int totalAtributos= objetoPrincipal.getChildCount();
		
		if(numeroAtributo>=totalAtributos) 
			throw new ArrayIndexOutOfBoundsException("Excedido el numero de atributos");
		
		return ((CoreOutputText)listaAtributos.get(numeroAtributo)).getValue().toString();
		
		
		
		
	}
	
	

}
