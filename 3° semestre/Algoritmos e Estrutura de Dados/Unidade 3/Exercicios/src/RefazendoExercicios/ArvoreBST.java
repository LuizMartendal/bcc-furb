package RefazendoExercicios;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() {}

    public void inserir(T info) {
        if (vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>) this.raiz).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.raiz).buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> no = buscar(info);

        if (no != null) {
            this.retirarUmNo(no);
        }
    }

    public void retirarUmNo(NoArvoreBST<T> no) {
        NoArvoreBST<T> noPai = getPai(no);

        if (no.getGrau() == 0) {
            if (noPai == null) {
                setRaiz(null);
            } else {
                if (noPai.getEsq() == no) {
                    noPai.setEsq(null);
                } else {
                    noPai.setDir(null);
                }
            }
        } else {
            if (no.getGrau() == 1) {
                NoArvoreBST<T> noFilho = no.getFilho();

                if (noPai == null) {
                    setRaiz(noFilho);
                } else {
                    if (noPai.getEsq() == no) {
                        noPai.setEsq(noFilho);
                    } else {
                        noPai.setDir(noFilho);
                    }
                }
            } else {
                NoArvoreBST<T> noSucessor = getSucessor(no);
                no.setInfo(noSucessor.getInfo());
                retirarUmNo(noSucessor);
            }
        }
    }

    public T getMenorElemento() {
        if (vazia()) {
            return null;
        }
        return getNoComMenorElemento().getInfo();
    }

    public T getMaiorElemento() {
        if (vazia()) {
            return null;
        }
        return getNoComMaiorElemento().getInfo();
    }

    public T getAntecessor(T info) {
        NoArvoreBST<T> noAntecessor = buscar(info);
        if (noAntecessor == null) {
            return null;
        }
        return getAntecessor(noAntecessor).getInfo();
    }

    public T getSucessor(T info) {
        NoArvoreBST<T> noSucessor = buscar(info);
        if (noSucessor == null) {
            return null;
        }
        return getSucessor(noSucessor).getInfo();
    }

    private NoArvoreBST<T> getAntecessor(NoArvoreBST<T> no) {
        if (vazia() || getMenorElemento().equals(no.getInfo())) {
            return null;
        }

        NoArvoreBST<T> noAntecessor = no;

        if (noAntecessor.getEsq() != null) {
            noAntecessor = (NoArvoreBST<T>) noAntecessor.getEsq();
            while (noAntecessor.getDir() != null) {
                noAntecessor = (NoArvoreBST<T>) noAntecessor.getDir();
            }
            return noAntecessor;
        }

        noAntecessor = getPai(noAntecessor);
        while (noAntecessor.getEsq() == no) {
            no = noAntecessor;
            noAntecessor = getPai(noAntecessor);
        }

        return noAntecessor;
    }

    public String toStringOrdered() {
        if (vazia()) {
            return "{}";
        }

        String str = "{ ";
        NoArvoreBST<T> no = getNoComMenorElemento();
        str += no.getInfo();

        while (getSucessor(no) != null) {
            no = getSucessor(no);
            str += " " + no.getInfo();
        }

        return str += " }";
    }

    private NoArvoreBST<T> getNoComMaiorElemento() {
        if (vazia()) {
            return null;
        }
        NoArvoreBST<T> no = (NoArvoreBST<T>) raiz;

        while (no.getDir() != null) {
            no = (NoArvoreBST<T>) no.getDir();
        }

        return no;
    }

    private NoArvoreBST<T> getNoComMenorElemento() {
        if (vazia()) {
            return null;
        }

        NoArvoreBST<T> no = (NoArvoreBST<T>) raiz;

        while (no.getEsq() != null) {
            no = (NoArvoreBST<T>) no.getEsq();
        }

        return no;
    }

    private NoArvoreBST<T> getSucessor(NoArvoreBST<T> no) {
        if (vazia() || getMaiorElemento().equals(no.getInfo())) {
            return null;
        }

        NoArvoreBST<T> noSucessor = no;

        if (noSucessor.getDir() != null) {
            noSucessor = (NoArvoreBST<T>) no.getDir();

            while (noSucessor.getEsq() != null) {
                noSucessor = (NoArvoreBST<T>) noSucessor.getEsq();
            }

            return noSucessor;
        }

        noSucessor = getPai(no);

        while (noSucessor.getDir() == no) {
            no = noSucessor;
            noSucessor = getPai(noSucessor);
        }

        return noSucessor;
    }

    private NoArvoreBST<T> getPai(NoArvoreBST<T> no) {
        if (no == raiz || vazia()) {
            return null;
        }

        NoArvoreBST<T> noPai = (NoArvoreBST<T>) raiz;

        while (noPai.getDir() != no && noPai.getEsq() != no) {
            if (noPai.getInfo().compareTo(no.getInfo()) > 0) {
                noPai = (NoArvoreBST<T>) noPai.getEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getDir();
            }
        }

        return noPai;
    }
}
