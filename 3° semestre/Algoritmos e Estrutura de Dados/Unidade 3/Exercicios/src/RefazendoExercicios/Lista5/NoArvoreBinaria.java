package RefazendoExercicios.Lista5;

public class NoArvoreBinaria<T> {
    
    private T info;
    private NoArvoreBinaria<T> noEsq;
    private NoArvoreBinaria<T> noDir;

    public NoArvoreBinaria(T info) {
        this.info = info;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> noEsq, NoArvoreBinaria<T> noDir) {
        this.info = info;
        this.setNoEsq(noEsq);
        this.setNoDir(noDir);
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (info == null) {
            return null;
        }

        if (this.info.equals(info)) {
            return this;
        }

        if (this.getNoEsq() != null) {
            NoArvoreBinaria<T> noEsq = this.noEsq.pertence(info);
            if (noEsq != null) {
                return noEsq;
            }
        }

        if (this.getNoDir() != null) {
            return this.getNoDir().pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        String str = "<";

        if (this.getInfo() != null) {
            str += this.getInfo();
        }

        if (this.getNoEsq() != null) {
            str += this.getNoEsq().imprimePre();
        } else if (this.getNoDir() != null) {
            str += "<>";
        }

        if (this.getNoDir() != null) {
            str += this.getNoDir().imprimePre();
        } else if (this.getNoEsq() != null) {
            str += "<>";
        }

        return str += ">";
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getNoEsq() {
        return this.noEsq;
    }

    public void setNoEsq(NoArvoreBinaria<T> noEsq) {
        this.noEsq = noEsq;
    }

    public NoArvoreBinaria<T> getNoDir() {
        return this.noDir;
    }

    public void setNoDir(NoArvoreBinaria<T> noDir) {
        this.noDir = noDir;
    }
}
