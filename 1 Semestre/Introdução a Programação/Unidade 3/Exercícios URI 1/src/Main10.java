import java.text.DecimalFormat;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat formatar = new DecimalFormat("0.0000");
        double x1 = ler.nextDouble();
        double y1 = ler.nextDouble();
        double x2 = ler.nextDouble();
        double y2 = ler.nextDouble();
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println(formatar.format(distancia));
        ler.close();
    }
}
