package br.com.fiap.painelpedidos.thread;

import br.com.fiap.painelpedidos.IPanelController;
import br.com.fiap.painelpedidos.sinc.Pedido;

public class Cliente extends Thread {
	private Pedido pedido;
	private IPanelController display;
	public Cliente(IPanelController d, Pedido pedido) {
		this.display = d; 
		this.pedido = pedido; 
	}
	public void run() {
		for (int i = 0; i < 20; i++) { 
			String[] c = pedido.retiraPedido().split(" "); 
			System.out.println("Pedido retirado: " + c[0]); 
			display.deleteRow(Integer.parseInt(c[1]));
			try {
				sleep((int)(Math.random() * 4000)); 
			} catch (InterruptedException e) { }
		}
	}
}