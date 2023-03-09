import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite idade do Homem 1:");
        int homem1 = ler.nextInt();
        System.out.println("Digite idade do Homem 2 (diferente da idade do Homem 1):");
        int homem2 = ler.nextInt();
        System.out.println("Digite idade da Mulher 1:");
        int mulher1 = ler.nextInt();
        System.out.println("Digite idade da Mulher 2 (diferente da idade da Mulher 1):");
        int mulher2 = ler.nextInt();
        int soma, produto;
        
        if (homem1 > homem2 && mulher1 > mulher2){
            soma = homem1 + mulher2;
            produto = homem2 * mulher1;
            System.out.println("A soma do Homem mais velho com a Mulher mais nova: " + soma);
            System.out.println("O produto do Homem mais novo com a Mulher mais velha: " + produto);
        }else if (homem1 > homem2 && mulher1 < mulher2){
            soma = homem1 + mulher1;
            produto = homem2 * mulher2;
            System.out.println("A soma do Homem mais velho com a Mulher mais nova: " + soma);
            System.out.println("O produto do Homem mais novo com a Mulher mais velha: " + produto);
        }else if (homem1 < homem2 && mulher1 > mulher2){
            soma = homem2 + mulher2;
            produto = homem1 * mulher1;
            System.out.println("A soma do Homem mais Velho com a Mulher mais nova: " + soma);
            System.out.println("O produto do Homem mais novo com a Mulher mais velha: " + produto);
        }else if (homem1 < homem2 && mulher1 < mulher2){
            soma = homem2 + mulher1;
            produto = homem1 * mulher2;
            System.out.println("A soma do Homem mais velho com a Mulher mais nova: " + soma);
            System.out.println("O produto do Homem mais novo com a Mulher mais velha: " + produto);
        }
        ler.close();
    }
}
