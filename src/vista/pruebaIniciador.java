package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Densidad;
import control.Iniciador;

public class pruebaIniciador extends JFrame {

	private JPanel contentPane;
	private JTextField txtMinas;
	private Iniciador iniciador=new Iniciador();
	private JComboBox cbxDensidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaIniciador frame = new pruebaIniciador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pruebaIniciador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minas");
		lblNewLabel.setBounds(42, 75, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtMinas = new JTextField();
		txtMinas.setBounds(104, 72, 86, 20);
		contentPane.add(txtMinas);
		txtMinas.setColumns(10);
		
		JLabel lblDensidad = new JLabel("densidad");
		lblDensidad.setBounds(42, 141, 46, 14);
		contentPane.add(lblDensidad);
		
		cbxDensidad = new JComboBox();
		cbxDensidad.setModel(new DefaultComboBoxModel(Densidad.values()));
		cbxDensidad.setBounds(104, 138, 86, 20);
		contentPane.add(cbxDensidad);
		
		JButton btnCreatablero = new JButton("CreaTablero");
		btnCreatablero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciador.iniciarJuego(Byte.valueOf(txtMinas.getText()),(Densidad)cbxDensidad.getSelectedItem());
			}
		});
		btnCreatablero.setBounds(201, 192, 113, 23);
		contentPane.add(btnCreatablero);
	}
}
