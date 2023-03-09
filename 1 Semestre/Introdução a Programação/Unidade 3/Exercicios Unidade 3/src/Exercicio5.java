import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Informar a quantidade de frangos: ");
        double quantidade_de_frangos = ler.nextDouble();
        double anelchip = 4;
        double anelalimento = 3.50;
        double gastoporfrango = (anelalimento * 2) + anelchip;
        double gastototal = quantidade_de_frangos * gastoporfrango;
        System.out.print("O gasto total da granja é: R$" + gastototal);
        ler.close();
    }
}
