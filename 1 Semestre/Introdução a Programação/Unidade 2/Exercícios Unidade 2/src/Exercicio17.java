import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Adicionar nome: ");
        String nome = ler.next();
        System.out.println("Adiconar horas trabalhadas: ");
        int horas_trabalhadas = ler.nextInt();
        System.out.println("Adiconar número de dependetes: ");
        int numero_dependentes = ler.nextInt();
        int rhora = 10;
        int rdependentes = 60;
        double inss = 0.085;
        double ir = 0.05;
        double salariobruto = (horas_trabalhadas * rhora) + (numero_dependentes * rdependentes);
        double salarioliquido = salariobruto - ((salariobruto * inss) + (salariobruto * ir));
        System.out.println("Nome: " + nome);
        System.out.println("Salário bruto: " + salariobruto);
        System.out.println("Salário liquido: " + salarioliquido);
        ler.close();
    }
}
