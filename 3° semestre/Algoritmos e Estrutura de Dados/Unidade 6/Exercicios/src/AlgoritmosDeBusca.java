public class AlgoritmosDeBusca<T extends Comparable<T>> {

    public int buscarLinear(T[] info, T valorBuscar) {
        int n = info.length;

        for (int i = 0; i < n; i++) {
            if (info[i] == valorBuscar) {
                return i;
            } else {
                if (valorBuscar.compareTo(info[i]) < 0) {
                    break;
                }
            }
        }
        return -1;
    }

    public int buscaBinaria(T[] info, T valorBuscar) {
        int n = info.length;
        int inicio = 0;
        int fim = n - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (valorBuscar.compareTo(info[meio]) < 0) {
                fim = meio - 1;
            } else {
                if (valorBuscar.compareTo(info[meio]) >= 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
        }
        return -1;
    }
}
