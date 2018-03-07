package control;

import modelo.Casilla;

public interface Marcable {

	/**
	 * procede a marcar o desmarcar una casilla velada
	 * @param casilla
	 */
	boolean marcarCasilla(Casilla casilla);
}
