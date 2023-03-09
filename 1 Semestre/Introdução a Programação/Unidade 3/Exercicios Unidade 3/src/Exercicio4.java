import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double nota1 = ler.nextDouble();
        double nota2 = ler.nextDouble();
        double nota3 = ler.nextDouble();
        double media = (nota1 * 5 + nota2 * 7 + nota3 * 8) / (5 + 7 + 8);
        System.out.print("A sua média é: " + media);
        ler.close();
    }
}
