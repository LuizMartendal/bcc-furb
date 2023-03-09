import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o cateto 1: ");
        double cateto1 = ler.nextDouble();
        double cateto2 = ler.nextDouble();
        double hipotenusa = (cateto1 * cateto1) + (cateto2 * cateto2);
        System.out.print("O comprimento da hipotenusa é: " + hipotenusa * hipotenusa);
        ler.close();
    }
}
