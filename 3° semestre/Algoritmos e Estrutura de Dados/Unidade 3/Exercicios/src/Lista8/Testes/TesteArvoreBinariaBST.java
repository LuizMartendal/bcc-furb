package Lista8.Testes;


import Exercicio2.Veiculo;
import Lista8.ArvoreBST;

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
        System.out.println("Sucessor de 11: " + arvoreBST.getSucessor(0));
        System.out.println("Antecessor de 13: " + arvoreBST.getAntecessor(13));
        System.out.println(arvoreBST.toStringOrdered());

        arvoreBST.retirar(22);
        arvoreBST.retirar(73);
        arvoreBST.retirar(22);
        arvoreBST.retirar(85);
        arvoreBST.retirar(15);
        arvoreBST.retirar(85);
        arvoreBST.retirar(30);
        arvoreBST.retirar(66);
        arvoreBST.retirar(28);
        arvoreBST.retirar(85);

        System.out.println(arvoreBST);

        Exercicio2.ArvoreBST<Veiculo> arvoreBST2 = new Exercicio2.ArvoreBST<>();

        Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
        Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
        Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");

        arvoreBST2.inserir(a);
        arvoreBST2.inserir(b);
        arvoreBST2.inserir(c);

        System.out.println(arvoreBST2.toStringOrdered());
    }
}
