
public class Vereador {
	private String nome;
	private Partido partido;
	private int qtdProjetosAprov;
	private int qtdProjetosApres;
	
	public Vereador(String nome, int qtdProjetosArov, int qtdProjetosApres) {
		this.setNome(nome);
		this.setQtdProjetosApres(qtdProjetosApres);
		this.setQtdProjetosAprov(qtdProjetosArov);
	}
	
	public double getDesempenho() {
		if (this.qtdProjetosApres == 0) {
			return 0;
		}else if (this.qtdProjetosApres > 0 && this.qtdProjetosApres <= 5) {
			return ((double)this.qtdProjetosAprov / this.qtdProjetosApres) * 0.80;
		}else if (this.qtdProjetosApres > 5 && this.qtdProjetosApres <= 10) {
			return ((double)this.qtdProjetosAprov / this.qtdProjetosApres) * 1;
		}else if (this.qtdProjetosApres > 10 && this.qtdProjetosApres <= 17) {
			return ((double)this.qtdProjetosAprov / this.qtdProjetosApres) * 1.08;
		}else {
			return ((double)this.qtdProjetosAprov / this.qtdProjetosApres) * 1.22;
		}
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setQtdProjetosAprov(int qtdProjetosAprov) {
		if (qtdProjetosAprov >= 0) {
			this.qtdProjetosAprov = qtdProjetosAprov;
		}
	}
	
	public int getQtdProjetosAprov() {
		return this.qtdProjetosAprov;
	}
	
	public void setQtdProjetosApres(int qtdProjetosApres) {
		if (qtdProjetosApres >= 0) {
			this.qtdProjetosApres = qtdProjetosApres;
		}
	}
	
	public int getQtdProjetosApres() {
		return this.qtdProjetosApres;
	}
	
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public Partido getPartido() {
		return this.partido;
	}
	
}
