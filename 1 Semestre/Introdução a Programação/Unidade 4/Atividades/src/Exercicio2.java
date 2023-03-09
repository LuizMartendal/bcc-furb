import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com uma valor inteiro maior que 0: ");
        int valor = ler.nextInt();
        if (valor % 2 == 0) {
            System.out.println("Número é par");
        } else {
            System.out.println("Número é ímpar");
        }
        ler.close();
    }
}
