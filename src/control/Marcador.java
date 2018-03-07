package control;

import modelo.Casilla;

public class Marcador implements Marcable{

	@Override
	public boolean marcarCasilla(Casilla casilla) {
		assert casilla!=null:"casilla no valida";
		return casilla.marcaCasilla();
	}

	
	
}
