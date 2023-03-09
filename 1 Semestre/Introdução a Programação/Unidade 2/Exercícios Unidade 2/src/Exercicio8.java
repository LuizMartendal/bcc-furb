import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //peça1
        System.out.println("Código da peça 1: ");
        String cp1 = ler.nextLine();
        System.out.println("Número de peças: ");
        double ndp1 = ler.nextFloat();
        System.out.println("Valor unitário de cada peça: ");
        double vudcp1 = ler.nextDouble();
        //peça 2
        System.out.println("Código da peça 2: ");
        String cp2 = ler.next();
        System.out.println("Número de peças: ");
        double ndp2 = ler.nextDouble();
        System.out.println("Valor unitário de cada peça: ");
        double vudcp2 = ler.nextDouble();
        double peca1 = ndp1 * vudcp1;
        double peca2 = ndp2 * vudcp2;
        System.out.println(cp1 + " R$" + peca1);
        System.out.println(cp2 + " R$" + peca2);
        ler.close();
    }
}
