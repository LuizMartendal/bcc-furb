package Exercicio2;

public class ArvoreBST<T extends Comparable<T>>  extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() { }

    public void inserir(T info) {
        if (this.getRaiz() == null) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>)this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        return ((NoArvoreBST<T>)this.getRaiz()).buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> noARemover = this.buscar(info);
        if (noARemover != null) {
            this.removerUmNo(noARemover);
        }
    }

    private void removerUmNo(NoArvoreBST<T> noARemover) {
        NoArvoreBST<T> noPai = this.identificarPai(noARemover);

        if (noARemover.getGrau() == 0) {
            if (noARemover == this.getRaiz()) {
                this.setRaiz(null);
            } else {
                if (noPai.getDir() == noARemover) {
                    noPai.setDir(null);
                } else {
                    noPai.setEsq(null);
                }
            }
        } else {
            if (noARemover.getGrau() == 1) {
                NoArvoreBST<T> noFilho = noARemover.identificarUnicoFilho();

                if (noPai == null) {
                    this.setRaiz(noFilho);
                } else {
                    if (noPai.getDir() == noARemover) {
                        noPai.setDir(noFilho);
                    } else {
                        noPai.setEsq(noFilho);
                    }
                }
            } else {
                NoArvoreBST<T> noSucessor = this.identificarSucessor(noARemover);
                T info = noSucessor.getInfo();
                this.removerUmNo(noSucessor);
                noARemover.setInfo(info);
            }
        }
    }

    private NoArvoreBST<T> identificarPai(NoArvoreBST<T> noARemover) {
        if (noARemover == this.getRaiz()) {
            return null;
        }
        NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();

        while (noPai.getDir() != noARemover && noPai.getEsq() != noARemover) {
            if (noARemover.getInfo().compareTo(noPai.getInfo()) < 0) {
                noPai = (NoArvoreBST<T>) noPai.getEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getDir();
            }
        }
        return noPai;
    }

    private NoArvoreBST<T> identificarSucessor(NoArvoreBST<T> noARemover) {
        NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) noARemover.getDir();
        while (noSucessor.getEsq() != null) {
            noSucessor = (NoArvoreBST<T>) noSucessor.getEsq();
        }
        return noSucessor;
    }

    @Override
    public String toString() {
        if (((NoArvoreBST<T>)this.getRaiz()) == null) {
            return "<>";
        }
        return ((NoArvoreBST<T>)this.getRaiz()).imprime();
    }

    public T menorElemento() {
        if (this.getRaiz() == null) {
            return null;
        }
        NoArvoreBST<T> noComMenorElemento = (NoArvoreBST<T>) this.getRaiz();
        while (noComMenorElemento.getEsq() != null) {
            noComMenorElemento = (NoArvoreBST<T>) noComMenorElemento.getEsq();
        }
        return noComMenorElemento.getInfo();
    }

    public T maiorElemento() {
        if (this.getRaiz() == null) {
            return null;
        }
        NoArvoreBST<T> noComMaiorElemento = (NoArvoreBST<T>) this.getRaiz();
        while (noComMaiorElemento.getDir() != null) {
            noComMaiorElemento = (NoArvoreBST<T>) noComMaiorElemento.getDir();
        }
        return noComMaiorElemento.getInfo();
    }

    public T getSucessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if (this.getRaiz() == null || this.maiorElemento().equals(info)) {
            return null;
        }
        if (no.getDir() != null) {
            return this.identificarSucessor(no).getInfo();
        }
        NoArvoreBST<T> noPai = this.identificarPai(no);
        while (noPai.getDir() == no) {
            no = noPai;
            noPai = this.identificarPai(no);
        }
        return noPai.getInfo();
    }

    private NoArvoreBST<T> identificarAntecessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> noAntecessor = (NoArvoreBST<T>) no.getEsq();
        while (noAntecessor.getDir() != null) {
            noAntecessor = (NoArvoreBST<T>) noAntecessor.getDir();
        }
        return noAntecessor;
    }

    public T getAntecessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if (this.getRaiz() == null || this.menorElemento().equals(info)) {
            return null;
        }
        if (no.getEsq() != null) {
            return this.identificarAntecessor(no).getInfo();
        }
        NoArvoreBST<T> noPai = this.identificarPai(no);
        while (noPai.getEsq() == no) {
            no = noPai;
            noPai = this.identificarPai(no);
        }
        return noPai.getInfo();
    }

}
