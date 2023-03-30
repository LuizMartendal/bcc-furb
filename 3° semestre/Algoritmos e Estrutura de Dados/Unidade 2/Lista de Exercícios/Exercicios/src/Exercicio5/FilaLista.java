package Exercicio5;

import Exercicio2.ListaEncadeada;
import Exercicio4.Fila;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> listaEncadeada = new ListaEncadeada<>();

    @Override
    public void inserir(T valor) {
        listaEncadeada.inserir(valor);
    }

    @Override
    public T peek() {
        return listaEncadeada.pegar(0);
    }

    @Override
    public T retirar() {
       T retorno = listaEncadeada.pegar(0);
       listaEncadeada.retirar(listaEncadeada.pegar(0));
       return retorno;
    }

    @Override
    public boolean estaVazia() {
        return listaEncadeada.estaVazia() ? true : false;
    }

    @Override
    public void liberar() {
        this.listaEncadeada = new ListaEncadeada<>();
    }

    @Override
    public String toString() {
        if (this.estaVazia()) {
            return "";
        }
        String str = "";
        for (int i = 0; i < listaEncadeada.getTamanho(); i++) {
            if (i == listaEncadeada.getTamanho() - 1) {
                str += listaEncadeada.pegar(i).toString();
            } else {
                str += listaEncadeada.pegar(i).toString() + ", ";
            }
        }
        return str;
    }

    public FilaLista<T> concatenar(FilaLista<T> outraFilaLista) {
        FilaLista<T> novaFilaLista = new FilaLista<>();
        for (int i = 0; i < listaEncadeada.getTamanho(); i++) {
            novaFilaLista.inserir(listaEncadeada.pegar(i));
        }
        for (int i = 0; i < outraFilaLista.listaEncadeada.getTamanho(); i++) {
            novaFilaLista.inserir(outraFilaLista.listaEncadeada.pegar(i));
        }
        return novaFilaLista;
    }
}
