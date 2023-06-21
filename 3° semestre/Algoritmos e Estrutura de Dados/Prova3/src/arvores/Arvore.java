package arvores;

public class Arvore<T> {
    private NoArvore<T> raiz;
    
    public NoArvore<T> pertence(T info) {
        return vazia() ?
                null : getRaiz().pertence(info);
    }
    public boolean vazia() {
        return getRaiz() == null;
    }
    @Override
    public String toString() {
        return vazia() ?
                "<>" : getRaiz().imprimePre();
    }
    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }
    public NoArvore<T> getRaiz() {
        return raiz;
    }
}