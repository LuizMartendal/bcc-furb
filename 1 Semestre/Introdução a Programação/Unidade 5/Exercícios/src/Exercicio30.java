import java.util.Scanner;

public class Exercicio30{
    public static void main(String[] args) {
        int m, n, k;
        String elementosMochila = "";
        String elementosFora = "";
        int somaMochila = 0;
        int somaFora = 0;

        Scanner s = new Scanner(System.in);
        System.out.print("Digite o valor para iniciar o decremento: ");
        n = s.nextInt();

        System.out.print("Digite o valor para o decremento: ");
        k = s.nextInt();

        System.out.print("Digite o tamanho da mochila: ");
        m = s.nextInt();

        int quantidade = 0;
        while (quantidade < m) {
            elementosMochila += n + " ";
            somaMochila += n;

            n = n - k; 

            quantidade++;
        }

        while (n >= 0) {
            elementosFora += n + " ";
            somaFora += n;

            n = n - k;
        }

        System.out.println("Mochila " + elementosMochila);
        System.out.println("Soma mochila " + somaMochila);
        System.out.println("Fora mochila " + elementosFora);
        System.out.println("Soma fora " + somaFora);
        s.close();
    }
}