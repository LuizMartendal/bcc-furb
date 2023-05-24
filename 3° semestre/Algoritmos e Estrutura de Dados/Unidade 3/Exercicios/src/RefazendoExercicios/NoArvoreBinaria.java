package RefazendoExercicios;

public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;

    public NoArvoreBinaria(T info) {
        this.info = info;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        this.esq = esq;
        this.dir = dir;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (info.equals(this.info)) {
            return this;
        }

        if (this.getEsq() != null) {
            NoArvoreBinaria<T> no =  this.getEsq().pertence(info);
            if (no != null) {
                return no;
            }
        }

        if (this.getDir() != null) {
            return this.getDir().pertence(info);
        }

        return null;
    }

    public String imprimePre() {
        String str = "<";

        str += this.getInfo();

        if (this.getEsq() != null) {
            str += this.getEsq().imprimePre();
        }

        if (this.getDir() != null) {
            str += this.getDir().imprimePre();
        }

        return str += ">";
    }

    public String imprimeOrd() {
        String str = "";

        if (this.getEsq() != null) {
            str += this.getEsq().imprimeOrd();
        }

        str += this.getInfo().toString() + " ";

        if (this.getDir() != null) {
            str += this.getDir().imprimeOrd();
        }

        return str;
    }

    public String imprimePos() {
        String str = "";

        if (this.getEsq() != null) {
            str += this.getEsq().imprimePos();
        }

        if (this.getDir() != null) {
            str += this.getDir().imprimePos();
        }

        str += this.getInfo().toString() + " ";

        return str;
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
