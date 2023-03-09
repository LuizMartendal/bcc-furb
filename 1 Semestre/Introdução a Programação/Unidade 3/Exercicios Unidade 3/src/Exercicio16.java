import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Preço do produto: ");
        int valor = ler.nextInt();
        System.out.println("Valor pago: ");
        int pagou = ler.nextInt();
        int troco = pagou - valor;
        int nota100 = troco / 100;
        troco %= 100;
        int nota10 = troco / 10;
        troco %= 10;
        int nota1 = troco / 1;
        System.out.println("Preço do produto: " + valor);
        System.out.println("Valor pago: " + pagou);
        System.out.println("Troco " + troco);
        System.out.println("Cédulas: ");
        System.out.println(nota100 + " notas de R$ 100,00");
        System.out.println(nota10 + " notas de R$ 10,00");
        System.out.println(nota1 + " notas de R$ 1,00");
        ler.close();
    }
}
