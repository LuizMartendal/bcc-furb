import java.util.ArrayList;

public class Folha_a4 extends Impressora{
	private ArrayList<String> frase = new ArrayList<>();
	
	public Folha_a4(String str) {
		super(str);
	}
	
	public void organizar() {
		for (int j = 0; j < this.str.size(); j++) {
			String str = this.getFrase();
			if (str.length() > 20) {
				for (int i = 0; i < str.length(); i += 20) {
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
			return s.substring(i, 20);
		}
		if ((i + 20) <= s.length()) {
			return s.substring(i, i + 20);
		}
		return s.substring(i, s.length());
	}
	
	@Override
	public ArrayList<String> imprimir() {		
		organizar();
		if (frase.size() < 12) {
			return this.frase;
		}
		frase.removeAll(frase);
		throw new IllegalArgumentException("Limite da folha.");
	}
}
