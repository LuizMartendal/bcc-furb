import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("Nota 1: ");
        double nota1 = ler.nextDouble();
        System.out.print("Nota 2: ");
        double nota2 = ler.nextDouble();
        System.out.print("Nota 3: ");
        double nota3 = ler.nextDouble();
        
        System.out.print("Média dos exercícios: ");
        double mediaExercicios = ler.nextDouble();
        
        double mediaFinal = (nota1 + nota2 * 2 + nota3 * 3 + mediaExercicios) / 7;
        char conceito = 0;
        System.out.println("Média de aproveitamento : " + df.format(mediaFinal));
        if (mediaFinal >= 9.0){
            conceito = 'A';
            System.out.println("Conceito: " + conceito);
        }else if (mediaFinal >= 7.5 && mediaFinal < 9.0){
            conceito = 'B';
            System.out.println("Conceito: " + conceito);
        }else if (mediaFinal >= 6.0 && mediaFinal < 7.5){
            conceito = 'C';
            System.out.println("Conceito: " + conceito);
        }else if (mediaFinal >= 4.0 && mediaFinal < 6.0){
            conceito = 'D';
            System.out.println("Conceito: " + conceito);
        }else if (mediaFinal < 4){
            conceito = 'E';
            System.out.println("Conceito: " + conceito);
        }
        if (conceito == 'A' || conceito == 'B' || conceito == 'C'){
            System.out.println("Aprovado");
        }else if (conceito == 'D' || conceito == 'E'){
            System.out.println("Reprovado");
        }
        ler.close();
    }
}
