package Exercicio2;

import Exercicio1.NoArvoreBinaria;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() { }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
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
