//Luiz Henrique Martendal;
public class Aeronave extends ObjetoVoador implements Comparable<ObjetoVoador>{
	private String prefixo;
	private int qtdPassageiros;
	private String statusVoo;
	
	public Aeronave(double[] coordenada, int altura, String status, String prefixo, int qtd) {
		super(coordenada, altura);
		this.setStatusVoo(status);
		this.setPrefixo(prefixo);
		this.setQtd(qtd);
	}
	
	public String getPrefixo() {
		return this.prefixo;
	}
	
	public void setPrefixo(String p) {
		this.prefixo = p;
	}
	
	public int getQtdPassageiros() {
		return this.qtdPassageiros;
	}
	
	public void setQtd(int qtd) {
		this.qtdPassageiros = qtd;
	}
	
	public String getStatusVoo() {
		return this.statusVoo;
	}
	
	public void setStatusVoo(String status) {
		this.statusVoo = status;
	}

	@Override
	public void movimentar() {
		if (this.statusVoo.equals("decolando")) {
			int a = this.getAltura() + 500;
			this.setAltura(a);
			if (this.getAltura() == 33000) {
				this.setStatusVoo("cruzeiro");
			}
		}else if (this.statusVoo.equals("pousando")) {
			int a = this.getAltura() - 500;
			this.setAltura(a);
			if (this.getAltura() == 0) {
				this.setStatusVoo("em solo");
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
		return "Aeronave [prefixo=" + prefixo + ", qtdPassageiros=" + qtdPassageiros + ", statusVoo=" + statusVoo
				+ ", getLatitude()=" + getLatitude() + ", getLongitude()=" + getLongitude() + ", getAltura()="
				+ getAltura() + "]";
	}
	
	
}
