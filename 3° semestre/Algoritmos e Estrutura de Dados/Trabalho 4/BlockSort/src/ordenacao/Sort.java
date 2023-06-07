package ordenacao;

public interface Sort<T extends Comparable<T>>{
    void sort(T[] vetor);
}