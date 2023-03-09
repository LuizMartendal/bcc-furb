import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Idade de Marquinhos:");
        int marquinhos = ler.nextInt();
        System.out.println("Idade de Zezinho");
        int zezinho = ler.nextInt();
        System.out.println("Idade de Luluzinha");
        int luluzinha = ler.nextInt();
        if ((marquinhos < zezinho) && (marquinhos <  luluzinha)){
            System.out.println("Marquinhos é a caçula");
        }else if ((luluzinha < marquinhos) && (luluzinha < zezinho)){
            System.out.println("Luluzinha é o caçula");
        }else if ((zezinho < luluzinha) && (zezinho < marquinhos)){
            System.out.println("Zezinho é o caçula");
        }
        ler.close();
    }
}
