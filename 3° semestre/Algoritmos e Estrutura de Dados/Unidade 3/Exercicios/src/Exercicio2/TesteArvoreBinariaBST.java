package Exercicio2;

public class TesteArvoreBinariaBST {

    public static void main(String[] args) {
        ArvoreBST<Integer> arvoreBST = new ArvoreBST<>();

        arvoreBST.inserir(22);
        arvoreBST.inserir(18);
        arvoreBST.inserir(9);
        arvoreBST.inserir(0);
        arvoreBST.inserir(5);
        arvoreBST.inserir(13);
        arvoreBST.inserir(11);
        arvoreBST.inserir(12);
        arvoreBST.inserir(0);
        arvoreBST.inserir(8);

        System.out.println(arvoreBST);
        System.out.println(arvoreBST.toStringOrdered());

//        arvoreBST.retirar(22);
//        arvoreBST.retirar(73);
//        arvoreBST.retirar(22);
//        arvoreBST.retirar(85);
//        arvoreBST.retirar(15);
//        arvoreBST.retirar(85);
//        arvoreBST.retirar(30);
//        arvoreBST.retirar(66);
//        arvoreBST.retirar(28);
//        arvoreBST.retirar(85);

        System.out.println(arvoreBST);
    }
}
