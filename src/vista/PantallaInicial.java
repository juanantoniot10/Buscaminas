package vista;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import control.Densidad;
import control.NumeroMinas;

public class PantallaInicial extends JPanel{
	private JButton btnJugar;
	private JComboBox comboBoxDificultad;
	private JComboBox comboBoxMinas;



	public PantallaInicial() {
		setLayout(null);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(160, 200, 89, 23);
		add(btnJugar);
		
		JLabel lblNumeroDeMinas = new JLabel("numero de minas");
		lblNumeroDeMinas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeMinas.setBounds(10, 79, 143, 14);
		add(lblNumeroDeMinas);
		
		comboBoxDificultad = new JComboBox();
		comboBoxDificultad.setModel(new DefaultComboBoxModel(Densidad.values()));
		comboBoxDificultad.setBounds(164, 107, 85, 20);
		add(comboBoxDificultad);
		
		JLabel lblDificultad = new JLabel("dificultad");
		lblDificultad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDificultad.setBounds(10, 110, 143, 14);
		add(lblDificultad);
		
		comboBoxMinas = new JComboBox();
		comboBoxMinas.setModel(new DefaultComboBoxModel(NumeroMinas.values()));
		comboBoxMinas.setBounds(160, 76, 89, 20);
		add(comboBoxMinas);
	}
	
	public JButton getBtnJugar() {
		return btnJugar;
	}
	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}

	public JComboBox getComboBoxDificultad() {
		return comboBoxDificultad;
	}

	public void setComboBoxDificultad(JComboBox comboBoxDificultad) {
		this.comboBoxDificultad = comboBoxDificultad;
	}

	public JComboBox getComboBoxMinas() {
		return comboBoxMinas;
	}

	public void setComboBoxMinas(JComboBox comboBox) {
		this.comboBoxMinas = comboBox;
	}
	
}
