public class VetorDeReais {
	private double[] vetor;
	
	public VetorDeReais(int tamanho) {
		this.vetor = new double[tamanho]; 
	}
	
	public void setVetor(double valor, int posicao) {
		vetor[posicao] = valor;
	}
	
	public double getValor(int posicao) {
		return this.vetor[posicao];
	}
	
	public int getTamanho() {
		return this.vetor.length;
	}
	
	public int getPares() {
		int qtd_n_pares = 0;
		for (int i = 0; i < vetor.length; i++) {
			if ((int)vetor[i] % 2 == 0) {
				qtd_n_pares++;
			}
		}
		return qtd_n_pares;
	}
	
	public VetorDeReais VetoresDivididos(VetorDeReais vetor_2) {
		if (this.getTamanho() != vetor_2.getTamanho()) {
			return null;
		}
		VetorDeReais vetores_divididos = new VetorDeReais(this.vetor.length);
		double aux = 0;
		for (int i = 0; i < this.vetor.length; i++) {
			aux = this.vetor[i] / vetor_2.getValor(i);
			vetores_divididos.setVetor(aux, i);		
		}
		
		return vetores_divididos;
	}
	
	public double Multiplicacao(VetorDeReais vetor_2) {
		double multiplicacao = 0;
		for (int i = 0, j = vetor.length - 1;i < vetor.length && j >= 0;j--, i++) {
			multiplicacao += vetor[i] * vetor_2.getValor(j);
		}
		return multiplicacao;
	}

	public double[] InverterVetor() {
		double bolha = 0;
		for (int i = 0, j = vetor.length - 1; i < vetor.length / 2; i++, j--) {
			bolha = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = bolha;
		}
		return this.vetor;
	}
	
	public double MaiorDiferenca() {
		double maior_diferenca = 0;
		double verificacao;
		for (int i = 0; i < vetor.length - 1; i++) {
			verificacao = this.vetor[i] - this.vetor[i + 1];
			if (Math.abs(verificacao) > maior_diferenca) {
				maior_diferenca = verificacao;
			}
		}
		return maior_diferenca;
	}
	
	public String exibir() {
		String str = "[";
		for (int i = 0; i < this.getTamanho(); i++) {
			str += this.vetor[i] + ", ";
		}
		return str + "]";
	}
	
}
