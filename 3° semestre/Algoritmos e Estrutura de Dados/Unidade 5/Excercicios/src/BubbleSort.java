public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        Sort<Integer> algoritmo = new BubbleSort<>();

        Integer[] vetor = new Integer[10];
        vetor[0] = 10;
        vetor[1] = 9;
        vetor[2] = 8;
        vetor[3] = 7;
        vetor[4] = 6;
        vetor[5] = 5;
        vetor[6] = 4;
        vetor[7] = 3;
        vetor[8] = 2;
        vetor[9] = 1;

        System.out.println("Vetor antes da ordenação = ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();

        algoritmo.sort(vetor);
        System.out.println("Vetor ordenador = ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
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
