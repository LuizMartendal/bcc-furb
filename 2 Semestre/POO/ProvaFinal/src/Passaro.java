//Luiz Henrique Martendal;
import java.util.Random;

public class Passaro extends ObjetoVoador implements Comparable<ObjetoVoador>{
	private String passaro;
	public Passaro(double[] coordenada, int altura, String p) {
		super(coordenada, altura);
		this.setEspecie(p);
	}
	
	public String getEspecie() {
		return this.passaro;
	}
	
	public void setEspecie(String p) {
		this.passaro = p;
	}

	@Override
	public void movimentar() {
		Random r = new Random();
		int a = r.nextInt(0, 2);
		this.setAltura(a);
	}
	
	@Override
	public int compareTo(ObjetoVoador o) {
		if (this.getAltura() > o.getAltura()) {
			return 1;
		}else if (this.getAltura() < o.getAltura()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Passaro [passaro=" + passaro + ", getLatitude()=" + getLatitude() + ", getLongitude()=" + getLongitude()
				+ ", getAltura()=" + getAltura() + "]";
	}
	
	
}
