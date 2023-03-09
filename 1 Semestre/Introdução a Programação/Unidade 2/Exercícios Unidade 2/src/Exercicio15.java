import java.util.Scanner;

public class Exercicio15 {

    public static void main(String[] args) throws Exception {

        int nota100, nota50;

        Scanner teclado = new Scanner(System.in);

    
        double valor = teclado.nextDouble();

        int valorInteiro = (int) (valor * 100);

        int cedulas = valorInteiro / 100;
        int moedas = valorInteiro % 100;

        //Cédulas:
        nota100 = cedulas / 100;
        cedulas = cedulas % 100;

        nota50 = cedulas / 50;
        cedulas = cedulas % 50;

        int nota20 = cedulas / 20;
        cedulas %= 20;

        int nota10 = cedulas / 10;
        cedulas %= 10;

        int nota5 = cedulas / 5;
        cedulas %= 5;

        int nota2 = cedulas / 2;
        int moeda1 = cedulas % 2;

        //Moedas:
        int moeda50 = moedas / 50;
        moedas = moedas % 50;

        int moeda25 = moedas / 25;
        moedas = moedas % 25;

        int moeda10 = moedas / 10;
        moedas = moedas % 10;

        int moeda5 = moedas / 5;
        int moeda01 = moedas % 5;


        System.out.println("NOTAS:");
        System.out.println(nota100 + " nota(s) de R$ 100.00");
        System.out.println(nota50 + " nota(s) de R$ 50.00");
        System.out.println(nota20 + " nota(s) de R$ 20.00");
        System.out.println(nota10 + " nota(s) de R$ 10.00");
        System.out.println(nota5 + " nota(s) de R$ 5.00");
        System.out.println(nota2 + " nota(s) de R$ 2.00");
        System.out.println("MOEDAS:");
        System.out.println(moeda1 + " moeda(s) de R$ 1.00" );
        System.out.println(moeda50 + " moeda(s) de R$ 0.50");
        System.out.println(moeda25 + " moeda(s) de R$ 0.25");
        System.out.println(moeda10 + " moeda(s) de R$ 0.10");
        System.out.println(moeda5 + " moeda(s) de R$ 0.05");
        System.out.println(moeda01 + " moeda(s) de R$ 0.01");
            teclado.close();
    }
}
