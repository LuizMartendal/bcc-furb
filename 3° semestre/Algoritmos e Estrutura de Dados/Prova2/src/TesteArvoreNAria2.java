public class TesteArvoreNAria2 {

    public static void main(String[] args) {
        NoArvore<String> nAA = new NoArvore<String>("AA");
        NoArvore<String> nBB = new NoArvore<String>("BB");
        NoArvore<String> nCC = new NoArvore<String>("CC");
        NoArvore<String> nDD = new NoArvore<String>("DD");
        NoArvore<String> nEE = new NoArvore<String>("EE");
        NoArvore<String> nM = new NoArvore<String>("M");
        nBB.inserirFilho(nAA);
        nCC.inserirFilho(nBB);
        nDD.inserirFilho(nCC);
        nEE.inserirFilho(nDD);
        nM.inserirFilho(nEE);

        NoArvore<String> nA = new NoArvore<String>("A");
        NoArvore<String> nB = new NoArvore<String>("B");
        NoArvore<String> nC = new NoArvore<String>("C");
        NoArvore<String> nD = new NoArvore<String>("D");

        nB.inserirFilho(nA);
        nC.inserirFilho(nB);
        nD.inserirFilho(nC);
        nM.inserirFilho(nD);

        NoArvore<String> nXX = new NoArvore<String>("XX");
        nM.inserirFilho(nXX);

        NoArvore<String> nR = new NoArvore<String>("R");
        NoArvore<String> nH = new NoArvore<String>("H");
        nH.inserirFilho(nR);
        nH.inserirFilho(nM);

        Arvore<String> a = new Arvore<>();
        a.setRaiz(nH);
        a.pertence("EE");
        int nivel = a.getNivel("CC");
        System.out.println(" O nível de CC deve ser 4: " + nivel);
// NoArvore<String> pai = a.getPai("XX");
// System.out.println(" O pai de XX, deve ser M: " + pai.getInfo());

        boolean isBalanceada = a.isBalanceada();
        System.out.println("Não deve estar balanceada: " + isBalanceada);
        int b = a.getAltura();
        System.out.println(" A altura da árvore deve ser 6: " + b);
        System.out.println("");

        Arvore<String> a2 = new Arvore<>();
        int b2 = a2.getAltura();
        boolean r2 = a2.isBalanceada();
        System.out.println("Deve estar balanceada: " + r2);
        System.out.println(" A altura da árvore deve ser -1: " + b2);
        System.out.println("");

        Arvore<String> a3 = new Arvore<>();
        NoArvore<String> nS = new NoArvore<String>("M");
        a3.setRaiz(nS);
        boolean r3 = a3.isBalanceada();
        System.out.println("Deve estar balanceada: " + r3);
        int b3 = a3.getAltura();
        System.out.println(" A altura da árvore deve ser zero: " + b3);
        System.out.println("");

        Arvore<String> a4 = new Arvore<>();
        NoArvore<String> nZ = new NoArvore<String>("Z");
        NoArvore<String> nU = new NoArvore<String>("U");
        NoArvore<String> nY = new NoArvore<String>("Y");
        NoArvore<String> nX = new NoArvore<String>("X");
        NoArvore<String> nHH = new NoArvore<String>("HH");
        NoArvore<String> nJ = new NoArvore<String>("J");
        a4.setRaiz(nZ);
        nZ.inserirFilho(nU);
        nZ.inserirFilho(nY);
        nY.inserirFilho(nX);
        nY.inserirFilho(nHH);
        nHH.inserirFilho(nJ);
        int b4 = a4.getAltura();
        int testNivel3 = a4.getNivel("xy");
        System.out.println(" A altura da árvore deve ser 3: " + b4);
        System.out.println(" O nível da árvore = -1: " + testNivel3);
    }
}
