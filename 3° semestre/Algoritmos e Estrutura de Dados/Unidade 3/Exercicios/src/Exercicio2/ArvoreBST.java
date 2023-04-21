package Exercicio2;

public class ArvoreBST<T extends Comparable<T>>  extends ArvoreBinariaAbstract<T> {

    public ArvoreBST() { }

    public void inserir(T info) {
        if (this.getRaiz() == null) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>)this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        return ((NoArvoreBST<T>)this.getRaiz()).buscar(info);
    }

    public void retirar(T info) {
        if (this.getRaiz() != null) {
            if (info.equals(((NoArvoreBST<T>) getRaiz()).getInfo()) && ((NoArvoreBST<T>) getRaiz()).getEsq() == null && ((NoArvoreBST<T>) getRaiz()).getDir() == null) {
                this.setRaiz(null);
            } else {
                ((NoArvoreBST<T>)this.getRaiz()).retirar(info);
            }
        }
    }

    @Override
    public String toString() {
        if (((NoArvoreBST<T>)this.getRaiz()) == null) {
            return "<>";
        }
        return ((NoArvoreBST<T>)this.getRaiz()).imprime();
    }
}
