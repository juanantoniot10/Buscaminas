package control;

public enum NumeroMinas {
	treinta(30), sesenta(60), cien(100);
	private int valor;

	private NumeroMinas(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
