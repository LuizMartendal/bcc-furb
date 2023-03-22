import javax.swing.JOptionPane;

import pilhas.Pilha;
import pilhas.PilhaLista;
import pilhas.PilhaVetor;

public class Calculadora {
	
	private String expressao;
	private int tipoDePilha;
	private Pilha<String> pilha;
	
	public Calculadora(String expressao, int tipoDePilha) {
		this.setExpressao(expressao);
		this.setTipoDePilha(tipoDePilha);
	}
	
	public String getExpressao() {
		if (expressao.isBlank() || expressao.isEmpty()) {
			throw new RuntimeException("Não há nenhuma expressão!");
		}
		return expressao;
	}

	public void setExpressao(String expressao) {
		if (expressao.isBlank() || expressao.isEmpty()) {
			throw new RuntimeException("Expressão não pode ser nula!");
		} else {
			this.expressao = expressao;
		}
	}

	public String getTipoDePilha() {
		if (tipoDePilha == 0) {
			return "Pilha Vetor";
		}
		return "Pilha Lista";
	}

	public void setTipoDePilha(int tipoDePilha) {
		if (tipoDePilha > 1 || tipoDePilha < 0) {
			tipoDePilha = 0;
		} else {
			this.tipoDePilha = tipoDePilha;
		}
	}
	
	public String calcular() {
		if (this.tipoDePilha == 0) {
			this.pilha = new PilhaVetor<>(100);
		} else {
			this.pilha = new PilhaLista<>();
		}
		
		this.manipularExpressao();
		
		return this.expressao + "" + this.tipoDePilha;
	}

	private void manipularExpressao() {
		expressaoNula();
		
		
	}

	private void validarExpressao() {
		
	}
	
	private void expressaoNula() {
		if (expressao.isBlank() || expressao.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Expressão não pode ser nula!");
			throw new IllegalArgumentException("Expressão não pode ser nula!");
		}
	}

}
