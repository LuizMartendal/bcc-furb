package arvores;
public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;
    
    public NoArvore(T info) {
        this.info = info;
    }
    public String imprimePre() {
        String string = "<" + getInfo().toString();
        if (getFilho() != null) {
            string += getFilho().imprimePre();
        }
        string += ">";
        if (getIrmao() != null) {
            string += getIrmao().imprimePre();
        }
        return string ;
    }
    public void inserirFilho(NoArvore<T> filho) {
        if (filho == null) {
            return;
        }
        filho.setIrmao(getFilho());
        setFilho(filho);
    }
    public NoArvore<T> pertence(T info) {
        if (getInfo().equals(info)) {
            return this;
        }
        NoArvore<T> filho = getFilho();
        if (filho != null) {
            NoArvore<T> retornoFilho = filho.pertence(info);
            if (retornoFilho != null) {
                return retornoFilho;
            }
        }
        return getIrmao() == null ?
                null : getIrmao().pertence(info);
    }
    private NoArvore<T> getFilho() {
        return filho;
    }
    private void setFilho(NoArvore<T> filho) {
        this.filho = filho;
    }
    private NoArvore<T> getIrmao() {
        return irmao;
    }
    private void setIrmao(NoArvore<T> irmao) {
        this.irmao = irmao;
    }
    public T getInfo() {
        return info;
    }
}
