import java.io.Serializable;
import java.time.LocalDate;

public class ClimaDoDia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LocalDate date;
	String ventoDirecao;
	int ventoVelocidade;
	int indicePluviometrico;
	double temperatura;
	
	ClimaDoDia(LocalDate dt, String vd, int vv, int ip, double temp){
		this.setDate(dt);
		this.setVentoDirecao(vd);
		this.setVentoVelocidade(ip);
		this.setIndicePluviometrico(ip);
		this.setTemperatura(temp);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getVentoDirecao() {
		return ventoDirecao;
	}

	public void setVentoDirecao(String ventoDirecao) {
		this.ventoDirecao = ventoDirecao;
	}

	public int getVentoVelocidade() {
		return ventoVelocidade;
	}

	public void setVentoVelocidade(int ventoVelocidade) {
		this.ventoVelocidade = ventoVelocidade;
	}

	public int getIndicePluviometrico() {
		return indicePluviometrico;
	}

	public void setIndicePluviometrico(int indicePluviometrico) {
		this.indicePluviometrico = indicePluviometrico;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "ClimaDoDia [date=" + date + ", ventoDirecao=" + ventoDirecao + ", ventoVelocidade=" + ventoVelocidade
				+ ", indicePluviometrico=" + indicePluviometrico + ", temperatura=" + temperatura + "]";
	}
	
	
}
