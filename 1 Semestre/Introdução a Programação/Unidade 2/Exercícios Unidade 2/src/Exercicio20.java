import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Dobre o papel sempre em números pares");
        int dobras = ler.nextInt();
        double quadrados = Math.pow(dobras, 2);
        DecimalFormat formatar = new DecimalFormat("0");
        System.out.println(formatar.format(quadrados) + " quadrados");
        ler.close();
    }    
}
