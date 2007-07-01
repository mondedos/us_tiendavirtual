package mfis.tiendavirtual.struts.actions;

import java.util.Arrays;
import java.util.List;

import mfis.tiendavirtual.modelo.dao.Categoria;
import mfis.tiendavirtual.struts.beans.ProductosBean;
import mfis.tiendavirtual.struts.forms.BusquedaForm;
import mfis.tiendavirtual.util.Utilidades;

import struts.MyTilesAction;
import struts.WebContext;


/**
* @author DVF
*
*/

// En este caso no podemos usar XDoclets porque nuestras acciones heredan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml
public class BusquedaAction extends MyTilesAction {
	
	private WebContext c;
	
    public BusquedaAction() {
    }

    public String execute(WebContext c) {
    	this.c = c;
    	BusquedaForm formulario = (BusquedaForm)c.getForm();
    	String cadPmin = Utilidades.HTMLEncode(formulario.getMin());
    	String cadPmax = Utilidades.HTMLEncode(formulario.getMax());
    	String marca= Utilidades.HTMLEncode(formulario.getMarca());
    	String cadCategoria = formulario.getCategoria();
    	boolean avanzada;
    	if(formulario.getChk_avanzada() != null) avanzada= formulario.getChk_avanzada().booleanValue();
    	else avanzada= false;
    	// Comprobamos que se selecciona al menos una categoria de busqueda.
    	if(Utilidades.cadenaVacia(cadCategoria) && Utilidades.cadenaVacia(marca) && !avanzada){
    		return imprimirError("Debe seleccionar al menos una opcion de busqueda");
    		
    	} if (Utilidades.cadenaVacia(cadCategoria) && Utilidades.cadenaVacia(marca) && avanzada && Utilidades.cadenaVacia(cadPmin) && Utilidades.cadenaVacia(cadPmax)){
    		return imprimirError("Debe seleccionar al menos una opcion de busqueda");
    	} // Comprobamos el rango de valores numericos.
    	Float pmin= null;
    	Float pmax= null;
    	
    	if(avanzada){
    		try{
    			if(!Utilidades.cadenaVacia(cadPmin)) pmin= new Float(Float.parseFloat(cadPmin));
    			if(!Utilidades.cadenaVacia(cadPmax)) pmax= new Float(Float.parseFloat(cadPmax));
    		}catch(NumberFormatException e){
    			return imprimirError("Por favor introduzca un precio minimo un precio maximo correctos para la busqueda");
    		}
    		
    		if(pmin!=null && pmax!= null && pmin.floatValue()>pmax.floatValue()){
    			return imprimirError("El rango de precios es incorrecto");
    		}
    	}
    	
    	
    	//Todas las validaciones correctas procedemos a realizar la busqueda
    	
    	List resultadoBusqueda= realizarBusqueda(pmin, pmax, cadCategoria, marca);
    	
    	if(resultadoBusqueda==null || resultadoBusqueda.isEmpty()) c.setRequest("lista", null);
    	else c.setRequest("lista", resultadoBusqueda);
    	
    	c.setRequest("titulo", "resultados de la búsqueda");
    	if(pmin==null) c.setRequest("pmin", "");
    	else c.setRequest("pmin", pmin);
    	if(pmax==null) c.setRequest("pmax", "");
    	else c.setRequest("pmax", pmax);
    	if(marca==null)c.setRequest("marca", "");
    	else c.setRequest("marca", marca);
    	if(cadCategoria==null) c.setRequest("categoria", "10");
    	else c.setRequest("categoria", cadCategoria);
    	
    	c.setRequest("urlImg", "gui/images");
    	
    	formulario.setChk_avanzada(new Boolean(false));
    	formulario.setMax("");
    	formulario.setMin("");
    	
    	
    	return MENUPAGE;
    }
    
    private static Categoria obtenerCategoria(String cadenaCategoria){
    	if (cadenaCategoria != null && !(cadenaCategoria.trim().equals(""))) {
    		int idCategoria = Integer.parseInt(cadenaCategoria);
        	return (CategoriaAction.obtenerCategoria(idCategoria));
    	} else return null;
    }
    
    private static List obtenerPalabrasClave(String marca){
    	
    	if((marca == null) || (marca.trim().equals(""))) return (null);
    	
    	String [] auxiliar = marca.split(" ");
    	
    	return (Arrays.asList(auxiliar));
    }
    
    private String imprimirError(String mensajeError){
    	
		c.setRequest("mensajeError", mensajeError);
		c.setRequest("direccionRetorno", "categoria.do?idcat=0");
	
		return (ERROR_USUARIO);
    	
    }
    
    public static List realizarBusqueda(Float pmin, Float pmax, String cadCategoria, String marca){
    	
    	Categoria categoria= obtenerCategoria(cadCategoria);
    	List palabrasClave= obtenerPalabrasClave(marca);
    	List resultadoBusqueda= ProductosBean.listarProductosBusqueda(pmin, pmax, categoria, palabrasClave);
    	
    	return resultadoBusqueda;
    	
    }
    
	
	
}