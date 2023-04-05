public class TesteInterseccao {
    public static void main(String[] args) {
        ListaEncadeada<String> lista1 = new ListaEncadeada<>();

        lista1.insereOrdenado("L");
        lista1.insereOrdenado("C");
        lista1.insereOrdenado("A");
        lista1.insereOrdenado("J");
        ListaEncadeada<String> lista2 = new ListaEncadeada<>();

        lista2.insereOrdenado("L");
        lista2.insereOrdenado("C");
        lista2.insereOrdenado("A");
        lista2.insereOrdenado("J");

        ListaEncadeada<String> lista3 = lista1.interseccao(lista2);
        System.out.println(lista3.exibir());
    }
}
