// Luiz Henrique Martendal; Daniel de Paula;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Apresentacao {

	private JFrame frmGerenciadorDeLinhas;
	private JTextField tfCadastrar_usuario;
	private JTextField tfEspecializado_numero;
	private JTextField tfEspecializado_endereco;
	private JTextField tfEspecializado_data;
	private JTextField tfEspecializado_qtd;
	private JTextField tfEspecializado_nome;
	private JTextField tfComercial_endereco;
	private JTextField tfComercial_numero;
	private JTextField tfComercial_data;
	private JTextField tfComercial_ramo;
	private JTextField tfComercial_nome;
	private JTextField tfResidencial_endereco;
	private JTextField tfResidencial_numero;
	private JTextField tfResidencial_data;
	private JTextField tfResidencial_nome;
	private JPanel painel_inicial;
	private JPanel painel_cadastrar;
	private JTextField tfConsultar_telefone;
	private Empresa empresa = new Empresa();
	private JButton btnCadastrar_especializado;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
	private JCheckBox cbxinternet;
	private JPanel painel_consultar;
	private JTextArea txtConsultar_telefone;
	private JTextArea txtFaturamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmGerenciadorDeLinhas.setVisible(true);
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
		frmGerenciadorDeLinhas = new JFrame();
		frmGerenciadorDeLinhas.getContentPane().setBackground(new Color(224, 255, 255));
		frmGerenciadorDeLinhas.setBackground(SystemColor.textHighlight);
		frmGerenciadorDeLinhas.setForeground(SystemColor.textHighlight);
		frmGerenciadorDeLinhas.setTitle("Gerenciador de linhas telefonicas");
		frmGerenciadorDeLinhas.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rique\\OneDrive\\Imagens\\Saved Pictures\\D2WKIB.jpg"));
		frmGerenciadorDeLinhas.setFont(new Font("Arial Black", Font.BOLD, 12));
		frmGerenciadorDeLinhas.setBounds(100, 100, 450, 300);
		frmGerenciadorDeLinhas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciadorDeLinhas.getContentPane().setLayout(null);
		
		painel_cadastrar = new JPanel();
		painel_cadastrar.setVisible(false);
		
		painel_consultar = new JPanel();
		painel_consultar.setVisible(false);
		painel_consultar.setEnabled(false);
		painel_consultar.setBackground(SystemColor.textHighlight);
		painel_consultar.setBounds(0, 0, 434, 261);
		frmGerenciadorDeLinhas.getContentPane().add(painel_consultar);
		painel_consultar.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPane.setBackground(SystemColor.textHighlight);
		tabbedPane.setBounds(0, 25, 434, 236);
		painel_consultar.add(tabbedPane);
		
		JPanel painel_consultar_telefone = new JPanel();
		painel_consultar_telefone.setBackground(SystemColor.textHighlight);
		tabbedPane.addTab("Consultar dados de um telefone", null, painel_consultar_telefone, null);
		painel_consultar_telefone.setLayout(null);
		
		JLabel lblConsultar_numero = new JLabel("Número:");
		lblConsultar_numero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblConsultar_numero.setForeground(SystemColor.text);
		lblConsultar_numero.setBounds(10, 11, 66, 21);
		painel_consultar_telefone.add(lblConsultar_numero);
		
		tfConsultar_telefone = new JTextField();
		tfConsultar_telefone.setBounds(105, 10, 98, 21);
		painel_consultar_telefone.add(tfConsultar_telefone);
		tfConsultar_telefone.setColumns(10);
		
		JButton btnConsultar_telefone = new JButton("Consultar");
		btnConsultar_telefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtConsultar_telefone.setText("");
					String numero = tfConsultar_telefone.getText();
					LinhaTelefonica t = empresa.getTelefone(numero);
					String tipo = t.getTipo();
					String endereco = t.getEnderecoInstalacao();
					LocalDate data = t.getDataInstalacao();
					String nome = t.getNome();
					double valor = t.getValorFixo();
					//
					if (tipo.equals("residencial")) {
						String internet = t.getTemConexaoInternet();
						txtConsultar_telefone.setText("Nome: " + nome + "\n"
													  + "Número: " + numero + "\n"
													  + "Tipo de linha: " + tipo + "\n"
													  + "Endereço de intalação: " + endereco + "\n"
													  + "Data de intalação: " + data + "\n"
													  + "Conexão com intenet: " + internet + "\n"
													  + "Valor a pagar: " + valor);
					}else if (tipo.equals("comercial")) {
						String ramo = t.getRamoAtividade();
						txtConsultar_telefone.setText("Nome: " + nome + "\n"
								  					  + "Número: " + numero + "\n"
								  					  + "Tipo de linha: " + tipo + "\n"
								  					  + "Endereço de intalação: " + endereco + "\n"
								  					  + "Data de intalação: " + data + "\n"
								  					  + "Ramo de atividade: " + ramo + "\n"
								  					  + "Valor a pagar: " + valor);
					}else {
						int qtd = t.getQtdOcorrencias();
						txtConsultar_telefone.setText("Nome: " + nome + "\n"
								  					  + "Número: " + numero + "\n"
								  					  + "Tipo de linha: " + tipo + "\n"
								  					  + "Endereço de intalação: " + endereco + "\n"
								  					  + "Data de intalação: " + data + "\n"
								  					  + "Quantidade de ocorrências: " + qtd + "\n"
								  					  + "Valor a pagar: " + valor);
					}
				}catch(IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Número não cadastrado.");
				}
			}
		});
		btnConsultar_telefone.setBackground(SystemColor.textHighlight);
		btnConsultar_telefone.setForeground(SystemColor.text);
		btnConsultar_telefone.setBounds(313, 10, 106, 22);
		painel_consultar_telefone.add(btnConsultar_telefone);
		
		txtConsultar_telefone = new JTextArea();
		txtConsultar_telefone.setEditable(false);
		txtConsultar_telefone.setBounds(10, 43, 409, 154);
		painel_consultar_telefone.add(txtConsultar_telefone);
		
		JPanel painel_consultar_faturamento = new JPanel();
		painel_consultar_faturamento.setBackground(SystemColor.textHighlight);
		tabbedPane.addTab("Consultar faturamento da empresa", null, painel_consultar_faturamento, null);
		painel_consultar_faturamento.setLayout(null);
		
		JButton btnConsultar_faturamento = new JButton("Consultar");
		btnConsultar_faturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFaturamento.setText("");
				double faturamento = empresa.getFaturamento();
				txtFaturamento.setText("Faturamento da empresa: R$" + faturamento);
			}
		});
		btnConsultar_faturamento.setForeground(SystemColor.text);
		btnConsultar_faturamento.setBackground(SystemColor.textHighlight);
		btnConsultar_faturamento.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConsultar_faturamento.setBounds(161, 157, 110, 35);
		painel_consultar_faturamento.add(btnConsultar_faturamento);
		
		txtFaturamento = new JTextArea();
		txtFaturamento.setEditable(false);
		txtFaturamento.setBounds(10, 11, 409, 135);
		painel_consultar_faturamento.add(txtFaturamento);
		
		JButton btnVoltar_1 = new JButton("Menu");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_consultar.setEnabled(false);
				painel_consultar.setVisible(false);
				painel_inicial.setEnabled(true);
				painel_inicial.setVisible(true);
			}
		});
		btnVoltar_1.setForeground(Color.WHITE);
		btnVoltar_1.setFont(new Font("Arial", Font.BOLD, 11));
		btnVoltar_1.setBackground(SystemColor.textHighlight);
		btnVoltar_1.setBounds(0, 0, 89, 17);
		painel_consultar.add(btnVoltar_1);
		
		painel_inicial = new JPanel();
		painel_inicial.setBackground(SystemColor.textHighlight);
		painel_inicial.setBounds(0, 0, 434, 261);
		frmGerenciadorDeLinhas.getContentPane().add(painel_inicial);
		
		JButton btnCon = new JButton("Consultar");
		btnCon.setForeground(SystemColor.text);
		btnCon.setBackground(SystemColor.textHighlight);
		btnCon.setBounds(160, 118, 126, 27);
		btnCon.setFont(new Font("Arial", Font.BOLD, 16));
		btnCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_inicial.setEnabled(false);
				painel_inicial.setVisible(false);
				painel_consultar.setEnabled(true);
				painel_consultar.setVisible(true);
			}
		});
		painel_inicial.setLayout(null);
		
		JLabel lblLogo = new JLabel("FURB");
		lblLogo.setBounds(160, 23, 126, 52);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		painel_inicial.add(lblLogo);
		lblLogo.setBackground(new Color(0, 0, 255));
		lblLogo.setForeground(new Color(0, 0, 128));
		lblLogo.setFont(new Font("Verdana", Font.BOLD, 42));
		painel_inicial.add(btnCon);
		
		JButton btnCad = new JButton("Cadastrar");
		btnCad.setBackground(SystemColor.textHighlight);
		btnCad.setForeground(Color.WHITE);
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_inicial.setEnabled(false);
				painel_inicial.setVisible(false);
				painel_cadastrar.setEnabled(true);
				painel_cadastrar.setVisible(true);
			}
		});
		btnCad.setBounds(160, 173, 126, 27);
		btnCad.setFont(new Font("Arial", Font.BOLD, 16));
		painel_inicial.add(btnCad);
		painel_cadastrar.setEnabled(false);
		painel_cadastrar.setBackground(SystemColor.textHighlight);
		painel_cadastrar.setBounds(0, 0, 434, 261);
		frmGerenciadorDeLinhas.getContentPane().add(painel_cadastrar);
		painel_cadastrar.setLayout(null);
		
		JButton btnVoltar = new JButton("Menu");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 11));
		btnVoltar.setForeground(SystemColor.text);
		btnVoltar.setBackground(SystemColor.textHighlight);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_cadastrar.setEnabled(false);
				painel_cadastrar.setVisible(false);
				painel_inicial.setEnabled(true);
				painel_inicial.setVisible(true);
			}
		});
		btnVoltar.setBounds(335, 4, 89, 17);
		painel_cadastrar.add(btnVoltar);
		
		JTabbedPane tabbedPane_cadastrar = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_cadastrar.setForeground(SystemColor.text);
		tabbedPane_cadastrar.setBackground(SystemColor.textHighlight);
		tabbedPane_cadastrar.setBounds(0, 0, 434, 261);
		tabbedPane_cadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		painel_cadastrar.add(tabbedPane_cadastrar);
		
		JPanel painel_cadastrar_usuario = new JPanel();
		painel_cadastrar_usuario.setBackground(SystemColor.textHighlight);
		tabbedPane_cadastrar.addTab("Usuário", null, painel_cadastrar_usuario, null);
		painel_cadastrar_usuario.setLayout(null);
		
		JLabel lblCadastrar_usuario = new JLabel("Nome:");
		lblCadastrar_usuario.setForeground(SystemColor.text);
		lblCadastrar_usuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastrar_usuario.setBounds(10, 35, 46, 14);
		painel_cadastrar_usuario.add(lblCadastrar_usuario);
		
		tfCadastrar_usuario = new JTextField();
		tfCadastrar_usuario.setBounds(92, 33, 271, 20);
		painel_cadastrar_usuario.add(tfCadastrar_usuario);
		tfCadastrar_usuario.setColumns(10);
		
		JButton btnCadastrar_usuario = new JButton("Cadastrar");
		btnCadastrar_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = tfCadastrar_usuario.getText();
					empresa.addUsuario(nome);
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
					tfCadastrar_usuario.setText("");
				}catch(IllegalArgumentException iae){
					JOptionPane.showMessageDialog(null, iae);
					tfCadastrar_usuario.requestFocus();
				}
				
			}
		});
		btnCadastrar_usuario.setBackground(SystemColor.textHighlight);
		btnCadastrar_usuario.setForeground(SystemColor.text);
		btnCadastrar_usuario.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar_usuario.setBounds(160, 169, 110, 35);
		painel_cadastrar_usuario.add(btnCadastrar_usuario);
		
		JPanel painel_cadastrar_telefone = new JPanel();
		painel_cadastrar_telefone.setForeground(SystemColor.text);
		painel_cadastrar_telefone.setBackground(SystemColor.textHighlight);
		tabbedPane_cadastrar.addTab("Telefone", null, painel_cadastrar_telefone, null);
		painel_cadastrar_telefone.setLayout(null);
		
		JTabbedPane tabbedPane_telefone = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_telefone.setForeground(SystemColor.text);
		tabbedPane_telefone.setBackground(SystemColor.textHighlight);
		tabbedPane_telefone.setBounds(10, 11, 409, 208);
		painel_cadastrar_telefone.add(tabbedPane_telefone);
		
		JPanel painel_especializado = new JPanel();
		painel_especializado.setForeground(SystemColor.text);
		painel_especializado.setBackground(SystemColor.textHighlight);
		tabbedPane_telefone.addTab("especializado", null, painel_especializado, null);
		painel_especializado.setLayout(null);
		
		JLabel lblEspecializado_numero = new JLabel("Número:");
		lblEspecializado_numero.setForeground(SystemColor.text);
		lblEspecializado_numero.setBounds(10, 11, 69, 14);
		painel_especializado.add(lblEspecializado_numero);
		
		JLabel lblEspecializado_endereco = new JLabel("Endereço de instalação:");
		lblEspecializado_endereco.setForeground(SystemColor.text);
		lblEspecializado_endereco.setBounds(10, 36, 161, 14);
		painel_especializado.add(lblEspecializado_endereco);
		
		JLabel lblEspecializacao_data = new JLabel("Data de instalação:");
		lblEspecializacao_data.setForeground(SystemColor.text);
		lblEspecializacao_data.setBounds(10, 61, 131, 14);
		painel_especializado.add(lblEspecializacao_data);
		
		JLabel lblEspecializacao_qtd = new JLabel("Quantidade de ocorrências:");
		lblEspecializacao_qtd.setForeground(SystemColor.text);
		lblEspecializacao_qtd.setBounds(10, 86, 180, 14);
		painel_especializado.add(lblEspecializacao_qtd);
		
		tfEspecializado_numero = new JTextField();
		tfEspecializado_numero.setBounds(181, 8, 86, 20);
		painel_especializado.add(tfEspecializado_numero);
		tfEspecializado_numero.setColumns(10);
		
		tfEspecializado_endereco = new JTextField();
		tfEspecializado_endereco.setBounds(181, 33, 213, 20);
		painel_especializado.add(tfEspecializado_endereco);
		tfEspecializado_endereco.setColumns(10);
		
		tfEspecializado_data = new JTextField();
		tfEspecializado_data.setBounds(181, 58, 86, 20);
		painel_especializado.add(tfEspecializado_data);
		tfEspecializado_data.setColumns(10);
		
		tfEspecializado_qtd = new JTextField();
		tfEspecializado_qtd.setBounds(181, 83, 213, 20);
		painel_especializado.add(tfEspecializado_qtd);
		tfEspecializado_qtd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do usuário:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(10, 111, 131, 14);
		painel_especializado.add(lblNewLabel);
		
		tfEspecializado_nome = new JTextField();
		tfEspecializado_nome.setBounds(181, 108, 213, 20);
		painel_especializado.add(tfEspecializado_nome);
		tfEspecializado_nome.setColumns(10);
		
		
		btnCadastrar_especializado = new JButton("Cadastrar");
		btnCadastrar_especializado.setBackground(SystemColor.textHighlight);
		btnCadastrar_especializado.setForeground(SystemColor.text);
		btnCadastrar_especializado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String numero = tfEspecializado_numero.getText();
					String endereco = tfEspecializado_endereco.getText();
					LocalDate data = LocalDate.parse(tfEspecializado_data.getText(), formatter);
					int qtd = Integer.parseInt(tfEspecializado_qtd.getText());
					String nome = tfEspecializado_nome.getText();
					//
					empresa.getUsuario(nome).addTelefone(nome, numero, "especializado", endereco, data);
					empresa.getUsuario(nome).getTelefone(numero).setQtdOcorrencias(qtd);
					JOptionPane.showMessageDialog(null, "Telefone do tipo especializado. Adicionado com sucesso para o usuário " + nome);
					//
					tfEspecializado_numero.setText("");
					tfEspecializado_endereco.setText("");
					tfEspecializado_data.setText("");
					tfEspecializado_qtd.setText("");
					tfEspecializado_nome.setText("");
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(null, "Data com formato inválido.");
				}
			}
		});
		btnCadastrar_especializado.setBounds(150, 146, 110, 23);
		painel_especializado.add(btnCadastrar_especializado);
		
		JPanel painel_comercial = new JPanel();
		painel_comercial.setForeground(SystemColor.text);
		painel_comercial.setBackground(SystemColor.textHighlight);
		tabbedPane_telefone.addTab("comercial", null, painel_comercial, null);
		painel_comercial.setLayout(null);
		
		JLabel lblComercial_numero = new JLabel("Número:");
		lblComercial_numero.setForeground(SystemColor.text);
		lblComercial_numero.setBounds(10, 11, 66, 14);
		painel_comercial.add(lblComercial_numero);
		
		JLabel lblComercial_endereco = new JLabel("Endereço de instalação:");
		lblComercial_endereco.setForeground(SystemColor.menu);
		lblComercial_endereco.setBounds(10, 36, 147, 14);
		painel_comercial.add(lblComercial_endereco);
		
		JLabel lblComercial_data = new JLabel("Data de instalação:");
		lblComercial_data.setForeground(SystemColor.text);
		lblComercial_data.setBounds(10, 61, 147, 14);
		painel_comercial.add(lblComercial_data);
		
		JLabel lblComercial_ramo = new JLabel("Ramo de atividade:");
		lblComercial_ramo.setForeground(SystemColor.text);
		lblComercial_ramo.setBounds(10, 86, 147, 14);
		painel_comercial.add(lblComercial_ramo);
		
		JLabel lblComercial_nome = new JLabel("Nome do usuário:");
		lblComercial_nome.setForeground(SystemColor.text);
		lblComercial_nome.setBounds(10, 111, 147, 14);
		painel_comercial.add(lblComercial_nome);
		
		tfComercial_endereco = new JTextField();
		tfComercial_endereco.setColumns(10);
		tfComercial_endereco.setBounds(181, 33, 213, 20);
		painel_comercial.add(tfComercial_endereco);
		
		tfComercial_numero = new JTextField();
		tfComercial_numero.setBounds(181, 8, 86, 20);
		painel_comercial.add(tfComercial_numero);
		tfComercial_numero.setColumns(10);
		
		tfComercial_data = new JTextField();
		tfComercial_data.setBounds(181, 58, 86, 20);
		painel_comercial.add(tfComercial_data);
		tfComercial_data.setColumns(10);
		
		tfComercial_ramo = new JTextField();
		tfComercial_ramo.setBounds(181, 83, 213, 20);
		painel_comercial.add(tfComercial_ramo);
		tfComercial_ramo.setColumns(10);
		
		tfComercial_nome = new JTextField();
		tfComercial_nome.setBounds(181, 108, 213, 20);
		painel_comercial.add(tfComercial_nome);
		tfComercial_nome.setColumns(10);
		
		JButton btnComercial_cadastrar = new JButton("Cadastrar");
		btnComercial_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String numero = tfComercial_numero.getText();
					String endereco = tfComercial_endereco.getText();
					LocalDate data = LocalDate.parse(tfComercial_data.getText(), formatter);
					String ramo = tfComercial_ramo.getText();
					String nome = tfComercial_nome.getText();
					//
					empresa.getUsuario(nome).addTelefone(nome, numero, "comercial", endereco, data);
					empresa.getUsuario(nome).getTelefone(numero).setRamoAtividade(ramo);
					JOptionPane.showMessageDialog(null, "Telefone do tipo comercial. Adicionado com sucesso para o usuário " + nome);
					//
					tfComercial_numero.setText("");
					tfComercial_endereco.setText("");
					tfComercial_data.setText("");
					tfComercial_ramo.setText("");
					tfComercial_nome.setText("");
				}catch (IllegalArgumentException iae){
					JOptionPane.showMessageDialog(null, iae);
				}catch (DateTimeParseException dtae) {
					JOptionPane.showMessageDialog(null, "Data com formato inválido.");
				}
				
			}
		});
		btnComercial_cadastrar.setBackground(SystemColor.textHighlight);
		btnComercial_cadastrar.setForeground(SystemColor.text);
		btnComercial_cadastrar.setBounds(150, 146, 110, 23);
		painel_comercial.add(btnComercial_cadastrar);
		
		JPanel painel_residencial = new JPanel();
		painel_residencial.setForeground(SystemColor.controlLtHighlight);
		painel_residencial.setBackground(SystemColor.textHighlight);
		tabbedPane_telefone.addTab("residencial", null, painel_residencial, null);
		painel_residencial.setLayout(null);
		
		JLabel lblResidencial_numero = new JLabel("Número:");
		lblResidencial_numero.setForeground(SystemColor.text);
		lblResidencial_numero.setBounds(10, 11, 112, 14);
		painel_residencial.add(lblResidencial_numero);
		
		JLabel lblResidencial_endereco = new JLabel("Endereço de instalação:");
		lblResidencial_endereco.setForeground(SystemColor.menu);
		lblResidencial_endereco.setBounds(10, 36, 183, 14);
		painel_residencial.add(lblResidencial_endereco);
		
		JLabel lblResidencial_data = new JLabel("Data de instalação");
		lblResidencial_data.setForeground(SystemColor.text);
		lblResidencial_data.setBounds(10, 61, 183, 14);
		painel_residencial.add(lblResidencial_data);
		
		JLabel lblResidencial_internet = new JLabel("Possui conexão com a internet:");
		lblResidencial_internet.setForeground(SystemColor.text);
		lblResidencial_internet.setBounds(10, 86, 183, 14);
		painel_residencial.add(lblResidencial_internet);
		
		JLabel lblResidencial_nome = new JLabel("Nome do usuário:");
		lblResidencial_nome.setForeground(SystemColor.text);
		lblResidencial_nome.setBounds(10, 111, 183, 14);
		painel_residencial.add(lblResidencial_nome);
		
		tfResidencial_endereco = new JTextField();
		tfResidencial_endereco.setColumns(10);
		tfResidencial_endereco.setBounds(181, 33, 213, 20);
		painel_residencial.add(tfResidencial_endereco);
		
		tfResidencial_numero = new JTextField();
		tfResidencial_numero.setBounds(181, 8, 86, 20);
		painel_residencial.add(tfResidencial_numero);
		tfResidencial_numero.setColumns(10);
		
		tfResidencial_data = new JTextField();
		tfResidencial_data.setBounds(181, 58, 86, 20);
		painel_residencial.add(tfResidencial_data);
		tfResidencial_data.setColumns(10);
		
		tfResidencial_nome = new JTextField();
		tfResidencial_nome.setBounds(181, 108, 213, 20);
		painel_residencial.add(tfResidencial_nome);
		tfResidencial_nome.setColumns(10);
		
		JButton btnResidencial_cadastrar = new JButton("Cadastrar");
		btnResidencial_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Boolean internet;
					if (cbxinternet.isEnabled()) {
						internet = true;
					}else {
						internet = false;
					}
					String numero = tfResidencial_numero.getText();
					String endereco = tfResidencial_endereco.getText();
					LocalDate data = LocalDate.parse(tfResidencial_data.getText(), formatter);
					String nome = tfResidencial_nome.getText();
					//
					empresa.getUsuario(nome).addTelefone(nome, numero, "residencial", endereco, data);
					empresa.getUsuario(nome).getTelefone(numero).setTemConexaoInternet(internet);
					JOptionPane.showMessageDialog(null, "Telefone do tipo residencial. Adiconado com sucesso para o usuário " + nome);
					//
					tfResidencial_numero.setText("");
					tfResidencial_endereco.setText("");
					tfResidencial_data.setText("");
					tfResidencial_nome.setText("");
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(null, "Data com formato inválido.");
				}
			}
		});
		btnResidencial_cadastrar.setForeground(SystemColor.menu);
		btnResidencial_cadastrar.setBackground(SystemColor.textHighlight);
		btnResidencial_cadastrar.setBounds(150, 146, 110, 23);
		painel_residencial.add(btnResidencial_cadastrar);
		
		cbxinternet = new JCheckBox("");
		cbxinternet.setBackground(SystemColor.textHighlight);
		cbxinternet.setBounds(191, 82, 31, 22);
		painel_residencial.add(cbxinternet);
	}
}
