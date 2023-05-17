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

    public int getAltura() {
        if (vazia()) {
            return -1;
        }
        return this.getRaiz().getAltura();
    }

    public int getNivel(T info) {
        NoArvore<T> no = this.pertence(info);

        if (no == null) {
            return -1;
        }

        return this.getRaiz().getNivel(no);
    }

    @Override
    public String toString() {
        if (vazia()) {
            return "";
        }

        return this.getRaiz().imprimePre();
    }
}
