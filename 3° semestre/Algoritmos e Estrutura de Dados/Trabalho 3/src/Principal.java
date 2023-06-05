public class Principal {
    public static void main(String[] args) {
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(10);

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


        System.out.println("\n\nMétodo inserir()\n");


        System.out.println("Inserindo a = Esperado: true |  retorno: " + mapa.inserir(a.getPlaca(), a));
        System.out.println("Inserindo a = Esperado: false | retorno: " + mapa.inserir(a.getPlaca(), a));

        System.out.println("Inserindo b = Esperado: true |  retorno: " + mapa.inserir(b.getPlaca(), b));
        System.out.println("Inserindo b = Esperado: false | retorno: " + mapa.inserir(b.getPlaca(), b));

        System.out.println("Inserindo c = Esperado: true |  retorno: " + mapa.inserir(c.getPlaca(), c));
        System.out.println("Inserindo c = Esperado: false | retorno: " + mapa.inserir(c.getPlaca(), c));

        System.out.println("Inserindo d = Esperado: true |  retorno: " + mapa.inserir(d.getPlaca(), d));
        System.out.println("Inserindo d = Esperado: false | retorno: " + mapa.inserir(d.getPlaca(), d));

        System.out.println("Inserindo e = Esperado: true |  retorno: " + mapa.inserir(e.getPlaca(), e));
        System.out.println("Inserindo e = Esperado: false | retorno: " + mapa.inserir(e.getPlaca(), e));

        System.out.println("Inserindo f = Esperado: true |  retorno: " + mapa.inserir(f.getPlaca(), f));
        System.out.println("Inserindo f = Esperado: false | retorno: " + mapa.inserir(f.getPlaca(), f));

        System.out.println("Inserindo g = Esperado: true |  retorno: " + mapa.inserir(g.getPlaca(), g));
        System.out.println("Inserindo g = Esperado: false | retorno: " + mapa.inserir(g.getPlaca(), g));

        System.out.println("Inserindo h = Esperado: true |  retorno: " + mapa.inserir(h.getPlaca(), h));
        System.out.println("Inserindo h = Esperado: false | retorno: " + mapa.inserir(h.getPlaca(), h));

        System.out.println("Inserindo i = Esperado: true |  retorno: " + mapa.inserir(i.getPlaca(), i));
        System.out.println("Inserindo i = Esperado: false | retorno: " + mapa.inserir(i.getPlaca(), i));

        System.out.println("Inserindo j = Esperado: true |  retorno: " + mapa.inserir(j.getPlaca(), j));
        System.out.println("Inserindo j = Esperado: false | retorno: " + mapa.inserir(j.getPlaca(), j));


        System.out.println("\n\nMétodo quantosElementos()\n");

        System.out.println("Total de elementos = Esperado: 10 | retornado: " + mapa.quantosElementos());


        System.out.println("\n\nMétodo buscar()\n");


        System.out.println("Buscando a = Esperado: MJT-7432 |  retorno: " + mapa.buscar(a.getPlaca()).getPlaca());

        System.out.println("Buscando b = Esperado: MIT-8008 |  retorno: " + mapa.buscar(b.getPlaca()).getPlaca());

        System.out.println("Buscando c = Esperado: MEI-4665 |  retorno: " + mapa.buscar(c.getPlaca()).getPlaca());

        System.out.println("Buscando d = Esperado: MIO-6668 |  retorno: " + mapa.buscar(d.getPlaca()).getPlaca());

        System.out.println("Buscando e = Esperado: DIO-3333 |  retorno: " + mapa.buscar(e.getPlaca()).getPlaca());

        System.out.println("Buscando f = Esperado: PAO-6472 |  retorno: " + mapa.buscar(f.getPlaca()).getPlaca());

        System.out.println("Buscando g = Esperado: CAO-2890 |  retorno: " + mapa.buscar(g.getPlaca()).getPlaca());

        System.out.println("Buscando h = Esperado: UVA-3939 |  retorno: " + mapa.buscar(h.getPlaca()).getPlaca());

        System.out.println("Buscando i = Esperado: OVO-0000 |  retorno: " + mapa.buscar(i.getPlaca()).getPlaca());

        System.out.println("Buscando j = Esperado: ABC-1234 |  retorno: " + mapa.buscar(j.getPlaca()).getPlaca());


        System.out.println("\n\nMétodo remover()\n");


        System.out.println("Buscando a = Esperado: MJT-7432 |  retorno: " + mapa.remover(a.getPlaca()).getPlaca());

        System.out.println("Buscando b = Esperado: MIT-8008 |  retorno: " + mapa.remover(b.getPlaca()).getPlaca());

        System.out.println("Buscando c = Esperado: MEI-4665 |  retorno: " + mapa.remover(c.getPlaca()).getPlaca());

        System.out.println("Buscando d = Esperado: MIO-6668 |  retorno: " + mapa.remover(d.getPlaca()).getPlaca());

        System.out.println("Buscando e = Esperado: DIO-3333 |  retorno: " + mapa.remover(e.getPlaca()).getPlaca());

        System.out.println("Buscando f = Esperado: PAO-6472 |  retorno: " + mapa.remover(f.getPlaca()).getPlaca());

        System.out.println("Buscando g = Esperado: CAO-2890 |  retorno: " + mapa.remover(g.getPlaca()).getPlaca());

        System.out.println("Buscando h = Esperado: UVA-3939 |  retorno: " + mapa.remover(h.getPlaca()).getPlaca());

        System.out.println("Buscando i = Esperado: OVO-0000 |  retorno: " + mapa.remover(i.getPlaca()).getPlaca());

        System.out.println("Buscando j = Esperado: ABC-1234 |  retorno: " + mapa.remover(j.getPlaca()).getPlaca());

        System.out.println("Buscando j = Esperado: null |  retorno: " + mapa.remover(j.getPlaca()));


        System.out.println("\n\nMétodo quantosElementos()\n");

        System.out.println("Total de elementos = Esperado: 0 | retornado: " + mapa.quantosElementos());
    }
}
