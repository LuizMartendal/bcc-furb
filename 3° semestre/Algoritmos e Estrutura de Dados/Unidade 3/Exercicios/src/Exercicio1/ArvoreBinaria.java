package Exercicio1;

import Exercicio2.ArvoreBinariaAbstract;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    ArvoreBinaria() {}

    @Override
    public void setRaiz(Exercicio1.NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }
}
