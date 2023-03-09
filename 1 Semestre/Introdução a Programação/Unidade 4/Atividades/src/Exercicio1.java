import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Entre com as horas trabalhadas no mês: ");
        int horasmes = ler.nextInt();
        System.out.println("Entre com o valor pago por hora: ");
        double horasvalor = ler.nextInt();
        double salariototal = horasmes * horasvalor;
        if (horasmes > 160){
            double salarioextra = (horasmes - 160) * (horasvalor / 2);
            salariototal = salariototal + salarioextra;
            System.out.println("O salário total é: R$" + df.format(salariototal));
        } else {
            System.out.println("O salário total é: R$" + df.format(salariototal));
        }
        ler.close();
    }
}
