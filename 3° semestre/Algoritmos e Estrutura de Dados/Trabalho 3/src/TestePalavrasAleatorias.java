public class TestePalavrasAleatorias {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MapaDispersao<String, String> mapa = new MapaDispersao<>(12);


        System.out.println("\n\nMétodo inserir()\n");


        System.out.println("Inserindo ABOLIR = Esperado: true |  retorno: " + mapa.inserir("ABOLIR", "ABOLIR"));
        System.out.println("Inserindo ABOLIR = Esperado: false | retorno: " + mapa.inserir("ABOLIR", "ABOLIR"));

        System.out.println("Inserindo ACEITAR = Esperado: true |  retorno: " + mapa.inserir("ACEITAR", "ACEITAR"));
        System.out.println("Inserindo ACEITAR = Esperado: false | retorno: " + mapa.inserir("ACEITAR", "ACEITAR"));

        System.out.println("Inserindo CLARIDADE = Esperado: true |  retorno: " + mapa.inserir("CLARIDADE", "CLARIDADE"));
        System.out.println("Inserindo CLARIDADE = Esperado: false | retorno: " + mapa.inserir("CLARIDADE", "CLARIDADE"));

        System.out.println("Inserindo DIGNIDADE = Esperado: true |  retorno: " + mapa.inserir("DIGNIDADE", "DIGNIDADE"));
        System.out.println("Inserindo DIGNIDADE = Esperado: false | retorno: " + mapa.inserir("DIGNIDADE", "DIGNIDADE"));

        System.out.println("Inserindo DUELO = Esperado: true |  retorno: " + mapa.inserir("DUELO", "DUELO"));
        System.out.println("Inserindo DUELO = Esperado: false | retorno: " + mapa.inserir("DUELO", "DUELO"));

        System.out.println("Inserindo FAZENDA = Esperado: true |  retorno: " + mapa.inserir("FAZENDA", "FAZENDA"));
        System.out.println("Inserindo FAZENDA = Esperado: false | retorno: " + mapa.inserir("FAZENDA", "FAZENDA"));

        System.out.println("Inserindo GELEIRA = Esperado: true |  retorno: " + mapa.inserir("GELEIRA", "GELEIRA"));
        System.out.println("Inserindo GELEIRA = Esperado: false | retorno: " + mapa.inserir("GELEIRA", "GELEIRA"));

        System.out.println("Inserindo HIGIENE = Esperado: true |  retorno: " + mapa.inserir("HIGIENE", "HIGIENE"));
        System.out.println("Inserindo HIGIENE = Esperado: false | retorno: " + mapa.inserir("HIGIENE", "HIGIENE"));

        System.out.println("Inserindo LARANJA = Esperado: true |  retorno: " + mapa.inserir("LARANJA", "LARANJA"));
        System.out.println("Inserindo LARANJA = Esperado: false | retorno: " + mapa.inserir("LARANJA", "LARANJA"));

        System.out.println("Inserindo MARTE = Esperado: true |  retorno: " + mapa.inserir("MARTE", "MARTE"));
        System.out.println("Inserindo MARTE = Esperado: false | retorno: " + mapa.inserir("MARTE", "MARTE"));

        System.out.println("Inserindo OBEDECER = Esperado: true |  retorno: " + mapa.inserir("OBEDECER", "OBEDECER"));
        System.out.println("Inserindo OBEDECER = Esperado: false | retorno: " + mapa.inserir("OBEDECER", "OBEDECER"));

        System.out.println("Inserindo POETA = Esperado: true |  retorno: " + mapa.inserir("POETA", "POETA"));
        System.out.println("Inserindo POETA = Esperado: false | retorno: " + mapa.inserir("POETA", "POETA"));


        System.out.println("\n\nMétodo quantosElementos()\n");

        System.out.println("Total de elementos = Esperado: 12 | retornado: " + mapa.quantosElementos());


        System.out.println("\n\nMétodo buscar()\n");


        System.out.println("Buscando ABOLIR = Esperado: ABOLIR |  retorno: " + mapa.buscar("ABOLIR"));

        System.out.println("Buscando ACEITAR = Esperado: ACEITAR |  retorno: " + mapa.buscar("ACEITAR"));

        System.out.println("Buscando CLARIDADE = Esperado: CLARIDADE |  retorno: " + mapa.buscar("CLARIDADE"));

        System.out.println("Buscando DIGNIDADE = Esperado: DIGNIDADE |  retorno: " + mapa.buscar("DIGNIDADE"));

        System.out.println("Buscando DUELO = Esperado: DUELO |  retorno: " + mapa.buscar("DUELO"));

        System.out.println("Buscando FAZENDA = Esperado: FAZENDA |  retorno: " + mapa.buscar("FAZENDA"));

        System.out.println("Buscando GELEIRA = Esperado: GELEIRA |  retorno: " + mapa.buscar("GELEIRA"));

        System.out.println("Buscando HIGIENE = Esperado: HIGIENE |  retorno: " + mapa.buscar("HIGIENE"));

        System.out.println("Buscando LARANJA = Esperado: LARANJA |  retorno: " + mapa.buscar("LARANJA"));

        System.out.println("Buscando MARTE = Esperado: MARTE |  retorno: " + mapa.buscar("MARTE"));

        System.out.println("Buscando OBEDECER = Esperado: OBEDECER |  retorno: " + mapa.buscar("OBEDECER"));

        System.out.println("Buscando POETA = Esperado: POETA |  retorno: " + mapa.buscar("POETA"));


        System.out.println("\n\nMétodo remover()\n");


        System.out.println("Buscando ABOLIR = Esperado: ABOLIR |  retorno: " + mapa.remover("ABOLIR"));

        System.out.println("Buscando ACEITAR = Esperado: ACEITAR |  retorno: " + mapa.remover("ACEITAR"));

        System.out.println("Buscando CLARIDADE = Esperado: CLARIDADE |  retorno: " + mapa.remover("CLARIDADE"));

        System.out.println("Buscando DIGNIDADE = Esperado: DIGNIDADE |  retorno: " + mapa.remover("DIGNIDADE"));

        System.out.println("Buscando DUELO = Esperado: DUELO |  retorno: " + mapa.remover("DUELO"));

        System.out.println("Buscando FAZENDA = Esperado: FAZENDA |  retorno: " + mapa.remover("FAZENDA"));

        System.out.println("Buscando GELEIRA = Esperado: GELEIRA |  retorno: " + mapa.remover("GELEIRA"));

        System.out.println("Buscando HIGIENE = Esperado: HIGIENE |  retorno: " + mapa.remover("HIGIENE"));

        System.out.println("Buscando LARANJA = Esperado: LARANJA |  retorno: " + mapa.remover("LARANJA"));

        System.out.println("Buscando MARTE = Esperado: MARTE |  retorno: " + mapa.remover("MARTE"));

        System.out.println("Buscando OBEDECER = Esperado: OBEDECER |  retorno: " + mapa.remover("OBEDECER"));

        System.out.println("Buscando POETA = Esperado: POETA |  retorno: " + mapa.remover("POETA"));


        System.out.println("\n\nMétodo quantosElementos()\n");

        System.out.println("Total de elementos = Esperado: 0 | retornado: " + mapa.quantosElementos());
    }
}