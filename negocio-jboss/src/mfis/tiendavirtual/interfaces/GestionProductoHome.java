/*
 * Generated by XDoclet - Do not edit!
 */
package mfis.tiendavirtual.interfaces;

/**
 * Home interface for GestionProducto.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface GestionProductoHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/GestionProducto";
   public static final String JNDI_NAME="ejb/GestionProducto";

   public mfis.tiendavirtual.interfaces.GestionProducto create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
