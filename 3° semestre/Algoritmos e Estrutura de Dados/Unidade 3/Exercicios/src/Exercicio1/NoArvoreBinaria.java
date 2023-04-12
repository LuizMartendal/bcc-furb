package Exercicio1;

public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> esq = null;
    private NoArvoreBinaria<T> dir = null;

    NoArvoreBinaria(T info) {
        this.setInfo(info);
    }

    NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.setInfo(info);
        this.setEsq(esq);
        this.setDir(dir);
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        if (esq != null) {
            NoArvoreBinaria<T> novo = esq.pertence(info);
            if (novo != null) {
                return novo;
            }
        }

        if (dir != null) {
            return dir.pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        String str = "<";

        if (info != null) {
            str += info;
        }

        if (esq != null) {
            str += esq.imprimePre();
        } else {
            str += "<>";
        }

        if (dir != null) {
            str += dir.imprimePre();
        } else {
            str += "<>";
        }

        return str + ">";
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsq() {
        return esq;
    }

    public void setEsq(NoArvoreBinaria<T> esq) {
        this.esq = esq;
    }

    public NoArvoreBinaria<T> getDir() {
        return dir;
    }

    public void setDir(NoArvoreBinaria<T> dir) {
        this.dir = dir;
    }
}
