import java.text.DecimalFormat;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String NOME = ler.nextLine();
        double SALARIO = ler.nextDouble();
        double VENDAS = ler.nextDouble();
        DecimalFormat df = new DecimalFormat("0.00");
        double TOTAL = SALARIO + (VENDAS * 0.15);
        System.out.println("TOTAL = R$ " + df.format(TOTAL));
        ler.close();
    }
}
