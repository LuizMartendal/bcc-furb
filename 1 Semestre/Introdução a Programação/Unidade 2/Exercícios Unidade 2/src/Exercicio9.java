import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double dolar = ler.nextDouble();
        double reais = 5.20;
        double valor = dolar * reais;
        System.out.println(valor);
        ler.close();
    }
}
