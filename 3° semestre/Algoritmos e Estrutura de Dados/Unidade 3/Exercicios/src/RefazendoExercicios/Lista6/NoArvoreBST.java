package RefazendoExercicios.Lista6;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 1) {
            if (this.getNoEsq() != null) {
                ((NoArvoreBST<T>)this.getNoEsq()).inserir(info);
            } else {
                this.setNoEsq(new NoArvoreBST<T>(info));
            }
        } else {
            if (this.getNoDir() != null) {
                ((NoArvoreBST<T>)this.getNoDir()).inserir(info);
            } else {
                this.setNoDir(new NoArvoreBST<T>(info));
            }
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        }

        if (info.compareTo(this.getInfo()) < 1) {
            if (this.getNoEsq() == null) {
                return null;
            } else {
                NoArvoreBST<T> no = ((NoArvoreBST<T>)this.getNoEsq()).buscar(info);
                if (no != null) {
                    return no;
                }
            }
        } else {
            if (this.getNoDir() == null) {
                return null;
            } else {
                return ((NoArvoreBST<T>)this.getNoDir()).buscar(info);
            }
        }

        return null;
    }
    
}
