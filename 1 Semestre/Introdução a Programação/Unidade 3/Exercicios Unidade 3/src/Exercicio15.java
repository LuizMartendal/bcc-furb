import java.util.Scanner;

public class Exercicio15 {
   public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);
        int numero = ler.nextInt();
        int centena = numero / 100;
        numero %= 100;
        int dezena = numero / 10;
        numero %= 10;
        int unidade = numero / 1;
        System.out.println(centena + " centena(s) " + dezena + " dezena(s) " + unidade + " unidade(s)");
       ler.close();

   } 
}
