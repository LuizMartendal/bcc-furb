package RefazendoExercicios.Lista7;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() {}

    public void inserir(T info) {
        if (vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>)this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>)this.getRaiz()).buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if (no != null) {
            this.retirarUmNo(no);
        }
    }

    public void retirarUmNo(NoArvoreBST<T> no) {
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
                NoArvoreBST<T> noSucessor = this.getSucessor(no);
                T info = noSucessor.getInfo();
                this.retirarUmNo(noSucessor);
                no.setInfo(info);
            }
        }
    }

    public NoArvoreBST<T> getPai(NoArvoreBST<T> no) {
        if (no == this.getRaiz()) {
            return null;
        }
        NoArvoreBST<T> noPai = ((NoArvoreBST<T>)this.getRaiz());
        while (noPai.getNoEsq() != no && noPai.getNoDir() != no) {
            if (no.getInfo().compareTo(noPai.getInfo()) < 0) {
                noPai = (NoArvoreBST<T>) noPai.getNoEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getNoDir();
            }
        }
        return noPai;
    }

    public NoArvoreBST<T> getSucessor(NoArvoreBST<T> no) {
        if (no.getNoDir() != null) {
            NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) no.getNoDir();
            while (noSucessor.getNoEsq() != null) {
                noSucessor = (NoArvoreBST<T>) noSucessor.getNoEsq();
            }
            return noSucessor;
        }
        return null;
    }
}
