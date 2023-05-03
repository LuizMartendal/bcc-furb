package Exercicio2.Testes;

import Exercicio2.ArvoreBST;
import Exercicio2.Veiculo;

public class TesteArvoreBinariaBST {

    public static void main(String[] args) {
        ArvoreBST<Veiculo> arvoreBST = new ArvoreBST<>();

        Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
        Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
        Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");

        arvoreBST.inserir(a);
        arvoreBST.inserir(b);
        arvoreBST.inserir(c);

        System.out.println(arvoreBST.toStringOrdered());

//        arvoreBST.inserir(22);
//        arvoreBST.inserir(18);
//        arvoreBST.inserir(9);
//        arvoreBST.inserir(0);
//        arvoreBST.inserir(5);
//        arvoreBST.inserir(13);
//        arvoreBST.inserir(11);
//        arvoreBST.inserir(12);
//        arvoreBST.inserir(0);
//        arvoreBST.inserir(8);
//
//        System.out.println(arvoreBST);
//        System.out.println(arvoreBST.toStringOrdered());
//
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
//
//        System.out.println(arvoreBST);
    }
}
