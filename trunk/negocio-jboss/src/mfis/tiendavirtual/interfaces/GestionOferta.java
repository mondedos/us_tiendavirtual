/*
 * Generated by XDoclet - Do not edit!
 */
package mfis.tiendavirtual.interfaces;

/**
 * Remote interface for GestionOferta.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface GestionOferta
   extends javax.ejb.EJBObject
{
   /**
    * Business method
    */
   public void nuevaOferta( mfis.tiendavirtual.mocks.persistence.Producto productoA,mfis.tiendavirtual.mocks.persistence.Producto productoB )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public mfis.tiendavirtual.mocks.persistence.Oferta getOferta(  )
      throws java.rmi.RemoteException;

}