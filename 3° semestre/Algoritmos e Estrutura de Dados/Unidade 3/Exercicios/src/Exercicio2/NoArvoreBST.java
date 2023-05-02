package Exercicio2;

import Exercicio1.NoArvoreBinaria;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 0) {
            if (this.getEsq() == null) {
                this.setEsq(new NoArvoreBST<T>(info));
            } else {
                ((NoArvoreBST<T>)this.getEsq()).inserir(info);
            }
        } else {
            if (this.getDir() == null) {
                this.setDir(new NoArvoreBST<T>(info));
            } else {
                ((NoArvoreBST<T>)this.getDir()).inserir(info);
            }
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (info.equals(this.getInfo())) {
            return this;
        } else {
            if (info.compareTo(this.getInfo()) < 0) {
                if (this.getEsq() == null) {
                    return null;
                }
                return ((NoArvoreBST<T>)this.getEsq()).buscar(info);
            } else {
                if (this.getDir() == null) {
                    return null;
                }
                return ((NoArvoreBST<T>)this.getDir()).buscar(info);
            }
        }
    }

    public String imprime() {
        String str = "<";

        if (this.getInfo() != null) {
            str += this.getInfo().toString();
        }

        if (this.getEsq() != null) {
            str += ((NoArvoreBST<T>)this.getEsq()).imprime();
        } else if (this.getEsq() == null && this.getDir() != null) {
            str += "<>";
        } else {
            str += "";
        }

        if (this.getDir() != null) {
            str += ((NoArvoreBST<T>)this.getDir()).imprime();
        } else if (this.getDir() == null && this.getEsq() != null) {
            str += "<>";
        } else {
            str += "";
        }

        return str += ">";
    }

    public NoArvoreBST<T> identificarUnicoFilho() {
        if (this.getDir() != null) {
            return (NoArvoreBST<T>) this.getDir();
        }
        return (NoArvoreBST<T>) this.getEsq();
    }

    public int getGrau() {
        int grau = 0;
        if (this.getDir() != null) {
            grau++;
        }
        if (this.getEsq() != null) {
            grau++;
        }
        return grau;
    }

    public String toStringOrdered() {
        String str = "";



        return str;
    }
}

