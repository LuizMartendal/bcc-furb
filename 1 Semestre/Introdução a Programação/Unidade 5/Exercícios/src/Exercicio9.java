import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Quantidade de alunos:");
        int n = ler.nextInt(), idade = 0, att_idade20 = 0; 
        String aluno, imprimir_aluno = "Alunos com 18 anos: \n";
        for (int i = 1; i <= n; i++){
            System.out.println("Escreva o nome do aluno:");
            aluno = ler.next();
            System.out.println("Escreva a idade do aluno:");
            idade = ler.nextInt();
            if (idade == 18){
                imprimir_aluno = imprimir_aluno + aluno + "\n";
            }
            if (idade > 20){
                att_idade20++;
            }
        }
        System.out.println(imprimir_aluno);
        if (att_idade20 > 0){
            System.out.println("Há " + att_idade20 + " alunos com mais de 20 anos.");
        }else if (att_idade20 <= 0){
            System.out.println("Não há alunos com 20 anos!");
        }
        ler.close();
    }
}
