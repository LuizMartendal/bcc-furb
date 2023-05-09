package Lista5;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {}

    public void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    public boolean vazia() {
        if (this.raiz != null) {
            return false;
        }
        return true;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (vazia()) {
            return null;
        }
        return this.raiz.pertence(info);
    }

    @Override
    public String toString() {
        if (vazia()) {
            return null;
        }
        return this.raiz.imprimePre();
    }
}
