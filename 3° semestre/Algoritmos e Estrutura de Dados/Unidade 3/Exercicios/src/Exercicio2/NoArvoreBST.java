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
        while (true) {
            if (info.compareTo(this.getInfo()) < 0) {
                if (this.getEsq() != null) {
                    if (!this.getEsq().getInfo().equals(info)) {
                        ((NoArvoreBST<T>) this.getEsq()).retirar(info);
                        break;
                    }

                    if (this.getEsq().getEsq() == null && this.getEsq().getDir() == null) {
                        if (this.getEsq().getInfo().equals(info)) {
                            this.setEsq(null);
                        }
                        break;
                    } else if (this.getEsq().getEsq() != null && this.getEsq().getDir() != null) {
                        retirarComDoisNos(info, "esq");
                        break;
                    } else {
                        retirarComUmNo(info);
                        break;
                    }
                }
            }
            if (info.compareTo(this.getInfo()) >= 0) {
                if (this.getDir() != null) {
                    if (!this.getDir().getInfo().equals(info)) {
                        ((NoArvoreBST<T>) this.getDir()).retirar(info);
                        break;
                    }

                    if (this.getDir().getEsq() == null && this.getDir().getDir() == null) {
                        if (this.getDir().getInfo().equals(info)) {
                            this.setDir(null);
                        }
                        break;
                    } else if (this.getDir().getEsq() != null && this.getDir().getDir() != null) {
                        retirarComDoisNos(info, "dir");
                        break;
                    } else {
                        retirarComUmNo(info);
                        break;
                    }
                }
            }
        }
    }

    private void retirarComDoisNos(T info, String lado) {
        NoArvoreBST<T> noEsq = null;
        NoArvoreBST<T> no = null;
        NoArvoreBST<T> novo = null;
        if (lado.equals("dir")) {
            noEsq = (NoArvoreBST<T>) this.getDir().getEsq();
            no = (NoArvoreBST<T>) this.getDir().getDir();
            novo = (NoArvoreBST<T>) this.getDir().getDir();
        } else {
            noEsq = (NoArvoreBST<T>) this.getEsq().getEsq();
            no = (NoArvoreBST<T>) this.getEsq().getDir();
            novo = (NoArvoreBST<T>) this.getEsq().getDir();
        }

        if (no.getEsq() == null) {
            novo.setEsq(noEsq);
            if (lado.equals("dir")) {
                this.setDir(novo);
            } else {
                this.setEsq(novo);
            }
        } else {
            while (no.getEsq() != null) {
                if (no.getEsq().getInfo().equals(info) && no.getEsq().getEsq() == null) {
                    novo = (NoArvoreBST<T>) no.getEsq();
                    no.setEsq(null);
                    novo.setEsq(noEsq);
                    break;
                } else {
                    no = (NoArvoreBST<T>) no.getEsq();
                }
            }
            if (lado.equals("dir")) {
                novo.setDir(this.getDir().getDir());
                this.setDir(novo);
            } else {
                novo.setDir(this.getEsq().getDir());
                this.setEsq(novo);
            }
        }
    }

    private void retirarComUmNo(T info) {
        if (this.getEsq() != null) {
            if (this.getEsq().getInfo().equals(info)) {
                if (this.getEsq().getEsq() == null) {
                    this.setEsq(null);
                } else {
                    this.setEsq(this.getEsq().getEsq());
                }
            }
        }
        if (this.getDir() != null){
            if (this.getDir().getInfo().equals(info)) {
                if (this.getDir().getDir() == null) {
                    this.setDir(null);
                } else {
                    this.setDir(this.getDir().getDir());
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
