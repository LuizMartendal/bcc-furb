import java.util.Scanner;

public class ExemploCondicionalSwitchSemBreak {
    public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    System.out.println("Opção: ");
    int opcao = ler.nextInt();
    switch (opcao){
        case 1:
        System.out.println("1");
        break;
        case 2:
        System.out.println("2");
        //Sem Break
        case 3:
        System.out.println("3");
        break;
        default:
        System.out.println("0");
        break;
    }
    ler.close();
    }
}
