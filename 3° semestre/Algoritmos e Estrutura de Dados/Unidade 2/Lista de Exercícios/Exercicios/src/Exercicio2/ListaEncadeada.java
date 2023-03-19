package Exercicio2;

import Exercicio1.Lista;
import Exercicio1.ListaEstatica;

public class ListaEncadeada<T> implements Lista<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int qtdElementos;

    @Override
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
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
    public int buscar(T valor) {
        NoLista<T> p = primeiro;

        int contador = 0;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
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
    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProx();
        }

        if (p != null) {
            if (p.getInfo().equals(primeiro.getInfo())) {
                primeiro = p.getProx();
            }  else {
                anterior.setProx(p.getProx());
            }

            if (p.getInfo().equals(ultimo.getInfo())) {
                ultimo = anterior;
            }

            qtdElementos--;
        }
    }

    @Override
    public String exibir() {
        String str = "[ ";

        NoLista<T> p = primeiro;

        while(p != null) {
            str += p.getInfo() + " ";
            p = p.getProx();
        }

        return str + "]";
    }

    @Override
    public Lista<T> copiar() {
        ListaEncadeada<T> lista = new ListaEncadeada<>();
        NoLista<T> p = primeiro;

        int contador = 0;

        while (contador < qtdElementos) {
            lista.inserir(p.getInfo());
            p = p.getProx();
            contador++;
        }

        return lista;
    }

    @Override
    public void concatenar(Lista<T> outra) {
        if (outra == null) {
            throw new IllegalArgumentException("Lista não pode ser nula.");
        }

        int qtd = 0;
        while (qtd < outra.getTamanho()) {
            T valor = outra.pegar(qtd);
            inserir(valor);
            qtd++;
        }
    }

    @Override
    public int getTamanho() {
        return qtdElementos;
    }

    @Override
    public T pegar(int pos) {
        NoLista<T> p = primeiro;

        int contador = 0;

        while (p != null) {
            if (contador == pos) {
                return p.getInfo();
            }
            p = p.getProx();
            contador++;
        }

        return null;
    }

    @Override
    public Lista<T> dividir() {
        int indice = 0;
        NoLista<T> no = primeiro;
        NoLista<T> ultimoNo = null;
        ListaEncadeada<T> lista = new ListaEncadeada<>();

        while (indice < getTamanho()) {
            if (indice == (getTamanho() / 2) - 1) {
                ultimoNo = no;
            } else if (indice == getTamanho() / 2) {
                lista.primeiro = no;
            } else if (indice == getTamanho() - 1) {
                lista.ultimo = no;
            }
            no = no.getProx();
            indice++;
        }

        ultimoNo.setProx(null);
        ultimo = ultimoNo;
        lista.qtdElementos = getTamanho() / 2 + 1;
        qtdElementos = (getTamanho() / 2);
        return lista;
    }
}
