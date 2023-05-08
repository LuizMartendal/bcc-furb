package RefazendoExercicios.Lista6;

import Lista6.NoArvoreBST;

public abstract class ArvoreBinariaAbstract<T> {
    
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {}

    protected void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }

    public boolean vazia() {
        if (raiz == null) {
            return true;
        }
        return false;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (vazia()) {
            return null;
        }

        if (raiz.getInfo().equals(info)) {
            return this.raiz;
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
