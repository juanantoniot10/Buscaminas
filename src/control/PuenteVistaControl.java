package control;

import javax.swing.JButton;

import vista.Botonera;
import vista.PantallaInicial;
import vista.Principal;

public class PuenteVistaControl extends Principal{
	Principal principal = new Principal();
	Iniciador iniciador = new Iniciador();
	Botonera botonera;
	ListenerInicio listenerInicio = new ListenerInicio(this.pantallaInicial,this.iniciador,this.botonera);
	
	
	public PuenteVistaControl() {
		super();
		this.pantallaInicial.getBtnJugar().addActionListener(listenerInicio);
	}
	
	
	
}
