package Exercicio1;

public class ListaEstatica implements Lista {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    @Override
    public void inserir(int valor) {
        if (tamanho == info.length) {
            this.redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        int[] novo = new int[info.length + 10];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    @Override
    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
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
    public void retirar(int valor) {
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
    public Lista copiar() { // contribui��o Gustavo G
        Lista copia = new ListaEstatica();
        for (int i = 0; i < tamanho; i++) {
            copia.inserir(info[i]);
        }
        return copia;
    }

    @Override
    public void concatenar(Lista outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
            inserir(outra.pegar(i));
        }
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public int pegar(int pos) {
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Pos=" + pos);
        }
        return info[pos];
    }

    @Override
    public Lista dividir(){
        Lista lista = new ListaEstatica();
        int metade = this.tamanho / 2;
        for (int i=metade; i < tamanho; i++) {
            lista.inserir(info[i]);
        }
        this.tamanho = metade;
        return lista;
    }
}