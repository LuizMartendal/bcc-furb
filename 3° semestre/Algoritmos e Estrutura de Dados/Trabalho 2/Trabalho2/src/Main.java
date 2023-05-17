public class Main {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();

        NoArvore<Integer> no1 = new NoArvore<>(1);
        arvore.setRaiz(no1);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        no1.setFilho(no2);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        no2.setFilho(no3);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        no3.setFilho(no4);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        no3.setIrmao(no5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        no2.setIrmao(no6);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        no6.setIrmao(no7);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        no7.setFilho(no8);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        no8.setIrmao(no9);
        NoArvore<Integer> no10 = new NoArvore<>(10);
        no9.setFilho(no10);
        NoArvore<Integer> no11 = new NoArvore<>(11);
        no10.setFilho(no11);
        NoArvore<Integer> no12 = new NoArvore<>(12);
        no5.setFilho(no12);
        NoArvore<Integer> no13 = new NoArvore<>(13);
        no12.setFilho(no13);
        NoArvore<Integer> no14 = new NoArvore<>(14);
        no13.setFilho(no14);

        int altura = arvore.getAltura();
        int nivel = arvore.getNivel(8);
        System.out.println("Árvore completa = " + arvore);
        System.out.println("Altura da árvore = " + arvore.getAltura());
        System.out.println("1 = " + arvore.getNivel(1));
        System.out.println("2 = " + arvore.getNivel(2));
        System.out.println("3 = " + arvore.getNivel(3));
        System.out.println("4 = " + arvore.getNivel(4));
        System.out.println("5 = " + arvore.getNivel(5));
        System.out.println("6 = " + arvore.getNivel(6));
        System.out.println("7 = " + arvore.getNivel(7));
        System.out.println("8 = " + arvore.getNivel(8));
        System.out.println("9 = " + arvore.getNivel(9));
        System.out.println("10 = " + arvore.getNivel(10));
        System.out.println("11 = " + arvore.getNivel(11));
        System.out.println("12 = " + arvore.getNivel(12));
        System.out.println("13 = " + arvore.getNivel(13));
        System.out.println("14 = " + arvore.getNivel(14));
    }
}