package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vista.Botonera;
import vista.PantallaInicial;

public class ListenerInicio implements ActionListener {
	
	PantallaInicial pantallaInicial;
	Iniciador iniciador;
	Botonera botonera;
	
	
	public ListenerInicio(PantallaInicial pantallaInicial, Iniciador iniciador,Botonera botonera) {
		this.pantallaInicial = pantallaInicial;
		this.iniciador = iniciador;
		this.botonera = botonera;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.iniciador.iniciarJuego((NumeroMinas)this.pantallaInicial.getComboBoxMinas().getSelectedItem(),(Densidad) this.pantallaInicial.getComboBoxDificultad().getSelectedItem());
		this.botonera=new Botonera(iniciador.getFilas(), iniciador.getColumnas());
		JPanel padre = (JPanel) this.pantallaInicial.getParent();
		padre.remove(pantallaInicial);
		padre.add(this.botonera);
		SwingUtilities.updateComponentTreeUI(padre);
	}

}
