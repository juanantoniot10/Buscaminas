package control;

import javax.print.attribute.standard.NumberOfDocuments;

import modelo.Tablero;

public class Iniciador implements Iniciable {
	private byte minas;
	private Densidad densidad;

	public byte getMinas() {
		return minas;
	}

	public void setMinas(byte minas) {
		assert minas>0;
		this.minas = minas;
	}

	public Densidad getDensidad() {
		return densidad;
	}

	public void setDensidad(Densidad densidad) {
		assert densidad!=null;
		this.densidad = densidad;
	}

	private byte filas, columnas;
	private Tablero tablero;

	@Override
	public void establecerDimensionTablero() {
		// TODO hay que poner un numero de filas y columnas en base
		//al numero de minas y a la densidad
		int valorDensidad=this.densidad.getValor();
		
	}

	@Override
	public void crearTablero() {
		assert this.filas > 0 && this.columnas > 0 : "numero no valido de filas/columnas";
		// TODO crear el objeto tablero
	}

	@Override
	public void colocarMinas() {
		assert this.tablero != null && minas > 0 : "fallo al definir el tablero y/o el numero de minas";
		// TODO hay que hacer un sorteo y pedirle al tablero que la coloque
		int x = 9, y = 8;
		// no se debe acceder directamente a las propiedades de otra clase
		// this.tablero.casillas[x][y].mina=true;
		boolean retorno = this.tablero.colocarMina(x, y);
	}

	public void iniciarJuego(Byte minas, Densidad densidad) {
		setMinas(minas);
		setDensidad(densidad);
		establecerDimensionTablero();
		crearTablero();
		colocarMinas();
		this.tablero.calcularMinasAlrededor();
	}

}
