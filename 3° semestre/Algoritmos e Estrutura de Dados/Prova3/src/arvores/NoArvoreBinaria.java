package arvores;

public class NoArvoreBinaria<T> { // contribuição do Gustavo G
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.info = info;
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esq = esq;
		this.dir = dir;
	}

	
	public NoArvoreBinaria<T> getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreBinaria<T> esq) {
		this.esq = esq;
	}

	public NoArvoreBinaria<T> getDir() {
		return dir;
	}

	public void setDir(NoArvoreBinaria<T> dir) {
		this.dir = dir;
	}

	public T getInfo() {
		return this.info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	public NoArvoreBinaria<T> pertence(T info) {
		if (info.equals(this.info)) {
			return this;
		}
		if (esq != null) {
			NoArvoreBinaria<T> valor = esq.pertence(info);
			if (valor != null) {
				return valor;
			}
		}
		if (dir != null) {
			return dir.pertence(info);
		}
		return null;
	}

	public String imprimePre() {
		String retorno = "<" + info.toString();
		if (esq != null) {
			retorno += esq.imprimePre();
		} else {
			retorno += "<>";
		}
		if (dir != null) {
			retorno += dir.imprimePre();
		} else {
			retorno += "<>";
		}
		return retorno + ">";
	}

	@Override
	public String toString() {
		return this.imprimePre();
	}

	public String imprimeEmOrdem() {
		String retorno = "";
		if (esq != null) {
			retorno += esq.imprimeEmOrdem();
		}
		retorno +=  info.toString()+", ";
		if (dir != null) {
			retorno += dir.imprimeEmOrdem();
		}
		return retorno;
	}
}
