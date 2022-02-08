package br.com.agenciadeviagensrosa.model;

public class Promocoes {
	private int id;
    private int fk_destino;
    private String data;
    private double valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFk_destino() {
		return fk_destino;
	}
	public void setFk_destino(int fk_destino) {
		this.fk_destino = fk_destino;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
    
    

}
