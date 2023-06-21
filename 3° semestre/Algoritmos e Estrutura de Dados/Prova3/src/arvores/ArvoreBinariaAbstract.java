package arvores;

public abstract class ArvoreBinariaAbstract<T> { // contribuição do Gustavo G
	private NoArvoreBinaria<T> raiz;

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	protected NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public boolean vazia() {
		return raiz == null; 
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}
}
