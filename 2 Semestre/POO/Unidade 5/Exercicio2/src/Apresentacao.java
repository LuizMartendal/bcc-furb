import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Apresentacao { 

	private JFrame frame;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfParecerista;
	private JTextField tfData;
	private JTextField tfConsulta;
	private Obra obraAtual;
	private HashMap<String, Obra> acervo = new HashMap<>();
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");
	private JTextArea taConteudo;
	private JButton btnAdicionarParecer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbTitulo = new JLabel("Titulo:");
		lbTitulo.setBounds(55, 39, 30, 14);
		frame.getContentPane().add(lbTitulo);

		tfTitulo = new JTextField();
		tfTitulo.setBounds(95, 36, 212, 20);
		frame.getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);

		JButton btnAdicionarObra = new JButton("Adicionar");
		btnAdicionarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// criar o objeto
					obraAtual = new Obra();
					// atribuir valores aos atributos
					obraAtual.setAutor(tfAutor.getText());
					obraAtual.setTitulo(tfTitulo.getText());
					// guardar o objeto para processamentos posteriores
					acervo.put(obraAtual.getTitulo(), obraAtual);
					JOptionPane.showMessageDialog(frame, "Obra adicionada");
					tfParecerista.setEnabled(true);
					tfData.setEnabled(true);
					taConteudo.setEnabled(true);
					btnAdicionarParecer.setEnabled(true);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(frame, iae.getMessage());
				}
			}
		});
		btnAdicionarObra.setBounds(335, 49, 89, 23);
		frame.getContentPane().add(btnAdicionarObra);

		JLabel lbAutor = new JLabel("Autor:");
		lbAutor.setBounds(55, 64, 42, 14);
		frame.getContentPane().add(lbAutor);

		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(95, 61, 212, 20);
		frame.getContentPane().add(tfAutor);

		JLabel lblParecer = new JLabel("Parecerista:");
		lblParecer.setBounds(31, 138, 66, 14);
		frame.getContentPane().add(lblParecer);

		tfParecerista = new JTextField();
		tfParecerista.setEnabled(false);
		tfParecerista.setColumns(10);
		tfParecerista.setBounds(95, 132, 212, 20);
		frame.getContentPane().add(tfParecerista);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(55, 159, 30, 14);
		frame.getContentPane().add(lblData);

		JLabel lblConteudo = new JLabel("Conteudo:");
		lblConteudo.setBounds(31, 184, 66, 14);
		frame.getContentPane().add(lblConteudo);

		tfData = new JTextField();
		tfData.setEnabled(false);
		tfData.setColumns(10);
		tfData.setBounds(95, 156, 116, 20);
		frame.getContentPane().add(tfData);

		btnAdicionarParecer = new JButton("Adicionar");
		btnAdicionarParecer.setEnabled(false);
		btnAdicionarParecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Parecer p = new Parecer();
					p.setParecerista(tfParecerista.getText());
					p.setData(LocalDate.parse(tfData.getText(), df));
					p.setConteudo(taConteudo.getText());
					obraAtual.addParecer(p);
					JOptionPane.showMessageDialog(frame, "Parecer adicionado");
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(frame, "Cadastre primeiro uma obra");
					tfTitulo.requestFocus();
				} catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(frame, "Data com formato inválido");
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(frame, iae.getMessage());
				}
			}
		});
		btnAdicionarParecer.setBounds(335, 155, 89, 23);
		frame.getContentPane().add(btnAdicionarParecer);

		JLabel lblInserirUm = new JLabel("Inserir uma Obra ");
		lblInserirUm.setBounds(144, 11, 99, 14);
		frame.getContentPane().add(lblInserirUm);

		JLabel lblInserirUmaParecer = new JLabel("Inserir um Parecer ");
		lblInserirUmaParecer.setBounds(133, 107, 99, 14);
		frame.getContentPane().add(lblInserirUmaParecer);

		JLabel lbTitulo_1 = new JLabel("Titulo:");
		lbTitulo_1.setBounds(31, 292, 30, 14);
		frame.getContentPane().add(lbTitulo_1);

		tfConsulta = new JTextField();
		tfConsulta.setColumns(10);
		tfConsulta.setBounds(71, 289, 212, 20);
		frame.getContentPane().add(tfConsulta);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Obra o = acervo.get(tfConsulta.getText());
				String s;
				if (o == null) {
					s = "Título não localizado";
				} else {
					s = "Título:" + o.getTitulo() + "\nAutor:" + o.getAutor() + "\nPareceres:";
					for (int i = 0; i < o.getQuantidadePareceres(); i++) {
						Parecer p = o.getParecer(i);
						s += "\n" + p.getParecerista() + " disse " + p.getConteudo() + " em " + df.format(p.getData());
					}
				}
				JOptionPane.showMessageDialog(frame, s);
			}
		});
		btnConsultar.setBounds(311, 288, 89, 23);
		frame.getContentPane().add(btnConsultar);

		JLabel lblConsultarUmTitulo = new JLabel("Consultar um Titulo");
		lblConsultarUmTitulo.setBounds(133, 264, 99, 14);
		frame.getContentPane().add(lblConsultarUmTitulo);

		taConteudo = new JTextArea();
		taConteudo.setEnabled(false);
		taConteudo.setBounds(95, 184, 212, 69);
		frame.getContentPane().add(taConteudo);
	}
}