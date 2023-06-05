public class TesteArvoreNAria {
    public static void main(String[] args) {
        NoArvore<Integer> n9 = new NoArvore<Integer>(9);
        NoArvore<Integer> n10 = new NoArvore<Integer>(10);
        NoArvore<Integer> n4 = new NoArvore<Integer>(4);
        NoArvore<Integer> n20 = new NoArvore<Integer>(20);
        NoArvore<Integer> n11 = new NoArvore<Integer>(11);
        NoArvore<Integer> n64 = new NoArvore<Integer>(64);
        n4.inserirFilho(n10);
        n4.inserirFilho(n9);
        n4.inserirFilho(n20);
        n4.inserirFilho(n11);
        n4.inserirFilho(n64);

        NoArvore<Integer> n80 = new NoArvore<Integer>(80);
        NoArvore<Integer> n59 = new NoArvore<Integer>(59);
        NoArvore<Integer> n74 = new NoArvore<Integer>(74);
        NoArvore<Integer> n3 = new NoArvore<Integer>(3);
        n3.inserirFilho(n80);
        n3.inserirFilho(n59);
        n3.inserirFilho(n74);

        NoArvore<Integer> n78 = new NoArvore<Integer>(78);
        NoArvore<Integer> n696 = new NoArvore<Integer>(696);
        NoArvore<Integer> n17 = new NoArvore<Integer>(17);
        NoArvore<Integer> n2 = new NoArvore<Integer>(2);
        n2.inserirFilho(n78);
        n2.inserirFilho(n696);
        n2.inserirFilho(n17);

        NoArvore<Integer> n1 = new NoArvore<Integer>(1);
        n1.inserirFilho(n4);
        n1.inserirFilho(n3);
        n1.inserirFilho(n2);

        Arvore<Integer> a = new Arvore<>();

        a.setRaiz(n1);

//        System.out.println(a);
//        System.out.println(a.pertence(4).getInfo());
//        System.out.println(a.pertence(6).getInfo());
//        System.out.println(a.pertence(1).getInfo());
//        System.out.println(a.pertence(8).getInfo());
//        System.out.println(a.pertence(99));
        Arvore<Integer> a1 = new Arvore<>();

        System.out.println(a1);

        System.out.println(a.getNivel(696));
        System.out.println(a.getAltura());
        System.out.println(a.isBalanceada());
    }
}