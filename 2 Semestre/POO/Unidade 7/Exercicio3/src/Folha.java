
public abstract class Folha {
	
	public Folha(int l, int c) {
		if (c == 20 && l == 12) {
			this.imprimirFolha();
		}else if (c == 8 && l == 10) {
			//this.imprimirCarta();
		}else {
			throw new IllegalArgumentException("Formato inválido.");
		}
	}
	
	public abstract String imprimirFolha();
	

}
