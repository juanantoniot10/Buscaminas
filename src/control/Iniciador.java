package control;

import javax.print.attribute.standard.NumberOfDocuments;

import junit.framework.Assert;
import modelo.Tablero;
import utiles.Utiles;

public class Iniciador implements Iniciable {
	private NumeroMinas minas;
	private Densidad densidad;
	private int filas,columnas;
	private Tablero tablero;

	@Override
	public void establecerDimensionTablero() {
		this.filas = (int) Math.sqrt((this.densidad.getValor() * this.minas.getValor()));
		this.columnas = (int) Math.sqrt((this.densidad.getValor() * this.minas.getValor()));
	}


	@Override
	public void crearTablero() {
		assert this.filas > 0 && this.columnas > 0 : "numero no valido de filas/columnas";
		this.tablero = new Tablero(filas, columnas);
	}

	@Override
	public void colocarMinas() {
 		assert this.tablero != null && minas !=null : "fallo al definir el tablero y/o el numero de minas";
 		boolean salida=false;
 		for (int i = 0; i < minas.getValor(); i++) {
			do {
				int x = Utiles.crearRandom(0, this.filas-1);
				int y = Utiles.crearRandom(0, this.columnas-1);
				// no se debe acceder directamente a las propiedades de otra clase
				// this.tablero.casillas[x][y].mina=true;
				if(this.tablero.colocarMina(x, y))salida=true;
			} while (salida==false);
		}
	}

	public void iniciarJuego(NumeroMinas minas, Densidad densidad) {
		setMinas(minas);
		setDensidad(densidad);
		establecerDimensionTablero();
		crearTablero();
		colocarMinas();
		this.tablero.calcularMinasAlrededor();
		
	}

	
	
	public NumeroMinas getMinas() {
		return minas;
	}

	public void setMinas(NumeroMinas minas) {
		assert minas!=null;
		this.minas = minas;
	}

	public Densidad getDensidad() {
		return densidad;
	}

	public void setDensidad(Densidad densidad2) {
		this.densidad = densidad2;
	}
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
