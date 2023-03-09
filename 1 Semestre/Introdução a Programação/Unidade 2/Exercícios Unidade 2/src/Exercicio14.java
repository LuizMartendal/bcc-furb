import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int valor = ler.nextInt();
        int nota100 = valor / 100;
        valor = valor % 100;
        int nota50 = valor / 50;
        valor = valor % 50;
        int nota20 = valor / 20;
        valor = valor % 20;
        int nota10 = valor / 10;
        valor = valor % 10;
        int nota5 = valor / 5;
        valor = valor % 5;
        int nota2 = valor / 2;
        valor = valor % 2;
        int nota1 = valor / 1;
        System.out.println(nota100 + " " + nota50 + " " + nota20 + " " + nota10 + " " + nota5 + " " + nota2 + " " + nota1);
        ler.close();
    }
}
