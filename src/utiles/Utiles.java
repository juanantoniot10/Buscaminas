package utiles;

import java.awt.Image;

import javax.swing.ImageIcon;

import modelo.Coordenada;

public class Utiles {
	public static final int OCHO = 8;

	public static Coordenada damePosicionAlrededor(int lugar) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 },
				{ +1, +1 } };
		return new Coordenada(posicion[lugar][0], posicion[lugar][1]);
	}

	public static ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 2, height - 2, Image.SCALE_SMOOTH));

	}
}
