
public class Manutencao {
	private float custo;
	private int tempoParado;
	private String descricao;
	private int numero;
	
	public float getCustoMedioDiario() {
		return this.custo / this.tempoParado;
	}
	
	public void setCusto(float custo) {
		if (custo < 0) {
			throw new IllegalArgumentException("Custo não pode ser negativo!");
		}
		this.custo = custo;
	}
	
	public float getCusto() {
		return this.custo;
	}
	
	public void setTempoParado(int tempoParado) {
		if (tempoParado <= 0) {
			throw new IllegalArgumentException("Tempo não pode ser menor ou igual a zero!");
		}
		this.tempoParado = tempoParado;
	}
	
	public int getTempoParado() {
		return this.tempoParado;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setNumero(int numero) {
		if (numero <= 0) {
			throw new IllegalArgumentException("Número inválido. Deve ser maior que zero!");
		}
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
}
