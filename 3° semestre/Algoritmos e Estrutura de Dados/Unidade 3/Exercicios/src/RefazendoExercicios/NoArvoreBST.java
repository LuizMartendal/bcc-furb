package RefazendoExercicios;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 0) {
            if (this.getNoEsq() != null) {
                ((NoArvoreBST<T>) this.getNoEsq()).inserir(info);
            } else {
                this.setNoEsq(new NoArvoreBST<>(info));
            }
        } else {
            if (this.getNoDir() != null) {
                ((NoArvoreBST<T>) this.getNoDir()).inserir(info);
            } else {
                this.setNoDir(new NoArvoreBST<>(info));
            }
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        } else {
            if (info.compareTo(this.getInfo()) < 0) {
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
        if (this.getNoDir() != null) {
            return (NoArvoreBST<T>) this.getNoDir();
        }
        return (NoArvoreBST<T>) this.getNoEsq();
    }
}
