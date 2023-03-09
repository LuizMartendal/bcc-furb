import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int N = ler.nextInt();
        int nota100 = N / 100;
        int N100 = N % 100;
        int nota50 = N100 / 50;
        int N50 = N100 % 50;
        int nota20 = N50 / 20;
        int N20 = N50 % 20;
        int nota10 = N20 / 10;
        int N10 = N20 % 10;
        int nota5 = N10 / 5;
        int N5 = N10 % 5;
        int nota2 = N5 / 2;
        int N2 = N5 % 2;
        int nota1 = N2 / 1;
        System.out.println(N);
        System.out.println(nota100 + " nota(s) de R$ 100,00");
        System.out.println(nota50 + " nota(s) de R$ 50,00");
        System.out.println(nota20 + " nota(s) de R$ 20,00");
        System.out.println(nota10 + " nota(s) de R$ 10,00");
        System.out.println(nota5 + " nota(s) de R$ 5,00");
        System.out.println(nota2 + " nota(s) de R$ 2,00");
        System.out.println(nota1 + " nota(s) de R$ 1,00");
        ler.close();
    }
}
