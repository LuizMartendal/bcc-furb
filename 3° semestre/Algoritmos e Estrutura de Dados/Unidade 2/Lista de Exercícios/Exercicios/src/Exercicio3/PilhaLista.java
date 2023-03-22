package Exercicio3;

import Exercicio2.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {

    private final ListaPilhaEncadeada<T> lista = new ListaPilhaEncadeada<>();

    public PilhaLista() {}

    @Override
    public void push(T v) {
        lista.inserir(v);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia!");
        }
        T valor = lista.pegar(0);
        lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        return lista.pegar(0);
    }

    @Override
    public boolean estaVazia() {
        if (lista.getTamanho() == 0)
            return true;
        else
            return false;
    }

    @Override
    public void liberar() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia!");
        }
        int i = 0;
        while (lista.pegar(0) != null) {
            T valor = lista.pegar(0);
            lista.retirar(valor);
        }
    }

    public String toString() {
        String str = "[";

        if (lista.getTamanho() > 0) {
            for (int i = 0; i < lista.getTamanho(); i++) {
                if (i == 0) {
                    str += lista.pegar(i);
                } else {
                    str += ", " + this.lista.pegar(i);
                }
            }
        }

        return str += "]";
    }
}
