import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int A = ler.nextInt();
        int B = ler.nextInt();
        int MULTIPLICACAO = A * B;
        System.out.println(MULTIPLICACAO);
        ler.close();
    }
}
