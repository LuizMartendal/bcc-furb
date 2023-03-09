import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        double imposto, rendaAnual, desconto, valorLiquido;
        int dependentes;
        System.out.print("Renda anual: R$");
        rendaAnual = ler.nextDouble();
        System.out.println("Número de dependentes:");
        dependentes = ler.nextInt();
        desconto = (dependentes * 0.02) * rendaAnual;
        valorLiquido = rendaAnual - desconto;
        if (valorLiquido <= 2000){
            System.out.println("Não paga imposto.");
        }else if (valorLiquido > 2000 && valorLiquido <= 5000){
            imposto = valorLiquido * 0.05;
            System.out.println("Você possui uma renda líquida entre R$ 2.000,00 e R$ 5.000,00, será cobrado 5% de imposto sobre a sua renda líquida");
            System.out.println("Valor de imposto a ser cobrado: R$" + df.format(imposto));
        }else if (valorLiquido > 5000 && valorLiquido <= 10000){
            imposto = valorLiquido * 0.10;
            System.out.println("Você possui uma renda líquida entre R$ 5.000,00 e R$ 10.000,00, será cobrado 10% de imposto sobre a sua renda líquida");
            System.out.println("Valor de imposto a ser cobrado: R$" + df.format(imposto));
        }else if (valorLiquido > 10000){
            imposto = valorLiquido * 0.15;
            System.out.println("Você possui uma renda líquida maior que R$ 10.000,00, será cobrado 15% de imposto sobre a sua renda líquida");
            System.out.println("Valor de imposto a ser cobrado: R$" + df.format(imposto));
        }
        ler.close();
    }
}
