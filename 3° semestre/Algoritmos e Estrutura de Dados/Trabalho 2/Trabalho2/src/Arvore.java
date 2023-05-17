import java.util.ArrayList;
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
}
