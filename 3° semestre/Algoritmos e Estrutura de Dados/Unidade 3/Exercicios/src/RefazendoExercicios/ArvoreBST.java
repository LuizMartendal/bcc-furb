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
        NoArvoreBST<T> no = this.buscar(info);

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
              if (noPai.getNoDir() != null) {
                  noPai.setNoDir(null);
              } else {
                  noPai.setNoEsq(null);
              }
          }
        } else {
            NoArvoreBST<T> noFilho = no.getUnicoFilho();

            if (no.getGrau() == 1) {
                if (noPai == null) {
                    this.setRaiz(noFilho);
                } else {
                    if (noPai.getNoDir() != null) {
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

    private NoArvoreBST<T> getSucessor(NoArvoreBST<T> no) {
        if (vazia() || this.getMaiorElemento().equals(no.getInfo())) {
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

    private NoArvoreBST<T> getPai(NoArvoreBST<T> no) {
        if (no == this.raiz) {
            return null;
        }

        NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.raiz;
        while (noPai.getNoEsq() != no && noPai.getNoDir() != no) {
            if (no.getInfo().compareTo(noPai.getInfo()) < 0) {
                noPai = (NoArvoreBST<T>) noPai.getNoEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getNoDir();
            }
        }

        return noPai;
    }

    private NoArvoreBST<T> getNoComMaiorElemento() {
        if (vazia()) {
            return null;
        }

        NoArvoreBST<T> no = (NoArvoreBST<T>) this.raiz;
        while (no.getNoDir() != null) {
            no = (NoArvoreBST<T>) no.getNoDir();
        }

        return no;
    }

    private T getMaiorElemento() {
        NoArvoreBST<T> no = this.getNoComMaiorElemento();

        if (no != null) {
            return no.getInfo();
        }

        return null;
    }

    private NoArvoreBST<T> getNoComMenorElemento() {
        if (vazia()) {
            return null;
        }

        NoArvoreBST<T> no = (NoArvoreBST<T>) this.raiz;
        while (no.getNoEsq() != null) {
            no = (NoArvoreBST<T>) no.getNoEsq();
        }

        return no;
    }

    private T getMenorElemento() {
        NoArvoreBST<T> no = this.getNoComMenorElemento();

        if (no != null) {
            return no.getInfo();
        }

        return null;
    }

    public NoArvoreBST<T> getAntecessor(NoArvoreBST<T> no) {
        if (vazia() || this.getMenorElemento().equals(no.getInfo())) {
            return null;
        }

        if (no.getNoEsq() != null) {
            NoArvoreBST<T> noAntecessor = (NoArvoreBST<T>) no.getNoEsq();
            while (noAntecessor.getNoDir() != null) {
                noAntecessor = (NoArvoreBST<T>) noAntecessor.getNoDir();
            }
            return noAntecessor;
        }

        NoArvoreBST<T> noPai = getPai(no);
        while (noPai.getNoEsq() == no) {
            no = noPai;
            noPai = getPai(noPai);
        }
        return noPai;
    }

    public T getSucessor(T info) {
        NoArvoreBST<T> no = this.getSucessor(this.buscar(info));

        if (no != null) {
            return  no.getInfo();
        }

        return null;
    }

    public T getAntecessor(T info) {
        NoArvoreBST<T> no = this.getAntecessor(this.buscar(info));

        if (no != null) {
            return no.getInfo();
        }

        return null;
    }

    public String toStringOrdered() {
        if (vazia()) {
            return "{ }";
        }

        String str = "{ ";
        NoArvoreBST<T> no = this.getNoComMenorElemento();
        str += no.getInfo();

        while (getSucessor(no) != null) {
            no = getSucessor(no);
            str += " " + no.getInfo();
        }
        return str += " }";
    }
}
