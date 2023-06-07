package ordenacao;

public class BlockSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        Integer[] vetor = new Integer[5];
        Sort<Integer> algoritmo = new BlockSort<>();
        vetor[0] = 5;
        vetor[1] = 4;
        vetor[2] = 3;
        vetor[3] = 2;
        vetor[4] = 1;
        algoritmo.sort(vetor);
        System.out.println();
    }

    @Override
    public void sort(T[] arr) {
        int n = arr.length;

        // Encontra o menor e o maior elemento no array
        T min = findMin(arr);
        T max = findMax(arr);

        // Define o tamanho do bloco
        int blockSize = (int) Math.sqrt(n);

        // Calcula o número de blocos necessários
        int blockCount = (int) Math.ceil((double) (max.compareTo(min) + 1) / blockSize);

        // Inicializa os arrays para armazenar informações sobre cada bloco
        T[] blockMin = (T[]) new Comparable[blockCount];
        T[] blockMax = (T[]) new Comparable[blockCount];
        int[] blockSizes = new int[blockCount];

        // Define os valores iniciais dos arrays
        for (int i = 0; i < blockCount; i++) {
            blockMin[i] = max;
            blockMax[i] = min;
        }

        // Divide os elementos em blocos
        for (int i = 0; i < n; i++) {
            int blockIndex = (arr[i].compareTo(min)) / blockSize;
            blockSizes[blockIndex]++;
            blockMin[blockIndex] = min(blockMin[blockIndex], arr[i]);
            blockMax[blockIndex] = max(blockMax[blockIndex], arr[i]);
        }

        // Calcula os offsets para cada bloco
        int[] blockOffsets = new int[blockCount];
        int offset = 0;

        for (int i = 0; i < blockCount; i++) {
            blockOffsets[i] = offset;
            offset += blockSizes[i];
        }

        // Cria um array auxiliar para armazenar a lista ordenada
        T[] sortedArr = (T[]) new Comparable[n];

        // Coloca os elementos nos blocos correspondentes no array auxiliar
        for (int i = 0; i < n; i++) {
            int blockIndex = (arr[i].compareTo(min)) / blockSize;
            int blockOffset = blockOffsets[blockIndex];
            int index = blockOffset++;
            sortedArr[index] = arr[i];
        }

        // Ordena cada bloco separadamente usando o algoritmo Insertion Sort
        for (int i = 0; i < blockCount; i++) {
            insertionSort(sortedArr, blockOffsets[i], blockOffsets[i] + blockSizes[i]);
        }

        // Copia os elementos ordenados de volta para o array original
        System.arraycopy(sortedArr, 0, arr, 0, n);
    }

    private T findMin(T[] arr) {
        T min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }

    private T findMax(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    private T min(T a, T b) {
        return (a.compareTo(b) < 0) ? a : b;
    }

    private T max(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }

    /*pika*/
    private void insertionSort(T[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
