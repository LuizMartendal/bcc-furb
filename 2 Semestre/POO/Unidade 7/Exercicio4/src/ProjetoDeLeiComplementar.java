//Luiz Henrique Martendal
import java.time.LocalDate;	

public class ProjetoDeLeiComplementar extends ProjetoDeLei {
	private String artigoLO;
	private int qtdVotosFavoraveis;
	
	public ProjetoDeLeiComplementar(String ar, int qtd, String t, LocalDate dtA) {
		super(t, dtA);
		this.setArtigoLO(ar);
		this.setQtdVotosFavoraveis(qtd);
	}

	public String getArtigoLO() {
		if (this.artigoLO != null) {
			return artigoLO;
		}
		throw new IllegalArgumentException("Artigo não prenchido.");
	}

	public void setArtigoLO(String artigoLO) {
		if (artigoLO != null) {
			this.artigoLO = artigoLO;
		}else {
			throw new IllegalArgumentException("Artigo não prenchido.");
		}
	}

	public int getQtdVotosFavoraveis() {
		if (this.qtdVotosFavoraveis >= 0) {
			return qtdVotosFavoraveis;
		}
		throw new IllegalArgumentException("Não são permitidos números negativos.");
	}

	public void setQtdVotosFavoraveis(int qtdVotosFavoraveis) {
		if (qtdVotosFavoraveis >= 0) {
			this.qtdVotosFavoraveis = qtdVotosFavoraveis;
		}else {
			throw new IllegalArgumentException("Não são permitidos números negativos.");
		}
	}
	
	public String mostrar() {
		if (this.getDataAprovacao() != null) {
			return "Projeto de lei complementar número " + this.getNumeroProjeto() + ": \n" +
				"Título: " + this.getTitulo() + "\n" +
				"Data de apresentação: " + this.getDataApresentacao() + "\n" +
				"Aprovado em: " + this.getDataAprovacao() + "\n" +
				"Artigo da Lei Orgânica: " + this.getArtigoLO() + "\n" +
				"Quantidade de votos favoraveis: " + this.getQtdVotosFavoraveis();
		}else {
			return "Projeto de lei complementar número " + this.getNumeroProjeto() + ": \n" +
					"Título: " + this.getTitulo() + "\n" +
					"Data de apresentação: " + this.getDataApresentacao() + "\n" +
					"Ainda não foi aprovado" + "\n" +
					"Artigo da Lei Orgânica: " + this.getArtigoLO() + "\n" +
					"Quantidade de votos favoraveis: " + this.getQtdVotosFavoraveis();
		}
		
	}
}
