//Luiz Henrique Martendal
import java.time.LocalDate;

public class ProjetoDeLei{
	private String titulo;
	private LocalDate dataApresentacao;
	private LocalDate dataAprovacao;
	private int numeroProjeto;
	
	public ProjetoDeLei(String t, LocalDate dtA) {
		this.setTitulo(t);
		this.setDataApresentacao(dtA);
	}

	public String getTitulo() {
		if (this.titulo != null) {
			return titulo;
		}
		throw new IllegalArgumentException("Título não prenchido.");
	}

	public void setTitulo(String titulo) {
		if (titulo != null) {
			this.titulo = titulo;
		}else {
			throw new IllegalArgumentException("Título não prenchido.");
		}
	}

	public LocalDate getDataApresentacao() {
		if (this.dataApresentacao != null) {
			return dataApresentacao;
		}
		throw new IllegalArgumentException("Data não prenchida.");
	}

	public void setDataApresentacao(LocalDate dataApresentacao) {
		if (dataApresentacao != null) {
			this.dataApresentacao = dataApresentacao;
		}else {
			throw new IllegalArgumentException("Data não prenchida.");
		}
	}

	public LocalDate getDataAprovacao() {
			return dataAprovacao;
	}

	public void setDataAprovacao(LocalDate dataAprovacao) {
		if (dataAprovacao != null) {
			this.dataAprovacao = dataAprovacao;
		}else {
			throw new IllegalArgumentException("Data não prenchida.");
		}
	}

	public int getNumeroProjeto() {
		if (this.numeroProjeto >= 0) {
			return numeroProjeto;
		}
		throw new IllegalArgumentException("Não são permitidos números negativos.");
	}

	public void setNumeroProjeto(int numeroProjeto) {
		if (numeroProjeto >= 0) {
			this.numeroProjeto = numeroProjeto;
		}else {
			throw new IllegalArgumentException("Não são permitidos números negativos.");
		}
	}
	
	public String mostrar() {
		if (this.getDataAprovacao() != null) {
			return "Projeto de lei complementar número " + this.getNumeroProjeto() + ": \n" +
				"Título: " + this.getTitulo() + "\n" +
				"Data de apresentação: " + this.getDataApresentacao() + "\n" +
				"Aprovado em: " + this.getDataAprovacao();
		}else {
			return "Projeto de lei complementar número " + this.getNumeroProjeto() + ": \n" +
					"Título: " + this.getTitulo() + "\n" +
					"Data de apresentação: " + this.getDataApresentacao() + "\n" +
					"Ainda não foi aprovado";
		}
	}
}
