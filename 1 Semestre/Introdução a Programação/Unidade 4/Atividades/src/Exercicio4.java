import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com um número ponto flutuante maior do que 0: ");
        double numero = ler.nextDouble();
        if (numero - Math.floor(numero) != 0) {
            System.out.println("O número possui casas decimais");
        } else {
            System.out.println("O número não possui casas decimais");
        }
        ler.close();
    }
}
