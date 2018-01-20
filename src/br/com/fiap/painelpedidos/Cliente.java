package br.com.fiap.painelpedidos;
class Cliente extends Thread {
	private Pedido pedido;
	private IPanelController display;
	public Cliente(IPanelController d, Pedido pedido) {
		this.display = d; 
		this.pedido = pedido; 
	}
	public void run() {
		for (int i = 0; i < 20; i++) { 
			int c = pedido.retiraPedido(); 
			System.out.println("Pedido retirado: " + c); 
			display.deleteRow(c);
			try {
				sleep((int)(Math.random() * 4000)); 
			} catch (InterruptedException e) { }
		}
	}
}