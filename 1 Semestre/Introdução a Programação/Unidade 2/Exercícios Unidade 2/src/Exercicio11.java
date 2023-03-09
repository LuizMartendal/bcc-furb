import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double A = ler.nextDouble();
        double B = ler.nextDouble();
        double C = ler.nextDouble();
        double areat = A * C;
        double areac = Math.pow(C, 2) * 3.1415;
        double areatr = (A + B) * C;
        double areaq = B * B;
        double arear = A * B;
        System.out.println("Área de um triângulo: " + areat);
        System.out.println("Área de um círculo: " + areac);
        System.out.println("Área de um trapézio: " + areatr);
        System.out.println("Área de um quadrado: " + areaq);
        System.out.println("Área de um retângulo: " + arear);
        ler.close();
    }
}
