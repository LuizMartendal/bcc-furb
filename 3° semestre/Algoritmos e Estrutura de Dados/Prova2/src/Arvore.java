//Luiz Henrique Martendal
import java.util.List;
import java.util.stream.Collectors;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {}

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public NoArvore<T> pertence(T info) {
        if (vazia()) {
            return null;
        }
        return this.getRaiz().pertence(info);
    }

    public boolean vazia() {
        if (this.getRaiz() != null) {
            return false;
        }
        return true;
    }

    public int getAltura() {
        if (vazia()) {
            return -1;
        }
        return this.getRaiz().getAltura();
    }

    public int getNivel(T info) {
        NoArvore<T> no = this.pertence(info);

        if (no == null) {
            return -1;
        }
        return this.getRaiz().getNivel(no);
    }

    public boolean isBalanceada() {
        if (vazia()) {
            return true;
        }
        List<Integer> folhas = this.getFolhas();
        int maiorNivel = 0;
        int menorNivel = folhas.get(0);
        for (int i = 1; i < folhas.size(); i++) {
            if (folhas.get(i) < menorNivel) {
                menorNivel = folhas.get(i);
            }
            if (folhas.get(i) > maiorNivel) {
                maiorNivel = folhas.get(i);
            }
            if ((maiorNivel - menorNivel) > 1) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getFolhas() {
        return this.getRaiz().getFolhas()
                .stream()
                .map( no -> {
                    return this.getRaiz().getNivel(no);
                }).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        if (vazia()) {
            return "";
        }

        return this.getRaiz().imprimePre();
    }

    public int getGrau() {
        if (vazia()) {
            return 0;
        }
        return this.raiz.getGrau();
    }

    public void excluir(T info) {
        NoArvore<T> no = pertence(info);

        if (no != null) {
            if (no == raiz) {
                setRaiz(null);
            } else {
                this.raiz.excluir(no);
            }
        }
    }

    public void mover(T info, T destino) {
        NoArvore<T> no = pertence(info);
        NoArvore<T> localFinal = pertence(destino);

        if (no != null && localFinal != null && no != raiz) {
            NoArvore<T> noInserido = new NoArvore<>(no.getInfo());
            if (no.getFilho() != null) {
                noInserido.setFilho(no.getFilho());
            }
            if (no.getIrmao() != null) {
                noInserido.setIrmao(no.getIrmao());
            }
            localFinal.inserirFilho(noInserido);
            raiz.excluir(no);
        }
    }
}
