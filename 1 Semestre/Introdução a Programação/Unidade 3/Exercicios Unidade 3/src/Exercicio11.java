import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe os graus em Celsius: ");
        double celsius = ler.nextDouble();
        double fa = celsius * (9/5) + 32;
        System.out.print("°F" + fa);
        ler.close();
    }
}
