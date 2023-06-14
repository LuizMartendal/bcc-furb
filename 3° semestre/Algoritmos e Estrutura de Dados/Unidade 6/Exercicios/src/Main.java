import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Integer[] vetor = new Integer[20];

        Random random = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(20);
        }

        AlgoritmosDeBusca<Integer> algoritmo = new AlgoritmosDeBusca<>();

        System.out.println(algoritmo.buscaLinear(vetor, vetor[vetor.length - 1]));
        System.out.println(algoritmo.buscaBinaria(vetor, vetor[vetor.length - 1]));
    }
}