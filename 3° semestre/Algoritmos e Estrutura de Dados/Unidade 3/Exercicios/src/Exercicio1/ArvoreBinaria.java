package Exercicio1;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    ArvoreBinaria() {}

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean vazia() {
        return raiz == null;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        return raiz.pertence(info);
    }

    @Override
    public String toString() {
        String str = "";

        str += raiz.imprimePre();

        return str + "";
    }
}
