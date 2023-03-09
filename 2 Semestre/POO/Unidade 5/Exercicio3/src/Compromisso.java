import java.time.LocalTime;

public class Compromisso {
	private LocalTime hora;
	private String descricao;
	private int tempo;
	private char prioridade;
	
	public Compromisso(LocalTime hora, String descricao, int tempo, char prioridade) {
		this.setHora(hora);
		this.setDescricao(descricao);
		this.setTempo(tempo);
		this.setPrioridade(prioridade);
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public LocalTime getHora() {
		return this.hora;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setTempo(int tempo) {
		if (tempo >= 0)
		this.tempo = tempo;
	}
	
	public int getTempo() {
		return this.tempo;
	}
	
	public void setPrioridade(char prioridade) {
		if (prioridade == 'A' || prioridade == 'B' || prioridade == 'N') {
			this.prioridade = prioridade;
		}
	}
	
	public char getPrioridade() {
		return this.prioridade;
	}
		
}
