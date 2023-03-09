import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe a quantidade de números:");
        int q = ler.nextInt();
        double valorMax = Double.MIN_VALUE;
        double valorMin = Double.MAX_VALUE;
        for (int i = 1; i <= q; i++){
            System.out.println("Leia o " + i + "° valor");
            double valor = ler.nextDouble();

            if (valor < valorMin){
                valorMin = valor;
            }
            if (valor > valorMax){
                valorMax = valor;
            }
        }
        System.out.println("O maior valor é: " + valorMax);
        System.out.println("O menor valor é: " + valorMin);
        ler.close();
    }
}
