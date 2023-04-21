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

    public void retirar(T info) {
        if (this.getInfo().compareTo(info) < 0) {
            if (this.getEsq() != null) {
                ((NoArvoreBST<T>)this.getEsq()).retirar(info);
            }
        }
        if (this.getInfo().compareTo(info) > 0) {
            if (this.getDir() != null) {
                ((NoArvoreBST<T>)this.getDir()).retirar(info);
            }
        } else {
            if (this.getEsq().getEsq() == null && this.getEsq().getDir() == null) {
                this.retirarFolha(info);
            } else if (this.getEsq().getEsq() != null && this.getEsq().getDir() != null) {
                retirarComDoisNos(info);
            } else {
                retirarComUmNo(info);
            }
        }
    }

    private void retirarFolha(T info) {
        if (this.getEsq().getInfo().equals(info) && this.getEsq() != null) {
            this.setEsq(null);
        } else if (this.getDir().getInfo().equals(info) && this.getDir() != null){
            this.setDir(null);
        } else {
            this.setInfo(null);
        }
    }

    private void retirarComDoisNos(T info) {
        NoArvoreBST<T> noEsq = (NoArvoreBST<T>) this.getEsq();
        NoArvoreBST<T> no = (NoArvoreBST<T>) this.getDir();
        NoArvoreBST<T> novo = (NoArvoreBST<T>) this.getDir();
        novo.setDir(this.getDir());
        while (no.getEsq() != null) {
            if (no.getEsq().getInfo().equals(info) && no.getEsq().getInfo() == null) {
                novo = (NoArvoreBST<T>) no.getEsq();
                no.setEsq(null);
                novo.setEsq(noEsq);
            } else {
                no = (NoArvoreBST<T>) no.getEsq();
            }
        }
    }

    private void retirarComUmNo(T info) {
        if (this.getEsq().getInfo().equals(info)) {
            if (this.getEsq().getEsq() == null) {
                this.setEsq(null);
            } else {
                this.setEsq(this.getEsq().getEsq());
            }
        } else if (this.getDir().getInfo().equals(info)){
            if (this.getDir() == null) {
                this.setDir(null);
            } else {
                this.setDir(this.getDir().getDir());
            }
        } else {
            this.setInfo(null);
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
}
