//Luiz Henrique Martendal
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Apresentacao {
	
	private JFrame frmCmaraMunicipalDe;
	private JTextField tfCadastrar_vereador;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfTitulo_projeto;
	private JTextField tfDataApresen;
	private JTextField tfArtigo;
	private JTextField tfVotos;
	private JTextField tfData_aprovado;
	private JTextField tfNome_partido;
	private JTextField tfNumero_partido;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JComboBox<Partido> cbPartido_vereador;
	private Camara camara = new Camara();
	private JRadioButton rdbtnProjetoDeLeiComplementar;
	private JComboBox<Vereador> cbNome_vereador;
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");
	private JCheckBox cbxBoolean_aprovado;
	private JComboBox<Vereador> cbConsultar_vereador_especifico;
	private JComboBox<Partido> cbNome_partido;
	private JRadioButton rbProj_apre;
	private JRadioButton rbProj_apro;
	private JRadioButton rbMedia_desempenho;
	private JRadioButton rbPior_vereador;
	private JRadioButton rbVereadores_maior_que_media;
	private JRadioButton rbVereador_mais_proj;
	private JRadioButton rbQtd_vereadores;
	private JTextArea taConsulta_partido;
	private JRadioButton rbProj_apre_1;
	private JRadioButton rbProj_apro_1;
	private JRadioButton rbMedia_desempenho_1;
	private JRadioButton rbPior_vereador_1;
	private JRadioButton rbVereadores_maior_desempenho;
	private JRadioButton rbVereador_mais_proj_1;
	private JRadioButton rbQtd_vereadores_1;
	private JTextArea taConsulta_camara;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmCmaraMunicipalDe.setVisible(true);
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
		frmCmaraMunicipalDe = new JFrame();
		frmCmaraMunicipalDe.setTitle("Câmara Municipal de Blumenau");
		frmCmaraMunicipalDe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rique\\OneDrive\\Estudos\\FURB\\2 Semestre\\POO\\Unidade 7\\Exercicio4\\src\\download.jpg"));
		frmCmaraMunicipalDe.setBounds(100, 100, 650, 550);
		frmCmaraMunicipalDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCmaraMunicipalDe.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Blumenau");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		lblTitulo.setBounds(237, 11, 265, 56);
		frmCmaraMunicipalDe.getContentPane().add(lblTitulo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setBounds(10, 117, 614, 383);
		frmCmaraMunicipalDe.getContentPane().add(tabbedPane);
		
		JPanel painel_inicio = new JPanel();
		painel_inicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.addTab("INICIO", null, painel_inicio, null);
		painel_inicio.setLayout(null);
		
		JLabel lblBem_vindo = new JLabel("Olá");
		lblBem_vindo.setBounds(266, 146, 153, 37);
		lblBem_vindo.setFont(new Font("Arial", Font.BOLD, 32));
		painel_inicio.add(lblBem_vindo);
		
		JPanel painel_vereador = new JPanel();
		tabbedPane.addTab("VEREADOR", null, painel_vereador, null);
		painel_vereador.setLayout(null);
		
		JLabel lblNome_vereadorl = new JLabel("Nome:");
		lblNome_vereadorl.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome_vereadorl.setBounds(10, 36, 74, 14);
		painel_vereador.add(lblNome_vereadorl);
		
		JLabel lblNome_vereadorl_1 = new JLabel("Partido:");
		lblNome_vereadorl_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome_vereadorl_1.setBounds(10, 61, 74, 14);
		painel_vereador.add(lblNome_vereadorl_1);
		
		tfCadastrar_vereador = new JTextField();
		tfCadastrar_vereador.setBounds(195, 36, 271, 14);
		painel_vereador.add(tfCadastrar_vereador);
		tfCadastrar_vereador.setColumns(10);
		
		JButton btnCadastrar_vereador = new JButton("CADASTRAR");
		btnCadastrar_vereador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = tfCadastrar_vereador.getText();
					Partido partido = (Partido) cbPartido_vereador.getSelectedItem();
					Vereador v = new Vereador(nome);
					camara.getPartido(partido.getNome()).addVereador(v);
					cbNome_vereador.addItem(v);
					cbConsultar_vereador_especifico.addItem(v);
					JOptionPane.showMessageDialog(null, "Vereador adicionado com sucesso!!");
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}
			}
		});
		btnCadastrar_vereador.setBounds(482, 36, 117, 14);
		painel_vereador.add(btnCadastrar_vereador);
		
		JLabel lblConsultar_vereador = new JLabel("Consultas de um vereador específico:");
		lblConsultar_vereador.setFont(new Font("Arial", Font.BOLD, 12));
		lblConsultar_vereador.setBounds(10, 293, 304, 20);
		painel_vereador.add(lblConsultar_vereador);
		
		cbPartido_vereador = new JComboBox<Partido>();
		cbPartido_vereador.setBounds(195, 61, 271, 14);
		painel_vereador.add(cbPartido_vereador);
		
		cbConsultar_vereador_especifico = new JComboBox<Vereador>();
		cbConsultar_vereador_especifico.setBounds(195, 324, 271, 14);
		painel_vereador.add(cbConsultar_vereador_especifico);
		
		JLabel lblConsultar_vereador_especifico = new JLabel("Nome:");
		lblConsultar_vereador_especifico.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConsultar_vereador_especifico.setBounds(10, 324, 74, 14);
		painel_vereador.add(lblConsultar_vereador_especifico);
		
		JButton btnConsultar_vereador_especifico = new JButton("CONSULTAR");
		btnConsultar_vereador_especifico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vereador v =  (Vereador) cbConsultar_vereador_especifico.getSelectedItem();
					String mostrar = "Nome: " + v.getNome() + "\n" +
									 "Partido: " + v.getPartido().getNome() + "\n" +
									 "Desempenho: " + v.getDesempenho() + "\n" +
									 "Quantidade de projetos aprovados: " + v.getQtdProjetosAprov() + "\n" +
									 "Quantidade de projetos apresentados: " + v.getQtdProjetosApres();
					JOptionPane.showMessageDialog(null, mostrar);
					for (int i = 0; i < v.getQtdProjetosApres(); i ++) {
						ProjetoDeLei p = v.getProjeto(i);
						JOptionPane.showMessageDialog(null, p.mostrar());
					}
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, npe);
				}
			}
		});
		btnConsultar_vereador_especifico.setBounds(482, 324, 117, 14);
		painel_vereador.add(btnConsultar_vereador_especifico);
		
		JLabel lblCadastrar_vereador = new JLabel("Cadastrar vereador:");
		lblCadastrar_vereador.setFont(new Font("Arial", Font.BOLD, 12));
		lblCadastrar_vereador.setBounds(10, 11, 304, 20);
		painel_vereador.add(lblCadastrar_vereador);
		
		JLabel lblCadastrar_projeto_de_lei = new JLabel("Cadastrar projeto de lei:");
		lblCadastrar_projeto_de_lei.setFont(new Font("Arial", Font.BOLD, 12));
		lblCadastrar_projeto_de_lei.setBounds(10, 83, 164, 20);
		painel_vereador.add(lblCadastrar_projeto_de_lei);
		
		JRadioButton rdbtnProjetoDeLei = new JRadioButton("Projeto de lei");
		rdbtnProjetoDeLei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfArtigo.setEnabled(false);
				tfVotos.setEnabled(false);
				rdbtnProjetoDeLei.requestFocus();
			}
		});
		rdbtnProjetoDeLei.setSelected(true);
		rdbtnProjetoDeLei.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnProjetoDeLei);
		rdbtnProjetoDeLei.setBounds(173, 82, 106, 23);
		painel_vereador.add(rdbtnProjetoDeLei);
		
		rdbtnProjetoDeLeiComplementar = new JRadioButton("Projeto de lei complementar");
		rdbtnProjetoDeLeiComplementar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfArtigo.setEnabled(true);
				tfVotos.setEnabled(true);
				rdbtnProjetoDeLeiComplementar.requestFocus();
			}
		});
		rdbtnProjetoDeLeiComplementar.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdbtnProjetoDeLeiComplementar);
		rdbtnProjetoDeLeiComplementar.setBounds(301, 82, 271, 23);
		painel_vereador.add(rdbtnProjetoDeLeiComplementar);
		
		JLabel lblTitulo_projeto = new JLabel("Título:");
		lblTitulo_projeto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo_projeto.setBounds(10, 140, 74, 14);
		painel_vereador.add(lblTitulo_projeto);
		
		JLabel lblData_de_apresentação = new JLabel("Data de apresentação:");
		lblData_de_apresentação.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData_de_apresentação.setBounds(10, 164, 164, 14);
		painel_vereador.add(lblData_de_apresentação);
		
		JLabel lblArtigo_lo = new JLabel("Artigo da Lei Orgânica: ");
		lblArtigo_lo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblArtigo_lo.setBounds(10, 192, 164, 14);
		painel_vereador.add(lblArtigo_lo);
		
		JLabel lblQtd_votos = new JLabel("Quantidade de votos favoráveis:");
		lblQtd_votos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQtd_votos.setBounds(10, 217, 215, 14);
		painel_vereador.add(lblQtd_votos);
		
		tfTitulo_projeto = new JTextField();
		tfTitulo_projeto.setColumns(10);
		tfTitulo_projeto.setBounds(195, 142, 271, 14);
		painel_vereador.add(tfTitulo_projeto);
		
		tfDataApresen = new JTextField();
		tfDataApresen.setColumns(10);
		tfDataApresen.setBounds(195, 164, 136, 14);
		painel_vereador.add(tfDataApresen);
		
		tfArtigo = new JTextField();
		tfArtigo.setEnabled(false);
		tfArtigo.setColumns(10);
		tfArtigo.setBounds(195, 192, 271, 14);
		painel_vereador.add(tfArtigo);
		
		tfVotos = new JTextField();
		tfVotos.setEnabled(false);
		tfVotos.setColumns(10);
		tfVotos.setBounds(195, 217, 136, 14);
		painel_vereador.add(tfVotos);
		
		JButton btnCadastrar_projeto = new JButton("CADASTRAR");
		btnCadastrar_projeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vereador vereador = (Vereador) cbNome_vereador.getSelectedItem();
					String titulo = tfTitulo_projeto.getText();
					LocalDate dataApre = LocalDate.parse(tfDataApresen.getText(), df);
					LocalDate dataApro;
					if (vereador != null ) {
						if (rdbtnProjetoDeLei.isSelected()) {
							ProjetoDeLei p = new ProjetoDeLei(titulo, dataApre);
							if (cbxBoolean_aprovado.isSelected()) {
								dataApro = LocalDate.parse(tfData_aprovado.getText(), df);
								p.setDataAprovacao(dataApro);
								camara.getPartido(vereador.getPartido().getNome()).getVereador(vereador.getNome()).addProjeto(p);
								JOptionPane.showMessageDialog(null, "Projeto adicionado com sucesso!!");
							}else {
								camara.getPartido(vereador.getPartido().getNome()).getVereador(vereador.getNome()).addProjeto(p);
								JOptionPane.showMessageDialog(null, "Projeto adicionado com sucesso!!");
							}
						}else {
							String art = tfArtigo.getText();
							int qtd = Integer.parseInt(tfVotos.getText());
							ProjetoDeLeiComplementar p = new ProjetoDeLeiComplementar(art, qtd, titulo, dataApre);
							if (cbxBoolean_aprovado.isSelected()) {
								dataApro = LocalDate.parse(tfData_aprovado.getText(), df);
								p.setDataAprovacao(dataApro);
								camara.getPartido(vereador.getPartido().getNome()).getVereador(vereador.getNome()).addProjeto(p);
								JOptionPane.showMessageDialog(null, "Projeto complementar adicionado com sucesso!!");
							}else {
								camara.getPartido(vereador.getPartido().getNome()).getVereador(vereador.getNome()).addProjeto(p);
								JOptionPane.showMessageDialog(null, "Projeto complementar adicionado com sucesso!!");
							}
						}
					}
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(null, "Formato inválido.");
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Sem dados.");
				}
			}
		});
		btnCadastrar_projeto.setBounds(482, 117, 117, 14);
		painel_vereador.add(btnCadastrar_projeto);
		
		cbxBoolean_aprovado = new JCheckBox("Aprovado?");
		cbxBoolean_aprovado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxBoolean_aprovado.isSelected()) {
					tfData_aprovado.setEnabled(true);
				}else {
					tfData_aprovado.setEnabled(false);
				}
			}
		});
		cbxBoolean_aprovado.setBounds(10, 238, 97, 23);
		painel_vereador.add(cbxBoolean_aprovado);
		
		JLabel lblData_de_aprovado = new JLabel("Data da aprovação:");
		lblData_de_aprovado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData_de_aprovado.setBounds(10, 268, 164, 14);
		painel_vereador.add(lblData_de_aprovado);
		
		tfData_aprovado = new JTextField();
		tfData_aprovado.setColumns(10);
		tfData_aprovado.setBounds(195, 268, 136, 14);
		tfData_aprovado.setEnabled(false);
		painel_vereador.add(tfData_aprovado);
		
		JLabel lblNome_vereadorl_2 = new JLabel("Nome:");
		lblNome_vereadorl_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome_vereadorl_2.setBounds(10, 114, 74, 14);
		painel_vereador.add(lblNome_vereadorl_2);
		
		cbNome_vereador = new JComboBox<Vereador>();
		cbNome_vereador.setBounds(195, 117, 271, 14);
		painel_vereador.add(cbNome_vereador);
		
		JPanel painel_partido = new JPanel();
		tabbedPane.addTab("PARTIDO", null, painel_partido, null);
		painel_partido.setLayout(null);
		
		JLabel lblCadastrar_partido = new JLabel("Cadastrar partido:");
		lblCadastrar_partido.setFont(new Font("Arial", Font.BOLD, 12));
		lblCadastrar_partido.setBounds(10, 11, 304, 20);
		painel_partido.add(lblCadastrar_partido);
		
		JLabel lblNome_vereadorl_3 = new JLabel("Nome:");
		lblNome_vereadorl_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome_vereadorl_3.setBounds(10, 36, 74, 14);
		painel_partido.add(lblNome_vereadorl_3);
		
		tfNome_partido = new JTextField();
		tfNome_partido.setColumns(10);
		tfNome_partido.setBounds(195, 36, 271, 14);
		painel_partido.add(tfNome_partido);
		
		JButton btnCadastrar_partido = new JButton("CADASTRAR");
		btnCadastrar_partido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				try {
					String nome = tfNome_partido.getText();
					int numero = Integer.parseInt(tfNumero_partido.getText());
					Partido p = new Partido();
					p.setNome(nome);
					p.setNumero(numero);
					camara.addPartido(p);
					cbPartido_vereador.addItem(p);
					cbNome_partido.addItem(p);
					JOptionPane.showMessageDialog(null, "Partido adicionado com sucesso.");
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Não existe.");
				}
			}
		});
		btnCadastrar_partido.setBounds(482, 36, 117, 14);
		painel_partido.add(btnCadastrar_partido);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumero.setBounds(10, 61, 74, 14);
		painel_partido.add(lblNumero);
		
		tfNumero_partido = new JTextField();
		tfNumero_partido.setColumns(10);
		tfNumero_partido.setBounds(195, 61, 137, 14);
		painel_partido.add(tfNumero_partido);
		
		JLabel lblConsultas = new JLabel("Consultas próprias de algum partido:");
		lblConsultas.setFont(new Font("Arial", Font.BOLD, 12));
		lblConsultas.setBounds(10, 86, 304, 20);
		painel_partido.add(lblConsultas);
		
		JLabel lblNome_partido_consultar = new JLabel("Nome:");
		lblNome_partido_consultar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome_partido_consultar.setBounds(10, 117, 74, 14);
		painel_partido.add(lblNome_partido_consultar);
		
		cbNome_partido = new JComboBox<Partido>();
		cbNome_partido.setBounds(195, 117, 271, 14);
		painel_partido.add(cbNome_partido);
		
		JButton btnConsultar_partido = new JButton("CONSULTAR");
		btnConsultar_partido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Partido p = (Partido) cbNome_partido.getSelectedItem();
					String str = "";
					if (rbProj_apre.isSelected()) {
						taConsulta_partido.setText("");
						str = p.getTotalProjApres() + " projetos apresentados pelo partido " + p.getNome();
						taConsulta_partido.append(str);
					}else if (rbProj_apro.isSelected()) {
						taConsulta_partido.setText("");
						str = p.getTotalProjAprov() + " projetos aprovados pelo partido " + p.getNome();
						taConsulta_partido.append(str);
					}else if (rbQtd_vereadores.isSelected()) {
						taConsulta_partido.setText("");
						str = p.getQtdVereadores() + " vereadores no partido " + p.getNome();
						taConsulta_partido.append(str);
					}else if (rbMedia_desempenho.isSelected()) {
						taConsulta_partido.setText("");
						str = p.getMediaDeDesempenho() + " é a média de desempenho do partido " + p.getNome();
						taConsulta_partido.append(str);
					}else if (rbPior_vereador.isSelected()) {
						taConsulta_partido.setText("");
						str = "O pior vereador do partido " + p.getNome() + " é " + p.getVerPior().getNome() + "\n" +
								"Desemepenho: " + p.getVerPior().getDesempenho() + "\n"+
								"Projetos aprovados: " + p.getVerPior().getQtdProjetosAprov() + "\n"+
								"Projetos apresentados: " + p.getVerPior().getQtdProjetosApres();
						taConsulta_partido.append(str);
					}else if (rbVereador_mais_proj.isSelected()) {
						taConsulta_partido.setText("");
						str = "O vereador com mais projetos aprovados do partido " + p.getNome() + " é " + p.getVereadorMaisProjAprov().getNome() + "\n" +
								"Desemepenho: " + p.getVereadorMaisProjAprov().getDesempenho() + "\n"+
								"Projetos aprovados: " + p.getVereadorMaisProjAprov().getQtdProjetosAprov() + "\n"+
								"Projetos apresentados: " + p.getVereadorMaisProjAprov().getQtdProjetosApres();
						taConsulta_partido.append(str);
					}else {
						for (int i = 0; i < p.getQtdVereadores(); i++) {
							str += "\nO vereador " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getNome() + "tem a média de desempenho maior que a média do partido " + p.getNome() + "\n" +
								"Desemepenho: " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getDesempenho() + "\n"+
								"Projetos aprovados: " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getQtdProjetosAprov() + "\n"+
								"Projetos apresentados: " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getQtdProjetosApres();
						}
						taConsulta_partido.setText("");
						taConsulta_partido.append(str);
					}
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Nulo");
				}catch (IndexOutOfBoundsException iobe) {
					JOptionPane.showMessageDialog(null, "Não encontrado.");
				}
			}
		});
		btnConsultar_partido.setBounds(482, 117, 117, 14);
		painel_partido.add(btnConsultar_partido);
		
		rbProj_apre = new JRadioButton("Proj apre");
		rbProj_apre.setSelected(true);
		buttonGroup_2.add(rbProj_apre);
		rbProj_apre.setBounds(10, 138, 109, 23);
		painel_partido.add(rbProj_apre);
		
		rbProj_apro = new JRadioButton("Proj aprov");
		buttonGroup_2.add(rbProj_apro);
		rbProj_apro.setBounds(145, 138, 109, 23);
		painel_partido.add(rbProj_apro);
		
		rbMedia_desempenho = new JRadioButton("Média de desem");
		buttonGroup_2.add(rbMedia_desempenho);
		rbMedia_desempenho.setBounds(291, 138, 109, 23);
		painel_partido.add(rbMedia_desempenho);
		
		rbPior_vereador = new JRadioButton("Pior veread");
		buttonGroup_2.add(rbPior_vereador);
		rbPior_vereador.setBounds(431, 138, 109, 23);
		painel_partido.add(rbPior_vereador);
		
		rbQtd_vereadores = new JRadioButton("Qtd vereadores");
		buttonGroup_2.add(rbQtd_vereadores);
		rbQtd_vereadores.setBounds(357, 164, 109, 23);
		painel_partido.add(rbQtd_vereadores);
		
		rbVereadores_maior_que_media = new JRadioButton("Ver + q média");
		buttonGroup_2.add(rbVereadores_maior_que_media);
		rbVereadores_maior_que_media.setBounds(10, 164, 109, 23);
		painel_partido.add(rbVereadores_maior_que_media);
		
		rbVereador_mais_proj = new JRadioButton("Ver + proj aprov");
		buttonGroup_2.add(rbVereador_mais_proj);
		rbVereador_mais_proj.setBounds(183, 164, 109, 23);
		painel_partido.add(rbVereador_mais_proj);
		
		taConsulta_partido = new JTextArea();
		taConsulta_partido.setEditable(false);
		taConsulta_partido.setBounds(10, 194, 589, 149);
		painel_partido.add(taConsulta_partido);
		
		JPanel painel_camara = new JPanel();
		tabbedPane.addTab("CÂMARA", null, painel_camara, null);
		painel_camara.setLayout(null);
		
		rbProj_apre_1 = new JRadioButton("Proj apre");
		buttonGroup_1.add(rbProj_apre_1);
		rbProj_apre_1.setBounds(35, 33, 109, 23);
		painel_camara.add(rbProj_apre_1);
		
		rbProj_apro_1 = new JRadioButton("Proj aprov");
		buttonGroup_1.add(rbProj_apro_1);
		rbProj_apro_1.setBounds(170, 33, 109, 23);
		painel_camara.add(rbProj_apro_1);
		
		rbMedia_desempenho_1 = new JRadioButton("Média de desem");
		buttonGroup_1.add(rbMedia_desempenho_1);
		rbMedia_desempenho_1.setBounds(316, 33, 109, 23);
		painel_camara.add(rbMedia_desempenho_1);
		
		rbPior_vereador_1 = new JRadioButton("Pior veread");
		buttonGroup_1.add(rbPior_vereador_1);
		rbPior_vereador_1.setBounds(456, 33, 109, 23);
		painel_camara.add(rbPior_vereador_1);
		
		rbVereadores_maior_desempenho = new JRadioButton("Ver + desem");
		buttonGroup_1.add(rbVereadores_maior_desempenho);
		rbVereadores_maior_desempenho.setBounds(35, 59, 109, 23);
		painel_camara.add(rbVereadores_maior_desempenho);
		
		rbQtd_vereadores_1 = new JRadioButton("Qtd vereadores");
		buttonGroup_1.add(rbQtd_vereadores_1);
		rbQtd_vereadores_1.setBounds(316, 59, 109, 23);
		painel_camara.add(rbQtd_vereadores_1);
		
		rbVereador_mais_proj_1 = new JRadioButton("Ver + proj aprov");
		buttonGroup_1.add(rbVereador_mais_proj_1);
		rbVereador_mais_proj_1.setBounds(170, 59, 109, 23);
		painel_camara.add(rbVereador_mais_proj_1);
		
		JLabel lblConsultas_na_camara = new JLabel("Consultas na câmara:");
		lblConsultas_na_camara.setFont(new Font("Arial", Font.BOLD, 12));
		lblConsultas_na_camara.setBounds(10, 6, 304, 20);
		painel_camara.add(lblConsultas_na_camara);
		
		JButton btnConsultar_camara = new JButton("CONSULTAR");
		btnConsultar_camara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Partido p = (Partido) cbNome_partido.getSelectedItem();
					String str = "";
					if (rbProj_apre_1.isSelected()) {
						taConsulta_camara.setText("");
						str = p.getTotalProjApres() + " projetos apresentados pelo partido " + p.getNome();
						taConsulta_camara.append(str);
					}else if (rbProj_apro_1.isSelected()) {
						taConsulta_camara.setText("");
						str = p.getTotalProjAprov() + " projetos aprovados pelo partido " + p.getNome();
						taConsulta_camara.append(str);
					}else if (rbQtd_vereadores_1.isSelected()) {
						taConsulta_camara.setText("");
						str = p.getQtdVereadores() + " vereadores no partido " + p.getNome();
						taConsulta_camara.append(str);
					}else if (rbMedia_desempenho_1.isSelected()) {
						taConsulta_camara.setText("");
						str = p.getMediaDeDesempenho() + " é a média de desempenho do partido " + p.getNome();
						taConsulta_camara.append(str);
					}else if (rbPior_vereador_1.isSelected()) {
						taConsulta_camara.setText("");
						str = "O pior vereador do partido " + p.getNome() + " é " + p.getVerPior().getNome() + "\n" +
								"Desemepenho: " + p.getVerPior().getDesempenho() + "\n"+
								"Projetos aprovados: " + p.getVerPior().getQtdProjetosAprov() + "\n"+
								"Projetos apresentados: " + p.getVerPior().getQtdProjetosApres();
						taConsulta_camara.append(str);
					}else if (rbVereador_mais_proj_1.isSelected()) {
						taConsulta_camara.setText("");
						str = "O vereador com mais projetos aprovados do partido " + p.getNome() + " é " + p.getVereadorMaisProjAprov().getNome() + "\n" +
								"Desemepenho: " + p.getVereadorMaisProjAprov().getDesempenho() + "\n"+
								"Projetos aprovados: " + p.getVereadorMaisProjAprov().getQtdProjetosAprov() + "\n"+
								"Projetos apresentados: " + p.getVereadorMaisProjAprov().getQtdProjetosApres();
						taConsulta_camara.append(str);
					}else {
						for (int i = 0; i < p.getQtdVereadores(); i++) {
							str += "\nO vereador " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getNome() + "tem a média de desempenho maior que a média do partido " + p.getNome() + "\n" +
								"Desemepenho: " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getDesempenho() + "\n"+
								"Projetos aprovados: " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getQtdProjetosAprov() + "\n"+
								"Projetos apresentados: " + p.getVeresMaiorQMedia(p.getMediaDeDesempenho()).get(i).getQtdProjetosApres();
						}
						taConsulta_camara.setText("");
						taConsulta_camara.append(str);
					}
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Nulo");
				}catch (IndexOutOfBoundsException iobe) {
					JOptionPane.showMessageDialog(null, "Não encontrado.");
				}
			}
		});
		btnConsultar_camara.setBounds(456, 63, 117, 14);
		painel_camara.add(btnConsultar_camara);
		
		taConsulta_camara = new JTextArea();
		taConsulta_camara.setBounds(10, 94, 589, 249);
		painel_camara.add(taConsulta_camara);
		
		JPanel painel_exercicio = new JPanel();
		tabbedPane.addTab("CONSULTA DO EXERCÍCIO", null, painel_exercicio, null);
		painel_exercicio.setLayout(null);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Partido> partidos = camara.getPartidos();
					for (Partido p: partidos) {
						ArrayList<Vereador> vereadores = p.getVereadores();
						for (Vereador v: vereadores) {
							String ver = "Nome do vereador: " + v.getNome() + "\n" +
										 "Partido: " + v.getPartido().getNome() + "\n" +
										 "Desempenho: " + v.getDesempenho();
							JOptionPane.showMessageDialog(null, ver);
							for (int i = 0; i < v.getQtdProjetosApres(); i++) {
								ProjetoDeLei projeto = v.getProjeto(i);
								JOptionPane.showMessageDialog(null, projeto.mostrar());
							}
						}
					}
					
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Nulo");
				}catch (IndexOutOfBoundsException iobe) {
					JOptionPane.showMessageDialog(null, "Não encontrado.");
				}
			}
		});
		btnConsultar.setBounds(244, 11, 117, 14);
		painel_exercicio.add(btnConsultar);
	}
}
