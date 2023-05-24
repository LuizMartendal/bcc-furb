//Luiz Henrique Martendal
import java.util.ArrayList;
import java.util.List;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public NoArvore(T info) {
        this.info = info;
    }

    public String imprimePre() {
        String str = "<";

        str += this.info.toString();

        if (filho != null) {
            str += filho.imprimePre();
        }
        str += ">";

        if (irmao != null) {
            str += irmao.imprimePre();
        }

        return str;
    }

    public void inserirFilho(NoArvore<T> filho) {
        if (filho == null) {
            return;
        }
        filho.setIrmao(getFilho());
        this.setFilho(filho);
    }

    public NoArvore<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        if (filho != null) {
            NoArvore<T> filho = this.filho.pertence(info);
            if (filho != null) {
                return filho;
            }
        }

        if (irmao != null) {
            return irmao.pertence(info);
        }

        return null;
    }

    public int getAltura() {
        int altura = 0;
        int alturaAtual = 0;

        if (filho != null) {
            alturaAtual++;
            alturaAtual += filho.getAltura();
        }

        if (alturaAtual > altura) {
            altura = alturaAtual;
        }

        if (irmao != null) {
            alturaAtual = irmao.getAltura();
        }

        if (alturaAtual > altura) {
            altura = alturaAtual;
        }

        return altura;
    }

    public int getNivel(NoArvore<T> no) {
        int nivel = 0;
        int nivelAtual = 0;

        if (this == no) {
            return 0;
        } else {
            if (filho != null) {
                nivelAtual++;
                int ehFilho = this.filho.getNivel(no);
                if (ehFilho < 0) {
                    nivelAtual--;
                } else {
                    nivelAtual += ehFilho;
                }
            }

            if (nivelAtual > nivel) {
                nivel = nivelAtual;
                return nivel;
            }

            if (irmao != null) {
                int irmao = this.irmao.getNivel(no);
                if (irmao >= 0) {
                    nivelAtual += irmao;
                    return nivelAtual;
                }
            }
        }

        return -1;
    }

    public List<NoArvore<T>> getFolhas() {
        List<NoArvore<T>> folhas = new ArrayList<>();

        if (this.ehFolha()) {
            folhas.add(this);
        }

        if (filho != null) {
            folhas.addAll(filho.getFolhas());
        }

        if (irmao != null) {
            folhas.addAll(irmao.getFolhas());
        }

        return folhas;
    }

    public boolean ehFolha() {
        if (filho != null) {
            return false;
        }
        return true;
    }

    public int getGrau() {
        int grau = 0;
        int grauAtual = 0;

        if (this.filho != null) {
            grauAtual = getGrau(this.filho);

            int grauFilho = filho.getGrau();
            if (grauFilho > grauAtual) {
                grauAtual = grauFilho;
            }
        }

        if (grauAtual > grau) {
            grau = grauAtual;
        }

        if (irmao != null) {
            int grauIrmao = irmao.getGrau();
            if (grauIrmao > grauAtual) {
                grauAtual = grauIrmao;
            }
        }

        if (grauAtual > grau) {
            grau = grauAtual;
        }
        return grau;
    }

    public int getGrau(NoArvore<T> no) {
        int grau = 1;
        while (no.irmao != null) {
            no = no.irmao;
            grau++;
        }
        return grau;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getFilho() {
        return filho;
    }

    public void setFilho(NoArvore<T> filho) {
        this.filho = filho;
    }

    public NoArvore<T> getIrmao() {
        return irmao;
    }

    public void setIrmao(NoArvore<T> irmao) {
        this.irmao = irmao;
    }

    public void excluir(NoArvore<T> no) {

        if (filho != null) {
            if (filho == no) {
                if (filho.irmao != null) {
                    filho = filho.irmao;
                }
            } else {
                this.filho.excluir(no);
            }
        }

        if (irmao != null) {
            if (irmao == no) {
                if (irmao.irmao != null) {
                    irmao = irmao.irmao;
                } else {
                    irmao = null;
                }
            } else {
                irmao.excluir(no);
            }
        }
    }
}