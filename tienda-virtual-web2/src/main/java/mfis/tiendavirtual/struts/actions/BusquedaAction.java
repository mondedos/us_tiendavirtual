package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.ProductoEJB;
import mfis.tiendavirtual.modelo.dao.Categoria;
import mfis.tiendavirtual.struts.forms.BusquedaForm;

import struts.MyTilesAction;
import struts.WebContext;


/**
* @author DVF
*
*/

// En este caso no podemos usar XDoclets porque nuestras acciones hereadan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml
public class BusquedaAction extends MyTilesAction {

    public BusquedaAction() {
    }

    public String execute(WebContext c) {
    	
    	GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);
    	
    	BusquedaForm formulario= (BusquedaForm)c.getForm();
    	
    	Categoria categoria = obtenerCategoria(formulario.getCategoria());
    	List palabrasClave = obtenerPalabrasClave(formulario.getMarca());
    	
    	Float pmin = new Float(0);
    	Float pmax = new Float(0);
    	
    	String cadPmin = formulario.getMin();
    	String cadPmax = formulario.getMax();
    	
    	if ((cadPmin != null) && (cadPmax != null)) {
    		if (cadPmin.trim().equals("")) pmin = null;
    		if(cadPmax.trim().equals("")) pmax = null;
    		
    		try {
    			if (pmin != null) pmin= new Float(Float.parseFloat(formulario.getMin()));
    			if (pmax != null) pmax= new Float(Float.parseFloat(formulario.getMax()));
    			
        	} catch (NumberFormatException e){
        		// TODO Poner un error en la web. De momento, ignoramos esto.
        		pmin = null;
        		pmax = null;
        	}
    		
    	} List resultadoBusqueda= null;
    	try{
    		resultadoBusqueda= gp.listarProductosBusqueda(pmin, pmax, categoria, palabrasClave);
    	} catch(RemoteException e){
    		throw new RuntimeException(e);
    	} c.setRequest("lista", resultadoBusqueda);
    	c.setRequest("titulo", "resultados de la búsqueda");
    	c.setRequest("idcat", new Integer(0));
    	c.setRequest("urlImg", "gui/images");
    	
    	if (c.getSession("operador") != null) return (OPERADOR);
    	else return (MENUPAGE);
    }
    
    private Categoria obtenerCategoria(String cadenaCategoria){
    	if (cadenaCategoria != null && !(cadenaCategoria.trim().equals(""))) {
    		int idCategoria = Integer.parseInt(cadenaCategoria);
        	return (CategoriaAction.obtenerCategoria(idCategoria));
    	} else return null;
    }
    
    private List obtenerPalabrasClave(String marca){
    	
    	if((marca == null) || (marca.trim().equals(""))) return (null);
    	
    	String [] auxiliar = marca.split(" ");
    	
    	return (Arrays.asList(auxiliar));
    }
}
