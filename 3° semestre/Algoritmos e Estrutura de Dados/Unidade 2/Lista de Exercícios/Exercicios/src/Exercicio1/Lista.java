package Exercicio1;

public interface Lista {

    void inserir(int valor);

    int buscar(int valor);

    boolean estaVazia();

    void retirar(int valor);

    String exibir();

    Lista copiar();

    void concatenar(Lista outra);

    int getTamanho();

    int pegar(int pos);

    Lista dividir();

}