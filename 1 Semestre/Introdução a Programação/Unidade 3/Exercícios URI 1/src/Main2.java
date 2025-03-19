import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double raio = entrada.nextDouble();

        double PI = 3.14159;

        double calculoCircunferencia = PI * ( raio * raio);

        DecimalFormat df = new DecimalFormat("0.0000");

        System.out.println("A=" + df.format(calculoCircunferencia));

    }
}
