import arvores.Arvore;
import arvores.ArvoreBST;
import buscas.AlgoritmosDeBusca;

public class Main {
    public static void main(String[] args) {
        Integer[] vetor = new Integer[7];

        vetor[0] = 10;
        vetor[1] = 20;
        vetor[2] = 30;
        vetor[3] = 40;
        vetor[4] = 50;
        vetor[5] = 60;
        vetor[6] = 70;

        AlgoritmosDeBusca<Integer> algoritmosDeBusca = new AlgoritmosDeBusca<>();

        ArvoreBST<Integer> arvore = algoritmosDeBusca.criarArvoreBST(vetor);

        System.out.println(arvore);
    }
}