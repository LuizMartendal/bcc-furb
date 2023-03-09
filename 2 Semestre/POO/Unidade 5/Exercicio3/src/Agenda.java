import java.time.LocalDate;
import java.util.HashMap;

public class Agenda {
	private HashMap<LocalDate, DataAgenda> dataAgenda = new HashMap<>();
	private LocalDate data;
	public Agenda() {}
	
	public void addDataAgenda(DataAgenda dataAgenda) {
		if (!this.dataAgenda.containsKey(dataAgenda.getData())) {
			this.dataAgenda.put(dataAgenda.getData(), dataAgenda);
		}
	}
	
	public Compromisso getMenorCompromisso() {
		int menorTempo = Integer.MAX_VALUE;
		Compromisso compromissoMenor = null;
		for(DataAgenda data: dataAgenda.values()) {
			Compromisso compromisso = data.getMenorCompromisso();
			if(compromisso != null) {
				if (menorTempo > compromisso.getTempo()) {
					compromissoMenor = compromisso;
					menorTempo = compromisso.getTempo();
					setDataMenorCompromisso(data.getData());
				}
			}
		}
		return compromissoMenor;
	}
	
	public DataAgenda getDataAgenda(LocalDate data) {
		return this.dataAgenda.get(data);
	}
	
	public void setDataMenorCompromisso(LocalDate data) {
		this.data = data;
	}
	
	public LocalDate getDataMenorCompromisso() {
		return this.data;
	}
}
 