package mfis.tiendavirtual.ejb;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GestionPedidosBeanTest {
	
	private GestionPedidosBean gp;
	
	@BeforeClass
	public void inicializar(){
		gp= new GestionPedidosBean();
	}
	
	@Test
	public void pruebaGenerarArchivoLog(){
		
		//generamos un fichero de log con un determinado mensaje
		//comprobamos el resultado manualmente 
		
		gp.generarArchivoLog("mensaje1");
		
	}

}
