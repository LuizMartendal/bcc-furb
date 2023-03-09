import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        double valor_compra, desconto, total_recebido = 0;
        System.out.print("Digite o valor da compra: R$ ");
        valor_compra = sc.nextDouble();
        while (valor_compra != 0){
            if (valor_compra > 500){
                desconto = valor_compra * 0.20;
                valor_compra = valor_compra - desconto;
                System.out.println("Valor da compra: R$ " + valor_compra);
                total_recebido = valor_compra + total_recebido;
            }else if (valor_compra > 0 && valor_compra <= 500){
                desconto = valor_compra * 0.15;
                valor_compra = valor_compra - desconto;
                System.out.println("Valor da compra: R$ " + valor_compra);
                total_recebido = valor_compra + total_recebido;
            }
            System.out.print("Digite o valor da compra: R$ ");
            valor_compra = sc.nextDouble();
        }
        System.out.print("Valor recebido pela loja ao final do dia: " + df.format(total_recebido));
        sc.close();
    }
}
