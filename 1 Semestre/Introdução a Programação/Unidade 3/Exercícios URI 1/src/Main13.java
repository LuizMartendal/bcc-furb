import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int N = ler.nextInt();
        int horas = N / 3600;
        int resto1 = N % 3600;
        int minutos = resto1 / 60;
        int segundos = resto1 % 60;
        System.out.println(horas + " : " + minutos + " : " + segundos);
        ler.close();
    }
}
