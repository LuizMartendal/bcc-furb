import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double preco = 12.50;
        double comprimento = ler.nextDouble();
        double altura = ler.nextDouble();
        int am2 = 9;
        double precom2 = preco * am2;
        double total = (comprimento * altura) * precom2;
        System.out.println(total);
        ler.close();
    }
}
