import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o lado 1:");
        int lado1 = ler.nextInt();
        System.out.println("Digite o lado 2:");
        int lado2 = ler.nextInt();
        System.out.println("Digite o lado 3:");
        int lado3 = ler.nextInt();
        if (lado1 < (lado2 + lado3) && lado2 < (lado1 + lado3) && lado3 < (lado1 + lado2)){
            if (lado1 == lado2 && lado1 == lado3){
                System.out.println("é equilatero");
            }else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3){
                System.out.println("é isósceles");
            }else {
                System.out.println("é escaleno");
            }
        }else{
            System.out.println("Não formam um triangulo");
        }
        ler.close();
    }
}
