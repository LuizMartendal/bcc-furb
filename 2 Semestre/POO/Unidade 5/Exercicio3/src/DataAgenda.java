import java.time.LocalDate;
import java.util.ArrayList;

public class DataAgenda {
	private LocalDate data;
	private String efemeride;
	private ArrayList<Compromisso> compromissos = new ArrayList<>();
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public void setEfemeride(String emfemeride) {
		this.efemeride = emfemeride;
	}
	public String getEmfemeride() {
		return this.efemeride;
	}
	
	public void addCompromisso(Compromisso compromisso) {
		for (Compromisso c: compromissos) {
			if (c.getHora().equals(compromisso.getHora())){
				return;
			}
		}
		compromissos.add(compromisso);
	}
	
	public int getTempoMedio() {
		int total = 0;
		for (Compromisso c: compromissos) {
			total += c.getTempo();
		}
		
		return total/compromissos.size();
	}
	
	public int getQtdCompromissosPrioridade(char prior) {
		int conta = 0;
		for (Compromisso c: compromissos) {
			if (c.getPrioridade() == prior) {
				conta++;
			}
		}
		return conta;
	}
	
	public ArrayList<Compromisso> getCompromissosPrioridade(char prior) {
		ArrayList<Compromisso> retorno = new ArrayList<>();
		for (Compromisso c: compromissos) {
			if (c.getPrioridade() == prior) {
				retorno.add(c);
			}
		}
		return retorno;
	}
	
	public Compromisso getMenorCompromisso() {
		Compromisso menor = null;
		int tempo = Integer.MAX_VALUE;
		for (Compromisso c: compromissos) {
			if (c.getTempo() < tempo) {
				menor = c;
			}
		}
		return menor;
	}
	
	public int getQtdCompromissos() {
		return this.compromissos.size();
	}
}
