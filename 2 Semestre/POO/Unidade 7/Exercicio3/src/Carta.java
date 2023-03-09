import java.util.ArrayList;

public class Carta extends Impressora{
	private ArrayList<String> frase = new ArrayList<>();
	
	public Carta(String str) {
		super(str);
	}
	
	public void organizar() {
		for (int j = 0; j < this.str.size(); j++) {
			String str = this.getFrase();
			if (str.length() > 8) {
				for (int i = 0; i < str.length(); i += 8) {
					frase.add(this.cortar(str, i));
				}
			}else {
				frase.add(str);
			}
			indice++;
		}
	}
	
	public String cortar(String s, int i) {
		if (i == 0) {
			return s.substring(i, 8);
		}
		if ((i + 8) <= s.length()) {
			return s.substring(i, i + 8);
		}
		return s.substring(i, s.length());
	}
	
	@Override
	public ArrayList<String> imprimir() {		
		organizar();
		if (frase.size() < 10) {
			return this.frase;
		}
		frase.removeAll(frase);
		throw new IllegalArgumentException("Limite da folha.");
	}
}
