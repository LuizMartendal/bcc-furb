import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Escreva o dia do vencimento (ocorre até o dia 10 de cada mês):");
        int diaVencimento = ler.nextInt();
        System.out.println("Escreva o dia do pagamento:");
        int diaPagamento = ler.nextInt();
        System.out.println("Escreva o valor da prestação:");
        double prestacao = ler.nextDouble();
        double desconto, multa;
        if (diaPagamento >= 1 && diaPagamento <=diaVencimento){
            desconto = prestacao * 0.10;
            prestacao = prestacao - desconto;
            System.out.println("Valor da prestação: R$" + prestacao);
            System.out.println("Pagamento em dia.");
        }else if (diaPagamento > diaVencimento && diaPagamento - diaVencimento <= 5){
            System.out.println("Valor da prestação: R$" + prestacao);
        }else if (diaPagamento > diaVencimento && diaPagamento - diaVencimento > 5){
            multa = ((diaPagamento - diaVencimento - 5) * 0.02) * prestacao;
            prestacao = prestacao + multa;
            System.out.println("Valor da prestação: R$" + prestacao);
        }
        ler.close();
    }
}
