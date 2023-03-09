import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = ler.next();
        while (!nome.trim().equalsIgnoreCase("Fim")){
            System.out.print("Digite a nota 1: ");
            float nota1 = ler.nextFloat();
            System.out.print("Digite a nota 2: ");
            float nota2 = ler.nextFloat();
            float media = (nota1 + nota2) / 2;
            System.out.print("Média: " + media);
            System.out.print("Digite o nome: ");
            nome = ler.next();
        }
        ler.close();
    }
}
