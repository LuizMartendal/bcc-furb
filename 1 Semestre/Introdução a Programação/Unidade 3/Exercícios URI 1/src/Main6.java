import java.text.DecimalFormat;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int NUMBER = ler.nextInt();
        int HOUR = ler.nextInt();
        double HW = ler.nextDouble();
        DecimalFormat df = new DecimalFormat("0.00");
        double SALARY = HOUR * HW;
        System.out.println("NUMBER = " + NUMBER);
        System.out.println("SALARY = U$ " + df.format(SALARY));
        ler.close();
    }
}
