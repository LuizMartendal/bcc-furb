import java.util.Scanner;

public class CoordenadasDeUmPonto {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float x, y;
        x = ler.nextFloat();
        y = ler.nextFloat();
        if (x == 0 && y == 0){
            System.out.println("Origem");
        }else if (x == 0){
            System.out.println("Eixo Y");
        }else if (y == 0){
            System.out.println("Eixo X");
        }else if (x > 0 && y > 0){
            System.out.println("Q1");
        }else if (x < 0 && y > 0){
            System.out.println("Q2");
        }else if (x < 0 && y < 0){
            System.out.println("Q3");
        }else if (x > 0 && y < 0){
            System.out.println("Q4");
        }
        ler.close();
    }
}
