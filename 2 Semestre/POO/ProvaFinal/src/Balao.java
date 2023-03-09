//Luiz Henrique Martendal;
public class Balao extends ObjetoVoador implements Comparable<ObjetoVoador>{
	private boolean subindo;
	
	public Balao(double[] coordenada, int altura) {
		super(coordenada, altura);
	}
	
	public boolean subindo() {
		return true;
	}

	public void setSubindo(boolean s) {
		this.subindo = s;
	}
	@Override
	public void movimentar() {
		if (subindo) {
			if (this.getAltura() < 3500) {
				int a = this.getAltura();
				this.setAltura(a++);
			}else {
				this.setSubindo(false);
			}
		}else {
			if (this.getAltura() > 0) {
				int a = this.getAltura();
				this.setAltura(a--);
			}else {
				this.setSubindo(true);
			}
		}
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
		return "Balao [getLatitude()=" + getLatitude() + ", getLongitude()=" + getLongitude() + ", getAltura()="
				+ getAltura() + "]";
	}
	
	
}
