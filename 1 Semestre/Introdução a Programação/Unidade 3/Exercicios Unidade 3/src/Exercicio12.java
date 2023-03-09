import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double reais_hora = 10;
        double reais_dependente = 60;
        double inss = 0.085;
        double ir = 0.05;
        System.out.print("Informar o nome: ");
        String nome = ler.nextLine();
        System.out.print("Horas trabalhadas: ");
        double horast = ler.nextDouble();
        System.out.print("Número de dependentes: ");
        double dependentes = ler.nextDouble();
        double salariobruto = horast * reais_hora * (dependentes * reais_dependente);
        System.out.print("O salário bruto de " + nome + " é: " + salariobruto);
        double salario_liquido = (salariobruto * inss) * ir;
        System.out.print("E seu salário liquido é: " + salario_liquido);
        ler.close();
    }
}
