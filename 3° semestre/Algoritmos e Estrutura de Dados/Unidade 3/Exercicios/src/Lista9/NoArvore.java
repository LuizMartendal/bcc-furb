package Lista9;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public NoArvore(T info) {
        this.info = info;
    }

    public String imprimePre() {
        String str = "<";

        str += this.info.toString();

        if (filho != null) {
            str += filho.imprimePre();
        }
        str += ">";

        if (irmao != null) {
            str += irmao.imprimePre();
        }

        return str;
    }

    public void inserirFilho(NoArvore<T> filho) {
        this.filho = filho;
    }

    public NoArvore<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        if (filho != null) {
            NoArvore<T> filho =  this.filho.pertence(info);
            if (filho != null) {
                return filho;
            }
        }

        if (irmao != null) {
            return irmao.pertence(info);
        }

        return null;
    }
}
