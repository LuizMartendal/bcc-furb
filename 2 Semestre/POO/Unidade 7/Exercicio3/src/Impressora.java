import java.util.ArrayList;

public abstract class Impressora implements Imprimir{
	protected ArrayList<String> str = new ArrayList<>();
	protected int indice;;
	
	public Impressora(String str) {
		if (str == null) {
			throw new IllegalArgumentException("f");
		}
		this.addFrase(str);
	}
	
	public void addFrase(String frase) {
		if (frase != null) {
			this.str.add(frase);
		}else {
			throw new IllegalArgumentException("Não há digitos.");
		}
	}
	
	public String getFrase() {
		if (this.str != null) {
			return str.get(indice);
		}
		throw new IllegalArgumentException("Tipo de folha inválido.");
	}
	
	public abstract ArrayList<String> imprimir();
}
