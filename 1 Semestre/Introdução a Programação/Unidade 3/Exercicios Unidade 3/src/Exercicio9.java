import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double PI = 3.1415;
        System.out.print("Informar o raio: ");
        double raio = ler.nextDouble();
        System.out.print("Informar a altura: ");
        double altura = ler.nextDouble();
        double volume = (raio * raio) * PI * altura;
        System.out.print("O volume da lata de óleo é: " + volume);
        ler.close();
    }
}
