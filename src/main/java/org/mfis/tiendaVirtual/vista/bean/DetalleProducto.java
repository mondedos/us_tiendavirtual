package org.mfis.tiendaVirtual.vista.bean;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.contexts.Context;
import org.jboss.seam.contexts.Contexts;
import org.mfis.tiendaVirtual.persistencia.objetoNegocio.Producto;
import org.mfis.tiendaVirtual.vista.objetoVista.ProductoDetallado;

@Scope(ScopeType.CONVERSATION)
@Name(DetalleProducto.DETALLE_PRODUCTO)
public class DetalleProducto implements Serializable{
	
	//CONSTANTES
	
	private static final long serialVersionUID = -2894527839396422395L;
	public static final String DETALLE_PRODUCTO= "detalleProducto";
	private static final String PRODUCTO_DETALLADO= "productoDetallado";
	
	
	//METODOS
	public static String ejecutar(Producto producto){
		
		ProductoDetallado productoDetallado= new ProductoDetallado();
		
		productoDetallado.setDescripcion(producto.getDescripcion());
		productoDetallado.setNombre(producto.getNombre());
		productoDetallado.setId(producto.getId());
		productoDetallado.setFoto(producto.getFoto());
		productoDetallado.setPaginaInicial("/consultaProducto.jsp");
		
		
		Context contextoConversacion = Contexts.getConversationContext();
		contextoConversacion.set(PRODUCTO_DETALLADO, productoDetallado);
		
		return "/detalleProducto.jsp";
		
	}
	
	

}
