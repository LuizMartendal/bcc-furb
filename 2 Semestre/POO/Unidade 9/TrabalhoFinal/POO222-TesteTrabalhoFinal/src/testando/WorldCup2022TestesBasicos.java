package testando;



import java.lang.reflect.Constructor;

import fifa.NationalTeamInfos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;


/* 
 * Universidade Regional de Blumenau - FURB
 * Departamento de Sistemas e Computação
 * Cursos de Ciência da Computação 
 * Disciplina de Programação Orientada a Objetos
 * 
 * 2022/2 - Matutino e Noturno
 */
public class WorldCup2022TestesBasicos {

	private JFrame frmWorldCup;
	private NationalTeamInfos currentNTI;
	private JLabel lblNomeSelecao;
	private JLabel lblBandeira;
	private JTextArea textArea;
	private JTextField tfSelecao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldCup2022TestesBasicos window = new WorldCup2022TestesBasicos();
					window.frmWorldCup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorldCup2022TestesBasicos() {
		initialize();
	}

	protected NationalTeamInfos loadNTI(String nome) {
		String completo = "module_" + nome.toLowerCase() + "." + nome;
		NationalTeamInfos nti = null;
		Class<?> c;
		try {
			c = Class.forName(completo);
			Constructor<?>[] construtor = c.getDeclaredConstructors();
			nti = (NationalTeamInfos) construtor[0].newInstance();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, completo + " = " + e.getClass().getName() + ":" + e.getMessage());
			e.printStackTrace();
		}
		return nti;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWorldCup = new JFrame();
		frmWorldCup.setTitle("WORLD CUP 2022 - CATAR - POO 2022-2");
		frmWorldCup.setBounds(50, 50, 800, 600);
		frmWorldCup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWorldCup.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Digite o nome da sele\u00E7\u00E3o \r\ne clique no bot\u00E3o Informa\u00E7\u00F5es:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(32, 14, 317, 36);
		frmWorldCup.getContentPane().add(lblNewLabel);

		JButton btnVerInfos = new JButton("Informa\u00E7\u00F5es");
		btnVerInfos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = tfSelecao.getText();
				currentNTI = loadNTI(name);
				if (currentNTI != null) {
					preencherAreaTexto();
				}

			}
		});
		btnVerInfos.setBounds(543, 21, 160, 23);
		frmWorldCup.getContentPane().add(btnVerInfos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 153, 551, 307);
		frmWorldCup.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		lblNomeSelecao = new JLabel("");
		lblNomeSelecao.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNomeSelecao.setBounds(10, 251, 160, 26);
		frmWorldCup.getContentPane().add(lblNomeSelecao);

		lblBandeira = new JLabel("");
		lblBandeira.setBounds(10, 319, 160, 91);
		frmWorldCup.getContentPane().add(lblBandeira);
		
		tfSelecao = new JTextField();
		tfSelecao.setBounds(359, 22, 160, 20);
		frmWorldCup.getContentPane().add(tfSelecao);
		tfSelecao.setColumns(10);
		
		JTextArea txtrNoSeuProjeto = new JTextArea();
		txtrNoSeuProjeto.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrNoSeuProjeto.setText("No seu projeto, gere o arquivo .jar.\r\nColoque-o como um jar externo neste projeto e fa\u00E7a os testes b\u00E1sicos.");
		txtrNoSeuProjeto.setBackground(Color.LIGHT_GRAY);
		txtrNoSeuProjeto.setEditable(false);
		txtrNoSeuProjeto.setBounds(21, 59, 725, 67);
		frmWorldCup.getContentPane().add(txtrNoSeuProjeto);

	}

	protected void preencherAreaTexto() {
		lblNomeSelecao.setText(currentNTI.getCountryName());
		Image imagem = currentNTI.getFlagImage();
		if (imagem != null) {
			ImageIcon ii = new ImageIcon(imagem.getScaledInstance(160, 90, 0));
			lblBandeira.setIcon(ii);
		} else {
			lblBandeira.setText("NULL");
		}
		textArea.setText("Informações solicitadas\n");
		textArea.append("\nQuantidade de membros da comitiva:" + currentNTI.getHowManyMembers());
		textArea.append("\nIdade média:" + currentNTI.getAverageAge());
		textArea.append("\nDados do jogador 1:" + currentNTI.getPlayer(6));
		int oldest = currentNTI.getOldestPlayer();
		textArea.append("\nDados do jogador mais velho [+"+oldest+"]:" + currentNTI.getPlayer(oldest));
		textArea.append("\nAssessor de imprensa:" + currentNTI.getPressOfficerContacts());
		textArea.append("\n"+currentNTI.getTechnicalCommittee().toString());
		textArea.append("\n"+currentNTI.getStatsResponsible().getHowManyCallsToPlayer(13) + 
						"\n" + currentNTI.getStatsResponsible().getHowManyQuestions());
	}
}
