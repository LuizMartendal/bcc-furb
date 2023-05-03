package Lista7;

import Lista6.NoArvoreBinaria;

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
        } else {
            if (this.getInfo().compareTo(info) < 0) {
                if (this.getNoEsq() == null) {
                    return null;
                }
                return ((NoArvoreBST<T>) this.getNoEsq()).buscar(info);
            } else {
                if (this.getNoDir() == null) {
                    return null;
                }
                return ((NoArvoreBST<T>) this.getNoDir()).buscar(info);
            }
        }
    }

    public int getGrau() {
        int grau = 0;
        if (this.getNoEsq() != null) {
            grau++;
        }
        if (this.getNoDir() != null) {
            grau++;
        }
        return grau;
    }

    public NoArvoreBST<T> getUnicoFilho() {
        if (this.getNoEsq() != null) {
            return (NoArvoreBST<T>) this.getNoEsq();
        }
        return (NoArvoreBST<T>) this.getNoDir();
    }
}
