package Lista8;

import Lista6.ArvoreBinariaAbstract;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() {}

    public void inserir(T info) {
        if (this.vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>) this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> noARetirar = this.buscar(info);
        if (noARetirar != null) {
            this.retirarUmNo(noARetirar);
        }
    }

    private void retirarUmNo(NoArvoreBST<T> no) {
        NoArvoreBST<T> noPai = this.getPai(no);

        if (no.getGrau() == 0) {
            if (noPai == null) {
                this.setRaiz(null);
            } else {
                if (noPai.getNoDir() == no) {
                    noPai.setNoDir(null);
                } else {
                    noPai.setNoEsq(null);
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
                NoArvoreBST<T> noSucessor = getSucessor(no);
                T info = noSucessor.getInfo();
                retirarUmNo(noSucessor);
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
        NoArvoreBST<T> noPai = getPai(no);
        while (noPai.getNoDir() == no) {
            no = noPai;
            noPai = getPai(noPai);
        }
        return noPai;
    }

    public NoArvoreBST<T> getPai(NoArvoreBST<T> no) {
        if (no == this.getRaiz()) {
            return null;
        }

        NoArvoreBST<T> noPai = ((NoArvoreBST<T>) this.getRaiz());
        while (noPai.getNoDir() != no && noPai.getNoEsq() != no) {
            if (noPai.getInfo().compareTo(no.getInfo()) > 0) {
                noPai = (NoArvoreBST<T>) noPai.getNoEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getNoDir();
            }
        }

        return noPai;
    }

    public T getMenorElemento() {
        return getNoComMenorElemento().getInfo();
    }

    public NoArvoreBST<T> getNoComMenorElemento() {
        if (this.vazia()) {
            return null;
        }

        NoArvoreBST<T> noComMenorElemento = (NoArvoreBST<T>) this.getRaiz();
        while (noComMenorElemento.getNoEsq() != null) {
            noComMenorElemento = (NoArvoreBST<T>) noComMenorElemento.getNoEsq();
        }
        return noComMenorElemento;
    }

    public T getMaiorElemento() {
        return getNoComMaiorElemento().getInfo();
    }

    public NoArvoreBST<T> getNoComMaiorElemento() {
        if (this.vazia()) {
            return null;
        }

        NoArvoreBST<T> noComMaiorElemento = (NoArvoreBST<T>) this.getRaiz();
        while (noComMaiorElemento.getNoDir() != null) {
            noComMaiorElemento = (NoArvoreBST<T>) noComMaiorElemento.getNoDir();
        }
        return noComMaiorElemento;
    }

    public T getAntecessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);

        if (this.vazia() || this.getMenorElemento().equals(info)) {
            return null;
        }

        if (no.getNoEsq() != null) {
            return identificarAntecessor(no).getInfo();
        }

        NoArvoreBST<T> noPai = getPai(no);
        while (noPai.getNoEsq() == no) {
            no = noPai;
            noPai = getPai(noPai);
        }
        return noPai.getInfo();
    }

    public NoArvoreBST<T> identificarAntecessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> noAntecessor = (NoArvoreBST<T>) no.getNoEsq();
        while (noAntecessor.getNoDir() != null) {
            noAntecessor = (NoArvoreBST<T>) noAntecessor.getNoDir();
        }
        return noAntecessor;
    }

    public T getSucessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if (vazia() || getMaiorElemento().equals(info)) {
            return null;
        }

        if (no.getNoDir() != null) {
            return this.identificarSucessor(no).getInfo();
        }

        NoArvoreBST<T> noPai = getPai(no);
        while (noPai.getNoDir() == no) {
            no = noPai;
            noPai = getPai(noPai);
        }
        return noPai.getInfo();
    }

    public NoArvoreBST<T> identificarSucessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) no.getNoDir();
        while (noSucessor.getNoEsq() != null) {
            if (!noSucessor.getNoEsq().getInfo().equals(no.getInfo())) {
                noSucessor = (NoArvoreBST<T>) noSucessor.getNoEsq();
            } else {
                break;
            }
        }
        return noSucessor;
    }

    public String toStringOrdered() {
        if (vazia()) {
            return "{}";
        }

        NoArvoreBST<T> no = getNoComMenorElemento();
        String str = "{ " + no.getInfo().toString();

        while (getSucessor(no) != null) {
            no = getSucessor(no);
            str += ", " + no.getInfo().toString();
        }
        return str + " }";
    }
}
