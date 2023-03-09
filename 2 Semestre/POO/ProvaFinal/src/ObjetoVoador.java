//Luiz Henrique Martendal;
public abstract class ObjetoVoador {
	private double latitude;
	private double longitude;
	private int altura;
	
	public ObjetoVoador(double[] coordenada, int altura) {
		this.setAltura(altura);
		this.setLatitude(coordenada[0]);
		this.setLongitude(coordenada[1]);
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		if (altura < 0) {
			throw new IllegalArgumentException("Altura menor que 0");
		}
		this.altura = altura;
	}
	
	public double[] getCoordenada() {
		double[] c = new double[2];
		c[0] = this.latitude;
		c[1] = this.longitude;
		return c;
	}
	
	public abstract void movimentar();
}
