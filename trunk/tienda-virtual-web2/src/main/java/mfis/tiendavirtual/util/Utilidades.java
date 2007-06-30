package mfis.tiendavirtual.util;

import java.text.DateFormat;
import java.util.Date;

// En esta clase tendran cabida operaciones comunes que tendremos que realizar.

public class Utilidades {
    
	public Utilidades() {
    }

    public static String capitalizeWord (String s) {
      if (s == null || s.length() == 0) {
          return s;
      } else {
          return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
      }
    }
    
    public static String obtenerPrecio(String original){
    	String precioFinal = null;
    	
    	int posicion = original.indexOf(".");
    	int longitud = original.length();
    	int diferencia = longitud-(posicion+1);
    	
    	if(posicion < 0) precioFinal = original;
    	else if (diferencia < 3) precioFinal = original.substring(0, posicion + diferencia + 1);
    	else precioFinal= original.substring(0, posicion+3);
    	
    	
    	if(precioFinal.matches("[0-9]+.000")|| precioFinal.matches("[0-9]+.00") || precioFinal.matches("[0-9]+.0"))
    		precioFinal= original.substring(0, posicion);
    	if ((precioFinal.matches("[0-9]+.[0-9]")) && (precioFinal).contains(".")) {
    		precioFinal += "0";
    	} // Reemplazamos el punto anglosajon por una coma. 
    	precioFinal = precioFinal.replace('.', ',');
    	
    	return (precioFinal);
    }
    
    public static String formatearFecha (Date fecha){	
    	String fechaFormateada= "";
    	
    	if(fecha!=null){
    		DateFormat df= DateFormat.getDateInstance(DateFormat.DEFAULT);
    		fechaFormateada= df.format(fecha);
    	}
    	
    	return (fechaFormateada);	
    }
    
    public static boolean cadenaVacia(String cadena){
    	return cadena== null || cadena.trim().equals("");
    }  
}