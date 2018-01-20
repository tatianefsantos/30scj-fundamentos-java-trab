package br.com.fiap.painelpedidos;

public interface IJDisplay {
    public int getRows();
    public int getCols();
    public void write(int row, int col, char c);
}
