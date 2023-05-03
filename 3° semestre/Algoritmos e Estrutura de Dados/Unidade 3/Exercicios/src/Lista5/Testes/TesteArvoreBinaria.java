package Lista5.Testes;

import Lista5.ArvoreBinaria;
import Lista5.NoArvoreBinaria;

public class TesteArvoreBinaria {

    public static void main(String[] args) {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);

        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no8 = new NoArvoreBinaria<>(8);
        no7.setNoEsq(no8);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no6, no7);

        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        System.out.println(no2.imprimePre());
        System.out.println(no3.imprimePre());
        System.out.println(no1.imprimePre());
        System.out.println(arvore);
        System.out.println(no2.pertence(5).getInfo());
        System.out.println(arvore.pertence(8).getInfo());
    }
}
