package Exercicio2;

public class TesteArvoreBinariaBST {

    public static void main(String[] args) {
        ArvoreBST<Integer> arvoreBST = new ArvoreBST<>();

        arvoreBST.inserir(85);
        arvoreBST.inserir(28);
        arvoreBST.inserir(66);
        arvoreBST.inserir(30);
        arvoreBST.inserir(85);
        arvoreBST.inserir(15);
        arvoreBST.inserir(85);
        arvoreBST.inserir(51);
        arvoreBST.inserir(73);
        arvoreBST.inserir(23);

        System.out.println(arvoreBST);
        System.out.println(arvoreBST.toStringOrdered());

        arvoreBST.retirar(23);
        arvoreBST.retirar(73);
        arvoreBST.retirar(51);
        arvoreBST.retirar(85);
        arvoreBST.retirar(15);
        arvoreBST.retirar(85);
        arvoreBST.retirar(30);
        arvoreBST.retirar(66);
        arvoreBST.retirar(28);
        arvoreBST.retirar(85);

        System.out.println(arvoreBST);
    }
}
