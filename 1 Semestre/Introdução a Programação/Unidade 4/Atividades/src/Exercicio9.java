import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numero1, numero2;
        numero1 = ler.nextInt();
        numero2 = ler.nextInt();
        if ((numero1 % numero2 == 0) || (numero2 % numero1 == 0)){
            System.out.println("São multiplos");
        }else{
            System.out.println("Não são multiplos");
        }
        
        ler.close();
    }
}
