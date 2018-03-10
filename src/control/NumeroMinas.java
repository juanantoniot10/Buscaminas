package control;

public enum NumeroMinas {
	diez(10), veinte(20), treinta(30);
	private int valor;

	private NumeroMinas(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
