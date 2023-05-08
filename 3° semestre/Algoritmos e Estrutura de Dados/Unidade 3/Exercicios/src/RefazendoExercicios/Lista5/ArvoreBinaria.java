package RefazendoExercicios.Lista5;

public class ArvoreBinaria<T> {
    
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {}

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    public boolean vazia() {
        if (this.getRaiz() == null) {
            return true;
        }
        return false;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (vazia()) {
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
}