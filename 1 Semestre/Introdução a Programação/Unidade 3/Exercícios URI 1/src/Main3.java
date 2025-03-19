import java.text.DecimalFormat;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int X = entrada.nextInt();
        int Y = entrada.nextInt();

        int calculoProd = X * Y;

        System.out.println("PROD = " + calculoProd);

    }
}