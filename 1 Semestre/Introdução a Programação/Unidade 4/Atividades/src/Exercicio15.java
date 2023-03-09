import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Adicione a quantidade de meses de admição: ");
        int meses = ler.nextInt();
        if (meses <= 12){
            System.out.println("5% de reajuste");
        }else if (meses > 12 && meses <= 48){
            System.out.println("7% de reajuste");
        }
        ler.close();
    }
}
