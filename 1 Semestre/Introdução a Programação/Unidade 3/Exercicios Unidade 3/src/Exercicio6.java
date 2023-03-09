import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double precokilo = 25;
        double pesodoprato = 750 / 1000;
        System.out.print("Informar o peso: ");
        double peso = ler.nextDouble();
        double valor_a_pagar = (peso * precokilo) - pesodoprato;
        System.out.print("O valor total a ser pago é: R$" + valor_a_pagar);
        ler.close();
        
    }
}
