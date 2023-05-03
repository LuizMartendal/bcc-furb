package Lista5;

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
        if (info.equals(this.info)) {
            return this;
        }

        if (this.noEsq != null) {
            NoArvoreBinaria<T> novo = this.noEsq.pertence(info);
            if (novo != null) {
                return novo;
            }
        }

        if (this.noDir != null) {
            return this.noDir.pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        String str = "<";

        if (info.equals(this.info)) {
            str += this.info;
        }

        if (this.noEsq != null) {
            str += this.noEsq.imprimePre();
        } else {
            str += "<>";
        }

        if (this.noDir != null) {
            str += this.noDir.imprimePre();
        } else {
            str += "<>";
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
