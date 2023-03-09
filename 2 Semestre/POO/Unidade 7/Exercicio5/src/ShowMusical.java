import java.time.LocalDate;

public class ShowMusical extends Evento{
	private String NomeBanda;
	private String estiloMusical;
	
	public ShowMusical(String banda, String estilo, String titulo, double valor, LocalDate data) {
		super(titulo, valor, data);
		this.setNomeBanda(banda);
		this.setEstiloMusical(estilo);
	}

	public String getNomeBanda() {
		return NomeBanda;
	}

	public void setNomeBanda(String nomeBanda) {
		if (!nomeBanda.isBlank()) {
			NomeBanda = nomeBanda;
		}else {
			throw new IllegalArgumentException("Nome não informado.");
		}
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		if (!estiloMusical.isBlank()) {
			this.estiloMusical = estiloMusical;
		}else {
			throw new IllegalArgumentException("Estilo não informado.");
		}
	}
	
	public String exibir() {
		return "Show musical " + this.getTitulo() + " de " + this.getEstiloMusical() + " de " + this.getNomeBanda() + " com ingressos a R$ " + this.getValor() + ", dia " + this.getData() + ". Ainda não avaliado.";
	}
	
}