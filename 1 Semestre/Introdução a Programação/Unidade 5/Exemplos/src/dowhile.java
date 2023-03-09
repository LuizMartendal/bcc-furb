import java.util.Scanner;

public class dowhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canal = 0;

        do {
            System.out.println("Digite o canal 4, 5, 9 ou 12: ");
            canal = sc.nextInt();
        } while (canal != 4 && canal != 5 && canal != 9 && canal != 12);
        System.out.println("Sai do laço!");
        sc.close();
    }
}
