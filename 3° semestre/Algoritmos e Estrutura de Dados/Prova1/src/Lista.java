
public interface Lista<T> {

    void inserir(T valor);

    int buscar(T valor);

    boolean estaVazia();

    void retirar(T valor);

    String exibir();

    Lista<T> copiar();

    void concatenar(Lista<T> outra);

    int getTamanho();

    T pegar(int pos);

    Lista<T> dividir();
}