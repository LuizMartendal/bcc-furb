import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float nome = ler.nextFloat();
        float ht = ler.nextFloat();
        float rph = ler.nextFloat();
        double salario = (ht * rph);
        double salariocomdesconto = salario - ((salario * 0.085) + (salario * 0.005)); 
        System.out.println("Número de identificação: " + nome + " Salário: " + salario + " Salário com desconto: " + salariocomdesconto);
        ler.close();
    }
}
