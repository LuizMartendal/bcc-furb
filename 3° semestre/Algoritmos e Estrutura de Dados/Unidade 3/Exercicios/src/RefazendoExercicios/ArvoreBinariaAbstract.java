package RefazendoExercicios;

public abstract class ArvoreBinariaAbstract<T> {

    protected NoArvoreBinaria<T> raiz;

    ArvoreBinariaAbstract() {}

    protected void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    public boolean vazia() {
        if (this.raiz == null) {
            return true;
        }
        return false;
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
