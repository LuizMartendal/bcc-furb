import java.time.LocalDate;
import java.util.ArrayList;

public class Transatlantico extends Embarcacao{
	private String nome;
	private LocalDate dataInauguracao;
	private ArrayList<BoteSalvaVidas> bsv = new ArrayList<>();
	
	public Transatlantico(String nome, LocalDate dataInauguracao, String regCapitania, int qtdPessoas) {
		super(regCapitania, qtdPessoas);
		this.setNome(nome);
		this.setDataInauguracao(dataInauguracao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}else {
			throw new IllegalArgumentException("Nome não informado.");
		}
	}

	public LocalDate getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(LocalDate dataInauguracao) {
		if (dataInauguracao != null) {
			this.dataInauguracao = dataInauguracao;
		}else {
			throw new IllegalArgumentException("Data não informada.");
		}
	}
	
	public void addBote(BoteSalvaVidas bote) {
		if (bote != null) {
			bsv.add(bote);
		}else {
			throw new IllegalArgumentException("Bote não informado.");
		}
	}

	public String verificaSeguranca() {
		int soma = 0;
		for (BoteSalvaVidas b: bsv) {
			soma += b.getQtdPessoas();
		}
		if (soma >= this.getQtdPessoas() ) {
			return "Está em condições adequadas de segurança.";
		}else {
			if (this.getDataInauguracao().isAfter(LocalDate.now())) {
				return "ALERTA: navio necessitando de mais botes.";
			}else {
				return "CUIDADO: navio em perigo.";
			}
		}
	}
}
