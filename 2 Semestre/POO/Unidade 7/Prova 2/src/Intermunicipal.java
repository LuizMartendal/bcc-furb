//Luiz Henrique Martendal
import java.time.LocalDate;
import java.time.LocalTime;

public class Intermunicipal extends Viagem{
	
	public Intermunicipal(String p, String n, LocalDate d, LocalTime t) {
		super(p,n,d,t);
	}
	
	public void addPassageiro(Passageiro p) {
		if (this.getQtdPassageiros() <= 32) {
			this.p.add(p);
		}else {
			throw new IllegalArgumentException("Limite excedido");
		}
	}
	
	public Float getValorTotal() {
		Float valor = 0f;
		for (Passageiro p: this.p) {
			valor += p.getTarifa() + 4.22f;
		}
		return valor;
	}
}
