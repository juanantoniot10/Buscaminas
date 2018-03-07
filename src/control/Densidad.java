package control;

public enum Densidad {
	facil(10), medio(20), dificil(30);
	private int valor;

	private Densidad(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
}
