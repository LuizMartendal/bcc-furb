import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("A cor é azul?");
        boolean resposta = ler.nextBoolean();
        if (resposta){
            System.out.println("Sim");
        }else if (!resposta){
            System.out.println("Não");
        }
        ler.close();
    }
}
