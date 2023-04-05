public class TesteCompare {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();

        lista.insereOrdenado("L");
        lista.insereOrdenado("C");
        lista.insereOrdenado("A");
        lista.insereOrdenado("B");
        lista.insereOrdenado("C");

        System.out.println(lista.exibir());
    }
}
