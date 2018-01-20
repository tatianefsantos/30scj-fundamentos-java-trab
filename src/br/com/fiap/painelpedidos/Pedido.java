package br.com.fiap.painelpedidos;

import java.util.*;

public class Pedido {
	private ArrayList<String> pedidos = new ArrayList<String>();
	private int capacidade = 20;

	public synchronized int retiraPedido() {
		while (pedidos.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		int linhaPedido = (int) (Math.random() * pedidos.size());
		String numPedido = pedidos.get(linhaPedido);
		pedidos.remove(numPedido);
		pedidos.trimToSize();
		notifyAll();
		return (linhaPedido);
	}

	public synchronized void adicionaPedido(String c) {
		while (pedidos.size() == capacidade) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		pedidos.add(c);
		notifyAll();
	}
}
