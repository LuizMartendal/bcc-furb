package Lista6;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {}

    protected void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    protected NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }

    public boolean vazia() {
        if (this.raiz == null) {
            return true;
        }
        return false;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        }
        return this.raiz.pertence(info);
    }

    @Override
    public String toString() {
        if (this.vazia()) {
            return "<>";
        }
        return this.raiz.imprimePre();
    }
}
