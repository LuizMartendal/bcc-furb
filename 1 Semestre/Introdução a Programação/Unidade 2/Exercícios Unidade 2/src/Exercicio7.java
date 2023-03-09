import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Adicione o nome do funcionário: ");
        String nome = ler.nextLine();
        System.out.println("Adicione o seu salário fixo: ");
        double salario = ler.nextDouble();
        System.out.println("Valor total de vendas efetuadas por ele(a) no mês (em dinheiro)");
        double vendas = ler.nextDouble();
        double comissao = vendas * 0.15;
        double salariototal = salario + comissao;
        System.out.println("Funcionário: " + nome);
        DecimalFormat formatar = new DecimalFormat("0.00");
        System.out.println("Salário com comissão: R$" + formatar.format(salariototal));
        ler.close();
    }
}
