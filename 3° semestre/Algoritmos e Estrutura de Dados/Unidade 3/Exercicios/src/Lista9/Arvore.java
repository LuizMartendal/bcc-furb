package Lista9;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {}

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public NoArvore<T> pertence(T info) {
        if (vazia()) {
            return null;
        }
        return this.getRaiz().pertence(info);
    }

    public boolean vazia() {
        if (this.getRaiz() != null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (vazia()) {
            return "";
        }
        return getRaiz().imprimePre();
    }
}
