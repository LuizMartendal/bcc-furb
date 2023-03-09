import java.text.DecimalFormat;
import java.util.Scanner;

public class Main14{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double valor = ler.nextDouble();
        valor = valor * 100;
        double cedulas = valor / 100;
        
        double nota100 = cedulas / 100;
        cedulas = cedulas % 100;
        double nota50 = cedulas / 50;
        cedulas = cedulas % 50;
        double nota20 = cedulas / 20;
        cedulas = cedulas % 20;
        double nota10 = cedulas / 10;
        cedulas = cedulas % 10;
        double nota5 = cedulas / 5;
        cedulas = cedulas % 5;
        double nota2 = cedulas / 2;
        double moedas = cedulas % 2;
        double moeda1 = moedas / 1;
        moedas = moedas % 1;
        double moeda50 = moedas / 0.50;
        moedas = moedas % 0.50;
        double moeda025 = moedas / 0.25;
        moedas = moedas % 0.25;
        double moeda010 = moedas / 0.10;
        moedas = moedas % 0.10;
        double moeda005 = moedas / 0.05;
        moedas= moedas % 0.05;
        double moeda001 = moedas / 0.01;
        DecimalFormat formatar = new DecimalFormat("0");
        System.out.println("NOTAS:");
        System.out.println(formatar.format(nota100));
        System.out.println(formatar.format(nota50));
        System.out.println(formatar.format(nota20));
        System.out.println(formatar.format(nota10));
        System.out.println(formatar.format(nota5));
        System.out.println(formatar.format(nota2));
        System.out.println("MOEDAS:");
        System.out.println(formatar.format(moeda1));
        System.out.println(formatar.format(moeda50));
        System.out.println(formatar.format(moeda025));
        System.out.println(formatar.format(moeda010));
        System.out.println(formatar.format(moeda005));
        System.out.println(formatar.format(moeda001));
        ler.close();
    }
}
