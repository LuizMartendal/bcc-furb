
public class Viagens {
	private int km;
	private int duracao;
	private float valorVendas;
	
	public Viagens(int km, int duracao, float valorVendas) {
		this.setKm(km);
		this.setDuracao(duracao);
		this.setValorVendas(valorVendas);
	}
	
	public void setKm(int km) {
		this.km = km;
	}
	
	public int getKm() {
		return this.km;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}
	
	public float getValorVendas() {
		return this.valorVendas;
	}
}
