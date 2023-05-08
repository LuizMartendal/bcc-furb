package RefazendoExercicios.Lista7.Testes;

import RefazendoExercicios.Lista7.ArvoreBST;

import java.util.Random;
import java.util.Scanner;

public class TesteRandom {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArvoreBST<Integer> arvoreBST = new ArvoreBST<>();
        System.out.print("Quantidade de nós: ");
        int qtd = s.nextInt();

        int[] elementos = new int[qtd];

        for (int i = 0; i < qtd; i++) {
            int n = new Random().nextInt(0, 100);
            elementos[i] = n;
            arvoreBST.inserir(n);
            System.out.println("Adicionando o elemento: " + elementos[i] +
                    "\nÁrvore: " + arvoreBST);
        }

        System.out.println("Árvore completa: " + arvoreBST);
//        System.out.println("Elementos ordenados em ordem crescente: " + arvoreBST.toStringOrdered());
//        System.out.println("Menor valor = "+arvoreBST.menorElemento());
//        System.out.println("Maior valor = "+arvoreBST.maiorElemento());
//
//
//        for (int i=0; i < elementos.length; i++) {
//            System.out.println("Sucessor de "+elementos[i]+" = "+arvoreBST.getSucessor(elementos[i]));
//        }
//
//        for (int i=0; i < elementos.length; i++) {
//            System.out.println("Antecessor de "+elementos[i]+" = "+arvoreBST.getAntecessor(elementos[i]));
//        }

        for (int i = qtd - 1; i >= 0; i--) {
            arvoreBST.retirar(elementos[i]);
            System.out.println("Tirando o elemento: " + elementos[i] +
                                "\nÁrvore: " + arvoreBST);
        }
        System.out.println("Árvore após retirada de todos elementos: " + arvoreBST);
        s.close();
    }
}
