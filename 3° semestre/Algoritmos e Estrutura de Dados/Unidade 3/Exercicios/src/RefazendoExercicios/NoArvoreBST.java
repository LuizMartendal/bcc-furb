package RefazendoExercicios;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 0) {
            if (this.getEsq() != null) {
                ((NoArvoreBST<T>) this.getEsq()).inserir(info);
            } else {
                this.setEsq(new NoArvoreBST<>(info));
            }
        } else {
            if (this.getDir() != null) {
                ((NoArvoreBST<T>) this.getDir()).inserir(info);
            } else {
                setDir(new NoArvoreBST<>(info));
            }
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        }

        if (info.compareTo(this.getInfo()) < 0) {
            return ((NoArvoreBST<T>) this.getEsq()).buscar(info);
        } else {
            return ((NoArvoreBST<T>) this.getDir()).buscar(info);
        }
    }

    public int getGrau() {
        int grau = 0;

        if (this.getEsq() != null) {
            grau++;
        }

        if (this.getDir() != null) {
            grau++;
        }

        return grau;
    }

    public NoArvoreBST<T> getFilho() {
        if (this.getEsq() != null) {
            return (NoArvoreBST<T>) this.getEsq();
        }
        return (NoArvoreBST<T>) this.getDir();
    }
}
