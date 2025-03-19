import java.text.DecimalFormat;
import java.util.Scanner;

public class Main14{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double cedulas = ler.nextDouble();
        
        double nota100 = Math.floor(cedulas / 100);
        cedulas = cedulas % 100;
        double nota50 = Math.floor(cedulas / 50);
        cedulas = cedulas % 50;
        double nota20 = Math.floor(cedulas / 20);
        cedulas = cedulas % 20;
        double nota10 = Math.floor(cedulas / 10);
        cedulas = cedulas % 10;
        double nota5 = Math.floor(cedulas / 5);
        cedulas = cedulas % 5;
        double nota2 = Math.floor(cedulas / 2);
        double moedas = cedulas % 2;
        double moeda1 = Math.floor(moedas / 1);
        moedas = moedas % 1;
        double moeda50 = Math.floor(moedas / 0.50);
        moedas = moedas % 0.50;
        double moeda025 = Math.floor(moedas / 0.25);
        moedas = moedas % 0.25;
        double moeda010 = Math.floor(moedas / 0.10);
        moedas = moedas % 0.10;
        double moeda005 = Math.floor(moedas / 0.05);
        moedas= moedas % 0.05;
        double moeda001 = moedas / 0.01;
        DecimalFormat formatar = new DecimalFormat("0");
        System.out.println("NOTAS:");
        System.out.println(formatar.format(nota100) + " nota(s) de R$ 100.00");
        System.out.println(formatar.format(nota50) + " nota(s) de R$ 50.00");
        System.out.println(formatar.format(nota20) + " nota(s) de R$ 20.00");
        System.out.println(formatar.format(nota10) + " nota(s) de R$ 10.00");
        System.out.println(formatar.format(nota5) + " nota(s) de R$ 5.00");
        System.out.println(formatar.format(nota2) + " nota(s) de R$ 2.00");
        System.out.println("MOEDAS:");
        System.out.println(formatar.format(moeda1) + " moeda(s) de R$ 1.00");
        System.out.println(formatar.format(moeda50) + " moeda(s) de R$ 0.50");
        System.out.println(formatar.format(moeda025) + " moeda(s) de R$ 0.25");
        System.out.println(formatar.format(moeda010) + " moeda(s) de R$ 0.10");
        System.out.println(formatar.format(moeda005) + " moeda(s) de R$ 0.05");
        System.out.println(formatar.format(moeda001) + " moeda(s) de R$ 0.01");
        ler.close();
    }
}
