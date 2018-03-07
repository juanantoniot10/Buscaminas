package control;

import modelo.Casilla;
import modelo.Tablero;

public class Desvelador implements Desvelable{
	Tablero tablero;
	
	public Desvelador(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	@Override
	public boolean desvelarCasilla(Casilla casilla) {
		assert casilla!=null:"casilla no valida";
		// TODO llamamos a la casilla pero tambien al tablero
		//porque el tablero debe buscar recursivamente las casillas a desvelar
		
		return tablero.desvelarCasilla(casilla);
	}

}
