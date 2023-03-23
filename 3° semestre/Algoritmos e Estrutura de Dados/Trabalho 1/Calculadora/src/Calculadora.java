import javax.swing.JOptionPane;

import pilhas.Pilha;
import pilhas.PilhaLista;
import pilhas.PilhaVetor;
import listas.ListaEncadeada;

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
		
		return this.manipularExpressao();
	}

	private String manipularExpressao() {
		expressaoNula();
		String[] lista = this.expressao.split(" ");
		ListaEncadeada<String> novaLista = validarExpressao(lista);
		String resultado = "";
		for (int i = novaLista.getTamanho() - 1; i >= 0 ; i--) {
			resultado += novaLista.pegar(i);
		}
		return resultado;
	}

	private ListaEncadeada<String> validarExpressao(String[] lista) {
		int qtdOperandos = 0;
		int qtdOperadores = 0;
		
		ListaEncadeada<String> novaLista = new ListaEncadeada<>();
		for (int i = 0; i < lista.length; i++) {
			if (novaLista.estaVazia()) {
				if (this.verificarSeEOperando(lista[i])) {
					novaLista.inserir(lista[i]);
					qtdOperandos++;
				}else {
					throw new RuntimeException("Expressão inválida!");
				}
			} else if (this.verificarSeEOperando(lista[i]) && i < lista.length - 1) {
				if (qtdOperandos == 2) {
					throw new RuntimeException("Expressão inválida!");
				} else if (qtdOperandos == 0) {
					qtdOperadores = 0;
				}
				novaLista.inserir(lista[i]);
				qtdOperandos++;
			} else if (this.verificarSeEOperador(lista[i])) {
				if (qtdOperadores == 1 || novaLista.getTamanho() < 4 && qtdOperandos != 2) {
					throw new RuntimeException("Expressão inválida!");
				}
				novaLista.inserir(lista[i]);
				qtdOperadores++;
				qtdOperandos = 0;
			} else if (lista[i] != "") {
				throw new RuntimeException("Expressão inválida!");
			}
		}
		return novaLista;
	}
	
	private boolean verificarSeEOperador(String valor) {
		if (valor.equals("")) return false;
		String[] operadores = {"+", "-", "*", "/"};
		if (valor.length() == 1) {
			for (String o: operadores) {
				if (valor.equals(o)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean verificarSeEOperando(String valor) {
		if (valor.equals("")) return false;
		String[] numerosPositivos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] numerosNegativos = {"-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1"};
			
		String valorComparar = "";
		for (int i = 0; i < valor.length(); i++) {
			if (valor.charAt(0) == '-' && valorComparar.length() == 0 && valor.length() > 1) {
				for (int j = 0; j < 9; j++) {
					if (numerosNegativos[j].equals("" + valor.charAt(0) + valor.charAt(1))) {
						valorComparar = numerosNegativos[j];
						i++;
					} 
				}
			} else {
				for (int j = 0; j < 10; j++) {
					if (numerosPositivos[j].equals("" + valor.charAt(i))) {
						valorComparar += numerosPositivos[j];
					}
				}
			}
			
			if (valor.charAt(i) == '.' && !valorComparar.contains(".") && valorComparar.length() > 0 && i < valor.length() - 1) {
				valorComparar += valor.charAt(i);
			}
		}
		if (valorComparar.equals(valor)) {
			return true;
		}
		return false;
	}
	
	private void expressaoNula() {
		if (expressao.isBlank() || expressao.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Expressão não pode ser nula!");
			throw new IllegalArgumentException("Expressão não pode ser nula!");
		}
	}

}
