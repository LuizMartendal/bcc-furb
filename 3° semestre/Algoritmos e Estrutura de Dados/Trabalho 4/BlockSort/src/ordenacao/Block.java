// Luiz Henrique Martendal; Guilherme Moll; Gustavo W. Antunes;

package ordenacao;

//import java.util.Arrays;
import java.util.Random;

public class Block<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] vetor) {
        if (vetor == null || vetor.length <= 1) {
            return;
        }

        int tamanhoDoBloco = (int) Math.sqrt(vetor.length);
        int numBlocos = (int) Math.ceil((double) vetor.length / tamanhoDoBloco);

        // Separa os elementos em blocos
        T[][] blocos = (T[][]) new Comparable[numBlocos][];
        for (int i = 0; i < numBlocos; i++) {
            int inicio = i * tamanhoDoBloco;
            int fim = Math.min(inicio + tamanhoDoBloco, vetor.length);
            int tamanho = fim - inicio;
            blocos[i] = (T[]) new Comparable[tamanho];
            System.arraycopy(vetor, inicio, blocos[i], 0, tamanho);
            quickSort(blocos[i], 0, blocos[i].length - 1);
        }

        // Mescla os blocos ordenados
        int[] indexes = new int[numBlocos];
        for (int i = 0; i < vetor.length; i++) {
            int indexComMenorValorAtual = encontrarIndexComMenorValorAtual(blocos, indexes);
            vetor[i] = blocos[indexComMenorValorAtual][indexes[indexComMenorValorAtual]];
            indexes[indexComMenorValorAtual]++;
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

    public void quickSort(T[] vetor, int menorPosicao, int maiorPosicao) {
        if (menorPosicao < maiorPosicao) {
            int posicaoDoPivo = particionar(vetor, menorPosicao, maiorPosicao);

            quickSort(vetor, menorPosicao, posicaoDoPivo -1);
            quickSort(vetor, posicaoDoPivo, maiorPosicao);
        }
    }

    private int particionar(T[] vetor, int menorPosicao, int maiorPosicao) {
        T pivo = vetor[maiorPosicao];

        int i = menorPosicao - 1;

        for (int j = menorPosicao; j < maiorPosicao; j++) {
            if (vetor[j].compareTo(pivo) <= 0) {
                i++;
                swap(vetor, i, j);
            }
        }

        swap(vetor, i + 1, maiorPosicao);

        return i + 1;
    }

    private void swap(T[] vetor, int i, int j) {
        T intermediador = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = intermediador;
    }

    public void insertionSort(T[] vetor) {
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

    public void bubbleSort(T[] vetor) {
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho; i++) {
            boolean troca = false;
            for (int j = 0; j < tamanho - 1; j++) {
                T intermediador = vetor[j + 1];
                if (intermediador != null) {
                    if (vetor[j].compareTo(intermediador) > 0) {
                        vetor[j + 1] = vetor[j];
                        vetor[j] = intermediador;
                        troca = true;
                    }
                }
            }
            if (!troca) {
                break;
            }
        }
    }

    public void bogoSort(T[] vetor) {
        while (!eOrdenado(vetor)) {
            shuffle(vetor);
        }
    }

    private void shuffle(T[] vetor) {
        Random rand = new Random();
        for (int i = vetor.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            T temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }
    }

    private boolean eOrdenado(T[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] blockSortArray = new Integer[1000000];
        Integer[] quickSortArray = new Integer[blockSortArray.length];
        Integer[] insertionSortArray = new Integer[blockSortArray.length];
        Integer[] bubbleSortArray = new Integer[blockSortArray.length];
        Integer[] bogoSortArray = new Integer[blockSortArray.length];
        Random r = new Random();

        for (int i = 0; i < blockSortArray.length; i++) {
            int value = Math.abs(r.nextInt(20));
            blockSortArray[i] = value;
        }

        System.arraycopy(blockSortArray, 0, quickSortArray, 0, blockSortArray.length);
        System.arraycopy(blockSortArray, 0, insertionSortArray, 0, blockSortArray.length);
        System.arraycopy(blockSortArray, 0, bubbleSortArray, 0, blockSortArray.length);
        System.arraycopy(blockSortArray, 0, bogoSortArray, 0, blockSortArray.length);

        //System.out.println("Array antes da ordenação: " + Arrays.toString(blockSortArray));

        Block<Integer> blockSort = new Block<>();

        long tempoInicialBlockSort = System.currentTimeMillis();

        blockSort.sort(blockSortArray);

        long tempoFinalBlockSort = System.currentTimeMillis();
        System.out.print("Tempo de execução do BlockSort = ");
        System.out.printf("%.3f ms%n", (tempoFinalBlockSort - tempoInicialBlockSort) / 1000d);

        long tempoInicialQuickSort = System.currentTimeMillis();

        blockSort.quickSort(quickSortArray, quickSortArray[0], quickSortArray.length -1);

        long tempoFinalQuickSort = System.currentTimeMillis();
        System.out.print("Tempo de execução do QuickSort = ");
        System.out.printf("%.3f ms%n", (tempoFinalQuickSort - tempoInicialQuickSort) / 1000d);

        long tempoInicialInsertionSort = System.currentTimeMillis();

        blockSort.insertionSort(insertionSortArray);

        long tempoFinalInsertionSort = System.currentTimeMillis();
        System.out.print("Tempo de execução do InsertionSort = ");
        System.out.printf("%.3f ms%n", (tempoFinalInsertionSort - tempoInicialInsertionSort) / 1000d);

        long tempoInicialBubbleSort = System.currentTimeMillis();

        blockSort.bubbleSort(bubbleSortArray);

        long tempoFinalBubbleSort = System.currentTimeMillis();
        System.out.print("Tempo de execução do BubbleSort = ");
        System.out.printf("%.3f ms%n", (tempoFinalBubbleSort - tempoInicialBubbleSort) / 1000d);

        long tempoInicialBogoSort = System.currentTimeMillis();

        blockSort.bogoSort(bogoSortArray);

        long tempoFinalBogoSort = System.currentTimeMillis();
        System.out.print("Tempo de execução do BubbleSort = ");
        System.out.printf("%.3f ms%n", (tempoFinalBogoSort - tempoInicialBogoSort) / 1000d);

        //System.out.println("Array após a ordenação: " + Arrays.toString(blockSortArray));
    }
}
