import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double azulejo = 12.50;
        //1 metro quadrado é formado por 9 azulejos
        double preco_m2 = azulejo * 9;
        System.out.print("Informe o comprimento: ");
        double comprimento = ler.nextDouble();
        System.out.print("Informe a altura : ");
        double altura = ler.nextDouble();
        double area = comprimento * altura;
        System.out.print("O preço a ser pago é: R$" + area * preco_m2);
        ler.close();
    }
}
