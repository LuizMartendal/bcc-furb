import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com a quantidade de números que você quer digitar:");
        double qNumeros = ler.nextInt(), n = 0, soma = 0, valor_negativo = Double.MAX_VALUE, media;
        int vn = 0, m = 0;
        for (int i = 1; i <= qNumeros; i++){
            System.out.println("Entre com o " + i + "° número:");
            n = ler.nextInt();
            if (n < valor_negativo && n < 0){
                valor_negativo = n;
                vn++;
            }
            if (n > 0){
                soma = n + soma;
                m++;
            }
        }
        media = soma / m;
        if (m > 0 && vn <= 0){
            System.out.println("Média de números positivos: " + media);
            System.out.println("Não houve entrada de qualquer número negativo!");
        }else if (vn > 0 && m <= 0){
            System.out.println("Não houve entrada de qualquer número positivo!");
            System.out.println("Menor valor negativo: " + valor_negativo);
        }else if (m > 0 && vn > 0){
            System.out.println("Média de números positivos: " + media);
            System.out.println("Menor valor negativo: " + valor_negativo);
        }
        ler.close();
    }
}
