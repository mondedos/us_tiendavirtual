package mfis.tiendavirtual.ejb;

public class Utilidades {
	
	 public static String obtenerPrecio(String original){
	    	String precioFinal= null;
	    	
	    	int posicion= original.indexOf(".");
	    	int longitud= original.length();
	    	int diferencia= longitud-(posicion+1);
	    	
	    	if(posicion<0) precioFinal= original;
	    	else if(diferencia<3) precioFinal= original.substring(0, posicion+diferencia+1);
	    	else precioFinal= original.substring(0, posicion+3);
	    	
	    	
	    	if(precioFinal.matches("[0-9]+.000")|| precioFinal.matches("[0-9]+.00") || precioFinal.matches("[0-9]+.0"))
	    		precioFinal= original.substring(0, posicion);
	    	
	    	return precioFinal;
	    }

}
