package Exercicio2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TesteRandom {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArvoreBST<Integer> arvoreBST = new ArvoreBST<>();
        System.out.print("Quantidade de nós: ");
        int qtd = s.nextInt();

        ArrayList<NoArvoreBST<Integer>> nos = new ArrayList<>();
        int[] elementos = new int[qtd];

        for (int i = 0; i < qtd; i++) {
            int n = new Random().nextInt(0, 100);
            elementos[i] = n;
            arvoreBST.inserir(n);
        }
        System.out.println("Árvore completa: " + arvoreBST.toString());
        for (int i = 0; i < qtd; i++) {
            arvoreBST.retirar(elementos[i]);
        }
        System.out.println("Árvore após retirada de todos elementos: " + arvoreBST.toString());
        s.close();
    }
}
