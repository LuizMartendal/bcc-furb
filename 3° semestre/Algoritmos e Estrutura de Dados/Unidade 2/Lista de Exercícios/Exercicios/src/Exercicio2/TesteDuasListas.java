package Exercicio2;

import Exercicio1.Lista;
import Exercicio1.ListaEstatica;

public class TesteDuasListas {
    public static void main(String[] args){
        System.out.println("TESTE COM LISTAS DE AMBAS AS CLASSES");
        System.out.println("\nJoao e Maria vao ao supermercado, com uma unica lista de compras.");
        Lista<String> lista = new ListaEncadeada<>();
        lista.inserir("arroz");
        lista.inserir("batata");
        lista.inserir("cafe");
        lista.inserir("detergente");
        System.out.println("Esperado arroz, batata, cafe, detergente = "+lista.exibir());
        System.out.println("\nMaria lembrou que tambem precisava de fosforos e anotou na lista.");
        lista.inserir("fosforos");
        System.out.println("Esperado arroz, batata, cafe, detergente, fosforos = "+lista.exibir());

        System.out.println("Joao passou na frente da gondola dos cereais e verificou se arroz e feijao estavam na lista");
        int pos = lista.buscar("arroz");
        System.out.println("Esperado 0 = "+pos);
        pos = lista.buscar("feijao");
        System.out.println("Esperado -1 = "+pos);
        System.out.println("Como arroz estava na lista, pegou arroz e riscou da lista.");
        lista.retirar("arroz");
        System.out.println("Agora a lista tem (Esperado batata, cafe, detergente, fosforos) = "+lista.exibir());

        System.out.println("\nMaria lembrou que ja havia outra lista de supermercado, que estava em seu bolso:");
        Lista<String> lista2 = new ListaEstatica<>();
        lista2.inserir("tomate");
        lista2.inserir("cebola");
        lista2.inserir("cenoura");
        System.out.println("Lista 2(Array) Esperado tomate,cebola,cenoura = "+lista2.exibir());
        System.out.println("Como estava na frente da gondola da cebola, ja pegou e tirou da lista, mas lembrou que tambem precisava de ovos:");
        lista2.retirar("cebola");
        lista2.inserir("ovos");
        System.out.println("Esperado tomate,cenoura,ovos = "+lista2.exibir());

        System.out.println("\nJoao fez uma copia de sua lista");
        Lista<String> lista3, lista3A;
        lista3 = lista.copiar();
        System.out.println("Lista copiada de Joao Esperado batata,cafe,detergente,fosforos = "+lista3.exibir());
        System.out.println("\nComo estavam com pressa, resolveram juntar as duas listas");
        lista.concatenar(lista2);
        System.out.println("Lista Joao+Maria Esperado batata,cafe,detergente,fosforos,tomate,cenoura,ovos = "+lista.exibir());
        lista2.concatenar(lista3);
        System.out.println("Lista Maria+Joao Esperado tomate,cenoura,ovos,batata,cafe,detergente,fosforos = "+lista2.exibir());

        System.out.println("E ai fizeram uma confusao, juntando tudo de novo... \nEsperado tomate,cenoura,ovos,batata,cafe,detergente,fosforos, batata,cafe,detergente,fosforos,tomate,cenoura,ovos");
        lista2.concatenar(lista);
        System.out.println("Nova Lista = "+lista2.exibir());

        System.out.println("\nPara resolver o problema, dividiram a lista ");
        Lista<String> lista4, lista5;
        lista4 = lista2.dividir();
        System.out.println("Joao (dividida) Esperado = batata,cafe,detergente,fosforos,tomate,cenoura,ovos\n"+lista4.exibir());
        System.out.println("Maria (divisao da Nova lista) Esperado = tomate,cenoura,ovos,batata,cafe,detergente,fosforos\n"+lista2.exibir());
        System.out.println("E Maria anotou mais uma coisa: cha");
        lista2.inserir("cha");
        System.out.println("Lista Maria Esperado = tomate,cenoura,ovos,batata,cafe,detergente,fosforos,cha\n"+lista2.exibir());

        System.out.println("E Maria entregou uma copia da lista para Joao Esperado = tomate,cenoura,ovos,batata,cafe,detergente,fosforos,cha");
        lista5 = lista2.copiar();
        System.out.println("Joao copiada de Maria = "+lista5.exibir());

        System.out.println("Por fim, Maria ainda acrescenta em sua lista mais um item: esponja\nEsperado = tomate,cenoura,ovos,batata,cafe,detergente,fosforos,cha,esponja");
        lista2.inserir("esponja");
        System.out.println("Lista Maria = "+lista2.exibir());
        System.out.println("Mas do Joao permanece a mesma\nEsperado = tomate,cenoura,ovos,batata,cafe,detergente,fosforos,cha,\n\t\t "+lista5.exibir());

    }
}