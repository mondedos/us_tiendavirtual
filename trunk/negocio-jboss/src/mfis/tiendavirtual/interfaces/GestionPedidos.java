/*
 * Generated by XDoclet - Do not edit!
 */
package mfis.tiendavirtual.interfaces;

/**
 * Remote interface for GestionPedidos.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface GestionPedidos
   extends javax.ejb.EJBObject
{
   /**
    * Business method
    */
   public void registrarPedido( mfis.tiendavirtual.ejb.Carrito c,java.lang.String direccion )
      throws java.rmi.RemoteException;

   /**
    * Business method
    * @throws IlegalChangedStateOrder
    */
   public void actualizarEstado( mfis.tiendavirtual.modelo.objetoNegocio.Pedido pedido,java.lang.String estado,java.util.Date fecha )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public mfis.tiendavirtual.modelo.objetoNegocio.Pedido getPedido( int id )
      throws java.rmi.RemoteException;
   
   /**
    * Business method
    */
   public java.lang.String obtenerEstado(mfis.tiendavirtual.modelo.objetoNegocio.Pedido pedido)
   	throws java.rmi.RemoteException;
   
   /**
    * Business method
    */
   public java.util.List obtenerLineasPedido(mfis.tiendavirtual.modelo.objetoNegocio.Pedido pedido)
   	throws java.rmi.RemoteException;

}
