//Luiz Henrique Martendal
import java.time.LocalDate;
import java.time.LocalTime;

public class Municipais extends Viagem{
	
	public Municipais (String p, String n, LocalDate d, LocalTime t) {
		super(p,n,d,t);
	}
	
	public void addPassageiro(Passageiro p) {
		if (this.getQtdPassageiros() <= 62) {
			if (p != null) {
				this.p.add(p);
			}
		}else {
			throw new IllegalArgumentException("Limite excedido.");
		}
	}
	
	public Float getValorTotal() {
		float valor = 0f;
		for (Passageiro p: this.p) {
			valor += p.getTarifa();
		}
		return valor;
	}
}
