import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUF;
	private JTextField tfRenda;
	private JTextField tfConsulta;
	private ArrayList<Contribuinte> contribuintes = new ArrayList<>();
	private HashMap<String, Contribuinte> hashContrib = new HashMap<>();
	private JTextField txt_consultar_cpf;

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
				contribuintes.add(c);
				hashContrib.put(c.getCpf(),c );
			}
		});
		btnInserir.setBounds(325, 109, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JLabel lblNewLabel_4 = new JLabel("Valor do imposto a consultar: R$");
		lblNewLabel_4.setBounds(10, 169, 150, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfConsulta = new JTextField();
		tfConsulta.setBounds(170, 167, 142, 20);
		frame.getContentPane().add(tfConsulta);
		tfConsulta.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double impostoAConsultar = Double.parseDouble(tfConsulta.getText());
				String exibicao = "Contribuintes com imposto acima de R$"
									+impostoAConsultar+"\n";
				
				for (int i=0; i < contribuintes.size(); i++) {
					Contribuinte c = contribuintes.get(i);
					if (c.calcularImposto() > impostoAConsultar) {
						exibicao += "\n"+c.getNome()+", CPF:"+c.getCpf()
									+" Renda "+c.getRendaAnual()
									+" Imposto "+c.calcularImposto();
					}
				}
				JOptionPane.showMessageDialog(frame, exibicao);
			}
		});
		btnConsultar.setBounds(325, 165, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
		JLabel lblNewLabel_5 = new JLabel("Consultar CPF:");
		lblNewLabel_5.setBounds(10, 199, 99, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txt_consultar_cpf = new JTextField();
		txt_consultar_cpf.setBounds(170, 197, 142, 19);
		frame.getContentPane().add(txt_consultar_cpf);
		txt_consultar_cpf.setColumns(10);
		
		JButton btn_consultar_cpf = new JButton("Consultar");
		btn_consultar_cpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exibicao = "CPF não encontrado!!!";
				for (Contribuinte c: contribuintes) {
					if (c.getCpf().equals(txt_consultar_cpf.getText())) {
						exibicao = "ArrayList =  Nome: " + c.getNome() 
								+ "\n CPF: " + c.getCpf()
								+ "\n Renda: " + c.getRendaAnual()
								+ "\n Imposto: " + c.calcularImposto();
					}
				}
				
				JOptionPane.showMessageDialog(frame, exibicao);
				
				Contribuinte c = hashContrib.get(txt_consultar_cpf.getText());
				if (c == null) {
					exibicao = "HashMap: CPF não encontrado";
				}else {
					exibicao = "HashMap =  Nome: " + c.getNome() 
								+ "\n CPF: " + c.getCpf()
								+ "\n Renda: " + c.getRendaAnual()
								+ "\n Imposto " + c.calcularImposto();
				}
						
			}
		});
		btn_consultar_cpf.setBounds(325, 195, 89, 23);
		frame.getContentPane().add(btn_consultar_cpf);
		
		JLabel lblNewLabel_6 = new JLabel("Consultar percentual:");
		lblNewLabel_6.setBounds(10, 229, 139, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btn_consultar_percentagem = new JButton("Consultar");
		btn_consultar_percentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double impostoTotal = 0;
				double sc = 0, pr = 0, rs = 0;
				for (Contribuinte c: contribuintes) {
					if (c.getUf().equals("RS")) {
						impostoTotal += c.calcularImposto();
						rs += c.calcularImposto();
					}else if (c.getUf().equals("SC")) {
						impostoTotal += c.calcularImposto();
						sc += c.calcularImposto();
					}else if (c.getUf().equals("PR")) {
						impostoTotal += c.calcularImposto();
						pr += c.calcularImposto();
					}
				}
				sc = (sc * 100) / impostoTotal;
				pr = (pr * 100) / impostoTotal;
				rs = (rs * 100) / impostoTotal;
				DecimalFormat df = new DecimalFormat("0.00");
				String resposta = "Imposto total dos 3 estados: " + impostoTotal + " = 100%"
									+ "\nSC " + df.format(sc) + "%"
									+ "\nRS " + df.format(rs) + "%"
									+ "\nPR " + df.format(pr) + "%";
				JOptionPane.showMessageDialog(frame, resposta);
													
			}
		});
		btn_consultar_percentagem.setBounds(325, 224, 89, 23);
		frame.getContentPane().add(btn_consultar_percentagem);
	}
}