import java.text.DecimalFormat;

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
			throw new RuntimeException("Expressão não pode ser null!");
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
		DecimalFormat df = new DecimalFormat("0.00"); 
		return df.format(Double.parseDouble(this.manipularExpressao()));
	}

	private String manipularExpressao() {
		expressaoNula();
		
		int qtdOperandos = 0;
		
		Double primeiroOperando = 0.0;
		Double segundoOperando = 0.0;
		String operador = "";
		
		String[] lista = this.expressao.split(" ");
		ListaEncadeada<String> novaLista = validarExpressao(lista);
		
		String resultado = "";
		for (int i = novaLista.getTamanho() - 1; i >= 0 ; i--) {
			if (this.verificarSeEOperando(novaLista.pegar(i))) {
				if (qtdOperandos == 2 && i == 0) {
					throw new RuntimeException("Expressão inválida!\nNão foram identificados operadores suficientes.");
				}
				operador = "";
				
				pilha.push(novaLista.pegar(i));
				qtdOperandos++;
			} else if (this.verificarSeEOperador(novaLista.pegar(i))) {
				
				operador = novaLista.pegar(i);
				segundoOperando = Double.parseDouble(pilha.pop());
				primeiroOperando = Double.parseDouble(pilha.pop());
				
				switch (operador) {
					case "+":
						resultado = "" + (primeiroOperando + segundoOperando);
						break;
					case "-":
						resultado = "" + (primeiroOperando - segundoOperando);
						break;
					case "*":
						resultado = "" + (primeiroOperando * segundoOperando);
						break;
					case "/":
						if (segundoOperando == 0) {
							throw new IllegalArgumentException("Não existe divisão por zero!");
						}
						resultado = "" + (primeiroOperando / segundoOperando);
						break;
					case "^":
						resultado = "" + (Math.pow(primeiroOperando, segundoOperando));
						break;
					default:
						throw new IllegalArgumentException("Operador inválido!");
				}
				pilha.push(resultado);
				qtdOperandos = 1;
			}
		}
		return resultado;
	}

	private ListaEncadeada<String> validarExpressao(String[] lista) {
		int qtdTotalOperandos = 0;
		int qtdOperandos = 0;
		int qtdOperadores = 0;
		
		ListaEncadeada<String> novaLista = new ListaEncadeada<>();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].contains(",")) {
				lista[i] = lista[i].replace(',', '.');
			}
			if (novaLista.estaVazia()) {
				if (this.verificarSeEOperando(lista[i])) {
					novaLista.inserir(lista[i]);
					qtdOperandos++;
					qtdTotalOperandos++;
				}else {
					throw new RuntimeException("Expressão inválida!" +
							"					\nAlguns possíveis motivos:\n" +
							"					O primeiro elemento da expressão deve ser um número;\n" +
							"					Algum número possui mais de uma vírgula ou ponto;" +
							"					\nPor regra de negócio, a expressão não pode iniciar com espaço, caso seja esse o problema...");
				}
			} else if (this.verificarSeEOperando(lista[i]) && i < lista.length - 1) {
				if (qtdOperandos == 2) {
					throw new RuntimeException("Expressão inválida!\nNão foi possível identificar operadores suficientes para concluir a operação!");
				} else if (qtdOperandos == 0) {
					qtdOperadores = 0;
				}
				novaLista.inserir(lista[i]);
				qtdOperandos++;
				qtdTotalOperandos++;
			} else if (this.verificarSeEOperador(lista[i])) {
				if ((qtdOperadores == 1 && qtdTotalOperandos < 4) || (novaLista.getTamanho() < 4 && qtdOperandos != 2)) {
					throw new RuntimeException("Expressão inválida!\nNão foi possível identificar operandos suficientes para concluir a operação!");
				}
				novaLista.inserir(lista[i]);
				qtdOperadores++;
				qtdOperandos = 0;
			} else if (lista[i] != "") {
				throw new RuntimeException("Expressão inválida!\nVerifique se a quantidade de operadores está correta, ou algum símbolo inválido!");
			}
		}
		return novaLista;
	}
	
	private boolean verificarSeEOperador(String valor) {
		if (valor.equals("")) return false;
		String[] operadores = {"+", "-", "*", "/", "^"};
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
