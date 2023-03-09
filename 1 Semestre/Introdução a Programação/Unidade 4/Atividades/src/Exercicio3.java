import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com o valor 1: ");
        int valor1 = ler.nextInt();
        System.out.println("Entre com o valor 2: ");
        int valor2 = ler.nextInt();
        if (valor1 > valor2) {
            System.out.println("O valor " + valor1 + " é maior que o valor " + valor2);
        } else {
            System.out.println("O valor " + valor2 + " é maior que o valor " + valor1);
        }
        ler.close();
    }
}
