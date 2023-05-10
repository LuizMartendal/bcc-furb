package Lista8.Testes;

import Lista8.ArvoreBST;
import Lista8.Veiculo;
import Lista8.VeiculoImpl;

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

        ArvoreBST<VeiculoImpl> arvoreBST3 = new ArvoreBST<>();

        VeiculoImpl k = new VeiculoImpl("MJT-7432", "Fusca", 1912, "Pedro");
        VeiculoImpl l = new VeiculoImpl("MIT-8008", "Celta", 1999, "Douglas");
        VeiculoImpl m = new VeiculoImpl("MEI-4665", "Gol", 2002, "Carlos");
        VeiculoImpl n = new VeiculoImpl("MIO-6668", "Fusca", 1915, "Aline");
        VeiculoImpl o = new VeiculoImpl("DIO-3333", "Celta", 1999, "Fausto");
        VeiculoImpl p = new VeiculoImpl("PAO-6472", "C3", 2007, "Carolina");
        VeiculoImpl q = new VeiculoImpl("CAO-2890", "C4", 2012, "Kelvin");
        VeiculoImpl r = new VeiculoImpl("UVA-3939", "BMW", 2015, "Zé");
        VeiculoImpl s = new VeiculoImpl("OVO-0000", "Gol", 2000, "Joshua");
        VeiculoImpl t = new VeiculoImpl("ABC-1234", "Ferrari", 2015, "Marta");

        arvoreBST3.inserir(k);
        arvoreBST3.inserir(l);
        arvoreBST3.inserir(m);
        arvoreBST3.inserir(n);
        arvoreBST3.inserir(o);
        arvoreBST3.inserir(p);
        arvoreBST3.inserir(q);
        arvoreBST3.inserir(r);
        arvoreBST3.inserir(s);
        arvoreBST3.inserir(t);

        System.out.println("Arvore com elementos ordenados pela placa: \n" +
                            arvoreBST2.toStringOrdered() +
                            "\n---------------------------------------------");
        System.out.println("Arvore com elementos ordenados pelo ano: \n" +
                arvoreBST3.toStringOrdered() +
                "\n---------------------------------------------");
    }
}
