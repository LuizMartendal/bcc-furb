import java.util.Scanner;



public class Exercicio1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Insira a altura: ");
        float altura = ler.nextFloat();
        System.out.println("Insira a largura: ");
        float largura = ler.nextFloat();
        float area = altura * largura;
        System.out.println("A área do terreno é: " + area);
        ler.close();
    }
}