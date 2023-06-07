import java.util.Arrays;
import java.util.Random;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();

        Integer[] array = new Integer[1000];
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            int value = r.nextInt();
            array[i] = value;
        }

        System.out.println("Array antes da ordenação: " + Arrays.toString(array));

        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(array);

        System.out.println("Array após a ordenação: " + Arrays.toString(array));

        long tempoFinal = System.currentTimeMillis();
        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }

    @Override
    public void sort(T[] v) {
        int n = v.length;
        T[] vetor = v;
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
}
