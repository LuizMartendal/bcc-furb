package Lista5;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {}

    public void setRaiz(NoArvoreBinaria<T> no) {
        if (no != null) {
            this.raiz = no;
        }
    }

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }

    public boolean vazia() {
        if (this.raiz == null) {
            return true;
        }
        return false;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        return this.getRaiz().pertence(info);
    }

    @Override
    public String toString() {
        return this.getRaiz().imprimePre();
    }
}
