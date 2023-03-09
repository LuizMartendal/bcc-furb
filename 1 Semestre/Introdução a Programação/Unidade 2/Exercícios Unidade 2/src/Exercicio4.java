import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float nota1 = ler.nextFloat();
        float nota2 = ler.nextFloat();
        double peso1 = 3.5;
        double peso2 = 7.5;
        double media = ((nota1 * peso1) + (nota2 * peso2)) / (peso1 + peso2);
        System.out.println(media);
        ler.close();
    }
}
