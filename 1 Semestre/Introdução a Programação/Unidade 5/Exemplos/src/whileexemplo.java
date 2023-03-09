import java.util.Scanner;

public class whileexemplo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numero = ler.nextInt();
        while (numero < 20){
            numero++;
        }
        System.out.println(numero);
        ler.close();
    }
}
