public class ListaEncadeada<T> implements Lista<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int qtdeElementos;

    private void setPrimeiro(NoLista<T> novoPrimeiro) {
        primeiro = novoPrimeiro;
    }

    private void setUltimo(NoLista<T> novoUltimo) {
        ultimo = novoUltimo;
    }

    private void setQtdeElementos(int novaQtdeElementos) {
        qtdeElementos = novaQtdeElementos;
    }

    @Override
    public boolean estaVazia() {
        return primeiro == null;
    }

    @Override
    public int buscar(T valor) {
        NoLista<T> no = primeiro;
        int contador = 0;
        while (no != null) {
            if (no.getInfo().equals(valor)) {
                return contador;
            }
            contador++;
            no = no.getProx();
        }
        return -1;
    }

    @Override
    public int getTamanho() {
        return qtdeElementos;
    }

    @Override
    public T pegar(int pos) {
        if (pos < 0 || pos >= getTamanho()) {
            throw new IndexOutOfBoundsException("Pos = " + pos);
        }
        NoLista<T> no = primeiro;
        for (int i = 0; i < pos; i++) {
            no = no.getProx();
        }
        return no.getInfo();
    }

    @Override
    public Lista<T> copiar() {
        ListaEncadeada<T> copia = new ListaEncadeada<>();
        NoLista<T> no = primeiro;
        while (no != null) {
            copia.inserir(no.getInfo());
            no = no.getProx();
        }
        return copia;
    }

    @Override
    public Lista<T> dividir() {
        int metade = getTamanho()/2;
        ListaEncadeada<T> novaLista = new ListaEncadeada<>();
        NoLista<T> no = primeiro;
        if (primeiro != null) {
            for (int i = 1; i < metade; i++) {
                no = no.getProx();
            }
            novaLista.setPrimeiro(no.getProx());
            novaLista.setUltimo(ultimo);
            if (getTamanho() == 1) {
                novaLista.setQtdeElementos(0);
            } else if (getTamanho()%2 == 0) {
                novaLista.setQtdeElementos(metade);
            } else {
                novaLista.setQtdeElementos(metade+1);
            }
            no.setProx(null);
            ultimo = no;
            qtdeElementos = metade;
        }
        return novaLista;
    }

    @Override
    public String exibir() {
        NoLista<T> no = primeiro;
        if (primeiro == null) {
            return "[]";
        }
        String retorno = "["+no.getInfo();
        no = no.getProx();
        while (no != null) {
            retorno += ", "+no.getInfo();
            no = no.getProx();
        }
        return retorno+"]";
    }

    @Override
    public void concatenar(Lista<T> outro) {
        if (outro == null) {
            return;
        }
        for (int i = 0; i < outro.getTamanho(); i++) {
            inserir(outro.pegar(i));
        }
    }

    @Override
    public void inserir(T valor) {
        NoLista<T> novoNo = new NoLista<>();
        novoNo.setInfo(valor);
        if (estaVazia()){
            primeiro = novoNo;
        } else {
            ultimo.setProx(novoNo);
        }
        ultimo = novoNo;
        qtdeElementos++;
    }

    public void inserir(T valor, int pos) {
        if (pos < 0 || pos >= getTamanho()) {
            throw new IndexOutOfBoundsException("Pos = " + pos);
        }
        NoLista<T> no = primeiro;
        NoLista<T> novoNo = new NoLista<>();
        novoNo.setInfo(valor);
        for (int i = 0; i < pos; i++) {
            no = no.getProx();
        }
        novoNo.setProx(no.getProx());
        no.setProx(novoNo);
        qtdeElementos++;
    }

    @Override
    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> no = primeiro;
        while (no != null && no.getInfo() != valor) {
            anterior = no;
            no = no.getProx();
        }
        if (no != null) {
            if (anterior == null) {
                primeiro = no.getProx();
            } else {
                anterior.setProx(no.getProx());
            }
            if (no == ultimo) {
                ultimo = anterior;
            }
            qtdeElementos--;
        }
    }

    public T retirarComRetorno(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> no = primeiro;
        while (no != null && no.getInfo() != valor) {
            anterior = no;
            no = no.getProx();
        }
        if (no != null) {
            if (anterior == null) {
                primeiro = no.getProx();
            } else {
                anterior.setProx(no.getProx());
            }
            if (no == ultimo) {
                ultimo = anterior;
            }
            qtdeElementos--;
            return no.getInfo();
        }
        return null;
    }

    protected NoLista<T> getPrimeiro() {
        return primeiro;
    }
}
