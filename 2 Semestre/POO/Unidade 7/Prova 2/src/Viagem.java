//Luiz Henrique Martendal
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Viagem {
	private String placaOnibus;
	private String nomeMotorista;
	private LocalDate dataViagem;
	private LocalTime horaViagem;
	protected ArrayList<Passageiro> p = new ArrayList<>();
	
	public Viagem(String p, String n, LocalDate d, LocalTime h) {
		this.setPlacaOnibus(p);
		this.setNomeMotorista(n);
		this.setDataViagem(d);
		this.setHoraViagem(h);
	}

	public String getPlacaOnibus() {
		return placaOnibus;
	}

	public void setPlacaOnibus(String placaOnibus) {
		this.placaOnibus = placaOnibus;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public LocalDate getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(LocalDate dataViagem) {
		this.dataViagem = dataViagem;
	}

	public LocalTime getHoraViagem() {
		return horaViagem;
	}

	public void setHoraViagem(LocalTime horaViagem) {
		this.horaViagem = horaViagem;
	}
	
	public int getQtdPassageiros() {
		return this.p.size();
	}
	
	public void addPassageiro(Passageiro p) {
		this.p.add(p);
	}
	
	public abstract Float getValorTotal();
}
