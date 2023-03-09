import java.util.Scanner;

public class Exemplo2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int idade = ler.nextInt();
        if (idade >= 18) {
            System.out.println("Adulto");
        } else {
            System.out.println("Não adulto");
        }
        System.out.println("FIM");
        ler.close();
    }
}
