import java.util.Scanner;

public class Exercicio22 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Escolha a sua opção: ");
        System.out.println("1: Ciência da computação");
        System.out.println("2: Licenciatura da computação");
        System.out.println("3: Sistemas de informação");
        int opcao = ler.nextInt();
        switch (opcao){
            case 1:
            System.out.println("Bacharel em Ciência da Computação");
            break;
            case 2:
            System.out.println("Licenciado em Computação");
            break;
            case 3:
            System.out.println("Bacharel em Sistemas de Infomração");
            break;
        }
        ler.close();
    }
}
