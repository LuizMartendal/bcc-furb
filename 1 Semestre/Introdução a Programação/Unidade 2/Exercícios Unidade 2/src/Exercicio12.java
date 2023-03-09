import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float x1 = ler.nextFloat();
        float y1 = ler.nextFloat();
        float x2 = ler.nextFloat();
        float y2 = ler.nextFloat();
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println(distancia);
        ler.close();
    }
}
