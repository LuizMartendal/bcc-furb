package Exercicio2;

import Exercicio1.Lista;

public class TesteListaDinamica {

    public static void main(String[] args) {
        Lista<Integer> lista = new ListaEncadeada<>();
        System.out.println("Lista original vazia. Tamanho = "+lista.getTamanho());
        lista.inserir(50);
        lista.inserir(-15);
        lista.inserir(12);
        lista.inserir(28);
        lista.inserir(91);
        System.out.println("Lista original = "+lista.exibir());
        System.out.println("Lista original. Tamanho = "+lista.getTamanho());
        System.out.println("Buscar 50 = "+lista.buscar(50));
        System.out.println("Buscar 91 = "+lista.buscar(91));
        System.out.println("Buscar 100 = "+lista.buscar(100));
        System.out.println("Pegar pela posição 2 = "+lista.pegar(2));
        lista.retirar(100);
        lista.retirar(50);
        System.out.println("Lista após retiradas = "+lista.exibir());
        System.out.println("Tamanho = "+lista.getTamanho());
        System.out.println("Buscar 50 = "+lista.buscar(50));
        System.out.println("Buscar 91 = "+lista.buscar(91));
        System.out.println("Pegar pela posição 2 = "+lista.pegar(2));
        lista.retirar(91);
        System.out.println("Buscar após retirada 91 = "+lista.buscar(91));
        lista.inserir(150);
        System.out.println("Lista após inserção = "+lista.exibir());
        System.out.println("Tamanho = "+lista.getTamanho());
        System.out.println("Pegar pela posição 2 = "+lista.pegar(2));
        //System.out.println("Pegar pela posição 20 = "+lista.pegar(20));

        Lista<Integer> lista1 = new ListaEncadeada<>();
        lista1.inserir(50);
        lista1.inserir(-15);
        lista1.inserir(12);
        lista1.inserir(28);
        lista1.inserir(91);
        lista1.inserir(57);
        lista1.inserir(25);
        System.out.println("Lista 1 = "+lista1.exibir());
        Lista<Integer> lista2 = lista1.dividir();
        System.out.println("Lista 1 = "+lista1.exibir());
        System.out.println("Lista 1 tam = "+lista1.getTamanho());
        System.out.println("Lista 2 = "+lista2.exibir());
        System.out.println("Lista 2 tam = "+lista2.getTamanho());
        lista1.concatenar(lista2);
        System.out.println("Lista 1 = " + lista1.exibir());
    }

}