package RefazendoExercicios.Lista8;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {}

    public boolean vazia() {
        if (this.getRaiz() != null) {
            return false;
        }
        return true;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (info == null || vazia()) {
            return null;
        }
        return this.getRaiz().pertence(info);
    }

    @Override
    public String toString() {
        if (vazia()) {
            return "<>";
        }
        return this.getRaiz().imprimePre();
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
}
