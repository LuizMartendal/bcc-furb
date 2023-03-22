package Exercicio3;

public class TestePilhaLista {
    public static void main(String[] args) {
        PilhaLista<Integer> pilhaLista = new PilhaLista<>();

        System.out.println("Teste estaVazia(). Esperado = true Retornado =  " + pilhaLista.estaVazia());
        pilhaLista.push(5);
        pilhaLista.push(4);
        pilhaLista.push(3);
        pilhaLista.push(2);
        pilhaLista.push(1);
        System.out.println("Teste toString() após 5 push(). Esperado = [1, 2, 3, 4, 5] Retornado = " + pilhaLista.toString());
        System.out.println("Teste estaVazia(). Esperado = false Retornado = " + pilhaLista.estaVazia());
        System.out.println("Teste pop(). Esperado = 1 Retornado = " + pilhaLista.pop());
        System.out.println("Teste peek(). Esperado = 2 Retornado = " + pilhaLista.peek());
        pilhaLista.liberar();
        System.out.println("Teste toString() após liberar(). Esperado = [] Retornado = " + pilhaLista.toString());
        System.out.println("Teste estaVazia(). Esperado = true Retornado = " + pilhaLista.estaVazia());

    }
}
