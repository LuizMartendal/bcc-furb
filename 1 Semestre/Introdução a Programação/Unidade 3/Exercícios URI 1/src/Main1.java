import java.text.DecimalFormat;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int codigoPeca1 = entrada.nextInt();
        int numeroPecas1 = entrada.nextInt();
        double valorUnitarioPeca1 = entrada.nextDouble();

        int codigoPeca2 = entrada.nextInt();
        int numeroPecas2 = entrada.nextInt();
        double valorUnitarioPeca2 = entrada.nextDouble();

        double valorAPagar = (numeroPecas1 * valorUnitarioPeca1) + (numeroPecas2 * valorUnitarioPeca2);

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("VALOR A PAGAR: R$ " + df.format(valorAPagar));

    }
}