package br.com.fiap.painelpedidos;

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
