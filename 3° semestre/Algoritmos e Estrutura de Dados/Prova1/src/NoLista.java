
public class NoLista<T> {
    private T info;

    private NoLista<T> prox;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProx() {
        return prox;
    }

    public void setProx(NoLista<T> prox) {
        this.prox = prox;
    }
}
