import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Digite a expressão: ");
		String expressao = s.next();
		Expressao exp = new Expressao(expressao);
		System.out.println("A expressão é: " + exp.estaCorretaSintaticamente());
		System.out.println("A quantidade de divisões é: " + exp.getQtdeDivisores());
		System.out.println("Posição do primeiro operador aritmético da expressão: " + exp.getPosicaoOperador());
		s.close();
	}
}
