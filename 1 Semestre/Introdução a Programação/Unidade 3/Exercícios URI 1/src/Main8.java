import java.text.DecimalFormat;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int peca1u = ler.nextInt();
        double peca1p = ler.nextDouble();
        int peca2u = ler.nextInt();
        double peca2p = ler.nextDouble();
        double VALOR_a_PAGAR = (peca1p * peca1u) + (peca2p * peca2u);
        DecimalFormat df = new DecimalFormat("0.00");
       System.out.println("VALOR A PAGAR: R$ " + df.format(VALOR_a_PAGAR));
        ler.close();
    }
}