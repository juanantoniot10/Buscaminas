package vista;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame{
	protected PantallaInicial pantallaInicial;
	private JPanel panel;

	public Principal() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
	    panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		pantallaInicial = new PantallaInicial();
		pantallaInicial.getComboBoxMinas().setBounds(165, 79, 124, 23);
		pantallaInicial.getComboBoxDificultad().setBounds(165, 113, 120, 23);
		pantallaInicial.getBtnJugar().setBounds(186, 173, 65, 23);
		panel.add(pantallaInicial);
		pantallaInicial.setLayout(null);
	}
	
}
