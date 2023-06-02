import java.util.ArrayList;

public class TesteRandom {

    public static void main(String[] args) {
        int tamanho = (int) Math.abs(Math.random() * 10000);
        ArrayList<Integer> lista = new ArrayList<>();

        MapaDispersao<Integer, Integer> mapa = new MapaDispersao<>(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int value = (int) (Math.random() * 100000000);
            boolean inseriu = mapa.inserir(value, value);
            if (inseriu) {
                lista.add(value);
                System.out.println("Inserindo " + value + " Valor retornado: " + true);
            } else {
                System.out.println("Inserindo " + value + " Valor retornado: " + false);
                if (lista.contains(value)) {
                    System.out.println("Tem mesmo");
                } else {
                    System.out.println("Tem PoBrEmA");
                }
            }
        }

        System.out.println("Quantidade total  = " + mapa.quantosElementos());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Buscando: " + lista.get(i) + " retornado: " + mapa.buscar(lista.get(i)));
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Removendo: " + lista.get(i) + " retornado: " + mapa.remover(lista.get(i)));
        }

        System.out.println("Quantidade total  = " + mapa.quantosElementos());
        System.out.println("Acho que deu boa");
    }
}
