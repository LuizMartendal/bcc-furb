package RefazendoExercicios.Lista8;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() {}

    public void inserir(T info) {
        if (vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST)this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if (no != null) {
            this.retirarUmNo(no);
        }
    }

    private void retirarUmNo(NoArvoreBST<T> no) {
        NoArvoreBST<T> noPai = this.getPai(no);
        if (no.getGrau() == 0) {
            if (noPai == null) {
                this.setRaiz(null);
            } else {
                if (noPai.getNoEsq() == no) {
                    noPai.setNoEsq(null);
                } else {
                    noPai.setNoDir(null);
                }
            }
        } else {
            if (no.getGrau() == 1) {
                NoArvoreBST<T> noFilho = no.getUnicoFilho();
                if (noPai == null) {
                    this.setRaiz(noFilho);
                } else {
                    if (noPai.getNoDir() == no) {
                        noPai.setNoDir(noFilho);
                    } else {
                        noPai.setNoEsq(noFilho);
                    }
                }
            } else {
                NoArvoreBST<T> noSucessor = this.getSucessor(no);
                T info = noSucessor.getInfo();
                this.retirarUmNo(noSucessor);
                no.setInfo(info);
            }
        }
    }

    public NoArvoreBST<T> getSucessor(NoArvoreBST<T> no) {
        if (getMaiorElemento().equals(no.getInfo())) {
            return null;
        }
        if (no.getNoDir() != null) {
            NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) no.getNoDir();
            while (noSucessor.getNoEsq() != null) {
                noSucessor = (NoArvoreBST<T>) noSucessor.getNoEsq();
            }
            return noSucessor;
        }
        NoArvoreBST<T> noPai = this.getPai(no);
        while (noPai.getNoDir() == no) {
            no = noPai;
            noPai = this.getPai(noPai);
        }
        return noPai;
    }

    public T getSucessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        return this.getSucessor(no).getInfo();
    }

    private NoArvoreBST<T> getPai(NoArvoreBST<T> no) {
        if (no == this.getRaiz()) {
            return null;
        }
        NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();
        while (noPai.getNoEsq() != no && noPai.getNoDir() != no) {
            if (noPai.getInfo().compareTo(no.getInfo()) > 0) {
                noPai = (NoArvoreBST<T>) noPai.getNoEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getNoDir();
            }
        }
        return noPai;
    }

    public T getMenorElemento() {
        NoArvoreBST<T> no = this.getNoComMenorElemento();
        if (no != null) {
            return no.getInfo();
        }
        return null;
    }

    private NoArvoreBST<T> getNoComMenorElemento() {
        if (vazia()) {
            return null;
        }
        NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
        while (no.getNoEsq() != null) {
            no = (NoArvoreBST<T>) no.getNoEsq();
        }
        return no;
    }

    public T getMaiorElemento() {
        NoArvoreBST<T> no = this.getNoComMaiorElemento();
        if (no != null) {
            return no.getInfo();
        }
        return null;
    }

    private NoArvoreBST<T> getNoComMaiorElemento() {
        if (vazia()) {
            return null;
        }
        NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
        while (no.getNoDir() != null) {
            no = (NoArvoreBST<T>) no.getNoDir();
        }
        return no;
    }

    public NoArvoreBST<T> getAntecessor(NoArvoreBST<T> no) {
        if (vazia() || getMenorElemento().equals(no.getInfo())) {
            return null;
        }
        if (no.getNoEsq() != null) {
            NoArvoreBST<T> noAntecessor = (NoArvoreBST<T>) no.getNoEsq();
            while (noAntecessor.getNoDir() != null) {
                noAntecessor = (NoArvoreBST<T>) noAntecessor.getNoDir();
            }
            return noAntecessor;
        }
        NoArvoreBST<T> noPai = this.getPai(no);
        while (noPai.getNoEsq() == no) {
            no = noPai;
            noPai = this.getPai(noPai);
        }
        return noPai;
    }

    public T getAntecessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        return this.getAntecessor(no).getInfo();
    }

    public String toStringOrdered() {
        if (vazia()) {
            return "<>";
        }
        NoArvoreBST<T> no = this.getNoComMenorElemento();
        String str = "{ " + no.getInfo().toString();

        while (getSucessor(no) != null) {
            no = this.getSucessor(no);
            str += ", " + no.getInfo().toString();
        }
        return str += " }";
    }
}
