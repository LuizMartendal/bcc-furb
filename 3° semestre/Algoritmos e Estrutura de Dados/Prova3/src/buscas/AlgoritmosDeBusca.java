package buscas;
// Luiz Henrique Martendal
import arvores.Arvore;
import arvores.ArvoreBST;

public class AlgoritmosDeBusca<T extends Comparable<T>> {

	public int buscaLinear(T[] info, T valorBuscar) {
		for (int i=0; i < info.length; i++) {
			if (valorBuscar.equals(info[i])) {
				return i;
			}
		}
		return -1;
	}


	public int buscaBinaria(T[] info, T valorBuscar) {
        int inicio = 0;
        int fim = info.length - 1;
        int meio;
        while(inicio<=fim) {
            meio = (inicio + fim)/2;
            if (valorBuscar.compareTo(info[meio]) < 0) {
                fim = meio - 1;
            } else {
                if (valorBuscar.compareTo(info[meio]) > 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
        }
        return -1;
	}

    public ArvoreBST<T> criarArvoreBST(T[] vetor) {
        ArvoreBST<T> arvore = new ArvoreBST<>();

        if (vetor == null || !possuiElementos(vetor)) {
            return arvore;
        }

        inserirElementoComBuscaBinaria(arvore, vetor, 0, vetor.length -1);

        return arvore;
    }

    private void inserirElementoComBuscaBinaria(ArvoreBST<T> arvore, T[] vetor, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            arvore.inserir(vetor[meio]);
            inserirElementoComBuscaBinaria(arvore, vetor, inicio, meio - 1);
            inserirElementoComBuscaBinaria(arvore, vetor, meio + 1, fim);
        }
    }

    private boolean possuiElementos(T[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            T info = vetor[i];
            if (info != null) {
                return true;
            }
        }
        return false;
    }
}
