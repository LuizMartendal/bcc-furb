import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o preço do litro: ");
        double precolitro = ler.nextDouble();
        System.out.print("Insira o valor pago: ");
        double valorpago = ler.nextDouble();
        double litros_abastecidos = valorpago / precolitro;
        System.out.print("Foram abastecidos: " + litros_abastecidos + " litros");
        ler.close();
    }
}       