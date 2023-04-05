//Luiz Henrique Martendal
public class ListaEncadeada<T> implements Lista<T>, Comparable<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int qtdElementos;

    @Override
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        if (estaVazia()) {
            ultimo = novo;
        } else {
            novo.setProx(primeiro);
        }
        primeiro = novo;
        qtdElementos++;
    }

    @Override
    public int buscar(T valor) {
        NoLista<T> p = primeiro;

        int contador = 0;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return contador;
            }
            contador++;
            p = p.getProx();
        }

        return -1;
    }

    @Override
    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }

        return false;
    }

    @Override
    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProx();
        }

        if (p != null) {
            if (p.getInfo().equals(primeiro.getInfo())) {
                primeiro = p.getProx();
            }  else {
                anterior.setProx(p.getProx());
            }

            if (p.getInfo().equals(ultimo.getInfo())) {
                ultimo = anterior;
            }

            qtdElementos--;
        }
    }

    @Override
    public String exibir() {
        String str = "[ ";

        NoLista<T> p = primeiro;

        while(p != null) {
            str += p.getInfo() + " ";
            p = p.getProx();
        }

        return str + "]";
    }

    @Override
    public Lista<T> copiar() {
        ListaEncadeada<T> lista = new ListaEncadeada<>();
        NoLista<T> p = primeiro;

        int contador = 0;

        while (contador < qtdElementos) {
            lista.inserir(p.getInfo());
            p = p.getProx();
            contador++;
        }

        return lista;
    }

    @Override
    public void concatenar(Lista<T> outra) {
        if (outra == null) {
            throw new IllegalArgumentException("Lista não pode ser nula.");
        }

        int qtd = 0;
        while (qtd < outra.getTamanho()) {
            T valor = outra.pegar(qtd);
            inserir(valor);
            qtd++;
        }
    }

    @Override
    public int getTamanho() {
        return qtdElementos;
    }

    @Override
    public T pegar(int pos) {
        NoLista<T> p = primeiro;

        int contador = 0;

        while (p != null) {
            if (contador == pos) {
                return p.getInfo();
            }
            p = p.getProx();
            contador++;
        }

        return null;
    }

    @Override
    public Lista<T> dividir() {
        int indice = 0;
        NoLista<T> no = primeiro;
        NoLista<T> ultimoNo = null;
        ListaEncadeada<T> lista = new ListaEncadeada<>();

        while (indice < getTamanho()) {
            if (indice == (getTamanho() / 2) - 1) {
                ultimoNo = no;
            } else if (indice == getTamanho() / 2) {
                lista.primeiro = no;
            } else if (indice == getTamanho() - 1) {
                lista.ultimo = no;
            }
            no = no.getProx();
            indice++;
        }

        ultimoNo.setProx(null);
        ultimo = ultimoNo;
        lista.qtdElementos = getTamanho() / 2 + 1;
        qtdElementos = (getTamanho() / 2);
        return lista;
    }

    public void insereOrdenado(T x) {
        if (x == null) {
            throw new NullPointerException("Null");
        }
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(x);
        if (getTamanho() == 0) {
            this.inserir(x);
        } else {
            if (compareTo(x) == 0) {
                this.inserir(x);
            } else if (compareTo(x) > 0) {
                NoLista<T> p = primeiro;
                NoLista<T> proximo = null;
                NoLista<T> anterior = null;
                for (int i = 0; i < getTamanho(); i++) {
                    if (p.getInfo().toString().compareTo(x.toString()) < 0) {
                        if (p.getProx() != null) {
                            proximo = p.getProx();
                        } else {
                            proximo = null;
                            ultimo = p;
                        }
                        if (i > 0) {
                            anterior.setProx(novo.getProx());
                        } else {

                        }
                        anterior = p;
                        p.setProx(novo);
                        p = proximo;
                        novo.setProx(proximo);
                    }
                }
                qtdElementos++;
            } else if (compareTo(x) < 0) {
                this.inserir(x);
            }
        }
    }

    @Override
    public int compareTo(T o) {
        if (o.toString().compareTo(primeiro.getInfo().toString()) == 0) {
            return 0;
        } else if (o.toString().compareTo(primeiro.getInfo().toString()) > 0) {
            return 1;
        }
        return -1;
    }

    public ListaEncadeada<T> interseccao(ListaEncadeada<T> outraLista) {
        NoLista<T> p = new NoLista<>();
        NoLista<T> outro = new NoLista<>();
        ListaEncadeada<T> nova = new ListaEncadeada<>();
        if (getTamanho() < outraLista.getTamanho()) {
            p = primeiro;
            outro.setInfo(outraLista.pegar(0));
            for (int i = 0; i < getTamanho(); i++) {

                for (int j = 0; j < outraLista.getTamanho(); j++) {
                    if (p.getInfo().toString().compareTo(outro.getInfo().toString()) == 0) {
                        outraLista.inserir(p.getInfo());
                    }
                    outro.setInfo(outraLista.pegar(j));
                }
                p = p.getProx();
            }
        } else {
            p.setInfo(outraLista.pegar(0));
            outro = primeiro;
            int qtd = 0;
            for (int i = 0; i < outraLista.getTamanho(); i++) {
                outro = primeiro;
                p.setInfo(outraLista.pegar(i));
                if (p.getInfo().toString().compareTo(outro.getInfo().toString()) == 0) {
                    qtd++;
                }
                while (outro.getProx() != null) {
                    outro = outro.getProx();
                    if (p.getInfo().toString().compareTo(outro.getInfo().toString()) == 0) {
                        qtd++;
                    }
                }
                if (qtd > 0) {
                    nova.insereOrdenado(p.getInfo());
                }
                qtd = 0;
                System.out.println(nova.exibir());
            }
        }
        return nova;
    }
}
