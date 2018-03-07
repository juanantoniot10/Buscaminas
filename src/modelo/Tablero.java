package modelo;

import javax.naming.event.NamespaceChangeListener;

import utiles.Utiles;

public class Tablero implements AccionesTablero {
	private Casilla[][] casillas;

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public Tablero(byte filas, byte columnas) {
		super();
		assert filas > 0 && columnas > 0 : "parametros incorrectos";
		// TODO Auto-generated constructor stub
		casillas = new Casilla[filas][columnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}

	@Override
	public void calcularMinasAlrededor() {
		// TODO recorrer el panel donde hay mina y colocar un incremento
		// de una mina alrededor de ella
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isMina()) {
					// VIVA el hardcode
					for (int j2 = 0; j2 < Utiles.OCHO; j2++) {
						Coordenada alrededor = crearCoordenadaAlrededor(i, j, j2);
						if (isInToLimits(alrededor)) {
							// ¿que nos preguntamos para incrementar en uno el
							// numero de minas alrededor de esta casilla
							if (!casillas[alrededor.getPosX()][alrededor.getPosY()].isMina()) {
								casillas[alrededor.getPosX()][alrededor.getPosY()].setAlrededor(
										(byte) (getAlrededor(alrededor) + 1));
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Crear la coordenada exacta con un posicion alrededor segun defina el
	 * lugar
	 * 
	 */
	public Coordenada crearCoordenadaAlrededor(int i, int j, int lugar) {
		Coordenada desplazamiento = Utiles.damePosicionAlrededor(lugar);
		// ¿Que nos estamos preguntando?
		int posX = i + desplazamiento.getPosX();
		int posY = j + desplazamiento.getPosY();
		return new Coordenada(posX, posY);
	}

	public boolean isInToLimits(Coordenada pos) {
		return isInside(pos, casillas.length) && isInside(pos, casillas[0].length);
	}

	public boolean isInside(Coordenada pos, int upperLimitRow) {
		return pos.getPosX() >= 0 && pos.getPosX() <= upperLimitRow;
	}

	public boolean colocarMina(int x, int y) {
		// no se debe acceder directamente a las propiedades de otra clase
		// casilla[x][y].mina=true;

		return casillas[x][y].colocaMina();
	}

	public boolean desvelarCasilla(Casilla casilla) {
		// TODO metodo reecursivo que a partir de un casilla desvelada (hay que
		// saber
		// cual es dentro del tablero) develada todas las de alrededor y
		// sucesivas que tengan
		// un valor de 0 minas alrededor
		return false;
	}

	@Override
	public void desvelarContigua(Coordenada lugar) {
		// lo que hay que hacer siempre
		// es velar una casilla
		setVelada(lugar);
		// comprobar si las casillas marcadas alrededor coincide con el
		// numero de minas alrededor de la casilla
		if (comprobarMarcadas(lugar)) {
			for (int i = 0; i < Utiles.OCHO; i++) {
				Coordenada posicion = crearCoordenadaAlrededor(lugar.getPosX(), lugar.getPosY(), i);
				if (isInToLimits(posicion)
						&& isVelada(posicion)
						&& !isMarcada(posicion)) {
					setVelada(lugar);
					if (getAlrededor(lugar) == 0)
						desvelarContigua(posicion);
				}
			}
		}
	}

	public byte getAlrededor(Coordenada lugar) {
		return casillas[lugar.getPosX()][lugar.getPosY()].getAlrededor();
	}

	public boolean isMarcada(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isMarcada();
	}

	public boolean isVelada(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isVelada();
	}

	public void setVelada(Coordenada lugar) {
		casillas[lugar.getPosX()][lugar.getPosY()].setVelada(false);
	}

	/**
	 * Comporbar si el numero de casillas marcadas alrededor de una casilla
	 * coincide con el numero de minas alrededor de una casilla
	 * 
	 * @param lugar
	 * @return
	 */
	private boolean comprobarMarcadas(Coordenada lugar) {
		int contador = 0;
		// es contar cuantas casilla marcadas rodean a la actual
		for (int i = 0; i < Utiles.OCHO; i++) {
			Coordenada posicion = crearCoordenadaAlrededor(lugar.getPosX(), lugar.getPosY(), i);
			if (isInToLimits(posicion)) {
				if (isMarcada(posicion)) {
					contador++;
				}
			}
		}
		boolean retorno = false;
		if (contador == getAlrededor(lugar)
				&& !casillas[lugar.getPosX()][lugar.getPosY()].isMina())
			retorno = true;
		return retorno;
	}

}
