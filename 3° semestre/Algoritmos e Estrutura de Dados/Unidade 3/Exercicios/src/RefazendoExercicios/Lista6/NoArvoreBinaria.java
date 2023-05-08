package RefazendoExercicios.Lista6;

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
        if (this.getInfo() == null) {
            return null;
        }

        if (this.getInfo().equals(info)) {
            return this;
        }

        if (this.getNoEsq() != null) {
            NoArvoreBinaria<T> no = this.getNoEsq().pertence(info);
            if (no != null) {
                return no;
            }
        }

        if (this.getNoDir() != null) {
            return this.getNoDir().pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        if (this.getInfo() == null) {
            return "<>";
        }

        String str = "<";

        str += this.getInfo();

        if (this.getNoEsq() != null) {
            str += this.getNoEsq().getInfo();
        } else if (this.getNoDir() != null) {
            str += "<>";
        }

        if (this.getNoDir() != null) {
            str += this.getNoDir().getInfo();
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
