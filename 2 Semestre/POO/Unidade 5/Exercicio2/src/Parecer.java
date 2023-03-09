
import java.time.LocalDate;

public class Parecer {
	private String parecerista;
	private LocalDate data;
	private String conteudo;

	public String getParecerista() {
		return parecerista;
	}

	public void setParecerista(String parecerista) {
		if (parecerista != null && !parecerista.isBlank()) {
			this.parecerista = parecerista;
		}else {
			IllegalArgumentException exc;
			exc = new IllegalArgumentException("Nome do parecerista inválido.");
			throw exc;
		}
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}