package arvores;

import java.util.Objects;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void inserir(T info) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<T>(info));
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(info);
		}
	}

	public NoArvoreBST<T> buscar(T info) {
		if (this.vazia()) {
			return null;
		}
		return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
	}

	public void retirar(T info) {
		NoArvoreBST<T> noARemover = this.buscar(info);
		if (noARemover != null) {
			this.removerUmNo(noARemover);
		}
	}

	private void removerUmNo(NoArvoreBST<T> no) {
		NoArvoreBST<T> noPai = this.identificarPai(no);

		if (no.getGrau() == 0) { // folha = caso 1
			if (noPai == null) {// no é raiz
				this.setRaiz(null);
			} else {
				if (noPai.getDir() == no) {
					noPai.setDir(null);
				} else {
					noPai.setEsq(null);
				}
			}
		} else {
			if (no.getGrau() == 1) { // apenas um filho = caso 2
				NoArvoreBST<T> noFilho = no.identificarUnicoFilho();
				if (noPai == null) {// no é raiz
					this.setRaiz(noFilho);
				} else {
					if (noPai.getDir() == no) {
						noPai.setDir(noFilho);
					} else {
						noPai.setEsq(noFilho);
					}
				}
			} else { // dois filhos = caso 3
				NoArvoreBST<T> noSucessor = this.identificarSucessor(no);
				T info = noSucessor.getInfo();
				this.removerUmNo(noSucessor);
				no.setInfo(info);
			}
		}
	}

	private NoArvoreBST<T> identificarPai(NoArvoreBST<T> no) {
		if (no == this.getRaiz()) {
			return null;
		}
		NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();

		while (noPai.getDir() != no && noPai.getEsq() != no) {

			if (no.getInfo().compareTo(noPai.getInfo()) < 0) {
				noPai = (NoArvoreBST<T>) noPai.getEsq();
			} else {
				noPai = (NoArvoreBST<T>) noPai.getDir();
			}
		}

		return noPai;
	}

	private NoArvoreBST<T> identificarSucessor(NoArvoreBST<T> no) {
		NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) no.getDir();
		while (noSucessor.getEsq() != null) {
			noSucessor = (NoArvoreBST<T>) noSucessor.getEsq();
		}
		return noSucessor;
	}

	public T buscarMenorElemento() { // contribuição do Gabriel C S 
		if (this.vazia()) {
			return null;
		}

		NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
		while (Objects.nonNull(no.getEsq())) {
			no = (NoArvoreBST<T>) no.getEsq();
		}

		return no.getInfo();
	}

	public T buscarMaiorElemento() {
		if (this.vazia()) {
			return null;
		}
		NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
		while (Objects.nonNull(no.getDir())) {
			no = (NoArvoreBST<T>) no.getDir();
		}
		return no.getInfo();
	}
	
	public NoArvoreBST<T> getSucessor(T info){
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null || info.equals(this.buscarMaiorElemento())) {
			return null;
		}
		if (no.getDir() != null) {
			return this.identificarSucessor(no);
		}
		NoArvoreBST<T> noPai = this.identificarPai(no);
		while(noPai.getDir() == no) {
			no = noPai;
			noPai = this.identificarPai(no);
		}
		return noPai;
	}
	
	private NoArvoreBST<T> identificarAntecessor(NoArvoreBST<T> no) {
		NoArvoreBST<T> noAntecessor = (NoArvoreBST<T>) no.getEsq();
		while (noAntecessor.getDir() != null) {
			noAntecessor = (NoArvoreBST<T>) noAntecessor.getDir();
		}
		return noAntecessor;
	}
	
	public NoArvoreBST<T> getAntecessor(T info){
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null || info.equals(this.buscarMenorElemento())) {
			return null;
		}
		if (no.getEsq() != null) {
			return this.identificarAntecessor(no);
		}
		NoArvoreBST<T> noPai = this.identificarPai(no);
		while(noPai.getEsq() == no) {
			no = noPai;
			noPai = this.identificarPai(no);
		}
		return noPai;
	}
	
	public String toStringOrdered() {
		if (this.vazia()) {
			return "<>";
		}
		return this.getRaiz().imprimeEmOrdem();
	}
}
