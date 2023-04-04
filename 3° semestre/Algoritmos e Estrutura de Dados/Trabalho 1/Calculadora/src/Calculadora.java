import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JOptionPane;

import pilhas.Pilha;
import pilhas.PilhaLista;
import pilhas.PilhaVetor;
import listas.ListaEncadeada;

public class Calculadora<T> {
	
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

		List<Double> operandos = new ArrayList<>();
		String operador = "";
		
		String[] lista = this.expressao.split(" ");
		ListaEncadeada<String> novaLista = validarExpressao(lista);
		
		Double resultado = 0.0;
		for (int i = novaLista.getTamanho() - 1; i >= 0 ; i--) {
			if (this.verificarSeEOperando(novaLista.pegar(i))) {
				if (qtdOperandos == 2 && i == 0) {
					throw new RuntimeException("Expressão inválida!\nNão foram identificados operadores suficientes.");
				}
				if (!operador.equals("+")) {
					operador = "";
				}
				
				pilha.push(novaLista.pegar(i));
				qtdOperandos++;
			} else if (this.verificarSeEOperador(novaLista.pegar(i))) {
				
				operador = novaLista.pegar(i);
				int ignorar = 0;
				if (qtdOperandos > 2 && !operador.equals("+")) {
					ignorar = qtdOperandos - 1;
				}
				while (qtdOperandos > ignorar) {
					operandos.add(Double.parseDouble(pilha.pop()));
					qtdOperandos--;
				}

				switch (operador) {
					case "+":
						for (int j = operandos.size() -1; j >= 0; j--) {
							resultado += operandos.get(j);
						}
						break;
					case "-":
						for (int j = operandos.size() -1; j >= 0; j--) {
							resultado -= operandos.get(j);
						}
						break;
					case "*":
						resultado = operandos.get(operandos.size() -1);
						for (int j = operandos.size() -2; j >= 0; j--) {
							resultado *= operandos.get(j);
						}
						break;
					case "/":
						if (operandos.get(0) == 0) {
							throw new IllegalArgumentException("Não existe divisão por zero!");
						}
						resultado = operandos.get(1) / operandos.get(0);
						break;
					case "^":
						resultado = (Math.pow(operandos.get(1), operandos.get(0)));
						break;
					default:
						throw new IllegalArgumentException("Operador inválido!");
				}
				operandos.clear();
				pilha.push(""+resultado);
				qtdOperandos = 1;
				if (i != 0) {
					resultado = 0.0;
				}
			}
		}
		return ""+resultado;
	}

	private ListaEncadeada<String> validarExpressao(String[] lista) {
		int qtdTotalOperandos = 0;
		int qtdTotalOperadores = 0;
		int qtdExpressoes = 0;
		int qtdOperandos = 0;
		int qtdOperadores = 0;
		String operador = "";
		
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
				 if (qtdOperandos == 0) {
					qtdOperadores = 0;
					 qtdExpressoes++;
				}
				novaLista.inserir(lista[i]);
				qtdOperandos++;
				qtdTotalOperandos++;
			} else if (this.verificarSeEOperador(lista[i])) {
				if ((qtdOperadores == 1 && qtdTotalOperandos < 4)) {
					throw new RuntimeException("Expressão inválida!\nNão foi possível identificar operandos suficientes para concluir a operação!");
				}
				operador = lista[i];

				if (qtdOperadores >= 2) {
					throw new RuntimeException("Expressão inválida!\nNão foi possível identificar operandos suficientes para concluir a operação!");
				}

				if (qtdTotalOperadores - qtdExpressoes != 1 && qtdTotalOperandos > 2) {
					throw new RuntimeException("Expressão inválida!\nNão foi possível identificar operandos suficientes para concluir a operação!");
				}

				if (qtdOperandos > 2 && !operador.equals("+")) {
					throw new RuntimeException("Expressão inválida!\nNão foi possível identificar operadores suficientes para concluir a operação!");
				}

				if (qtdTotalOperandos == 8) {
					System.out.println(5);
				}
				novaLista.inserir(lista[i]);
				qtdOperadores++;
				qtdTotalOperadores++;
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
