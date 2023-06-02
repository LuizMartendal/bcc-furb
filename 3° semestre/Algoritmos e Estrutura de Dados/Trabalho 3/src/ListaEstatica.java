public class ListaEstatica<T> implements Lista<T> {
    private T[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == info.length) {
            this.redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        T[] novo = (T[]) new Object[info.length + 10];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public void retirar(T valor) {
        int pos = this.buscar(valor);
        if (pos != -1) {
            for (int i = pos; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    @Override
    public String exibir() {
        String str = "[";
        for (int i = 0; i < tamanho; i++) {
            str += info[i] + ", ";
        }
        return str + "]";
    }

    @Override
    public Lista<T> copiar() { // contribui��o Gustavo G
        Lista<T> copia = new ListaEstatica<>();
        for (int i = 0; i < tamanho; i++) {
            copia.inserir(info[i]);
        }
        return copia;
    }

    @Override
    public void concatenar(Lista<T> outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
            inserir(outra.pegar(i));
        }
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public T pegar(int pos) {
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Pos=" + pos);
        }
        return info[pos];
    }

    @Override
    public Lista<T> dividir(){
        Lista<T> lista = new ListaEstatica<>();
        int metade = this.tamanho / 2;
        for (int i=metade; i < tamanho; i++) {
            lista.inserir(info[i]);
        }
        this.tamanho = metade;
        return lista;
    }

    public T retirarComRetorno(T par) {
        int pos = this.buscar(par);
        if (pos != -1) {
            T info = this.info[pos];
            for (int i = pos; i < tamanho - 1; i++) {
                this.info[i] = this.info[i + 1];
            }
            tamanho--;
            return info;
        }
        return null;
    }
}