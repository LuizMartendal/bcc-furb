//Nome: Luiz Henrique Martendal
public class Expressao {
	private String exp;
	
	public Expressao(String exp) {
		this.exp = exp;
	}
	  
	public boolean estaCorretaSintaticamente() {    
	    String pilha = "";
		int cont_esquerda = 0, cont_direita = 0;
	    for (int i = 0; i < this.exp.length(); i++){
	      char c = exp.charAt(i);     
	      
	      if (c == '(') {
	        pilha += c;                             
			cont_esquerda++;
	      }else if (c == ')') { 
	        if (pilha == ""){  
	          return false;                                   
	        }
			if (cont_esquerda < 2){
				pilha = "";
				cont_esquerda = 0;
			}else if (cont_esquerda >= 2){
				pilha += c;
				cont_direita++;
			}              
			if (cont_direita == cont_esquerda && cont_direita > 1 && cont_esquerda > 1){
				pilha = "";
			}                
	      }
	    }
	  
	    if (pilha != ""){        
	    	return false;                                       
	    }else {
	    	return true;
	    }
	}
	
	public int getQtdeDivisores() {
		int qtd_de_divisores = 0;
		
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (c == '/') {
				qtd_de_divisores++;
			}
		}
		return qtd_de_divisores;
	}
	
	public int getPosicaoOperador(){
		int posicao_operador = -1; // <<<<<< depois ||| antes >>>>>> int posicao_operador = 0;
		int cont = 0;
		for (int i = 0; i < this.exp.length(); i++){
			char c = this.exp.charAt(i);
			if (c == '+' || c == '-' || c == '/' || c == '*'){
				if (cont == 0) {
					posicao_operador = i;
				cont++;
				}
			}
		}
		return posicao_operador;
	}
}
