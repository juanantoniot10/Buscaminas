package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import control.Marcador;
import modelo.Casilla;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pruebaMarcador extends JFrame {

	private JPanel contentPane;
	private Marcador marcador=new Marcador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaMarcador frame = new pruebaMarcador();
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
	public pruebaMarcador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		Casilla casillaVelada=new Casilla();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcador.marcarCasilla(casillaVelada);
				((JButton)e.getSource()).setText(String.valueOf(casillaVelada.isMarcada()));
			}
		});
		button.setBounds(66, 74, 84, 64);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		Casilla casillaDesvelada=new Casilla();
		casillaDesvelada.setVelada(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcador.marcarCasilla(casillaDesvelada);
				((JButton)e.getSource()).setText(String.valueOf(casillaDesvelada.isMarcada()));
			}
		});
		button_1.setBounds(151, 74, 84, 64);
		contentPane.add(button_1);
		
		JButton btnMouse = new JButton(" ");
		btnMouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int boton=e.getButton();
				switch (boton){
				case 1:System.out.println("soy el boton izq");break;
				case 2:System.out.println("soy el boton central");break;
				case 3:System.out.println("soy el boton dcha");break;
				default:System.out.println("soy el boton no lo tengo claro");break;
				}
			}
		});
		btnMouse.setBounds(61, 182, 89, 23);
		contentPane.add(btnMouse);
	}

}
