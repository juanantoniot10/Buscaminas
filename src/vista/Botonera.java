package vista;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Botonera extends JPanel {
	public JButton botones[][];
	/**
	 * Create the panel.
	 */
	public Botonera(int filas, int columnas) {
//		assert filas > 0 && columnas>0:"numero de columnas o filas vacio";
		GridLayout gridBotonera = new GridLayout(filas, columnas);
		gridBotonera.setHgap(-2);
		gridBotonera.setVgap(-2);
		gridBotonera.setColumns(columnas);
		gridBotonera.setRows(filas);
		setLayout(gridBotonera);
		iniciarBotonera(filas,columnas);
	}

	private void iniciarBotonera(int filas, int columnas) {
		this.botones = new JButton[filas][columnas];
		for (int i = 0; i < this.botones.length; i++) {
			for (int j = 0; j < this.botones[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setName(String.valueOf(i) + " " + String.valueOf(j));
				this.botones[i][j].setText(" ");
				this.add(this.botones[i][j]);
			}
		}
	}
}
