import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com um valor: R$ ");
        double valor = sc.nextDouble();
        double valor1 = 0, valor2 = 0, valor5 = 0, valor10 = 0, valor20 = 0, valor_total = 0;
        while (valor_total != valor){
            valor20 = valor / 20;
            valor = valor % 20;
            valor10 = valor / 10;
            valor = valor % 10;
            valor5 = valor / 5;
            valor = valor % 5;
            valor1 = valor / 1;
        }
        valor_total = (valor20 * 20) + (valor10 * 10) + (valor5 * 5) + (valor2 * 2) + (valor1 * 1);
        System.out.println((int)valor20 + " notas de R$ 20,00");
        System.out.println((int)valor10 + " notas de R$ 10,00");
        System.out.println((int)valor5 + " notas de R$ 05,00");
        System.out.println((int)valor2 + " notas de R$ 02,00");
        System.out.println((int)valor1 + " notas de R$ 01,00");
        sc.close();
    }
}