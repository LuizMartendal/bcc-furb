package Exercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilaVetor<T> implements Fila<T>{

    private T[] vetor;
    private int inicio;
    private int limite;
    private int tamanho = 0;

    public FilaVetor(int limite) {
        this.limite = limite;
        vetor = (T[]) new Object[limite];
    }

    public int getLimite() {
        return limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new RuntimeException("Fila está cheia!");
        }
        int posicao = (inicio + tamanho) % limite;
        vetor[posicao] = valor;
        tamanho++;
    }

    @Override
    public T peek() {
        if (tamanho == 0) {
            throw new RuntimeException("Não há elementos na fila!");
        }
        return vetor[inicio];
    }

    @Override
    public T retirar() {
        T valor = vetor[inicio];
        vetor[inicio] = null;
        tamanho--;
        inicio = (inicio + tamanho) % limite;
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0 ? true : false;
    }

    @Override
    public void liberar() {
        vetor = (T[]) new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public String toString() {
        if (this.estaVazia()) {
            return "";
        }
        String str = vetor.toString();
        for (int i = 0; i < tamanho; i++) {
            int pos = (i + inicio) % limite;
            str += ", " + vetor[pos].toString();
        }
        return str;
    }

    public FilaVetor<T> concatenar(FilaVetor<T> outraFila) {
        if (outraFila.estaVazia()) {
            throw new RuntimeException("Fila recebida como parametro não pode ser vazia!");
        }
        FilaVetor<T> novaFila = new FilaVetor<>(tamanho + outraFila.getTamanho());
        for (int i = 1; i < tamanho; i++) {
            int pos = (i + inicio) % limite;
            novaFila.inserir(vetor[pos]);
        }
        for (int i = 1; i < outraFila.getTamanho(); i++) {
            int pos = (i + outraFila.inicio) % outraFila.getLimite();
            novaFila.inserir(outraFila.vetor[pos]);
        }
        return novaFila;
    }
}
