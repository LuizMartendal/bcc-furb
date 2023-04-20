package Exercicio2;

public class TesteArvoreBinariaBST {

    public static void main(String[] args) {
        ArvoreBST<Integer> arvoreBST = new ArvoreBST<>();

        arvoreBST.inserir(50);
        arvoreBST.inserir(30);
        arvoreBST.inserir(35);
        arvoreBST.inserir(80);
        arvoreBST.inserir(70);
        arvoreBST.inserir(50);
        arvoreBST.inserir(50);
        arvoreBST.inserir(29);
        arvoreBST.inserir(34);
        arvoreBST.inserir(33);
        arvoreBST.inserir(85);
        arvoreBST.inserir(84);
        arvoreBST.inserir(86);
        System.out.println(arvoreBST.toString());
        arvoreBST.retirar(50);
        arvoreBST.retirar(50);
        arvoreBST.retirar(50);
        System.out.println(arvoreBST.toString());
    }
}
