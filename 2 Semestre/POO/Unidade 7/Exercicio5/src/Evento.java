import java.time.LocalDate;

public class Evento {
	private String titulo;
	private double valor;
	private LocalDate data;
	private Avaliacao avaliacao;

	public Evento(String t, double v, LocalDate data) {
		this.setTitulo(t);
		this.setValor(v);
		this.setData(data);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (!titulo.isBlank()) {
			this.titulo = titulo;
		}else {
			throw new IllegalArgumentException("Título não informado.");
		}
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if (valor > 0 ) {
			this.valor = valor;
		}else {
			throw new IllegalArgumentException("Valor precisa ser maior que 0");
		}
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		if (data != null) {
			this.data = data;
		}else {
			throw new IllegalArgumentException("Data não informada.");
		}
	}
	
	public void addAvaliacao(Avaliacao a) {
		if (LocalDate.now().isAfter(this.data)) {
			avaliacao = a;
		}
	}
	
	public String exibir() {
		return "Evento: " + this.getTitulo() + ", no dia " + this.getData() + ", ingressos a R$ " + this.getValor() + ", teve " + avaliacao.getQtdPagantes() + " que acharam o evento " + avaliacao.getOpniaoGeral();
	}
}
