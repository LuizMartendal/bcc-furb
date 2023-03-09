import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner  ler = new Scanner(System.in);
        double cotacao = 5.20;
        System.out.print("Informe o valor em dólares: $");
        double dolar = ler.nextDouble();
        double reais = dolar * cotacao;
        System.out.print("Valor em reais a ser recebido: R$" + reais);
        ler.close();
    }
}
