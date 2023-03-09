import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

public class Apresentacao {

	private JFrame frmViagensjava;
	private JTextField tfNomeVendedor;
	private HashMap<String, Vendedor> vendedores = new HashMap<>();
	private JTextField tfConsultar;
	private JTextField tfKm;
	private JTextField tfDuracao;
	private JTextField tfValorVendas;
	private JTextField tfConsultarDado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmViagensjava.setVisible(true);
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
		frmViagensjava = new JFrame();
		frmViagensjava.setForeground(Color.BLACK);
		frmViagensjava.setFont(new Font("Arial", Font.PLAIN, 15));
		frmViagensjava.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rique\\OneDrive\\Imagens\\Saved Pictures\\D2WKIB.jpg"));
		frmViagensjava.setTitle("Viagens.java");
		frmViagensjava.getContentPane().setBackground(Color.WHITE);
		frmViagensjava.setBounds(100, 100, 435, 300);
		frmViagensjava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViagensjava.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empresa de Viagens");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(129, 11, 157, 25);
		frmViagensjava.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 399, 203);
		frmViagensjava.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Vendedor", null, panel, null);
		panel.setLayout(null);
		
		JLabel jlNomeVendedor = new JLabel("Nome: ");
		jlNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeVendedor.setBounds(10, 8, 46, 20);
		panel.add(jlNomeVendedor);
		
		JButton btnAdicionar = new JButton("Adicionar Vendedor");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNomeVendedor.getText();
				Vendedor v = new Vendedor();
				v.setNome(nome);
				vendedores.put(nome, v);
				JOptionPane.showMessageDialog(null, "O vendededor " + vendedores.get(nome).getNome() + " foi adicionado com sucesso!!!");
				btnAdicionar.setEnabled(false);
			}
		});
		btnAdicionar.setEnabled(false);
		btnAdicionar.setBounds(100, 114, 181, 23);
		panel.add(btnAdicionar);
		
		tfNomeVendedor = new JTextField();
		tfNomeVendedor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String nome = tfNomeVendedor.getText();
				if (nome != null) {
					btnAdicionar.setEnabled(true);
				}
			}
		});
		tfNomeVendedor.setBounds(60, 9, 167, 20);
		panel.add(tfNomeVendedor);
		tfNomeVendedor.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Viagem", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel jlNomeVendedor_1 = new JLabel("Nome: ");
		jlNomeVendedor_1.setBounds(10, 11, 40, 15);
		jlNomeVendedor_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(jlNomeVendedor_1);
		
		JButton btnAdicionarViagem = new JButton("Adicionar");
		btnAdicionarViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfKm.getText().equals("") && !tfDuracao.getText().equals("") && !tfValorVendas.getText().equals("")) {
					String vendedor = tfConsultar.getText();
					int km = Integer.parseInt(tfKm.getText());
					int duracao = Integer.parseInt(tfDuracao.getText());
					float valor = Float.parseFloat(tfValorVendas.getText());
					Viagens viagens = new Viagens(km, duracao, valor);
					for (Vendedor v: vendedores.values()) {
						v.addViagem(viagens);
						vendedores.put(vendedor, v);
						JOptionPane.showMessageDialog(null, "Viagem adicionada com sucesso!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				}
				btnAdicionarViagem.setEnabled(false);
			}
		});
		btnAdicionarViagem.setBounds(295, 127, 89, 20);
		panel_1.add(btnAdicionarViagem);
		btnAdicionarViagem.setEnabled(false);
		
		JButton btnConsultarVendedor = new JButton("Consultar");
		btnConsultarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfConsultar.getText();
				if (!tfConsultar.getText().equals("") && vendedores.get(nome) != null	) {
					JOptionPane.showMessageDialog(null, "Você escolheu o vendedor " + nome);
					btnConsultarVendedor.setEnabled(false);
					tfKm.setEnabled(true);
					tfDuracao.setEnabled(true);
					tfValorVendas.setEnabled(true);
					btnAdicionarViagem.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Vendedor não encontrado!");
					btnConsultarVendedor.setEnabled(false);
				}
			}
		});
		btnConsultarVendedor.setBounds(295, 9, 89, 20);
		panel_1.add(btnConsultarVendedor);
		btnConsultarVendedor.setEnabled(false);
		
		tfConsultar = new JTextField();
		tfConsultar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String nome = tfConsultar.getText();
				if (nome != null) {
					btnConsultarVendedor.setEnabled(true);
				}
			}
		});
		tfConsultar.setColumns(10);
		tfConsultar.setBounds(106, 9, 167, 20);
		panel_1.add(tfConsultar);
		
		JLabel lbKm = new JLabel("KM:");
		lbKm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbKm.setBounds(10, 42, 46, 15);
		panel_1.add(lbKm);
		
		tfKm = new JTextField();
		tfKm.setBounds(116, 40, 86, 20);
		panel_1.add(tfKm);
		tfKm.setColumns(10);
		tfKm.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Duração:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 73, 75, 15);
		panel_1.add(lblNewLabel_1);
		
		tfDuracao = new JTextField();
		tfDuracao.setBounds(116, 71, 86, 20);
		panel_1.add(tfDuracao);
		tfDuracao.setColumns(10);
		tfDuracao.setEnabled(false);
		
		JLabel lblNewLabel_2 = new JLabel("Valor em Vendas:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 103, 112, 15);
		panel_1.add(lblNewLabel_2);
		
		tfValorVendas = new JTextField();
		tfValorVendas.setBounds(116, 102, 86, 20);
		panel_1.add(tfValorVendas);
		tfValorVendas.setColumns(10);
		tfValorVendas.setEnabled(false);
	
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 394, 175);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Viajante com maior valor a receber", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Dados de um vendedor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 23, 389, 108);
		panel_3.add(textArea);
		
		JButton btnConsultarDados = new JButton("Consultar");
		btnConsultarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_a_consultar = tfConsultarDado.getText();
				if (vendedores.get(nome_a_consultar) != null) {
					String nome = vendedores.get(nome_a_consultar).getNome();
					String viagens = "";
					Vendedor vendedor = vendedores.get(nome);
					for (int i = 0; i < vendedor.getQtdViagens(); i++ ) {
						Viagens v = vendedor.getViagem(i);
						viagens += "Dia " + v.getDuracao() + " KM " + v.getKm() + " Vendas R$" +v.getValorVendas() + "\n";
					}
					textArea.setText("Nome " + nome 
									+"\n" +viagens
									+"\nTotal KM: " + vendedor.getTotalKm() + "	Total a receber: " + vendedor.getValorAPagar());
				}else {
					JOptionPane.showMessageDialog(null, "Nome não encontrado!");
					btnConsultarDados.setEnabled(false);
				}
			}
		});
		btnConsultarDados.setBounds(300, 0, 89, 23);
		panel_3.add(btnConsultarDados);
		btnConsultarDados.setEnabled(false);
		
		tfConsultarDado = new JTextField();
		tfConsultarDado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!tfConsultarDado.getText().equals("")) {
					btnConsultarDados.setEnabled(true);
				}
			}
		});
		tfConsultarDado.setBounds(93, 1, 165, 20);
		panel_3.add(tfConsultarDado);
		tfConsultarDado.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 4, 46, 15);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Viagem de menor km", null, panel_4, null);
		panel_4.setLayout(null);
		
	}
}
