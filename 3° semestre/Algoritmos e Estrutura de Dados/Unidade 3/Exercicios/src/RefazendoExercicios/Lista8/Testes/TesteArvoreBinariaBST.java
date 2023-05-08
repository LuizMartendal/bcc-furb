package RefazendoExercicios.Lista8.Testes;

import Lista8.Veiculo;
import RefazendoExercicios.Lista8.ArvoreBST;

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
        System.out.println("Sucessor de 11: " + arvoreBST.getSucessor(11));
        System.out.println("Antecessor de 13: " + arvoreBST.getAntecessor(13));
        System.out.println(arvoreBST.toStringOrdered());

        arvoreBST.retirar(8);
        arvoreBST.retirar(0);
        arvoreBST.retirar(12);
        arvoreBST.retirar(11);
        arvoreBST.retirar(13);
        arvoreBST.retirar(5);
        arvoreBST.retirar(0);
        arvoreBST.retirar(9);
        arvoreBST.retirar(18);
        arvoreBST.retirar(22);

        System.out.println(arvoreBST);

        ArvoreBST<Veiculo> arvoreBST2 = new ArvoreBST<>();

        Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
        Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
        Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");

        arvoreBST2.inserir(a);
        arvoreBST2.inserir(b);
        arvoreBST2.inserir(c);

        System.out.println(arvoreBST2.toStringOrdered());
    }
}
