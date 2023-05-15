package RefazendoExercicios.Testes;

import Lista8.Veiculo;
import RefazendoExercicios.ArvoreBST;

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
        Veiculo d = new Veiculo("MIO-6668", "Fusca", 1915, "Aline");
        Veiculo e = new Veiculo("DIO-3333", "Celta", 1999, "Fausto");
        Veiculo f = new Veiculo("PAO-6472", "C3", 2007, "Carolina");
        Veiculo g = new Veiculo("CAO-2890", "C4", 2012, "Kelvin");
        Veiculo h = new Veiculo("UVA-3939", "BMW", 2015, "Zé");
        Veiculo i = new Veiculo("OVO-0000", "Gol", 2000, "Joshua");
        Veiculo j = new Veiculo("ABC-1234", "Ferrari", 2015, "Marta");

        arvoreBST2.inserir(a);
        arvoreBST2.inserir(b);
        arvoreBST2.inserir(c);
        arvoreBST2.inserir(d);
        arvoreBST2.inserir(e);
        arvoreBST2.inserir(f);
        arvoreBST2.inserir(g);
        arvoreBST2.inserir(h);
        arvoreBST2.inserir(i);
        arvoreBST2.inserir(j);

        System.out.println(arvoreBST2.toStringOrdered());
    }
}
