import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe a quantidade de produtos comprados:");
        System.out.print("Lata de 350ml: ");
        double lata1 = ler.nextFloat();
        System.out.print("Lata de 600ml: ");
        double lata2 = ler.nextFloat();
        System.out.print("Informe de 2 litros: ");
        double garrafa = ler.nextFloat();
        double lata350 = 350 * lata1;
        double lata600 = 600 * lata2;
        double garrafa2 = 2 * garrafa;
        double quantidade_total = (lata350 / 1000) + (lata600 / 1000) + garrafa2;
        System.out.print("A quantidade total de litros é: " + quantidade_total);

        ler.close();
    }
}
