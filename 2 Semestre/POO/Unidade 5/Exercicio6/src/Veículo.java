import java.time.LocalDate;
import java.util.ArrayList;

public class Veículo {
	private String placa;
	private String modelo;
	private LocalDate dataAquisicao;
	private ArrayList<Manutencao> manutencoes = new ArrayList<>();
	
	public void setPlaca(String placa) {
		if (placa.length() != 8) {
			throw new IllegalArgumentException("Placa inválida!");
		}
		this.placa = placa;
	}
	
	public String getPlaca() {
		return this.placa;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	
	public LocalDate getDataAquisicao() {
		return this.dataAquisicao;
	}
	
	public double getIndiceSucateamento() {
		double tempoParado = this.getTotalTempoParado();
		if (tempoParado < 21) {
			return 0;
		}else if (tempoParado < 51) {
			return 0.5f;
		}else if (tempoParado < 81) {
			return 1;
		}else if (tempoParado < 121) {
			return 1.5f;
		}
		return 2;
	}
	
	public double getCustoMedioManutencao() {
		double custoMedio = 0;
		int soma = 0;
		for (Manutencao m: manutencoes) {
			soma += m.getCusto();
		}
		custoMedio = soma / this.manutencoes.size();
		return custoMedio;
	}
	
	public int comparaVeiculo(Veículo veiculo) {
		if (this.getIndiceSucateamento() > veiculo.getIndiceSucateamento()) {
			return 1;
		}else if (this.getIndiceSucateamento() == veiculo.getIndiceSucateamento()) {
			return 0;
		}
		return -1;
	}
	
	public void addManutencao(Manutencao manutencao) {
		this.manutencoes.add(manutencao);
	}
	
	public int getTotalTempoParado() {
		int dias = 0;
		for (Manutencao m: manutencoes) {
			dias += m.getTempoParado();
		}
		return dias;
	}
	
	public int getQtdServicos(String descricao) {
		int qtd = 0;
		for (Manutencao m: manutencoes) {
			if (descricao.equals(m.getDescricao())) {
				qtd++;
			}
		}
		return qtd;
	}
}
