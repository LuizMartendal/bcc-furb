import java.util.Arrays;
import java.util.Random;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        Integer[] array = new Integer[100000];
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            int value = r.nextInt();
            array[i] = value;
        }

        //System.out.println("Array antes da ordenação: " + Arrays.toString(array));

        long tempoInicial = System.currentTimeMillis();
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(array);
        //bubbleSort.bubbleSortRescursivo(array.length, array);

        long tempoFinal = System.currentTimeMillis();
        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //System.out.println("Array após a ordenação: " + Arrays.toString(array));
    }

    @Override
    public void sort(T[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n; i++) {
            boolean troca = false;
            for (int j = 0; j < n - i - 1; j++) {
                T proximo = vetor[j + 1];
                if (proximo != null) {
                    if (vetor[j].compareTo(proximo) > 0) {
                        vetor[j + 1] = vetor[j];
                        vetor[j] = proximo;
                        troca = true;
                    }
                }
            }
            if (!troca) {
                break;
            }
        }
    }

    public void bubbleSortRescursivo(int n, T[] vetor) {
        boolean troca = false;

        for (int j = 0; j < n - 1; j++) {
            if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                T intermediario = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = intermediario;
                troca = true;
            }
        }
        if (troca) {
            bubbleSortRescursivo(n, vetor);
        }
    }
}
