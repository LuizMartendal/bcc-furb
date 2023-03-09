import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int km = ler.nextInt();
        int minutos = km * 2;
        System.out.println(minutos + "minutos");
        ler.close();
    }
}
