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
        if (info.compareTo(this.getInfo()) < 0) {
            if ((NoArvoreBST<T>)this.getEsq() != null) {
                if (((NoArvoreBST<T>)this.getEsq()).getInfo().equals(info)) {
                    if (((NoArvoreBST<T>)this.getEsq()).getEsq() == null && ((NoArvoreBST<T>)this.getEsq()).getDir() == null) {
                        this.setEsq(null);
                    } else if (((NoArvoreBST<T>)this.getEsq()).getEsq() != null && ((NoArvoreBST<T>)this.getEsq()).getDir() != null) {
                        NoArvoreBST<T> noesq = (NoArvoreBST<T>) ((NoArvoreBST<T>)this.getEsq()).getEsq();
                        NoArvoreBST<T> no = (NoArvoreBST<T>) ((NoArvoreBST<T>)this.getEsq()).getDir();
                        NoArvoreBST<T> novo = null;
                        while (true) {
                            if ((NoArvoreBST<T>)((NoArvoreBST<T>)no.getEsq()).getEsq() == null) {
                                novo = ((NoArvoreBST<T>)no.getEsq());
                                novo.setDir((NoArvoreBST<T>) ((NoArvoreBST<T>)this.getEsq()).getDir());
                                no.setEsq(null);
                                novo.setEsq(noesq);
                                this.setEsq(novo);
                                break;
                            }
                            no = ((NoArvoreBST<T>)no.getEsq());
                        }
                    } else {
                        if (((NoArvoreBST<T>)this.getEsq()).getDir() != null) {
                            this.setEsq(((NoArvoreBST<T>)this.getEsq()).getDir());
                        } else {
                            this.setEsq(((NoArvoreBST<T>)this.getEsq()).getEsq());
                        }
                    }
                }
                if (((NoArvoreBST<T>)this.getEsq()) != null) {
                    ((NoArvoreBST<T>)this.getEsq()).retirar(info);
                }
            }
        } else {
            if ((NoArvoreBST<T>)this.getDir() != null) {
                if (((NoArvoreBST<T>)this.getDir()).getInfo().equals(info)) {
                    if (((NoArvoreBST<T>)this.getDir()).getDir() == null && ((NoArvoreBST<T>)this.getDir()).getEsq() == null) {
                        this.setDir(null);
                    } else if (((NoArvoreBST<T>)this.getDir()).getDir() != null && ((NoArvoreBST<T>)this.getDir()).getEsq() != null) {
                        NoArvoreBST<T> noesq = (NoArvoreBST<T>) ((NoArvoreBST<T>)this.getDir()).getEsq();
                        NoArvoreBST<T> no = (NoArvoreBST<T>) ((NoArvoreBST<T>)this.getDir()).getDir();
                        NoArvoreBST<T> novo = null;
                        while (true) {
                            if ((NoArvoreBST<T>)((NoArvoreBST<T>)no.getEsq()).getEsq() == null) {
                                novo = ((NoArvoreBST<T>)no.getEsq());
                                novo.setDir((NoArvoreBST<T>) ((NoArvoreBST<T>)this.getDir()).getDir());
                                no.setEsq(null);
                                novo.setEsq(noesq);
                                this.setDir(novo);
                                break;
                            }
                            no = ((NoArvoreBST<T>)no.getEsq());
                        }
                    } else {
                        if (((NoArvoreBST<T>)this.getDir()).getDir() != null) {
                            this.setDir(((NoArvoreBST<T>)this.getDir()).getDir());
                        } else {
                            this.setDir(((NoArvoreBST<T>)this.getDir()).getEsq());
                        }
                    }
                }
                if (((NoArvoreBST<T>)this.getDir()) != null) {
                    ((NoArvoreBST<T>)this.getDir()).retirar(info);
                }
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
}
