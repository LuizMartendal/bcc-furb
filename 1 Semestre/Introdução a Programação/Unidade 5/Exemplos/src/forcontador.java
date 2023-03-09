import java.util.Scanner;

public class forcontador {
    public static void main(String[] args)  {
        for (int contador = 0; contador < 10; contador++){
            System.out.println(contador);
        }
        Scanner ler = new Scanner (System.in);
        System.out.println("Digite um número: ");
        int numero = ler.nextInt();
        for (int i = 0; i < numero; i++){
            System.out.println(i);
        }
        ler.close();
    }
}
