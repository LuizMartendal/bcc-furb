package Exercicio3;

public class TestePilhaVetor {
    public static void main(String[] args) {
        PilhaVetor<Integer> pilhaVetor = new PilhaVetor<>(5);

        System.out.println("Teste estaVazia(). Esperado = true Retornado =  " + pilhaVetor.estaVazia());
        pilhaVetor.push(5);
        pilhaVetor.push(4);
        pilhaVetor.push(3);
        pilhaVetor.push(2);
        pilhaVetor.push(1);
        System.out.println("Teste toString() após 5 push(). Esperado = [1, 2, 3, 4, 5] Retornado = " + pilhaVetor.toString());
        System.out.println("Teste estaVazia(). Esperado = false Retornado = " + pilhaVetor.estaVazia());
        System.out.println("Teste pop(). Esperado = 1 Retornado = " + pilhaVetor.pop());
        System.out.println("Teste peek(). Esperado = 2 Retornado = " + pilhaVetor.peek());
        pilhaVetor.liberar();
        System.out.println("Teste toString() após liberar(). Esperado = [] Retornado = " + pilhaVetor.toString());

    }
}
