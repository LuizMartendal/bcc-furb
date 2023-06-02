public class MapaDispersao<K, T> {

    public Lista<ParChaveValor<K,T>>[] tabela;

    public MapaDispersao(int quantidade) {
        this.tabela = new Lista[proximoPrimo(quantidade)];
    }

    private int proximoPrimo(int valor) {
        boolean primo = false;
        int prox = valor;
        while (!primo) {
            primo = ePrimo(prox);
            if (!primo) {
                prox++;
            }
        }
        return prox;
    }

    private static boolean ePrimo(int prox) {
        boolean primo;
        primo = true;
        for (int i = 2; i < prox; i++) {
            if (prox % i == 0) {
                primo = false;
                break;
            }
        }
        return primo;
    }


    private int calcularHash(K chave) {
        return Math.abs(chave.hashCode() % tabela.length);
    }

    public boolean inserir(K chave, T valor) {
        int pos = calcularHash(chave);
        Lista<ParChaveValor<K, T>> lista = tabela[pos];
        if (lista == null) {
            ListaEstatica<ParChaveValor<K, T>> novaLista = new ListaEstatica<>();
            novaLista.inserir(new ParChaveValor<>(chave, valor));
            tabela[pos] = novaLista;
            return true;
        }
        if (chaveExiste(lista, chave)) {
            return false;
        }
        lista.inserir(new ParChaveValor<>(chave, valor));
        return true;
    }

    private boolean chaveExiste(Lista<ParChaveValor<K, T>> lista, K chave) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            if (lista.pegar(i).getChave().equals(chave)) {
                return true;
            }
        }
        return false;
    }

    public T remover(K chave) {
        int pos = calcularHash(chave);
        ListaEstatica<ParChaveValor<K, T>> lista = (ListaEstatica<ParChaveValor<K,T>>) tabela[pos];
        if (lista == null) {
            return null;
        }
        ParChaveValor<K, T> par = buscarPar(lista, chave);
        if (par == null) {
            return null;
        }
        ParChaveValor<K, T> a =  lista.retirarComRetorno(par);
        return a.getValor();
    }

    private ParChaveValor<K, T> buscarPar(ListaEstatica<ParChaveValor<K,T>> lista, K chave) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            ParChaveValor<K, T> par = lista.pegar(i);
            if (par.getChave().equals(chave)) {
                return par;
            }
        }
        return null;
    }

    public T buscar(K chave) {
        int pos = calcularHash(chave);
        ListaEstatica<ParChaveValor<K, T>> lista = (ListaEstatica<ParChaveValor<K,T>>) tabela[pos];
        if (lista == null) {
            return null;
        }
        ParChaveValor<K, T> par = buscarPar(lista, chave);
        if (par == null) {
            return null;
        }
        return par.getValor();
    }

    public int quantosElementos() {
        int tamanho = 0;
        for (int i = 0; i < tabela.length; i++) {
            Lista<ParChaveValor<K,T>> lista = tabela[i];
            if (lista != null) {
                tamanho += lista.getTamanho();
            }
        }
        return tamanho;
    }
}
