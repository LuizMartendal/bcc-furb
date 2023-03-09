import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("X = ");
        int x = ler.nextInt();
        System.out.print("Y = ");
        int y = ler.nextInt();
        if (x == 0 && y == 0){
            System.out.println("Quadrante 0");
        }else if (x > 0 && y > 0){
            System.out.println("Quadrante 1");
        }else if (x > 0 && y < 0){
            System.out.println("Quadrante 2");//se for um plano cartesiano eu teria que inverter para x < 0 e y > 0. Mas usei o que pediu na questão
        }else if (x < 0 && y < 0){
            System.out.println("Quadrante 3");
        }else if (x < 0 && y > 0){
            System.out.println("Quadrante 4");//o mesmo se aplicaria aqui x > 0 e y < 0
        }
        ler.close();
    }
}
