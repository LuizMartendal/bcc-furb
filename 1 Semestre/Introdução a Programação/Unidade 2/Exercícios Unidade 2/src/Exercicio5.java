import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float A = ler.nextFloat();
        float B = ler.nextFloat();
        float C = ler.nextFloat();
        float D = ler.nextFloat();
        float diferenca = (A * B - D * C);
        System.out.println(diferenca);
        ler.close();
    }
}
