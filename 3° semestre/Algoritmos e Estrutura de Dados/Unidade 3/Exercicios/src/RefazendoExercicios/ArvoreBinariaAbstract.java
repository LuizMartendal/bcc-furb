package RefazendoExercicios;

public class ArvoreBinariaAbstract<T> {

    protected NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {}

    protected void setRaiz(NoArvoreBinaria<T> no) {
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
            return "<>";
        }

        return this.raiz.imprimePre();
    }
}
