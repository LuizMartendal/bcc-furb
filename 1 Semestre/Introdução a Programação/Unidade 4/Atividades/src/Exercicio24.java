import java.util.Scanner;

public class Exercicio24 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int valor1, valor2, valor3, n1 = 0, n2 = 0, n3 = 0;
        
        System.out.print("Escreva o valor 1: " );
        valor1 = ler.nextInt();
        System.out.print("Escreva o valor 2: ");
        valor2 = ler.nextInt();
        System.out.print("Escreva o valor 3: ");
        valor3 = ler.nextInt();
        System.out.println("Lista de opções:");
        System.out.println("1. Ordem crescente;");
        System.out.println("2. Ordem decrescente;");
        System.out.println("3. O número maior aparece no meio;");
        System.out.print("Escreva a sua opção: ");
        int opcao = ler.nextInt();
       
        if (valor1 > valor2 && valor1 > valor3){
            n3 = valor1;
        }else if (valor1 < valor2 && valor1 > valor3 || valor1 < valor3 && valor1 > valor2){
            n2 = valor1;
        }else if (valor1 < valor2 && valor1 < valor3){
            n1 = valor1;
        }
        
        if (valor2 > valor1 && valor2 > valor3){
            n3 = valor2;
        }else if (valor2 > valor1 && valor2 < valor3 || valor2 < valor1 && valor2 > valor3){
            n2 = valor2;
        }else if (valor2 < valor1 && valor2 < valor3){
            n1 = valor2;
        }
        
        if (valor3 > valor1 && valor3 > valor2){
            n3 = valor3;
        }else if (valor3 > valor1 && valor3 < valor2 || valor3 < valor1 && valor3 > valor2){
            n2 = valor3;
        }else if (valor3 < valor1 && valor3 < valor2){
            n1 = valor3;
        }
        
        switch (opcao){
            case 1:
            System.out.println(n1 + " " + n2 + " " + n3);
            break;
            case 2:
            System.out.println(n3 + " " + n2 + " " + n1);
            break;
            case 3:
            System.out.println(n1 + " " + n3 + " " + n2);
            break;
        }
        ler.close();
    }
}
