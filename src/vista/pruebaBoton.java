package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utiles.Utiles;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pruebaBoton extends JFrame {

	private JPanel contentPane;
	private boolean estado = false;
	// lo de las imagenes es para gente que se aburre
	protected ImageIcon bandera = new ImageIcon(getClass().getResource("/assets/banderaPeque.png"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaBoton frame = new pruebaBoton();
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
	public pruebaBoton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton pulsado = (JButton) e.getSource();
				switch (e.getButton()) {
				case 1:
					System.out.println("boton izquierda");
					pulsado.setContentAreaFilled(estado);
					pulsado.setText("5");
					break;
				case 3:
					// System.out.println("boton derecho");
					if (estado) {
						// pulsado.setText("X");
						pulsado.setIcon(Utiles.createScaledIcon(bandera, pulsado.getHeight()));
					} else {
						// pulsado.setText("");
						pulsado.setIcon(null);
					}
					estado = !estado;
					break;
				}
			}
		});
		contentPane.add(button, BorderLayout.CENTER);
	}

}
