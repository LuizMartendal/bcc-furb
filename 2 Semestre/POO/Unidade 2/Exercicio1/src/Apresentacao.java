import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUF;
	private JTextField tfRenda;
	private JTextField tfConsulta;
	private Contribuinte[] contribuintes = new Contribuinte[500];
	private int indice;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do contribuinte:");
		lblNewLabel.setBounds(10, 22, 139, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(158, 19, 218, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 52, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(158, 50, 86, 20);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Estado (UF):");
		lblNewLabel_2.setBounds(10, 83, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfUF = new JTextField();
		tfUF.setBounds(158, 81, 46, 20);
		frame.getContentPane().add(tfUF);
		tfUF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Renda anual: R$");
		lblNewLabel_3.setBounds(10, 113, 99, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfRenda = new JTextField();
		tfRenda.setBounds(158, 110, 86, 20);
		frame.getContentPane().add(tfRenda);
		tfRenda.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte c;
				c = new Contribuinte(tfNome.getText(), 
									tfCPF.getText(),
									tfUF.getText(),
									Double.parseDouble(tfRenda.getText()));
				double imposto = c.calcularImposto();
				String msg = "Contribuinte "+c.getNome()
							 +", CPF:"+c.getCpf()
							 +" pagará R$"+imposto;
				JOptionPane.showMessageDialog(frame, msg);
				contribuintes[indice] = c;
				indice++;
			}
		});
		btnInserir.setBounds(325, 166, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JLabel lblNewLabel_4 = new JLabel("Valor do imposto a consultar: R$");
		lblNewLabel_4.setBounds(10, 203, 150, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfConsulta = new JTextField();
		tfConsulta.setBounds(173, 201, 142, 20);
		frame.getContentPane().add(tfConsulta);
		tfConsulta.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double impostoAConsultar = Double.parseDouble(tfConsulta.getText());
				String exibicao = "Contribuintes com imposto acima de R$"
									+impostoAConsultar+"\n";
				
				for (int i=0; i < indice; i++) {
					Contribuinte c = contribuintes[i];
					if (c.calcularImposto() > impostoAConsultar) {
						exibicao += "\n"+c.getNome()+", CPF:"+c.getCpf()
									+" Renda "+c.getRendaAnual()
									+" Imposto "+c.calcularImposto();
					}
				}
				JOptionPane.showMessageDialog(frame, exibicao);
			}
		});
		btnConsultar.setBounds(325, 199, 89, 23);
		frame.getContentPane().add(btnConsultar);
	}
}