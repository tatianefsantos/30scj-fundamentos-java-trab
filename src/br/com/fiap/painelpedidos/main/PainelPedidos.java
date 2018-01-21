package br.com.fiap.painelpedidos.main;

import br.com.fiap.painelpedidos.IPanelController;
import br.com.fiap.painelpedidos.impl.PanelController;
import br.com.fiap.painelpedidos.sinc.Pedido;
import br.com.fiap.painelpedidos.thread.Balcao;
import br.com.fiap.painelpedidos.thread.Cliente;

public class PainelPedidos {
	public static void main(String[] args) {
		IPanelController display = new PanelController();
		Pedido pedido = new Pedido(); 
		Balcao p1 = new Balcao(display, pedido); 
		Cliente c1 = new Cliente(display, pedido); 
		p1.start();
		c1.start();
	}
}
