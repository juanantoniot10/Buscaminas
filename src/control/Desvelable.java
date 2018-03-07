package control;

import modelo.Casilla;

public interface Desvelable {
	/**
	 * Devela una casilla velada y sigue el mecanismo de desvelo impuesto
	 * @param casilla
	 * @return
	 */
	boolean desvelarCasilla(Casilla casilla);
}
