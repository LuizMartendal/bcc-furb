import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Adicione a quantidade de latas de 350ml: ");
        int lata350 = ler.nextInt();
        System.out.println("Adicoine a quantidade de garrafas 600ml: ");
        int lata600 = ler.nextInt();
        System.out.println("Adicione a quantidade de garrafas de 2 litros: ");
        int l2 = ler.nextInt();
        int l350 = 350;
        int g600 = 600;
        int g2 = 2000;
        int total = ((lata350 * l350) + (lata600 * g600) + (l2 * g2)) / 1000;
        System.out.println("Quantidade total de litos: " + total + " litros");
        ler.close();
    }
}
