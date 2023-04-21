import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Apresentacao {

	private JFrame frmCalculadoraUsandoPilha;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtEx;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmCalculadoraUsandoPilha.setVisible(true);
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
		frmCalculadoraUsandoPilha = new JFrame();
		frmCalculadoraUsandoPilha.setTitle("Calculadora usando pilha");
		frmCalculadoraUsandoPilha.setBounds(100, 100, 600, 400);
		frmCalculadoraUsandoPilha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmCalculadoraUsandoPilha.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULADORA");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
		lblTitulo.setBounds(148, 20, 285, 32);
		panel.add(lblTitulo);
		
		JRadioButton rdbtnPilhaVetor = new JRadioButton("Pilha Vetor");
		rdbtnPilhaVetor.setBackground(Color.DARK_GRAY);
		rdbtnPilhaVetor.setForeground(Color.WHITE);
		rdbtnPilhaVetor.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPilhaVetor.setFont(new Font("Arial", Font.BOLD, 20));
		buttonGroup.add(rdbtnPilhaVetor);
		rdbtnPilhaVetor.setSelected(true);;
		rdbtnPilhaVetor.setBounds(148, 109, 143, 39);
		panel.add(rdbtnPilhaVetor);
		
		JRadioButton rdbtnPilhaLista = new JRadioButton("Pilha Lista");
		rdbtnPilhaLista.setBackground(Color.DARK_GRAY);
		rdbtnPilhaLista.setForeground(Color.WHITE);
		rdbtnPilhaLista.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPilhaLista.setFont(new Font("Arial", Font.BOLD, 20));
		buttonGroup.add(rdbtnPilhaLista);
		rdbtnPilhaLista.setBounds(281, 109, 152, 39);
		panel.add(rdbtnPilhaLista);
		
		txtEx = new JTextField();
		txtEx.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnCalcular.setEnabled(true);
			}
		});
		txtEx.setEnabled(false);
		txtEx.setBorder(null);
		txtEx.setText("Ex: 1 1 + 1 -1 - *");
		txtEx.setToolTipText("");
		txtEx.setForeground(Color.WHITE);
		txtEx.setBackground(Color.GRAY);
		txtEx.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtEx.setBounds(112, 194, 344, 39);
		panel.add(txtEx);
		txtEx.setColumns(10);
		
		btnCalcular = new JButton("CALCULAR");
		btnCalcular.setEnabled(false);
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setBackground(Color.DARK_GRAY);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expressao = txtEx.getText();
				int tipoDePilha = rdbtnPilhaVetor.isSelected() ? 0 : 1;
				try {
					Calculadora<Double> calculadora = new Calculadora<>(expressao, tipoDePilha);
					String resultado = calculadora.calcular();
					txtEx.setText(resultado);
					System.out.println("olá");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getLocalizedMessage());
				}
			}
		});
		btnCalcular.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCalcular.setBounds(162, 282, 119, 39);
		panel.add(btnCalcular);
		
		JLabel lblNewLabel = new JLabel("clique em limpar para adicionar uma expressão *");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(112, 244, 344, 14);
		panel.add(lblNewLabel);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(Color.DARK_GRAY);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				txtEx.setEnabled(true);
				txtEx.setText(null);
			}
		});
		btnLimpar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnLimpar.setBounds(291, 282, 119, 39);
		panel.add(btnLimpar);
	}
}
