package RefazendoExercicios.Lista6;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() {}

    public void inserir(T info) {
        if (this.vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>) this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
    }
}