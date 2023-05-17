package Lista9;

public class ArvoreTeste {

    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();

        NoArvore<Integer> filho1 = new NoArvore<>(1);
        NoArvore<Integer> filho2 = new NoArvore<>(2);
        filho1.inserirFilho(filho2);
        NoArvore<Integer> filho3 = new NoArvore<>(3);
        filho2.inserirFilho(filho3);

        arvore.setRaiz(filho1);

        System.out.println(arvore);
        System.out.println(arvore.pertence(2).imprimePre());
        System.out.println(arvore.pertence(3).imprimePre());
    }
}
