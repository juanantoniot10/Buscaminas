package control;

interface Iniciable {
	
	
	/**
	 * En relacion al numero de minas y a la densidad se decide el numero
	 * de filas y columnas del tablero
	 */
	void establecerDimensionTablero();
	/**
	 * crea un objeto de tipo tablero, vacio, en base al numero de filas y columnas
	 * definido
	 */
	void crearTablero();
	/**
	 * coloca, aleatoriamente, en el tablero el numero de minas definido anteriormente
	 * cada mina debe colocarse donde no haya ya una colocada
	 */
	void colocarMinas();
	
}
