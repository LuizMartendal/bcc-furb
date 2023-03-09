import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Apresentacao {

	private JFrame frmEvento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmEvento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEvento = new JFrame();
		frmEvento.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rique\\OneDrive\\Imagens\\Saved Pictures\\D2WKIB.jpg"));
		frmEvento.setTitle("Evento");
		frmEvento.setBounds(100, 100, 450, 300);
		frmEvento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEvento.getContentPane().setLayout(null);
		
		JPanel painel_cadastrar_evento = new JPanel();
		painel_cadastrar_evento.setBounds(0, 0, 434, 261);
		frmEvento.getContentPane().add(painel_cadastrar_evento);
		painel_cadastrar_evento.setLayout(null);
		
		JLabel lblCadastrar_evento = new JLabel("Cadastrar evento");
		lblCadastrar_evento.setFont(new Font("Arial", Font.BOLD, 16));
		lblCadastrar_evento.setBounds(153, 11, 165, 40);
		painel_cadastrar_evento.add(lblCadastrar_evento);
		
		JLabel lblTitulo_evento = new JLabel("Título:");
		lblTitulo_evento.setBounds(10, 77, 46, 25);
		painel_cadastrar_evento.add(lblTitulo_evento);
		
		JLabel lblTitulo = new JLabel("FURB");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 33));
		lblTitulo.setBounds(164, 11, 100, 40);
		frmEvento.getContentPane().add(lblTitulo);
		
		JButton btnCadastrar_evento = new JButton("Cadastrar evento");
		btnCadastrar_evento.setBounds(123, 105, 185, 23);
		frmEvento.getContentPane().add(btnCadastrar_evento);
		
		JButton btnCadastrarShowMusical = new JButton("Cadastrar show musical");
		btnCadastrarShowMusical.setBounds(123, 139, 185, 23);
		frmEvento.getContentPane().add(btnCadastrarShowMusical);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(123, 173, 185, 23);
		frmEvento.getContentPane().add(btnConsultar);
		
		JPanel painel_cadastrar_show = new JPanel();
		painel_cadastrar_show.setBounds(0, 0, 434, 261);
		frmEvento.getContentPane().add(painel_cadastrar_show);
		painel_cadastrar_show.setLayout(null);
		
		JPanel painel_consultar = new JPanel();
		painel_consultar.setBounds(0, 0, 434, 261);
		frmEvento.getContentPane().add(painel_consultar);
	}
}
