package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class BlockSort<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        Integer[] array = new Integer[100000];
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            int value = Math.abs(r.nextInt(20));
            array[i] = value;
        }

        //System.out.println("Array antes da ordenação: " + Arrays.toString(array));

        BlockSort<Integer> blockSort = new BlockSort<>();

        long tempoInicial = System.currentTimeMillis();

        blockSort.sort(array);
        //blockSort.insertionSort(array); // A diferença de tempo de execução entre os dois usando vetores maiores é muito grande

        long tempoFinal = System.currentTimeMillis();
        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //System.out.println("Array após a ordenação: " + Arrays.toString(array));
    }

    public void sort(T[] vetor) {
        if (vetor == null || vetor.length <= 1) {
            return;
        }

        int tamanhoDoBloco = (int) Math.sqrt(vetor.length);
        int numBlocos = (int) Math.ceil((double) vetor.length / tamanhoDoBloco);

        T[][] blocos = (T[][]) new Comparable[numBlocos][];
        for (int i = 0; i < numBlocos; i++) {
            int inicio = i * tamanhoDoBloco;
            int fim = Math.min(inicio + tamanhoDoBloco, vetor.length);
            int tamanho = fim - inicio;
            blocos[i] = (T[]) new Comparable[tamanho];
            System.arraycopy(vetor, inicio, blocos[i], 0, tamanho);
        }

        // Ordena cada bloco separadamente
        for (T[] bloco : blocos) {
            insertionSort(bloco);
        }

        // Mescla os blocos ordenados
        int[] indexes = new int[numBlocos];
        for (int i = 0; i < vetor.length; i++) {
            int indexComMenorValorAtual = encontrarIndexComMenorValorAtual(blocos, indexes);
            vetor[i] = blocos[indexComMenorValorAtual][indexes[indexComMenorValorAtual]];
            indexes[indexComMenorValorAtual]++;
        }
    }

    private void insertionSort(T[] vetor) {
        int n = vetor.length;
        for (int i = 1; i < n; ++i) {
            T key = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].compareTo(key) > 0) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = key;
        }
    }

    private int encontrarIndexComMenorValorAtual(T[][] blocos, int[] indexes) {
        int indexDoMenorBloco = -1;
        for (int i = 0; i < blocos.length; i++) {
            if (indexes[i] < blocos[i].length && (indexDoMenorBloco == -1 ||
                blocos[i][indexes[i]].compareTo(blocos[indexDoMenorBloco][indexes[indexDoMenorBloco]]) < 0)) {
                indexDoMenorBloco = i;
            }
        }
        return indexDoMenorBloco;
    }
}
