package RefazendoExercicios;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() {}

    public void inserir(T info) {
        if (vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>) this.raiz).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (vazia()) {
            return null;
        }

        return ((NoArvoreBST<T>) this.raiz).buscar(info);
    }

    public void retirar(T info) {

    }
}
