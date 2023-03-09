package Exercicio2;

import Exercicio1.Lista;
import Exercicio1.ListaEstatica;

public class ListaEncadeada implements Lista {

    private NoLista primeiro;
    private NoLista ultimo;
    private int qtdElementos;

    @Override
    public void inserir(int valor) {
        NoLista novo = new NoLista();
        novo.setInfo(valor);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProx(novo);
        }
        ultimo = novo;
        qtdElementos++;
    }

    @Override
    public int buscar(int valor) {
        NoLista p = primeiro;

        int contador = 0;

        while (p != null) {
            if (p.getInfo() == valor) {
                return contador;
            }
            contador++;
            p = p.getProx();
        }

        return -1;
    }

    @Override
    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }

        return false;
    }

    @Override
    public void retirar(int valor) {
        NoLista anterior = null;
        NoLista p = primeiro;

        while (p != null && p.getInfo() != valor) {
            anterior = p;
            p = p.getProx();
        }

        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProx();
            } else {
                anterior.setProx(p.getProx());
            }

            if (p.getProx() == null) {
                ultimo = anterior;
            }

            qtdElementos--;
        }
    }

    @Override
    public String exibir() {
        String str = "[ ";

        NoLista p = primeiro;

        while(p != null) {
            str += p.getInfo() + " ";
            p = p.getProx();
        }

        return str + "]";
    }

    @Override
    public Lista copiar() {
        ListaEncadeada lista = new ListaEncadeada();
        NoLista p = primeiro;

        int contador = 0;

        while (contador < qtdElementos) {
            lista.inserir(pegar(contador));
            contador++;
        }

        return lista;
    }

    @Override
    public void concatenar(Lista outra) {
        if (outra == null) {
            throw new IllegalArgumentException("Lista não pode ser nula.");
        }

        int qtd = 0;

        while (qtd < outra.getTamanho()) {
            inserir(outra.pegar(qtd));
            qtd++;
        }
    }

    @Override
    public int getTamanho() {
        return qtdElementos;
    }

    @Override
    public int pegar(int pos) {
        NoLista p = primeiro;

        int contador = 0;

        while (p != null) {
            if (contador == pos) {
                return p.getInfo();
            }
            p = p.getProx();
            contador++;
        }

        return -1;
    }

    @Override
    public Lista dividir() {
        int indice = getTamanho() / 2;

        ListaEncadeada lista = new ListaEncadeada();

        while (indice < getTamanho()) {
            lista.inserir(pegar(indice));
            indice++;
        }

        indice = getTamanho() / 2;

        while (indice < getTamanho()) {
            retirar(indice);
            indice++;
        }

        qtdElementos = getTamanho() / 2;

        return lista;
    }
}
