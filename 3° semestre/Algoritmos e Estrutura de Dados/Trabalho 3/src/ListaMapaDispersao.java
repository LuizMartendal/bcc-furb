public class ListaMapaDispersao<K,T> extends ListaEncadeada<ParChaveValor<K,T>> {
    public boolean chaveExiste(K chave) {
        NoLista<ParChaveValor<K,T>> no = getPrimeiro();
        while (no != null) {
            if (no.getInfo().getChave().equals(chave)) {
                return true;
            }
            no = no.getProx();
        }
        return false;
    }

    public ParChaveValor<K,T> buscarPar(K chave) {
        NoLista<ParChaveValor<K,T>> no = getPrimeiro();
        while (no != null) {
            ParChaveValor<K, T> par = no.getInfo();
            if (par.getChave().equals(chave)) {
                return par;
            }
            no = no.getProx();
        }
        return null;
    }
}
