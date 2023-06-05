public class MapaDispersao<K, T> {

    public Lista<ParChaveValor<K, T>>[] tabela;

    public MapaDispersao(int quantidade) {
        int tamanho = proximoPrimo(quantidade);
        this.tabela = new Lista[tamanho];
    }

    private static int proximoPrimo(int valor) {
        int prox = valor;
        while (!ePrimo(prox)) {
            prox++;
        }
        return prox;
    }

    private static boolean ePrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }


    private int calcularHash(K chave) {
        int hash = chave.hashCode();
        hash = (hash < 0) ? -hash : hash;
        return hash % tabela.length;
    }

    public boolean inserir(K chave, T valor) {
        int pos = calcularHash(chave);
        ListaMapaDispersao<K, T> lista = (ListaMapaDispersao<K, T>) tabela[pos];
        if (lista == null) {
            ListaMapaDispersao<K, T> novaLista = new ListaMapaDispersao<>();
            novaLista.inserir(new ParChaveValor<>(chave, valor));
            tabela[pos] = novaLista;
            return true;
        }
        if (lista.chaveExiste(chave)) {
            return false;
        }
        lista.inserir(new ParChaveValor<>(chave, valor));
        return true;
    }

    public T remover(K chave) {
        int pos = calcularHash(chave);
        ListaMapaDispersao<K, T> lista = (ListaMapaDispersao<K,T>) tabela[pos];
        if (lista == null) {
            return null;
        }
        ParChaveValor<K, T> par = lista.buscarPar(chave);
        if (par == null) {
            return null;
        }
        ParChaveValor<K, T> a =  lista.retirarComRetorno(par);
        return a.getValor();
    }

    public T buscar(K chave) {
        int pos = calcularHash(chave);
        ListaMapaDispersao<K, T> lista = (ListaMapaDispersao<K,T>) tabela[pos];
        if (lista == null) {
            return null;
        }
        ParChaveValor<K, T> par = lista.buscarPar(chave);
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
