/*
 * Generated by XDoclet - Do not edit!
 */
package mfis.tiendavirtual.interfaces;

/**
 * Remote interface for GestionProducto.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface GestionProducto
   extends javax.ejb.EJBObject
{
   /**
    * Business method
    */
   public java.util.List listarProductosBusqueda( java.lang.Float precioMinimo,java.lang.Float precioMaximo,mfis.tiendavirtual.modelo.dao.Categoria categoria,java.util.List palabrasClave )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public java.util.List listarProductosCategoria( mfis.tiendavirtual.modelo.dao.Categoria categoria )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public mfis.tiendavirtual.modelo.objetoNegocio.Item getProducto( int id )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public void anadirProducto( mfis.tiendavirtual.modelo.objetoNegocio.Producto p )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public void modificarProducto( int id,mfis.tiendavirtual.modelo.objetoNegocio.Producto p )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public void eliminarProducto( int id )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public java.util.List get10ProductosMenosBeneficiosos(  )
      throws java.rmi.RemoteException;

   /**
    * Business method
    */
   public java.util.List get10ProductosMasBeneficiosos(  )
      throws java.rmi.RemoteException;

}
