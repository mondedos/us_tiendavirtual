package mfis.tiendavirtual.persitencia.asignacionPedido;

import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

public class AsignacionPedidoConcurrente implements Runnable {

	private Thread hilo;
	private OperadorDAO operadorDao;
	private Long idOperador;
	private Pedido pedido;
	
	public AsignacionPedidoConcurrente (OperadorDAO operadorDao, long idOperador){
		this.operadorDao = operadorDao;
		this.idOperador = idOperador;
		
		this.hilo.start();
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		this.pedido = this.operadorDao.siguientePedido(this.idOperador);
		
	}
	
	public boolean isAlive(){
		return this.hilo.isAlive();
	}
	
	public Pedido getPedido(){
		return this.pedido;
	}

}
