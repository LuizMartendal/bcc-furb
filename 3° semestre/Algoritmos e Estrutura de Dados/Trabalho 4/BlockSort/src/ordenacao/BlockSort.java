package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class BlockSort<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();

        Integer[] array = new Integer[1000];
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            int value = r.nextInt();
            array[i] = value;
        }

        System.out.println("Array antes da ordenação: " + Arrays.toString(array));

        BlockSort<Integer> blockSort = new BlockSort<>();
        blockSort.sort(array);

        System.out.println("Array após a ordenação: " + Arrays.toString(array));

        long tempoFinal = System.currentTimeMillis();
        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        T minValue = findMinValue(array);
        T maxValue = findMaxValue(array);

        int blockSize = (int) Math.sqrt(array.length); // Tamanho do bloco

        int blockCount = (maxValue.compareTo(minValue) / blockSize) + 1; // Número de blocos

        Object[] blocks = new Object[blockCount]; // Array de blocos

        // Distribuir os elementos nos blocos
        for (T value : array) {
            int blockIndex = (value.compareTo(minValue) / blockSize) % blockCount;

            if (blocks[blockIndex] == null) {
                blocks[blockIndex] = new Object[array.length];
            }

            Object[] block = (Object[]) blocks[blockIndex];
            int insertionIndex = findInsertionIndex(block, value);

            shiftElementsRight(block, insertionIndex);

            block[insertionIndex] = value;
        }

        // Ordenar cada bloco individualmente (usando insertion sort)
        for (Object block : blocks) {
            if (block != null) {
                Object[] sortedBlock = (Object[]) block;
                int sortedBlockLength = findSortedBlockLength(sortedBlock);

                T[] sortedArray = createGenericArray(sortedBlockLength);
                for (int i = 0; i < sortedBlockLength; i++) {
                    sortedArray[i] = (T) sortedBlock[i];
                }

                insertionSort(sortedArray);

                for (int i = 0; i < sortedBlockLength; i++) {
                    sortedBlock[i] = sortedArray[i];
                }
            }
        }

        // Concatenar os blocos ordenados
        int arrayIndex = 0;

        for (Object block : blocks) {
            if (block != null) {
                Object[] sortedBlock = (Object[]) block;

                for (Object value : sortedBlock) {
                    if (value != null) {
                        array[arrayIndex] = (T) value;
                        arrayIndex++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private T findMinValue(T[] array) {
        T minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(minValue) < 0) {
                minValue = array[i];
            }
        }

        return minValue;
    }

    private T findMaxValue(T[] array) {
        T maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(maxValue) > 0) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }

    private int findInsertionIndex(Object[] block, T value) {
        int insertionIndex = 0;

        while (insertionIndex < block.length && block[insertionIndex] != null
                && ((T) block[insertionIndex]).compareTo(value) < 0) {
            insertionIndex++;
        }

        return insertionIndex;
    }

    private void shiftElementsRight(Object[] block, int startIndex) {
        for (int i = block.length - 1; i > startIndex; i--) {
            block[i] = block[i - 1];
        }
    }

    private int findSortedBlockLength(Object[] block) {
        int length = 0;

        for (Object value : block) {
            if (value != null) {
                length++;
            } else {
                break;
            }
        }

        return length;
    }

    private T[] createGenericArray(int length) {
        return (T[]) new Comparable[length];
    }

    private void insertionSort(T[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
}
