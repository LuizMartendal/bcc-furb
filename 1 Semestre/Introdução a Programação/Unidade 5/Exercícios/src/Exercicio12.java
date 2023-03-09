import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int linhas = 0, colunas = 0, n, numeros = 1;
        System.out.println("Adicione o número de linhas do triângulo:");
        n = ler.nextInt();
        for (linhas = 1; linhas <= n; linhas++){
            for (colunas = 1; colunas <= linhas; colunas++){
                System.out.print("\t" + numeros);
                numeros++;
            }
            System.out.println();
        }
        ler.close();
    }
}
