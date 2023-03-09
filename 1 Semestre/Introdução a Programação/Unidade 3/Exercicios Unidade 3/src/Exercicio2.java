import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double desconto = 0.12;
        System.out.print("Inserir o valor do sapato: R$");
        double valor_do_sapato = ler.nextDouble();
        double desconto_do_valor = valor_do_sapato * desconto;
        double sapato_com_desconto = valor_do_sapato - desconto_do_valor;
        System.out.print("O desconto é de: R$" + desconto_do_valor);
        System.out.print("O valor do par de sapatos com desconto é: R$" + sapato_com_desconto);
        ler.close();
    }
}
