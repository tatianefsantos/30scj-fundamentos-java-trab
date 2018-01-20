package br.com.fiap.painelpedidos;

import java.awt.*;
import javax.swing.*;

public class JDisplay implements IJDisplay {

	private JFrame win;
	private PanelDisplay[][] text;
	private static int ROWS = 20;
	private static int COLS = 30;

	public JDisplay() {
		win = new JFrame();
		win.getContentPane().setLayout(new GridLayout(ROWS, COLS));
		win.setTitle("Painel de pedidos");
		text = new PanelDisplay[ROWS][COLS];
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < COLS; j++) {
				text[i][j] = new PanelDisplay();
				win.getContentPane().add(text[i][j]);
			}
		win.pack();
		win.setVisible(true);
	}

	public int getRows() {
		return ROWS;
	}

	public int getCols() {
		return COLS;
	}

	public void write(int row, int col, char c) {
		text[row][col].write(c);
	}

}

class PanelDisplay extends JLabel {

	public PanelDisplay() {
		setText(" ");
		setFont(new Font("Monospaced", Font.BOLD, 20));
		setBackground(Color.BLACK);
		setForeground(Color.PINK);
		setOpaque(true);
	}

	public void write(final char c) {
		Runnable r = () -> setText(new Character(c).toString());
		SwingUtilities.invokeLater(r);
	};
}