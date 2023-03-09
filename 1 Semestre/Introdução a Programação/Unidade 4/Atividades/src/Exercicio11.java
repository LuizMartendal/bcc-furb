import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Idade do 1° irmão: ");
        int irmao1 = ler.nextInt();
        System.out.println("Idade do 2° irmão: ");
        int irmao2 = ler.nextInt();
        System.out.println("Idade do 3° irmão");
        int irmao3 = ler.nextInt();
        if ((irmao1 == irmao2) && (irmao2 == irmao3)){
            
            System.out.println("São trigêmeos");
        
        }else if ((irmao1 == irmao2) && (irmao1 != irmao3) && (irmao2 != irmao3)){
            System.out.println("O 1° irmão e o 2° irmão, são gêmeos");
        }else if ((irmao1 == irmao3) && (irmao1 != irmao2) && (irmao3 != irmao2)){
            System.out.println("O 1° irmão e o 3° irmão, são gêmeos");
        }else if ((irmao2 == irmao3) && (irmao2 != irmao1) && (irmao3 != irmao1)){
            System.out.println("O 2° irmão e o 3° irmão, são gêmeos");
        }else {
            System.out.println("São todos, apenas irmãos");
        }
        ler.close();
;    }
}
