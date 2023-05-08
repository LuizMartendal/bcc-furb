package RefazendoExercicios.Lista6.Testes;

import Lista6.ArvoreBST;

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
        s.close();
    }
}
