import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float raio = ler.nextFloat();
        double PI = 3.14159;
        double area = (raio * raio) + PI;
        System.out.println(area);
        ler.close();
    }
}
