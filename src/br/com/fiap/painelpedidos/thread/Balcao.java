package br.com.fiap.painelpedidos.thread;

import java.text.DecimalFormat;

import br.com.fiap.painelpedidos.IPanelController;
import br.com.fiap.painelpedidos.sinc.Pedido;

public class Balcao extends Thread {
	private Pedido pedido;
	private IPanelController display;
	DecimalFormat df = new DecimalFormat("##");

	public Balcao(IPanelController d, Pedido pedido) {
		this.display = d; 
		this.pedido = pedido; 
	}

	public void run() {
		String c;
		for (int i = 0; i < 20; i++) { 
			c = df.format(Math.random() * 26); 
			pedido.adicionaPedido(c); 
			System.out.println("Adicionado pedido " + c + " na fila."); 
			display.addRow(c);
			try {
				sleep((int)(Math.random() * 1000)); 
			} catch (InterruptedException e) { }
		}
	}
}