package RefazendoExercicios;

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
        if (this.info.equals(info)) {
            return this;
        }

        if (this.noEsq != null) {
            NoArvoreBinaria<T> no = this.noEsq.pertence(info);
            if (no != null) {
                return no;
            }
        }

        if (this.noDir != null) {
            return this.noDir.pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        String str = "<";

        str += this.info.toString();

        if (this.noEsq != null) {
            str += this.noEsq.imprimePre();
        } else if (this.noDir != null) {
            str += "<>";
        }

        if (this.noDir != null) {
            str += this.noDir.imprimePre();
        } else if (this.noEsq != null) {
            str += "<>";
        }

        return str;
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
