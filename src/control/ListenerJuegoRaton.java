package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import vista.Botonera;
import vista.PantallaInicial;

public class ListenerJuegoRaton extends MouseAdapter{
	
	private Botonera botonera;
	private Iniciador iniciador;


		public ListenerJuegoRaton(Botonera botonera, Iniciador iniciador) {
		super();
		this.botonera = botonera;
		this.iniciador = iniciador;
	}


		@Override
		public void mouseClicked(MouseEvent e) {
			int boton=e.getButton();
			switch (boton){
			case 1:if(iniciador.getTablero().getCasillas()[obtenerPosicionX(e)][obtenerPosicionY(e)].isVelada()) {
						Casilla casilla= this.iniciador.getTablero().getCasillas()[obtenerPosicionX(e)][obtenerPosicionY(e)];
						if(casilla.isMina()) {
							finalizarPartida();
						}
						else if (casilla.getAlrededor()!=0){
							descubrirUnaCasilla(e);
						}
						else {
							this.iniciador.getTablero().desvelarContigua(new Coordenada(obtenerPosicionX(e),obtenerPosicionY(e)));
						}
					}	
						actualizarBotonera();
			break;
			case 3:
				this.iniciador.getTablero().getCasillas()[obtenerPosicionX(e)][obtenerPosicionY(e)].setMarcada(!this.iniciador.getTablero().getCasillas()[obtenerPosicionX(e)][obtenerPosicionY(e)].isMarcada());
				actualizarBotonera();
			break;	
			}
		}
		
		
	private void descubrirUnaCasilla(MouseEvent e) {
		this.botonera.botones[obtenerPosicionX(e)][obtenerPosicionY(e)].setBackground(new Color(241, 241, 241));
		this.iniciador.getTablero().getCasillas()[obtenerPosicionX(e)][obtenerPosicionY(e)].setVelada(false);
	}

	private void finalizarPartida() {
		for (int i = 0; i < this.iniciador.getTablero().getCasillas().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasillas()[i].length; j++) {
				this.botonera.botones[i][j].setText(String.valueOf(iniciador.getTablero().getCasillas()[i][j].getAlrededor()));
				this.iniciador.getTablero().getCasillas()[i][j].setVelada(false);
			}
		}
	}

	private void actualizarBotonera() {
		for (int i = 0; i < this.iniciador.getTablero().getCasillas().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasillas()[i].length; j++) {
				if (!iniciador.getTablero().getCasillas()[i][j].isVelada()) {
					this.botonera.botones[i][j].setText(String.valueOf(iniciador.getTablero().getCasillas()[i][j].getAlrededor()));
					this.botonera.botones[i][j].setBackground(new Color(241, 241, 241));
				}
				else if (iniciador.getTablero().getCasillas()[i][j].isMarcada()) {
					this.botonera.botones[i][j].setText("x");
				}
				else this.botonera.botones[i][j].setText(" ");
			}
		}
	}

	private int obtenerPosicionX(MouseEvent e) {
		int posicionEspacio=String.valueOf(((JButton)e.getSource()).getName()).indexOf(' ');
		return Integer.valueOf(String.valueOf(((JButton)e.getSource()).getName()).substring(0,posicionEspacio));
	}

	private int obtenerPosicionY(MouseEvent e) {
		int posicionEspacio=String.valueOf(((JButton)e.getSource()).getName()).indexOf(' ');
		return Integer.valueOf(String.valueOf(((JButton)e.getSource()).getName()).substring(posicionEspacio+1));
	}

	public void setIniciador(Iniciador iniciador) {
		this.iniciador = iniciador;
	}

	public Botonera getBotonera() {
		return botonera;
	}

	public void setBotonera(Botonera botonera) {
		this.botonera = botonera;
	}

	public Iniciador getIniciador() {
		return iniciador;
	}
}
