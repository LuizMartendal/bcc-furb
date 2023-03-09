import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = 0;
        for (int i = 1; i <= 20; i++ ){
        System.out.println("Escreva o " + i + "° número");
        n1 = s.nextInt();
        if (n1 % 2 == 0){
            System.out.println("É par");
        }else {
            System.out.println("É impar");
        }
        }
        s.close();
    }
}
