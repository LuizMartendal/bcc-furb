package Lista6;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info) {
        if (this.getInfo().compareTo(info) < 0) {
            if (this.getNoEsq() == null) {
                NoArvoreBST<T> novo = new NoArvoreBST<>(info);
                this.setNoEsq(novo);
            } else {
                ((NoArvoreBST<T>) this.getNoEsq()).inserir(info);
            }
        } else {
            if (this.getNoDir() == null) {
                NoArvoreBST<T> novo = new NoArvoreBST<>(info);
                this.setNoDir(novo);
            } else {
                ((NoArvoreBST<T>) this.getNoDir()).inserir(info);
            }
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        }

        if (this.getInfo().compareTo(info) < 0) {
            return ((NoArvoreBST<T>) this.getNoEsq()).buscar(info);
        }

        if (this.getInfo().compareTo(info) >= 0) {
            return ((NoArvoreBST<T>) this.getNoDir()).buscar(info);
        }

        return null;
    }
}
