package Lista6;

public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> noEsq;
    private NoArvoreBinaria<T> noDir;

    public NoArvoreBinaria(T info) {
        this.info = info;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> noEsq, NoArvoreBinaria<T> noDir) {
        this.info = info;
        this.noEsq = noEsq;
        this.noDir = noDir;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        }

        if (this.getNoEsq() != null) {
            NoArvoreBinaria<T> novo = this.getNoEsq().pertence(info);
            if (novo != null) {
                return novo;
            }
        }

        if (this.getNoDir() != null) {
            return this.getNoDir().pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        String str = "<";

        str += this.getInfo();

        if (this.getNoEsq() != null) {
            str += this.getNoEsq().imprimePre();
        }

        if (this.getNoDir() != null) {
            str += this.getNoDir().imprimePre();
        }

        return str += ">";
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getNoEsq() {
        return noEsq;
    }

    public void setNoEsq(NoArvoreBinaria<T> noEsq) {
        this.noEsq = noEsq;
    }

    public NoArvoreBinaria<T> getNoDir() {
        return noDir;
    }

    public void setNoDir(NoArvoreBinaria<T> noDir) {
        this.noDir = noDir;
    }
}
