package Exercicio4;

public interface Fila<T> {

    void inserir(T valor);
    T peek();
    T retirar();
    boolean estaVazia();
    void liberar();
}
