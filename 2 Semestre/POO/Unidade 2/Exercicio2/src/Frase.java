public class Frase{
	private String texto;
	
	public Frase(String texto) {
		this.texto = texto;
	}
	
	public String[] decompor() {
		
		return this.texto.split(" ");
	}
}