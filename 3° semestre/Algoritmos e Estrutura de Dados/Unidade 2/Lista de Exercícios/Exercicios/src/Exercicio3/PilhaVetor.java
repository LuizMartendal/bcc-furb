package Exercicio3;

public class PilhaVetor<T> implements Pilha<T> {

    private int limite;
    private int tamanho;
    private T[] info;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

    @Override
    public void push(T v) {
        if (limite == tamanho) {
            throw new RuntimeException("Capacidade esgotada da pilha");
        }
        info[tamanho] = v;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        tamanho--;
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return info[tamanho-1];
    }

    @Override
    public boolean estaVazia() {
        if (tamanho == 0)
            return true;
        else
            return false;
    }

    @Override
    public void liberar() {
        while (tamanho > 0) {
            this.pop();
            tamanho--;
        }
    }

    public String toString() {
        String str = "[";

        if (tamanho > 0) {
            for (int i = (tamanho - 1); i >= 0; i--) {
                if (i == tamanho - 1) {
                    str += this.info[i];
                } else {
                    str += ", " + this.info[i];
                }
            }
        }

        return str += "]";
    }
}
