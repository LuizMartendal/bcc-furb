	import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Apresentação {

	private JFrame frmFurb;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private JPanel painel_cadastrar;
	private JPanel painel_consultar;
	private JTextField tfNomeAluno;
	private JTextField tfDataNascimento;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbU;
	private JRadioButton rbE;
	private String nomeAtual;
	private LocalDate dataAtual;
	private JPanel painel_inicial;
	private JPanel painel_em;
	private JPanel painel_u;
	private JLabel lblNewLabel;
	private JLabel lblSelecao;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnCadastrarAlunoEM;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnCadastrar_universitario;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JRadioButton rbEnem;
	private JRadioButton rbVestibular;
	private JRadioButton rbSeletivoEspecial;
	private JRadioButton rbTI;
	private JRadioButton rbTE;
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/y");
	private JComboBox<Curso> cbCurso;
	private JPanel painel_cadastrar_curso;
	private JLabel lblCadastrarCurso;
	private JLabel lblNome_do_curso;
	private JLabel lblSigla_do_curso;
	private JTextField tfCadastrar_curso;
	private JTextField tfCadastrar_sigla;
	private HashMap<String, Curso> cursos = new HashMap<>();
	private JButton btnCurso_menu;
	private JButton btnConsultarAlunos;
	private JTextArea taConsultar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentação window = new Apresentação();
					window.frmFurb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Apresentação() throws FileNotFoundException, IOException {
		initialize();
		this.getSavedFiles();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFurb = new JFrame();
		frmFurb.setForeground(new Color(128, 0, 0));
		frmFurb.setTitle("FURB");
		frmFurb.setBounds(100, 100, 450, 300);
		frmFurb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFurb.getContentPane().setLayout(null);
		
		painel_em = new JPanel();
		painel_em.setVisible(false);
		
		painel_cadastrar = new JPanel();
		painel_cadastrar.setVisible(false);
		
		painel_cadastrar_curso = new JPanel();
		painel_cadastrar_curso.setVisible(false);
		
		painel_u = new JPanel();
		painel_u.setVisible(false);
		
		painel_consultar = new JPanel();
		painel_consultar.setVisible(false);
		
		painel_inicial = new JPanel();
		painel_inicial.setBackground(Color.WHITE);
		painel_inicial.setBounds(0, 0, 449, 275);
		frmFurb.getContentPane().add(painel_inicial);
		painel_inicial.setLayout(null);
		
		JLabel lblLogo = new JLabel("FURB");
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setForeground(Color.GRAY);
		lblLogo.setFont(new Font("Arial", Font.BOLD, 61));
		lblLogo.setBounds(130, 10, 171, 51);
		painel_inicial.add(lblLogo);
		
		JButton btnCadastrar_alunos = new JButton("Cadastrar alunos");
		btnCadastrar_alunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_inicial.setEnabled(false);
				painel_inicial.setVisible(false);
				painel_cadastrar.setEnabled(true);
				painel_cadastrar.setVisible(true);
			}
		});
		btnCadastrar_alunos.setForeground(Color.GRAY);
		btnCadastrar_alunos.setBackground(Color.WHITE);
		btnCadastrar_alunos.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar_alunos.setBounds(130, 86, 171, 32);
		painel_inicial.add(btnCadastrar_alunos);
		
		JButton btnConsultar = new JButton("Consultar alunos");
		btnConsultar.setForeground(Color.GRAY);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_inicial.setEnabled(false);
				painel_inicial.setVisible(false);
				painel_consultar.setEnabled(true);
				painel_consultar.setVisible(true);
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 12));
		btnConsultar.setBounds(130, 172, 171, 32);
		painel_inicial.add(btnConsultar);
		
		JButton btnCadastrarCurso = new JButton("Cadastrar curso");
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_inicial.setEnabled(false);
				painel_inicial.setVisible(false);
				painel_cadastrar_curso.setEnabled(true);
				painel_cadastrar_curso.setVisible(true);
			}
		});
		btnCadastrarCurso.setForeground(Color.GRAY);
		btnCadastrarCurso.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrarCurso.setBackground(Color.WHITE);
		btnCadastrarCurso.setBounds(130, 129, 171, 32);
		painel_inicial.add(btnCadastrarCurso);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (FileOutputStream fos = new FileOutputStream("Alunos.txt")){
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					for (Aluno a: alunos) {
						oos.writeObject(a);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try (FileOutputStream fos = new FileOutputStream("Cursos.txt")){
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					for (Curso c: cursos.values()) {
						oos.writeObject(c);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setForeground(Color.GRAY);
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(130, 215, 171, 32);
		painel_inicial.add(btnSalvar);
		painel_consultar.setEnabled(false);
		painel_consultar.setBounds(0, 0, 436, 263);
		frmFurb.getContentPane().add(painel_consultar);
		painel_consultar.setLayout(null);
		
		btnConsultarAlunos = new JButton("Consultar");
		btnConsultarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				alunos.sort(null);
				for (Aluno a: alunos) {
					str += "\n" + a.mostra();
				}
				taConsultar.setText(str);
			}
		});
		btnConsultarAlunos.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultarAlunos.setBorder(null);
		btnConsultarAlunos.setBounds(0, 0, 436, 35);
		painel_consultar.add(btnConsultarAlunos);
		
		taConsultar = new JTextArea();
		taConsultar.setEditable(false);
		taConsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		taConsultar.setBounds(10, 45, 416, 174);
		painel_consultar.add(taConsultar);
		
		JButton btnConsultar_Menu = new JButton("Menu");
		btnConsultar_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_consultar.setEnabled(false);
				painel_consultar.setVisible(false);
				painel_inicial.setEnabled(true);
				painel_inicial.setVisible(true);
			}
		});
		btnConsultar_Menu.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultar_Menu.setBorder(null);
		btnConsultar_Menu.setBounds(0, 217, 436, 35);
		painel_consultar.add(btnConsultar_Menu);
		painel_u.setEnabled(false);
		painel_u.setBounds(0, 0, 436, 263);
		frmFurb.getContentPane().add(painel_u);
		painel_u.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Universitário");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(147, 10, 195, 28);
		painel_u.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Curso:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(54, 160, 71, 28);
		painel_u.add(lblNewLabel_2);
		
		btnCadastrar_universitario = new JButton("Cadastrar");
		btnCadastrar_universitario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbEnem.setSelected(true);;
				try {
					char i;
					if (rbEnem.isSelected()) {
						i = 'E';
					}else if (rbVestibular.isSelected()) {
						i = 'V';
					}else if (rbSeletivoEspecial.isSelected()) {
						i = 'S';
					}else if (rbTI.isSelected()) {
						i = 'T';
					}else {
						i = 'I';
					}
					Curso curso = cursos.get(cbCurso.getSelectedItem().toString());
					AlunoUniversitario aluno = new AlunoUniversitario(nomeAtual, dataAtual, i, curso);
					
					alunos.add(aluno);
					JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso.");
					painel_u.setEnabled(false);
					painel_u.setVisible(false);
					painel_cadastrar.setEnabled(true);
					painel_cadastrar.setVisible(true);
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}
			}
		});
		btnCadastrar_universitario.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar_universitario.setBounds(159, 204, 117, 28);
		painel_u.add(btnCadastrar_universitario);
		
		rbEnem = new JRadioButton("Enem");
		buttonGroup_2.add(rbEnem);
		rbEnem.setBounds(88, 88, 71, 21);
		painel_u.add(rbEnem);
		rbEnem.setEnabled(true);
		
		rbVestibular = new JRadioButton("Vestibular");
		buttonGroup_2.add(rbVestibular);
		rbVestibular.setBounds(303, 88, 96, 21);
		painel_u.add(rbVestibular);
		
		rbSeletivoEspecial = new JRadioButton("Seletivo especial");
		buttonGroup_2.add(rbSeletivoEspecial);
		rbSeletivoEspecial.setBounds(161, 88, 140, 21);
		painel_u.add(rbSeletivoEspecial);
		
		rbTI = new JRadioButton("Trans. interna");
		buttonGroup_2.add(rbTI);
		rbTI.setBounds(104, 123, 124, 21);
		painel_u.add(rbTI);
		
		rbTE = new JRadioButton("Trans. externa");
		buttonGroup_2.add(rbTE);
		rbTE.setBounds(230, 123, 111, 21);
		painel_u.add(rbTE);
		
		JLabel lblNewLabel_3 = new JLabel("Forma de ingresso");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_3.setBounds(147, 54, 188, 28);
		painel_u.add(lblNewLabel_3);
		
		cbCurso = new JComboBox<>();
		cbCurso.setBounds(159, 165, 117, 21);
		painel_u.add(cbCurso);
		painel_cadastrar_curso.setEnabled(false);
		painel_cadastrar_curso.setBounds(0, 0, 436, 263);
		frmFurb.getContentPane().add(painel_cadastrar_curso);
		painel_cadastrar_curso.setLayout(null);
		
		lblCadastrarCurso = new JLabel("Curso");
		lblCadastrarCurso.setBounds(180, 10, 195, 28);
		lblCadastrarCurso.setFont(new Font("Arial", Font.BOLD, 25));
		painel_cadastrar_curso.add(lblCadastrarCurso);
		
		lblNome_do_curso = new JLabel("Nome do curso:");
		lblNome_do_curso.setBounds(10, 80, 145, 24);
		lblNome_do_curso.setFont(new Font("Arial", Font.BOLD, 14));
		painel_cadastrar_curso.add(lblNome_do_curso);
		
		lblSigla_do_curso = new JLabel("Sigla:");
		lblSigla_do_curso.setFont(new Font("Arial", Font.BOLD, 14));
		lblSigla_do_curso.setBounds(10, 114, 145, 24);
		painel_cadastrar_curso.add(lblSigla_do_curso);
		
		tfCadastrar_curso = new JTextField();
		tfCadastrar_curso.setBounds(144, 84, 174, 19);
		painel_cadastrar_curso.add(tfCadastrar_curso);
		tfCadastrar_curso.setColumns(10);
		
		tfCadastrar_sigla = new JTextField();
		tfCadastrar_sigla.setColumns(10);
		tfCadastrar_sigla.setBounds(144, 114, 86, 19);
		painel_cadastrar_curso.add(tfCadastrar_sigla);
		
		JButton btnCadastrar_curso = new JButton("Cadastrar");
		btnCadastrar_curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = tfCadastrar_curso.getText();
					String sigla = tfCadastrar_sigla.getText();
					if ((cursos != null && !cursos.containsKey(sigla)) || cursos == null) {
						Curso curso = new Curso(nome, sigla);
						cursos.put(sigla.toUpperCase(), curso);
						cbCurso.addItem(curso);;
						JOptionPane.showMessageDialog(null, "Curso adicionado com sucesso.");
						tfCadastrar_curso.setText("");
						tfCadastrar_sigla.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Curso já adiconado.");
					}
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, "Nenhum objeto criado.");
				}
			}
		});
		btnCadastrar_curso.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar_curso.setBounds(225, 202, 120, 28);
		painel_cadastrar_curso.add(btnCadastrar_curso);
		
		btnCurso_menu = new JButton("Menu");
		btnCurso_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_cadastrar_curso.setEnabled(false);
				painel_cadastrar_curso.setVisible(false);
				painel_inicial.setEnabled(true);
				painel_inicial.setVisible(true);
			}
		});
		btnCurso_menu.setFont(new Font("Arial", Font.BOLD, 14));
		btnCurso_menu.setBounds(86, 202, 120, 28);
		painel_cadastrar_curso.add(btnCurso_menu);
		painel_cadastrar.setEnabled(false);
		painel_cadastrar.setBounds(0, 0, 436, 263);
		frmFurb.getContentPane().add(painel_cadastrar);
		painel_cadastrar.setLayout(null);
		
		JLabel lblNomeAluno = new JLabel("Nome do aluno:");
		lblNomeAluno.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeAluno.setBounds(10, 32, 135, 28);
		painel_cadastrar.add(lblNomeAluno);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(10, 86, 173, 28);
		painel_cadastrar.add(lblDataDeNascimento);
		
		tfNomeAluno = new JTextField();
		tfNomeAluno.setBounds(152, 36, 216, 24);
		painel_cadastrar.add(tfNomeAluno);
		tfNomeAluno.setColumns(10);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(233, 88, 135, 24);
		painel_cadastrar.add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		rbE = new JRadioButton("Ensino médio");
		rbE.setSelected(true);
		buttonGroup.add(rbE);
		rbE.setFont(new Font("Arial", Font.BOLD, 14));
		rbE.setBounds(66, 140, 150, 28);
		painel_cadastrar.add(rbE);
		
		rbU = new JRadioButton("Universitário");
		buttonGroup.add(rbU);
		rbU.setFont(new Font("Arial", Font.BOLD, 14));
		rbU.setBounds(248, 140, 135, 28);
		painel_cadastrar.add(rbU);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nomeAtual = tfNomeAluno.getText();
					dataAtual = LocalDate.parse(tfDataNascimento.getText(), f);
					
					if (rbE.isSelected()) {
						painel_cadastrar.setEnabled(false);
						painel_cadastrar.setVisible(false);
						painel_em.setEnabled(true);
						painel_em.setVisible(true);
					}else if (rbU.isSelected()) {
						painel_cadastrar.setEnabled(false);
						painel_cadastrar.setVisible(false);
						painel_u.setEnabled(true);
						painel_u.setVisible(true);
					}
					tfNomeAluno.setText("");
					tfDataNascimento.setText("");
				}catch (IllegalArgumentException iae){
					JOptionPane.showMessageDialog(null, iae);
				}catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(null, "Data com formato inválido.");
				}
			}
		});
		btnProximo.setFont(new Font("Arial", Font.BOLD, 14));
		btnProximo.setBounds(267, 204, 101, 28);
		painel_cadastrar.add(btnProximo);
		
		JButton btnMenu1 = new JButton("Menu");
		btnMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_cadastrar.setEnabled(false);
				painel_cadastrar.setVisible(false);
				painel_inicial.setEnabled(true);
				painel_inicial.setVisible(true);
			}
		});
		btnMenu1.setFont(new Font("Arial", Font.BOLD, 14));
		btnMenu1.setBounds(66, 204, 101, 28);
		painel_cadastrar.add(btnMenu1);
		painel_em.setEnabled(false);
		painel_em.setBounds(0, 0, 436, 263);
		frmFurb.getContentPane().add(painel_em);
		painel_em.setLayout(null);
		
		lblNewLabel = new JLabel("Ensino médio");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(135, 10, 202, 28);
		painel_em.add(lblNewLabel);
		
		lblSelecao = new JLabel("Selecione o ano em que o(a) aluno(a) se encontra:");
		lblSelecao.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSelecao.setBounds(10, 73, 392, 28);
		painel_em.add(lblSelecao);
		
		rb1 = new JRadioButton("1° ano");
		buttonGroup_1.add(rb1);
		rb1.setFont(new Font("Arial", Font.BOLD, 14));
		rb1.setBounds(75, 138, 103, 28);
		painel_em.add(rb1);
		rb1.setSelected(true);
		
		rb2 = new JRadioButton("2° ano");
		buttonGroup_1.add(rb2);
		rb2.setFont(new Font("Arial", Font.BOLD, 14));
		rb2.setBounds(180, 138, 103, 28);
		painel_em.add(rb2);
		
		rb3 = new JRadioButton("3° ano");
		buttonGroup_1.add(rb3);
		rb3.setFont(new Font("Arial", Font.BOLD, 14));
		rb3.setBounds(285, 138, 103, 28);
		painel_em.add(rb3);
		
		btnCadastrarAlunoEM = new JButton("Cadastrar");
		btnCadastrarAlunoEM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ano;
					if (rb1.isSelected()) {
						ano = 1;
					}else if (rb2.isSelected()) {
						ano = 2;
					}else {
						ano = 3;
					}
					AlunoEnsinoMedio aluno = new AlunoEnsinoMedio(nomeAtual, dataAtual, ano);
					alunos.add(aluno);
					JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso.");
					painel_em.setEnabled(false);
					painel_em.setVisible(false);
					painel_cadastrar.setEnabled(true);
					painel_cadastrar.setVisible(true);
				}catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae);
				}
			}
		});
		btnCadastrarAlunoEM.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrarAlunoEM.setBounds(156, 213, 112, 24);
		painel_em.add(btnCadastrarAlunoEM);
	}
	
	private void getSavedFiles() throws FileNotFoundException, IOException {
		if (new File("Alunos.txt").canRead()) {
			try (FileInputStream fis = new FileInputStream("Alunos.txt")){
				ObjectInputStream ois = new ObjectInputStream(fis);
				while (true) {
					Aluno aluno = (Aluno) ois.readObject();
					alunos.add(aluno);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException eof) {
				JOptionPane.showMessageDialog(null, "Arquivos restaurados.");
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(null, fnfe);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (new File("Cursos.txt").canRead()) {
			try (FileInputStream fis = new FileInputStream("Cursos.txt")){
				ObjectInputStream ois = new ObjectInputStream(fis);
				while (true) {
					Curso curso = (Curso) ois.readObject();
					cursos.put(curso.getSigla(), curso);
					cbCurso.addItem(curso);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException eof) {
				JOptionPane.showMessageDialog(null, "Arquivos restaurados.");
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(null, fnfe);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Bem vindo");
	}
}
