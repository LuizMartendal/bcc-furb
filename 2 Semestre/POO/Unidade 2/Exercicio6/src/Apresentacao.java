import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Apresentacao {

	private JFrame frmLista;
	private JTextField tfTamanho;
	private JTextField tfValor;
	private JTextField tfPosicao;
	private VetorDeReais meuObjeto,
						 outroObjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmLista.setVisible(true);
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
		frmLista = new JFrame();
		frmLista.setTitle("Lista 2 - Exercício 6");
		frmLista.setBounds(100, 100, 450, 300);
		frmLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLista.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qual o tamanho do vetor?");
		lblNewLabel.setBounds(10, 21, 148, 14);
		frmLista.getContentPane().add(lblNewLabel);
		
		tfTamanho = new JTextField();
		tfTamanho.setBounds(149, 18, 46, 20);
		frmLista.getContentPane().add(tfTamanho);
		tfTamanho.setColumns(10);
		
		JButton btnCriar = new JButton("Criar o vetor");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meuObjeto = new VetorDeReais(Integer.parseInt(tfTamanho.getText()));
			}
		});
		btnCriar.setBounds(239, 17, 116, 23);
		frmLista.getContentPane().add(btnCriar);
		
		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setBounds(10, 61, 48, 14);
		frmLista.getContentPane().add(lblNewLabel_1);
		
		tfValor = new JTextField();
		tfValor.setBounds(62, 58, 96, 20);
		frmLista.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Posição:");
		lblNewLabel_2.setBounds(168, 61, 48, 14);
		frmLista.getContentPane().add(lblNewLabel_2);
		
		tfPosicao = new JTextField();
		tfPosicao.setBounds(226, 58, 46, 20);
		frmLista.getContentPane().add(tfPosicao);
		tfPosicao.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meuObjeto.setVetor(Double.parseDouble(tfValor.getText()),
								Integer.parseInt(tfPosicao.getText()));
			}
		});
		btnOK.setBounds(282, 57, 69, 23);
		frmLista.getContentPane().add(btnOK);
		
		JButton btnPares = new JButton("Quantos pares?");
		btnPares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmLista, "A quantidade de pares é "+meuObjeto.getPares());
			}
		});
		btnPares.setBounds(10, 99, 116, 23);
		frmLista.getContentPane().add(btnPares);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 368, 83);
		frmLista.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VetorDeReais objResultado = meuObjeto.VetoresDivididos(outroObjeto);
				textArea.setText("Divis�o entre vetores\n");
				textArea.append("\nPrimeiro vetor:"+meuObjeto.exibir());
				textArea.append("\nSegundo vetor:"+outroObjeto.exibir());
				textArea.append("\nVetor resultado:"+objResultado.exibir());
			}
		});
		btnDividir.setBounds(10, 133, 89, 23);
		frmLista.getContentPane().add(btnDividir);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double resultado = meuObjeto.Multiplicacao(outroObjeto);
				textArea.setText("Multiplica��o entre vetores\n");
				textArea.append("\nPrimeiro vetor:"+meuObjeto.exibir());
				textArea.append("\nSegundo vetor:"+outroObjeto.exibir());
				textArea.append("\nResultado:"+resultado);
			}
		});
		btnMultiplicar.setBounds(127, 133, 89, 23);
		frmLista.getContentPane().add(btnMultiplicar);
		
		JButton btnInverter = new JButton("Inverter");
		btnInverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Invers�o do vetor\n");
				textArea.append("\nVetor antes:"+meuObjeto.exibir());
				meuObjeto.InverterVetor();
				textArea.append("\nVetor depois:"+meuObjeto.exibir());
			}
		});
		btnInverter.setBounds(239, 133, 89, 23);
		frmLista.getContentPane().add(btnInverter);
		
		JButton btnMaiorDiferenca = new JButton("Maior diferen�a");
		btnMaiorDiferenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Maior diferen�a do vetor = "+meuObjeto.MaiorDiferenca());
			}
		});
		btnMaiorDiferenca.setBounds(136, 99, 116, 23);
		frmLista.getContentPane().add(btnMaiorDiferenca);
		
		JButton btnGuardar = new JButton("Guardar vetor");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outroObjeto = meuObjeto;
			}
		});
		btnGuardar.setBounds(262, 99, 116, 23);
		frmLista.getContentPane().add(btnGuardar);
		
		
	}
}