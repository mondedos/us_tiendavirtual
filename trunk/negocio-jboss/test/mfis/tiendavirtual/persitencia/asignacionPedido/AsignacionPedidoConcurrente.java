package mfis.tiendavirtual.persitencia.asignacionPedido;

import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

public class AsignacionPedidoConcurrente implements Runnable {

	private Thread hilo;
	private OperadorDAO operadorDao;
	private Long idOperador;
	private Pedido pedido;
	private int retardo;
	
	public AsignacionPedidoConcurrente (OperadorDAO operadorDao,long idOperador, int retardo){
		this.operadorDao = operadorDao;
		this.idOperador = idOperador;
		this.retardo = retardo;
		
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	
	public void run() {
		try {
			Thread.sleep(this.retardo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.pedido = this.operadorDao.siguientePedido(this.idOperador);
	}
	
	public boolean isAlive(){
		return this.hilo.isAlive();
	}
	
	public Pedido getPedido(){
		return this.pedido;
	}

}
